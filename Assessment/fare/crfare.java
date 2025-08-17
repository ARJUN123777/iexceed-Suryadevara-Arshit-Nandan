package fare;
import fourwheelers.*;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
public class crfare implements parkingfare
{
    public static LocalTime tout=LocalTime.now();
    DateTimeFormatter formatter=DateTimeFormatter.ofPattern("HH:mm:ss");
    String outtime=(String)tout.format(formatter);
    Duration d;
    long hours;
    String st1;
    public crfare(String st1)
    {
        this.st1=st1;
        boolean found=false;
        try
        {
        DataInputStream fin=new DataInputStream(new FileInputStream("D:\\OneDrive\\Desktop\\Lot C.txt"));
        while(fin.available()>0)
        {
            String ticket=fin.readUTF();
            String intime=fin.readUTF();
            if(ticket.equals( this.st1))
            {
                System.out.println("Your Vehicle is Parked in FLOOR C,LOT "+(ticket).substring(2));
                System.out.println("Vehcile In Time-"+intime);
                System.out.println("Vehicle Time out-"+this.outtime);
                this.d=Duration.between(LocalTime.parse(intime,this.formatter),this.tout);
                this.hours=(long)d.toHours();
                fare();
                cars.vehicleleft();
                found=true;
                break;
            }
        }
        }catch(Exception e){};
        if(!found)
            {
                System.out.println("Vehicle Not found");
            }
    }
    public void fare()
    {
        System.out.println("Vehicle Time out-"+this.outtime); 
        if(this.hours<3)
        {
        System.out.println("The Parking Fare for your Car --- 200Rs");
        }
        else
        {
            System.out.println("The Parking Fare for your Car --- 250Rs");
        }
    }
}
