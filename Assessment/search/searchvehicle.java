package search;
import fare.*;
public class searchvehicle
{
    public String st1;
    String ticketNo;
    public searchvehicle(String ticketNo)
    {
        this.ticketNo=ticketNo;
        find(ticketNo);
    }
    public void find(String st1)
    {
        this.st1=st1;
       if((this.st1).contains("MB"))  
       {
           new mbfare(this.st1);
       }
       else if((this.st1).contains("C"))
       {
           new cfare(this.st1);
       }
       else if((this.st1).contains("CR"))
       {
        new crfare(this.st1);

       }
       else if((this.st1).contains("V"))
       {
           new vfare(this.st1);
       }
       else if((this.st1).contains("CR"))
       {
           new tfare(this.st1);
       }
       else
       {
        System.out.println("CAN NOT FIND YOUR VEHICLE");
       }
    }
}
