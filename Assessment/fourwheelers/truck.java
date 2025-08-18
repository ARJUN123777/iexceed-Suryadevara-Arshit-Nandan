package fourwheelers;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
public class truck
{
    public static int i=0;   //Static is used to make random value to be constant
  public String t;
  public truck()
    {
      if(i>10)  //10 Refers to no of lots in Truck Parking Area
      {
        System.out.println("Lot Not Available");
      }
      try
      {
      DataOutputStream fout=new DataOutputStream(new FileOutputStream("D:\\OneDrive\\Desktop\\Lot E.txt",true));
      i++;   
      this.t="TR"+String.valueOf(i); 
      fout.writeUTF(this.t);
      fout.close();
      display();
      }catch(Exception e){};


    }
   public void display()
   {
    System.out.println("===============================================");
    System.out.println("Welcome to TIER E");
    System.out.println("Park your Vehcile Here");
     System.out.println(" PARKED! ");
     System.out.println("Your Ticket No is: "+this.t);
   }
   public static void vehicleleft()
   {
     i--;
   }
}