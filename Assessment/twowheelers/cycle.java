package twowheelers;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
public class cycle
{
  public static int i=0;   //Static is used to make random value to be constant
  public String t;
  public cycle()
    {
      if(i>15)  //15 Refers to no of lots in cycle Parking Area
      {
        System.out.println("Lot Not Available");
      }
      try
      {
      DataOutputStream fout=new DataOutputStream(new FileOutputStream("D:\\OneDrive\\Desktop\\Lot A.txt",true));
      i++;   
      this.t="C"+String.valueOf(i); 
      fout.writeUTF(this.t);
      fout.close();
      display();
      }catch(Exception e){};


    }
   public void display()
   {
    System.out.println("===============================================");
    System.out.println("Welcome to TIER A");
    System.out.println("Park your Vehcile Here");
     System.out.println(" PARKED! ");
     System.out.println("Your Ticket No is: "+this.t);
   }
   public static void vehicleleft()
   {
     i--;
   }
  }