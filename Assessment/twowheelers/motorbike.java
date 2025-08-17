package twowheelers;
import java.time.*;
import java.util.*;
public class motorbike
{
    public static int t1=new Random().nextInt(1,25);   //25 Refers to no of lots in Car Parking Area
    public static String t="MB"+String.valueOf(t1);      //Static is used to make random value to be constant
    public static LocalTime tin=LocalTime.now();
    public void display()
    {
    System.out.println("===============================================");
    System.out.println("Welcome to TIER B");
    System.out.println("Park your Vehcile Here");
    System.out.println("  PARKED! ");
    System.out.println("Your Ticket No is: "+t);
    }
}