package counter1;
import java.util.*;
import java.io.*;
public class create
{
    Scanner sc=new Scanner(System.in);
    double balance=0.0;
    String username,pwd;
    int loan=0;
    String st,aadhar,address;
    int age;
    create()
    {
        System.out.println("\n\nWELCOME TO COUNTER 1");
        System.out.println("PLEASE FILL THE DETAILS TO CREATE A BANK ACCOUNT");
        System.out.print("YOUR NAME: ");
        this.st=sc.nextLine();
        System.out.print("Your AGE: ");
        this.age=sc.nextInt();
        if(this.age<18)
        {
            System.out.println("YOU ARE NOT ELIGIBLE TO CREATE AN ACCOUNT WITH US");
        }
        else
        {
            while(true)
            System.out.println("YOUR AADHAR NO: ");
            this.aadhar=sc.nextInt();
            if(aadhar.length()!=12||(!aadhar.matches("\\d{12}")))
            {
                System.out.println("PLEASE ENTER A VALID 12 DIGIT  AADHAR NO");
            }
            else
            {
                System.out.print("Enter your Address: ");
                this.address=sc.nextLine();
                this.username=this.aadhar.substring(this.aadhar.length()-6);
                System.out.println("Your username");
               createaccount();
            }
        }
    }
    public void createaccount()
    {
        try
        {
            File file=new File(username+".txt");
            FileWriter fw=new FileWriter(file);
            fw.write("NAME: "+st);
            fw.write("AADHAR NO: "+aadhar);
            fw.write("AGE: "+age);
            fw.write("Address: "+address);
            fw.write("Balance: "+balance);
            fw.write("Loan: "+loan);
            fw.write("pwd: "+pwd);
            fw.close();
            System.out.println("ACCOUNT CREATED SUCCESSFULLY FOR USER "+username);
            System.out.println("YOU CAN LOGIN USING YOUR USERNAME AND PASSWORD");
        }catch (IOException e) 
        {
            System.out.println(" ERROR WHILE CREATING ACCOUNT FILE.");
            e.printStackTrace();
        }
    }
}

