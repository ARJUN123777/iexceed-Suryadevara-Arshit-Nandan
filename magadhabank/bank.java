//Program to execute the operations carried out in the bank
package magadhabank;
import java.util.Scanner;
import counter1.*;
import counter2.*;
import java.util.*;
public class bank
{
    public static void main(String args[])
    {
      Scanner sc=new Scanner(System.in);
      int option;
      while(true)
      {
        System.out.println("==========================================================================================");
        System.out.println("\t\tWECLOME TO MAGADHA BANK");
        System.out.println("\t\tHOW CAN WE HELP YOU?");
        System.out.println("\t\t1.CREATE AN ACCOUNT");
        System.out.println("\t\t2.DEPOSIT MONEY INTO YOUR ACCOUNT");
        System.out.println("\t\t3.LOAN");
        System.out.println("\t\t4.Exit");
        System.out.print("\t\tPLEASE SELECT YOUR CHOICE: ");
        option=sc.nextInt();
        if(option==1)
        {
            System.out.println("\t\tFOR ACCOUNT CREATION PLEASE GO TO COUNTER 1");
            new create();
        }
        else if(option==2)
        {
            System.out.println("\t\tFOR DEPOSITING MONEY INTO YOUR ACCOUNT PLEASE GO TO COUNTER 2");
            new deposit();
        }
        else if(option==3)
        {
            System.out.println("\t\tFOR LOAN PLEASE GO TO COUNTER 3");
            //counter3();
        }
        else if(option==4)
        {
            System.out.println("==========================================================================================");
            System.out.println("\t\tTHANK YOU FOR BANKING WITH US,PLEASE VISIT AGAIN");
        }
        else
        {
            System.out.println("PLEASE SELECT A VALID OPTION!!");
        }
      }
    }
}
