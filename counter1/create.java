package counter1;
import java.io.*;
import java.util.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
public class create
{
Scanner sc = new Scanner(System.in);
    double balance = 0.0;
    String username, pwd;
    int loan = 0;
    String st, aadhar, address;
    int age;
    public create()
    {
        System.out.println("==========================================================================================");
        System.out.println("\n\nWELCOME TO COUNTER 1");
        System.out.println("PLEASE FILL THE DETAILS TO CREATE A BANK ACCOUNT");
        System.out.print("YOUR NAME: ");
        this.st = sc.nextLine();
        System.out.print("Your AGE: ");
        this.age = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        if (this.age < 18)
        {
            System.out.println("YOU ARE NOT ELIGIBLE TO CREATE A BANK ACCOUNT");
        }
        else
        {
            while (true)
            {
               System.out.println("YOUR AADHAR NO: ");
               this.aadhar = sc.nextLine();
            if (this.aadhar.length() != 12 || (!this.aadhar.matches("\\d{12}")))
            {
                System.out.println("PLEASE ENTER A VALID 12 DIGIT  AADHAR NO");
            }
            else
            {
                break;
            }
            }
                System.out.print("Enter your Address: ");
                this.address = sc.nextLine();
                this.username = this.aadhar.substring(this.aadhar.length() - 6);
                System.out.println("YOUR USERNAME: "+this.username);
                System.out.println("SET YOUR PASSWORD: ");
                this.pwd = sc.nextLine();
                createaccount();
        }
    }
    public void createaccount() throws Exception
    {
        try {
            File file = new File(username + ".txt");
            FileOutputStream fos = new FileOutputStream(file);
            String data = "NAME: " + st + "\n" +
                          "AADHAR NO: " + aadhar + "\n" +
                          "AGE: " + age + "\n" +
                          "Address: " + address + "\n" +
                          "Balance: " + balance + "\n" +
                          "Loan: " + loan + "\n" +
                          "Password: " + pwd + "\n";
            byte[] encryptedData = encrypt(data, pwd);
            fos.write(encryptedData);
            fos.close();
            System.out.println("ACCOUNT CREATED SUCCESSFULLY FOR USER " + username);
            System.out.println("YOU CAN LOGIN USING YOUR USERNAME AND PASSWORD");
        } catch (IOException e)
        {
            System.out.println("ERROR WHILE CREATING ACCOUNT FILE.");
            e.printStackTrace();
        }
    }
    public static byte[] encrypt(String data, String password) throws Exception
    {
        SecretKeySpec key = new SecretKeySpec(getKey(password), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(data.getBytes());
    }
    public static byte[] getKey(String password) throws Exception
    {
        byte[] key = password.getBytes("UTF-8");
        return Arrays.copyOf(key, 16); // use first 16 bytes
    }
    public static String decrypt(byte[] data, String password) throws Exception
    {
        SecretKeySpec key = new SecretKeySpec(getKey(password), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        return new String(cipher.doFinal(data));
    }
}