package fare;
import fourwheelers.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
public class tfare implements parkingfare
{
     public static LocalTime tout=LocalTime.now();
    Duration d=Duration.between(truck.tin,tout);
    long hours=d.toHours();
    DateTimeFormatter formatter=DateTimeFormatter.ofPattern("HH:mm:ss");
    public void fare()
    {
        System.out.println("Vehicle Time In-"+(String)((truck.tin).format(formatter)));
        System.out.println("Vehicle Time out-"+(String)((this.tout).format(formatter))); 
        if(this.hours<3)
        {
        System.out.println("The Parking Fare for your Truck--- 250Rs");
        }
        else
        {
            System.out.println("The Parking Fare for your Truck --- 250Rs");
        }
    }
}
