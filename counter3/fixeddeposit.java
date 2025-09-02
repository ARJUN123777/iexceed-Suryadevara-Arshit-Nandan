package counter3;
import counter1.create;
import java.io.*;
import java.util.*;
public class fixeddeposit {
    Scanner sc = new Scanner(System.in);
    String username, pass;
    public fixeddeposit() {
        try {
            System.out.println("\t\t=============================================================");
            System.out.println("\t\t\t\tWELCOME TO COUNTER 3 ");
            System.out.println("\t\t\tPLEASE LOGIN TO ACCESS FD SERVICES");
            while (true) 
            {
                System.out.print("\t\t\tUsername: ");
                this.username = sc.nextLine();
                System.out.print("\t\t\tPassword: ");
                this.pass = sc.nextLine();
                File file = new File(username + ".txt");
                if (!file.exists()) {
                    System.out.println("\t\t\tUSER NOT FOUND, TRY AGAIN!");
                    continue;
                }
                // Read encrypted data
                byte[] encryptedData = new byte[(int) file.length()];
                FileInputStream fis = new FileInputStream(file);
                fis.read(encryptedData);
                fis.close();
                try {
                    // Decrypt account data
                    String decryptedData = create.decrypt(encryptedData, pass);
                    // Auto credit FD interests (only once per month)
                    decryptedData = autoCreditInterest(file, decryptedData);
                    while (true) {
                        System.out.println("\n\t\t************** FIXED DEPOSIT MENU **************");
                        System.out.println("\t\t1. CREATE NEW FIXED DEPOSIT");
                        System.out.println("\t\t2. VIEW YOUR FIXED DEPOSITS");
                        System.out.println("\t\t3. EXIT");
                        System.out.print("\t\tYOUR CHOICE: ");
                        int choice = sc.nextInt();
                        sc.nextLine(); // consume newline
                        if (choice == 1) {
                            createFD(file, decryptedData);
                            decryptedData = reloadDecryptedData(file);
                        } else if (choice == 2) {
                            viewFDs(decryptedData);
                        } else if (choice == 3) {
                            System.out.println("\t\tEXITING FD SERVICES...");
                            return;
                        } else {
                            System.out.println("\t\tINVALID CHOICE, TRY AGAIN!");
                        }
                    }
                } catch (Exception e) {
                    System.out.println("\t\tINCORRECT PASSWORD! TRY AGAIN");
                }
            }
        } catch (Exception e) {
            System.out.println("\t\tERROR DURING FD OPERATION.");
            e.printStackTrace();
        }
    }
    private String autoCreditInterest(File file, String decryptedData) throws Exception {
        String[] lines = decryptedData.split("\n");
        double balance = 0.0;
        List<String> updated = new ArrayList<>();
        // extract balance
        for (String line : lines) {
            if (line.trim().startsWith("BALANCE:")) {
                balance = Double.parseDouble(line.split(":")[1].trim());
            }
        }
        boolean credited = false;
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy");
        Date now = new Date();
        for (int i = 0; i < lines.length; i++) {
            updated.add(lines[i]);
            if (lines[i].contains("FIXED DEPOSIT:")) {
                double fdAmount = Double.parseDouble(lines[i].split(" ")[2]);
                double rate = Double.parseDouble(lines[i].split("@")[1].replace("%", "").trim());
                // Find LAST INTEREST CREDIT line
                String lastCreditLine = "";
                int lastCreditIndex = -1;
                for (int j = i; j < lines.length; j++) {
                    if (lines[j].startsWith("LAST INTEREST CREDIT:")) {
                        lastCreditLine = lines[j];
                        lastCreditIndex = j;
                        break;
                    }
                    if (lines[j].contains("DATE OF ISSUE")) {
                        // If FD just created, use issue date as last credit
                        lastCreditLine = "LAST INTEREST CREDIT:" + lines[j].split(":")[1].trim();
                        lastCreditIndex = -1;
                        break;
                    }
                }
                Date lastCreditDate = sdf.parse(lastCreditLine.split(":")[1].trim());
                // Calculate months between last credit and now
                Calendar c1 = Calendar.getInstance();
                Calendar c2 = Calendar.getInstance();
                c1.setTime(lastCreditDate);
                c2.setTime(now);
                int monthsDiff = (c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR)) * 12 +
                                 (c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH));
                if (monthsDiff > 0) {
                    double monthlyRate = rate / 12 / 100;
                    double interest = fdAmount * monthlyRate * monthsDiff;
                    balance += interest;
                    credited = true;
                    updated.add("\t\tINTEREST CREDITED: ₹" + String.format("%.2f", interest) +
                                " (" + monthsDiff + " MONTHS)");
                    // Update LAST INTEREST CREDIT date to current date
                    String newLastCredit = "LAST INTEREST CREDIT: " + sdf.format(now);
                    if (lastCreditIndex != -1) {
                        updated.set(lastCreditIndex, newLastCredit);
                    } else {
                        updated.add(newLastCredit);
                    }
                }
            }
        }
        // update balance in file
        if (credited) {
            for (int j = 0; j < updated.size(); j++) {
                if (updated.get(j).trim().startsWith("BALANCE:")) {
                    updated.set(j, "BALANCE: " + balance);
                }
            }
            String updatedData = String.join("\n", updated);
            byte[] updatedEncrypted = create.encrypt(updatedData, pass);
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(updatedEncrypted);
            fos.close();
            System.out.println("\n\t\tMONTHLY FD INTEREST CREDITED!\n\t\tUPDATED BALANCE: " + balance);
            return updatedData;
        }
        return decryptedData;
    }
    private void createFD(File file, String decryptedData) throws Exception {
        String[] lines = decryptedData.split("\n");
        double balance = 0.0;
        // extract balance
        for (String line : lines) {
            if (line.trim().startsWith("BALANCE:")) {
                balance = Double.parseDouble(line.split(":")[1].trim());
            }
        }
        System.out.print("\n\t\tENTER FD AMOUNT: ");
        double fdAmount = sc.nextDouble();
        sc.nextLine();
        if (fdAmount > balance) {
            System.out.println("\t\tINSUFFICIENT BALANCE TO CREATE FD!");
            return;
        }
        System.out.print("\t\tENTER FD DURATION(IN YEARS): ");
        int years = sc.nextInt();
        sc.nextLine();
        double rate = 10; // 10% interest
        double maturity = fdAmount * Math.pow(1 + (rate / 100), years);
        balance -= fdAmount;
        // Update account
        List<String> updated = new ArrayList<>();
        for (String line : lines) {
            if (line.trim().startsWith("BALANCE:")) {
                updated.add("BALANCE: " + balance);
            } else {
                updated.add(line);
            }
        }
        // Add new FD entry
        String fdEntry = "FIXED DEPOSIT: " + fdAmount + " for " + years + " years @ " + rate + "%";
        String maturityEntry = "MATURITY VALUE: " + String.format("%.2f", maturity);
        String dateEntry = "DATE OF ISSUE: " +new java.text.SimpleDateFormat("dd-MM-yyyy").format(new java.util.Date());
        String lastCreditEntry = "LAST INTEREST CREDITED ON " +new java.text.SimpleDateFormat("dd-MM-yyyy").format(new java.util.Date());
        updated.add(fdEntry);
        updated.add(maturityEntry);
        updated.add(dateEntry);
        updated.add(lastCreditEntry);
        // Encrypt and save
        String updatedData = String.join("\n", updated);
        byte[] updatedEncrypted = create.encrypt(updatedData, pass);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(updatedEncrypted);
        fos.close();
        System.out.println("\n\t\tFD Created Successfully!");
        System.out.println("\t\tUpdated Account Balance: " + balance);
        // Generate bond
        generateBond(lines[0].split(":")[1].trim(), fdAmount, years, rate, maturity);
    }
    private void viewFDs(String decryptedData) {
        System.out.println("\n\t\t************** YOUR FIXED DEPOSITS **************");
        String[] lines = decryptedData.split("\n");
        boolean found = false;
        int fdCount = 1;
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].contains("FIXED DEPOSIT:")) {
                found = true;
                System.out.println("\nFD #" + fdCount++);
                System.out.println(lines[i]);
                if (i + 1 < lines.length && lines[i + 1].contains("MATURITY VALUE")) {
                    System.out.println(lines[i + 1]);
                }
                if (i + 2 < lines.length && lines[i + 2].contains("DATE OF ISSUE")) {
                    System.out.println(lines[i + 2]);
                }
                if (i + 3 < lines.length && lines[i + 3].contains("LAST INTEREST CREDITED ON")) {
                    System.out.println(lines[i + 3]);
                }
                System.out.println("---------------------------------------------------");
            }
        }
        if (!found) {
            System.out.println("\t\tNo Fixed Deposits found!");
        }
    }
    private String reloadDecryptedData(File file) throws Exception {
        byte[] encryptedData = new byte[(int) file.length()];
        FileInputStream fis = new FileInputStream(file);
        fis.read(encryptedData);
        fis.close();
        return create.decrypt(encryptedData, pass);
    }
    private void generateBond(String accountHolder, double fdAmount, int years, double rate, double maturity)
            throws IOException {
        String date = new java.text.SimpleDateFormat("dd-MM-yyyy").format(new java.util.Date());
        System.out.println("\n\t\t=============================================================");
        System.out.println("                MAGADHA BANK FIXED DEPOSIT BOND");
        System.out.println("*\t\t************************************************************");
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Aadhar No      : " + aadharMasked(this.username));
        System.out.println("FD Amount      : ₹ " + fdAmount);
        System.out.println("Duration       : " + years + " years");
        System.out.println("Interest Rate  : " + rate + "% (compounded annually)");
        System.out.println("Maturity Value : ₹ " + String.format("%.2f", maturity));
        System.out.println("Date of Issue  : " + date);
        System.out.println("=============================================================");
        System.out.println("             THANK YOU FOR TRUSTING MAGADHA BANK");
        System.out.println("=============================================================");
    }
    private String aadharMasked(String username) {
        return "XXXXXX" + username;
    }
}