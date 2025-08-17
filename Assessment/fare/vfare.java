package fare;
import fourwheelers.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
public class vfare implements parkingfare
{
     public static LocalTime tout=LocalTime.now();
    Duration d=Duration.between(van.tin,tout);
    long hours=d.toHours();
    DateTimeFormatter formatter=DateTimeFormatter.ofPattern("HH:mm:ss");
    public void fare()
    {
        System.out.println("Vehicle Time In-"+(String)((van.tin).format(formatter)));
        System.out.println("Vehicle Time out-"+(String)((this.tout).format(formatter))); 
        if(this.hours<3)
        {
        System.out.println("The Parking Fare for your Van--- 200Rs");
        }
        else
        {
            System.out.println("The Parking Fare for your Van --- 250Rs");
        }
    }
}
