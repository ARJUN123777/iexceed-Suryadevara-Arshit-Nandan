package twowheelers;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
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
      FileWriter fout=new FileWriter("C:\\Users\\arshit.nandan\\Desktop\\LOT A.txt",true);
      i++;  
      LocalTime tin=LocalTime.now();  
      DateTimeFormatter format=DateTimeFormatter.ofPattern("HH:mm:ss"); 
      String intime=tin.format(format); 
      this.t="C"+i; 
      fout.write(this.t+","+intime+"\n");
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