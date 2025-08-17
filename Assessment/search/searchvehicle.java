package search;
import fare.*;
import fourwheelers.*;
import twowheelers.*;
public class searchvehicle
{
    public String st1;
    String ticketNo;
    cars cr;
    public searchvehicle(String ticketNo)
    {
        this.ticketNo=ticketNo;
        find(ticketNo);
    }
    public void find(String st1)
    {
        this.st1=st1;
       if((this.st1).equals(new motorbike().t))  
       {
           System.out.println("Your Vehicle is Parked in TIER B,LOT "+new motorbike().t.substring(2));
           new mbfare().fare();
       }
       else if((this.st1).equals(new cycle().t))
       {
        System.out.println("Your Vehicle is Parked in FLOOR A,LOT "+new cycle().t.substring(2));
           new cfare().fare();
       }
       else if((this.st1).contains("CR"))
       {
        new crfare(this.st1);

       }
       else if((this.st1).equals(new van().t))
       {
        System.out.println("Your Vehicle is Parked in FLOOR D,LOT "+new van().t.substring(1));
           new vfare().fare();
       }
       else if((this.st1).equals(new truck().t))
       {
        System.out.println("Your Vehicle is Parked in FLOOR E,LOT "+new truck().t.substring(1));
           new tfare().fare();
       }
       else
       {
        System.out.println("CAN NOT FIND YOUR VEHICLE");
       }
    }
}
