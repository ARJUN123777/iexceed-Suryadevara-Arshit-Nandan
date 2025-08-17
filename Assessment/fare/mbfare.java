package fare;
import java.time.*;
import java.time.format.DateTimeFormatter;
import twowheelers.*;
//Dependecy Inversion Principle
interface parkingfare     //Functional Interface takes only one method
{
    public void fare();
}
public class mbfare implements parkingfare
{
    public static LocalTime tout=LocalTime.now();
    Duration d=Duration.between(motorbike.tin,tout);
    long hours=d.toHours();
    DateTimeFormatter formatter=DateTimeFormatter.ofPattern("HH:mm:ss");
    public void fare()
    {
        System.out.println("Vehicle Time In-"+(String)(motorbike.tin).format(formatter));
        System.out.println("Vehicle Time out-"+(String)(this.tout).format(formatter)); 
        if(this.hours<3)
        {
        System.out.println("The Parking Fare for your Motor Cycle --- 100Rs");
        }
        else
        {
            System.out.println("The Parking Fare for your Motor Cycle --- 150Rs");
        }
    }
}
