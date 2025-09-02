package counter4;
import counter1.*;
import java.io.*;
import java.util.*;
public class loan {
    Scanner sc = new Scanner(System.in);
    String username, pass;
    public loan() 
    {
        try {
            System.out.println("\t\t=======================================================");
            System.out.println("\t\t\tWELCOME TO COUNTER 4 - LOAN SERVICES");
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
    private static class LoanItem {
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
    private List<LoanItem> parseLoans(String data) {
        List<LoanItem> loans = new ArrayList<>();
        String[] lines = data.split("\n");
        LoanItem temp = null;
        for (String line : lines) {
            if (line.startsWith("LOAN AMOUNT:")) {
                double amt = Double.parseDouble(line.split(":")[1].trim());
                temp = new LoanItem(amt, 12.0, "", ""); // default 12%
            } else if (line.startsWith("LOAN ISSUED DATE:") && temp != null) {
                temp.loanDate = line.split(":")[1].trim();
            } else if (line.startsWith("LAST INTEREST PAID:") && temp != null) {
                temp.lastPaidMonth = line.split(":")[1].trim();
                loans.add(temp);
                temp = null;
            }
        }
        return loans;
    }
    private double parseBalance(String data) {
        double balance = 0.0;
        for (String line : data.split("\n")) {
            if (line.startsWith("BALANCE:")) {
                balance = Double.parseDouble(line.split(":")[1].trim());
            }
        }
        return balance;
    }
    private void showReminder(List<LoanItem> loans) {
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
    private LoanItem takeLoan(double balance) {
        System.out.print("\t\tENTER LOAN AMOUNT: ");
        double amt = sc.nextDouble();
        sc.nextLine();
        String date = new java.text.SimpleDateFormat("dd-MM-yyyy").format(new Date());
        String month = new java.text.SimpleDateFormat("MM-yyyy").format(new Date());
        return new LoanItem(amt, 12.0, date, month); // default 12% per annum
    }
    private void payInterest(double balance, List<LoanItem> loans) {
        if (loans.isEmpty()) {
            System.out.println("\t\tYOU HAVE ACTIVE LOANS!");
            return;
        }
        System.out.println("\t\tYOUR LOANS");
        for (int i = 0; i < loans.size(); i++) {
            LoanItem l = loans.get(i);
            System.out.printf("\t\t%d. LOAN ₹%.2f, RATE %.2f%%, ISSUED DATE: %s%n", i + 1, l.amount, l.rate, l.loanDate);
        }
        System.out.print("\t\tFOR WHICH LOAN YOU WANT TO PAY THE INTEREST ? ");
        int choice = sc.nextInt() - 1;
        sc.nextLine();
        if (choice < 0 || choice >= loans.size()) {
            System.out.println("\t\tINVALID LOAN SELECTION!");
            return;
        }
        LoanItem l = loans.get(choice);
        String thisMonth = new java.text.SimpleDateFormat("MM-yyyy").format(new Date());
        if (thisMonth.equals(l.lastPaidMonth)) {
            System.out.println("\t\tYOU ALREADY PAID THIS MONTH INTEREST FOR THIS LOAN!");
            return;
        }
        double interest = l.amount * (l.rate / 100) / 12;
        System.out.println("\t\tMONTHLY INTEREST OF ₹" + interest + " iS DUE FOR THIS LOAN.");
        System.out.print("\t\tDO YOU WANT TO PAY IT NOW? (yes/no): ");
        String ans = sc.nextLine();
        if (ans.equalsIgnoreCase("yes")) {
            l.lastPaidMonth = thisMonth;
            System.out.println("\t\tINTREST PAID SUCCESSFULLY!");
        } else {
            System.out.println("\t\tPLEASE PAY THE INTEREST .");
        }
    }
    private double clearLoan(double balance, List<LoanItem> loans) {
        if (loans.isEmpty()) {
            System.out.println("\t\tNO ACTIVE LOANS!");
            return balance;
        }
        System.out.println("\t\tYOUR LOANS");
        for (int i = 0; i < loans.size(); i++) {
            LoanItem l = loans.get(i);
            System.out.printf("\t\t%d. LOAN ₹%.2f, RATE %.2f%%, ISSUED DATE: %s%n", i + 1, l.amount, l.rate, l.loanDate);
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
            return balance;
        }
        balance -= l.amount;
        loans.remove(choice);
        System.out.println("\t\tLOAN CLEARED SUCCESSFULLY!");
        System.out.println("\t\tUPDATED BALANCE: " + balance);
        return balance;
    }
    private void showLoans(List<LoanItem> loans) {
        if (loans.isEmpty()) {
            System.out.println("\t\tYOU HAVE NO ACTIVE LOANS.");
            return;
        }
        System.out.println("\n\t\t================ YOUR LOAN STATUS ================");
        String thisMonth = new java.text.SimpleDateFormat("MM-yyyy").format(new Date());
        for (int i = 0; i < loans.size(); i++) {
            LoanItem l = loans.get(i);
            System.out.printf("\t\tLOAN %d: ₹%.2f, RATE %.2f%%, ISSUED DATE: %s, LAST PAID INTEREST ON %s%n",
                    i + 1, l.amount, l.rate, l.loanDate, l.lastPaidMonth);
            if (l.lastPaidMonth == null || !l.lastPaidMonth.equals(thisMonth)) {
                System.out.println("\t\tPENDING STATUS: INTEREST DUE FOR THIS MONTH!");
            } else {
                System.out.println("\t\tPENDING STATUS: NO DUES FOR THIS MONTH");
            }
            System.out.println("---------------------------------------------------");
        }
    }
    private void saveAccount(File file, double balance, List<LoanItem> loans) throws IOException, Exception {
        List<String> data = new ArrayList<>();
        data.add("BALANCE: " + balance);
        for (LoanItem l : loans) {
            data.add("LOAN AMOUNT: " + l.amount);
            data.add("LOAN DATE: " + l.loanDate);
            data.add("LAST INTEREST PAID: " + l.lastPaidMonth);
        }
        String updatedData = String.join("\n", data);
        byte[] encrypted = create.encrypt(updatedData, pass);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(encrypted);
        fos.close();
    }
    private double recalcBalance(double balance, List<LoanItem> loans) {
        // interest is not deducted automatically
        return balance;
    }
}
