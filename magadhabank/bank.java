package magadhabank;
import counter1.*;
import counter2.*;
import counter3.*;
import counter4.*;
import java.util.Scanner;
public class bank
{
    public static void main(String args[])
    {
      Scanner sc=new Scanner(System.in);
      int option;
      while(true)
      {
        System.out.println("\t============================================================================");
        System.out.println("\t\t\t\tWECLOME TO MAGADHA BANK");
        System.out.println("\n\t\t\t\tHOW CAN WE HELP YOU?");
        System.out.println("\t\t\t\t1.CREATE AN ACCOUNT");
        System.out.println("\t\t\t\t2.DEPOSIT");
        System.out.println("\t\t\t\t3.FIXED DEPOSIT");
        System.out.println("\t\t\t\t4.LOAN");
        System.out.println("\t\t\t\t5.Exit");
        System.out.print("\t\t\t\tPLEASE SELECT YOUR CHOICE: ");
        option=sc.nextInt();
        if(option==1)
        {
            System.out.println("\t\t\tFOR ACCOUNT CREATION PLEASE GO TO COUNTER 1");
            new create();
        }
        else if(option==2)
        {
            System.out.println("\t\tFOR DEPOSITING MONEY INTO YOUR ACCOUNT PLEASE GO TO COUNTER 2");
            new deposit();
        }
        else if(option==3)
        {
            System.out.println("\t\t\tFOR FIXED DEPOSIT PLEASE GO TO COUNTER 3");
            new fixeddeposit();
        }
        else if(option==4)
        {
            System.out.println("\t\t\tFOR LOAN PLEASE GO TO COUNTER 4");
            new loan();
        }
        else if(option==5)
        {
            System.out.println("\t\t=============================================================");
            System.out.println("\t\t\tTHANK YOU FOR BANKING WITH US,PLEASE VISIT AGAIN");
            return;
        }
        else
        {
            System.out.println("\t\t\t\tPLEASE SELECT A VALID OPTION!!");
        }
      }
    }
}