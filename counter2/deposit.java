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
            System.out.println("==========================================================================================");
            System.out.println("\t\tWELCOME TO COUNTER 2");
            System.out.println("\t\tFOR DEPOSIT AND WITHDRAWAL PLEASE LOGIN INTO YOUR ACCOUNT");
            System.out.print("\t\tUsername: ");
            this.username = sc.nextLine();
            System.out.print("\t\tPassword: ");
            this.pass = sc.nextLine();
            File file = new File(username + ".txt");
            if (!file.exists()) 
            {
                System.out.println("\t\tUSER NOT FOUND");
                return;
            }
            // Read encrypted data from file
            byte[] encryptedData = new byte[(int) file.length()];
            FileInputStream fis = new FileInputStream(file);
            fis.read(encryptedData);
            fis.close();
            try {
                // Decrypt account data using password
                String decryptedData = create.decrypt(encryptedData, pass);
                System.out.println("\n\t\tLOGIN SUCCESSFUL.\n\t\tACCOUNT DETAILS");
                System.out.println("\t\t" + decryptedData);
                // Parse balance from decrypted text
                String[] lines = decryptedData.split("\n");
                double balance = 0.0;
                for (String line : lines) {
                    if (line.startsWith("Balance:")) {
                        balance = Double.parseDouble(line.split(":")[1].trim());
                    }
                }
                // Deposit or Withdraw
                System.out.println("\t\tPLEASE SELECT ANY ONE OPTION");
                System.out.println("\n\t\t1. DEPOSIT\n\t\t2. WITHDRAW\n\t\tYOUR CHOICE:");
                int choice = sc.nextInt();
                System.out.println("\t\tENTER AMOUNT: ");
                double amt = sc.nextDouble();
                if (choice == 1) 
                {
                    balance += amt;
                    System.out.println("\t\tDEPOSIT SUCCESSFUL");
                } 
                else if (choice == 2) 
                {
                    if (amt > balance) 
                    {
                        System.out.println("\t\tINSUFFICIENT BALANCE!");
                        return;
                    }
                    balance -= amt;
                    System.out.println("\t\tWITHDRAWAL SUCCESSFUL");
                } else 
                {
                    System.out.println("\t\tINVALID CHOICE!");
                    return;
                }
                // Update Balance line
                for (int i = 0; i < lines.length; i++) 
                {
                    if (lines[i].startsWith("Balance:")) 
                    {
                        lines[i] = "Balance: " + balance;
                    }
                }
                // Rejoin lines and encrypt
                String updatedData = String.join("\n", lines);
                byte[] updatedEncrypted = create.encrypt(updatedData, pass);
                // Save back to file
                FileOutputStream fos = new FileOutputStream(file);
                fos.write(updatedEncrypted);
                fos.close();
                System.out.println("UPDATED ACCOUNT DETAILS.");
            } catch (Exception e) 
            {
                System.out.println("INCORRECT PASSWORD!!");
            }
        } catch (Exception e) {
            System.out.println("ERROR DURING LOGIN.");
            e.printStackTrace();
        }
    }
}