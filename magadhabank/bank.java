//Program to execute the operations carried out in the bank
package magadhabank;
import java.util.Scanner;
import java.util.*;
public class bank
{
    public static void main(String args[])
    {
      Scanner sc=new Scanner(System.in);
      int option;
      while(true)
      {
        System.out.println("============================================");
        System.out.println("WECLOME TO MAGADHA BANK");
        System.out.println("HOW CAN WE HELP YOU?");
        System.out.println("1.CREATE AN ACCOUNT");
        System.out.println("2.DEPOSIT MONEY INTO YOUR ACCOUNT");
        System.out.println("3.LOAN");
        System.out.println("4.Exit");
        System.out.print("PLEASE SELECT YPOUR CHOICE: ");
        option=sc.nextInt();
        if(option==1)
        {
            System.out.println("=================================================");
            System.out.println("FOR ACCOUNT CREATION PLEASE GO TO COUNTER 1");
            counter1();
        }
        else if(option==2)
        {
            System.out.println("=================================================");
            System.out.println("FOR DEPOSITING MONEY INTO YOUR ACCOUNT PLEASE GO TO COUNTER 2");
            counter2();
        }
        else if(option==3)
        {
            System.out.println("=================================================");
            System.out.println("FOR LOAN PLEASE GO TO COUNTER 3");
            counter3();
        }
        else if(option==4)
        {
            System.out.println("=================================================");
            System.out.println("THANK YOU FOR BAKING WITH US,PLEASE VISIT AGAIN");
        }
        else
        {
            System.out.println("PLEASE SELECT A VALID OPTION!!");
        }
      }
    }
}
