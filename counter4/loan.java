package counter4;
import counter1.*;
import java.io.*;
import java.util.*;
public class loan 
{
    Scanner sc = new Scanner(System.in);
    String username, pass;
    public loan() 
    {
        try {
            System.out.println("\t\t=======================================================");
            System.out.println("\t\t\tWELCOME TO COUNTER 4 ");
            System.out.println("\t\tPLEASE LOGIN TO ACCESS LOAN FACILITIES");
            while (true) {
                System.out.print("\t\t\tUsername: ");
                username = sc.nextLine();
                System.out.print("\t\t\tPassword: ");
                pass = sc.nextLine();
                File file = new File(username + ".txt");
                if (!file.exists()) {
                    System.out.println("\t\t\tUSER NOT FOUND, TRY AGAIN!");
                    continue;
                }
                byte[] encryptedData = new byte[(int) file.length()];
                FileInputStream fis = new FileInputStream(file);
                fis.read(encryptedData);
                fis.close();
                try {
                    String decryptedData = create.decrypt(encryptedData, pass);
                    List<LoanItem> loans = parseLoans(decryptedData);
                    double balance = parseBalance(decryptedData);
                    // Show reminder if any loan has unpaid interest this month
                    showReminder(loans);
                    while (true) {
                        System.out.println("\n\t\t================ LOAN MENU ================");
                        System.out.println("\t\t1. TAKE LOAN");
                        System.out.println("\t\t2. PAY INTEREST");
                        System.out.println("\t\t3. CLEAR LOAN");
                        System.out.println("\t\t4. VIEW YOUR LOANS");
                        System.out.println("\t\t5. EXIT");
                        System.out.print("\t\tYOUR CHOICE: ");
                        int choice = sc.nextInt();
                        sc.nextLine();

                        switch (choice) {
                            case 1 -> { // Take Loan
                                LoanItem newLoan = takeLoan(balance);
                                balance += newLoan.amount;
                                loans.add(newLoan);
                                System.out.println("\t\tLOAN OF ₹" + newLoan.amount + " GRANTED SUCCESSFULLY!");
                                System.out.println("\t\tUPDATED SUCCESSFULLY: " + balance);
                            }
                            case 2 -> { // Pay Interest
                                payInterest(balance, loans);
                                balance = recalcBalance(balance, loans); // update balance after payment
                            }
                            case 3 -> { // Clear Loan
                                balance = clearLoan(balance, loans);
                            }
                            case 4 -> showLoans(loans);
                            case 5 -> {
                                saveAccount(file, balance, loans);
                                System.out.println("\t\tEXITING LOAN SERVICES...");
                                return;
                            }
                            default -> System.out.println("\t\tINVALID CHOICE, TRY AGAIN!");
                        }
                        saveAccount(file, balance, loans);
                    }
                } catch (Exception e) {
                    System.out.println("\t\tINCORRECT PASSWORD! TRY AGAIN");
                }
            }
        } catch (Exception e) {
            System.out.println("\t\tERROR DURING LOAN OPERATION.");
            e.printStackTrace();
        }
    }
    public static class LoanItem {
        double amount;
        double rate;
        String loanDate;
        String lastPaidMonth;
        LoanItem(double amt, double r, String date, String lastPaid) {
            amount = amt;
            rate = r;
            loanDate = date;
            lastPaidMonth = lastPaid;
        }
    }
    public List<LoanItem> parseLoans(String data) {
        List<LoanItem> loans = new ArrayList<>();
        String[] lines = data.split("\n");
        LoanItem temp = null;
        for (String line : lines) {
            if (line.trim().startsWith("LOAN AMOUNT:")) {
                double amt = Double.parseDouble(line.split(":")[1].trim());
                temp = new LoanItem(amt, 12.0, "", ""); // default 12%
            } else if (line.trim().startsWith("LOAN ISSUED DATE:") && temp != null) {
                temp.loanDate = line.split(":")[1].trim();
            } else if (line.trim().startsWith("LAST INTEREST PAID ON") && temp != null) {
                temp.lastPaidMonth = line.split(":")[1].trim();
                loans.add(temp);
                temp = null;
            }
        }
        return loans;
    }
    public double parseBalance(String data) {
        double balance = 0.0;
        for (String line : data.split("\n")) {
            if (line.trim().startsWith("BALANCE:")) {
                balance = Double.parseDouble(line.split(":")[1].trim());
            }
        }
        return balance;
    }
    public void showReminder(List<LoanItem> loans) {
        String thisMonth = new java.text.SimpleDateFormat("MM-yyyy").format(new Date());
        boolean hasReminder = false;
        for (LoanItem l : loans) {
            if (!thisMonth.equals(l.lastPaidMonth)) {
                hasReminder = true;
                break;
            }
        }
        if (hasReminder) System.out.println("\t\tREMINDER: YOU MUST PAY LOAN INTEREST FOR THIS MONTH!");
        else if (!loans.isEmpty()) System.out.println("\t\tYOU HAVE ALREADY PAID THIS MONTH INTEREST");
    }
    public LoanItem takeLoan(double balance) {
    System.out.print("\t\tENTER LOAN AMOUNT: ");
    double amt = sc.nextDouble();
    sc.nextLine();
    String date = new java.text.SimpleDateFormat("dd-MM-yyyy").format(new Date());
    String month = new java.text.SimpleDateFormat("MM-yyyy").format(new Date());
    double rate = 10.0; // default 10% per annum
    double monthlyInterest = amt * (rate / 100) / 12;
    System.out.println("\t\tLOAN OF ₹" + amt + " GRANTED SUCCESSFULLY!");
    System.out.println("\t\tINTEREST RATE: " + rate + "% per annum");
    System.out.println("\t\tYOUR MONTHLY INTEREST WILL BE: ₹" + monthlyInterest);
    return new LoanItem(amt, rate, date, month);
}
    public double payInterest(double balance, List<LoanItem> loans) {
    if (loans.isEmpty()) {
        System.out.println("\t\tNO ACTIVE LOANS!");
        return balance;
    }
    System.out.println("\t\tYOUR LOANS");
    for (int i = 0; i < loans.size(); i++) {
        LoanItem l = loans.get(i);
        System.out.printf("\t\t%d. LOAN ₹%.2f, RATE %.2f%%,LOAN ISSUED DATE: %s%n",
                i + 1, l.amount, l.rate, l.loanDate);
    }
    System.out.print("\t\tFOR WHICH LOAN YOU WANT TO PAY THE INTEREST ? ");
    int choice = sc.nextInt() - 1;
    sc.nextLine();
    if (choice < 0 || choice >= loans.size()) {
        System.out.println("\t\tINVALID LOAN SELECTION!");
        return balance;
    }
    LoanItem l = loans.get(choice);
    String thisMonth = new java.text.SimpleDateFormat("MM-yyyy").format(new Date());
    try {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("MM-yyyy");
        // If never paid before, use loan starting month
        String lastPaid = (l.lastPaidMonth == null || l.lastPaidMonth.isEmpty())? l.loanDate.substring(3): l.lastPaidMonth;  // extract MM-yyyy from loanDate
        Date lastDate = sdf.parse(lastPaid);
        Date currentDate = sdf.parse(thisMonth);
        Calendar c1 = Calendar.getInstance();
        c1.setTime(lastDate);
        Calendar c2 = Calendar.getInstance();
        c2.setTime(currentDate);
        int monthsDue = (c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR)) * 12 + (c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH));
        if (monthsDue <= 0) {
            System.out.println("\t\tYOU ALREADY PAID THIS MONTH INTEREST FOR THIS LOAN!");
            return balance;
        }
        double monthlyInterest = l.amount * (l.rate / 100) / 12;
        double totalInterest = monthsDue * monthlyInterest;
        System.out.println("\t\tINTEREST DUE FOR " + monthsDue + " MONTH(S): ₹" + totalInterest);
        System.out.print("\t\tDO YOU WANT TO PAY IT NOW? (yes/no): ");
        String ans = sc.nextLine();
        if (ans.equalsIgnoreCase("yes")) {
            if (balance >= totalInterest) {
                balance -= totalInterest;
                l.lastPaidMonth = thisMonth; // update to current month
                System.out.println("\t\tINTEREST PAID SUCCESSFULLY!");
                System.out.println("\t\tUPDATED BALANCE: " + balance);
            } else {
                System.out.println("\t\tINSUFFICIENT BALANCE TO PAY INTEREST!");
            }
        } else {
            System.out.println("\t\tPLEASE PAY THE INTEREST.");
        }
    } catch (Exception e) {
        System.out.println("\t\tERROR WHILE CALCULATING INTEREST DUES!");
    }
    return balance;   // return updated balance
}
    public double clearLoan(double balance, List<LoanItem> loans) {
        if (loans.isEmpty()) {
            System.out.println("\t\tNO ACTIVE LOANS!");
            return balance;
        }
        System.out.println("\t\tYOUR LOANS");
        for (int i = 0; i < loans.size(); i++) {
            LoanItem l = loans.get(i);
            System.out.printf("\t\t%d. LOAN ₹%.2f,INTEREST RATE %.2f%%,LOAN ISSUED DATE: %s%n", i + 1, l.amount, l.rate, l.loanDate);
        }
        System.out.print("\t\tWHICH LOAN YOU WANT TO CLEAR? ");
        int choice = sc.nextInt() - 1;
        sc.nextLine();
        if (choice < 0 || choice >= loans.size()) {
            System.out.println("\t\tINVALID LOAN SELECTION!");
            return balance;
        }
        LoanItem l = loans.get(choice);
        if (balance < l.amount) {
            System.out.println("\t\tINSUFFICIENT BALANCE TO CLEAR THIS LOAN");
            System.out.println("\t\tPLEASE CHECK YOUR BALANCE");
            return balance;
        }
        balance -= l.amount;
        loans.remove(choice);
        System.out.println("\t\tLOAN CLEARED SUCCESSFULLY!");
        System.out.println("\t\tUPDATED BALANCE: " + balance);
        return balance;
    }
   public void showLoans(List<LoanItem> loans) {
    if (loans.isEmpty()) {
        System.out.println("\t\tYOU HAVE NO ACTIVE LOANS.");
        return;
    }
    System.out.println("\n\t\t================ YOUR LOAN STATUS ================");
    String thisMonth = new java.text.SimpleDateFormat("MM-yyyy").format(new Date());
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("MM-yyyy");
    for (int i = 0; i < loans.size(); i++) {
        LoanItem l = loans.get(i);
        System.out.printf("\t\tLOAN %d: ₹%.2f, INTEREST RATE %.2f%%,LOAN ISSUED DATE: %s, LAST INTEREST PAID ON %s%n",
                i + 1, l.amount, l.rate, l.loanDate,
                (l.lastPaidMonth == null || l.lastPaidMonth.isEmpty()) ? "NEVER" : l.lastPaidMonth);
        try {
            // If never paid, consider loan from the starting month
            String lastPaid = (l.lastPaidMonth == null || l.lastPaidMonth.isEmpty())? l.loanDate.substring(3): l.lastPaidMonth;  // extract MM-yyyy from loanDate (dd-MM-yyyy → MM-yyyy)
            Date lastDate = sdf.parse(lastPaid);
            Date currentDate = sdf.parse(thisMonth);
            Calendar c1 = Calendar.getInstance();
            c1.setTime(lastDate);
            Calendar c2 = Calendar.getInstance();
            c2.setTime(currentDate);
            int monthsDue = (c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR)) * 12 + (c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH));
            if (monthsDue > 0) {
                double monthlyInterest = l.amount * (l.rate / 100) / 12;
                double totalDue = monthsDue * monthlyInterest;
                System.out.println("\t\tPENDING STATUS: INTEREST DUE FOR " + monthsDue + " MONTH(S) → ₹" + totalDue);
            } else {
                System.out.println("\t\tPENDING STATUS: NO DUES FOR THIS MONTH");
            }
        } catch (Exception e) {
            System.out.println("\t\tERROR CALCULATING DUES!");
        }
        System.out.println("---------------------------------------------------");
    }
}
    public void saveAccount(File file, double balance, List<LoanItem> loans) throws IOException, Exception {
        List<String> data = new ArrayList<>();
        data.add("BALANCE: " + balance);
        for (LoanItem l : loans) {
            data.add("LOAN AMOUNT: " + l.amount);
            data.add("LOAN ISSUED DATE: " + l.loanDate);
            data.add("LAST INTEREST PAID ON " + l.lastPaidMonth);
        }
        String updatedData = String.join("\n", data);
        byte[] encrypted = create.encrypt(updatedData, pass);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(encrypted);
        fos.close();
    }
    public double recalcBalance(double balance, List<LoanItem> loans) {
        // interest is not deducted automatically
        return balance;
    }
}