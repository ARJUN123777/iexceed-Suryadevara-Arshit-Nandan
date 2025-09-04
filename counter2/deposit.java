package counter2;
import counter1.*;
import java.io.*;
import java.util.*;
public class deposit 
{
    Scanner sc = new Scanner(System.in);
    String username, pass;
    public deposit() 
    {
        try {
            System.out.println("\t\t======================================================");
            System.out.println("\t\t\t\tWELCOME TO COUNTER 2");
            System.out.println("\t\tFOR DEPOSIT AND WITHDRAWAL PLEASE LOGIN INTO YOUR ACCOUNT");
            while (true)  
            {       // keep asking until correct login
                        System.out.print("\t\t\tUsername: ");
                        this.username = sc.nextLine();
                        System.out.print("\t\t\tPassword: ");
                        this.pass = sc.nextLine();
                       File file = new File(username + ".txt");
               if (!file.exists()) {
                System.out.println("\t\t\t\tUSER NOT FOUND");
                continue;
                }
                // Read encrypted data from file
                byte[] encryptedData = new byte[(int) file.length()];
                FileInputStream fis = new FileInputStream(file);
                fis.read(encryptedData);
                fis.close();
             try {
                // Decrypt account data using password
                String decryptedData = create.decrypt(encryptedData, pass);
                String name = "", aadhar = "", address = "";
                int age = 0;
                double balance = 0.0;
                System.out.println("\t\t******************************************************");
                System.out.println("\t\t\t\tACCOUNT DETAILS");
                String[] lines = decryptedData.split("\n");
                balance = 0.0;
                // Print account details and extract balance
                for (String line : lines) 
                {
                    if (line.trim().startsWith("NAME:")) {
                            name = line.split(":", 2)[1].trim();
                        } else if (line.trim().startsWith("AADHAR NO:")) {
                            aadhar = line.split(":", 2)[1].trim();
                        } else if (line.trim().startsWith("AGE:")) {
                            age = Integer.parseInt(line.split(":", 2)[1].trim());
                        } else if (line.trim().startsWith("ADDRESS:")) {
                            address = line.split(":", 2)[1].trim();
                        } else if (line.trim().startsWith("BALANCE:")) {
                            balance = Double.parseDouble(line.split(":", 2)[1].trim());
                        }
                }
                // Show account details before transaction
                    System.out.println("\t\tName      : " + name);
                    System.out.println("\t\tAge       : " + age);
                    System.out.println("\t\tAadhar No : " + aadhar);
                    System.out.println("\t\tAddress   : " + address);
                    System.out.println("\t\tBalance   : " + balance);
                // Deposit or Withdraw
                String choice="";
                while (true) 
                {    
                System.out.print("\n\t\t\tDO YOU WANT TO DEPOSIT OR WITHDRAW- ");
                choice = sc.nextLine();
                if (choice.toLowerCase().equals("deposit")) 
                {
                    System.out.print("\t\t\tENTER THE AMOUNT TO DEPOSIT: ");
                    double amt = sc.nextDouble();
                    sc.nextLine();
                    balance += amt;
                    System.out.println("\n\t\t\t\tDEPOSIT SUCCESSFUL");
                    break;
                } else if (choice.toLowerCase().equals("withdraw")) 
                {
                    System.out.print("\t\t\tENTER THE AMOUNT TO WITHDRAW: ");
                    double amt = sc.nextDouble();
                    if (amt > balance) {
                        System.out.println("\t\t\t\tINSUFFICIENT BALANCE!");
                        break;
                    }
                    balance -= amt;
                    System.out.println("\n\t\t\t\tWITHDRAWAL SUCCESSFUL");
                    break;
                } else {
                    System.out.println("\t\t\tPLEASE TYPE DEPOSIT OR WITHDRAW!");

                }
            }
                // Update Balance line
                for(int i = 0; i < lines.length; i++) {
                    if (lines[i].trim().startsWith("BALANCE")) {
                        lines[i] = "BALANCE: " + balance;
                    }
                }
                // Rejoin lines and encrypt again
                String updatedData = String.join("\n", lines);
                byte[] updatedEncrypted = create.encrypt(updatedData, pass);
                // Save back to file
                FileOutputStream fos = new FileOutputStream(file);
                fos.write(updatedEncrypted);
                fos.close();
                // Show updated account details
                System.out.println("\t\t******************************************************");
                System.out.println("\t\t\t\tUPDATED ACCOUNT DETAILS");
                System.out.println("\t\tName      : " + name);
                System.out.println("\t\tAge       : " + age);
                System.out.println("\t\tAadhar No : " + aadhar);
                System.out.println("\t\tAddress   : " + address);
                System.out.println("\t\tBalance   : " + balance);

                break;
             } catch (Exception e) {
                System.out.println("\t\t\tINCORRECT PASSWORD!");
            }
        }
        } catch (Exception e) {
            System.out.println("\t\t\t\tERROR DURING LOGIN.");
            e.printStackTrace();
        }
    }
}