package fourwheelers;
import java.io.*;
import java.lang.*;
public class cars 
{
  public static int i=0;   //Static is used to make random value to be constant
  public String t;
  public cars()
    {
      if(i>20)  //20 Refers to no of lots in Car Parking Area
      {
        System.out.println("Lot Not Available");
      }
      try
      {
      DataOutputStream fout=new DataOutputStream(new FileOutputStream("D:\\OneDrive\\Desktop\\Lot C.txt",true));
      i++;   
      this.t="CR"+String.valueOf(i); 
      fout.writeUTF(this.t);
      fout.close();
      display();
      }catch(Exception e){};


    }
   public void display()
   {
    System.out.println("===============================================");
    System.out.println("Welcome to TIER C");
    System.out.println("Park your Vehcile Here");
     System.out.println(" PARKED! ");
     System.out.println("Your Ticket No is: "+this.t);
   }
   public static void vehicleleft()
   {
     i--;
   }
}