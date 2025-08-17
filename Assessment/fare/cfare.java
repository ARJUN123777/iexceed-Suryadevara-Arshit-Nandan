package fare;
import java.time.*;
import java.time.format.DateTimeFormatter;
import twowheelers.*;
public class cfare implements parkingfare
{
     public static LocalTime tout=LocalTime.now();
    Duration d=Duration.between(cycle.tin,tout);
    long hours=d.toHours();
    DateTimeFormatter formatter=DateTimeFormatter.ofPattern("HH:mm:ss");
    public void fare()
    {
        System.out.println("Vehicle Time In-"+(String)((cycle.tin).format(formatter)));
        System.out.println("Vehicle Time out-"+(String)((this.tout).format(formatter))); 
        if(this.hours<3)
        {
        System.out.println("The Parking Fare for your Cycle --- 50Rs");
        }
        else
        {
            System.out.println("The Parking Fare for your Cycle --- 100Rs");
        }
    }
}
