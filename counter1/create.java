package counter1;
import java.io.*;
import java.util.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class create {
    Scanner sc = new Scanner(System.in);
    double balance = 0.0;
    String username, pwd;
    String st, aadhar, address;
    int age;

    public create() {
        System.out.println("\t\t=============================================================");
        System.out.println("\t\t\t\tWELCOME TO COUNTER 1");
        System.out.println("\n\t\tPLEASE FILL THE DETAILS TO CREATE A BANK ACCOUNT");
        System.out.print("\t\t\tYOUR NAME: ");
        this.st = sc.nextLine();
        System.out.print("\t\t\tYour AGE: ");
        this.age = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        if (this.age < 18) {
            System.out.println("\t\t\t\tYOU ARE NOT ELIGIBLE TO CREATE A BANK ACCOUNT");
        } else {
            while (true) {
                System.out.print("\t\t\tYOUR AADHAR NO: ");
                this.aadhar = sc.nextLine();
                if (this.aadhar.length() != 12 || (!this.aadhar.matches("\\d{12}"))) {
                    System.out.println("\t\t\tPLEASE ENTER A VALID 12 DIGIT  AADHAR NO");
                } else {
                    break;
                }
            }
            System.out.print("\t\t\tENTER YOUR ADDRESS: ");
            this.address = sc.nextLine();
            this.username = this.aadhar.substring(this.aadhar.length() - 6);
            System.out.println("\t\t\tYOUR USERNAME(last 6 digits of your AADHAR number): " + this.username);
            System.out.print("\t\t\tSET YOUR PASSWORD: ");
            this.pwd = sc.nextLine();
            try {
                createaccount();
            } catch (Exception e) {
                System.out.println("\t\t\tERROR WHILE CREATING ACCOUNT.");
                e.printStackTrace();
            }
        }
    }

    public void createaccount() throws Exception {
        try {
            File file = new File(username + ".txt");
            if (file.exists()) {
                System.out.println("\t\t\tACCOUNT ALREADY EXISTS FOR USER " + username);
                return;
            }
            FileOutputStream fos = new FileOutputStream(file, false);
            String data = "NAME: " + st + "\n" +
                    "AADHAR NO: " + aadhar + "\n" +
                    "AGE: " + age + "\n" +
                    "ADDRESS: " + address + "\n" +
                    "BALANCE: " + balance + "\n";
            byte[] encryptedData = encrypt(data, pwd);
            fos.write(encryptedData);
            fos.close();
            System.out.println("\t\t\tYOU CAN LOGIN USING YOUR USERNAME AND PASSWORD");
        } catch (IOException e) {
            System.out.println("\t\t\tERROR WHILE CREATING ACCOUNT FILE.");
            e.printStackTrace();
        }
    }

    public static byte[] encrypt(String data, String password) throws Exception {
        SecretKeySpec key = new SecretKeySpec(getKey(password), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(data.getBytes());
    }

    public static byte[] getKey(String password) throws Exception {
        byte[] key = password.getBytes("UTF-8");
        return Arrays.copyOf(key, 16); // use first 16 bytes
    }

    public static String decrypt(byte[] data, String password) throws Exception {
        SecretKeySpec key = new SecretKeySpec(getKey(password), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        return new String(cipher.doFinal(data));
    }
}