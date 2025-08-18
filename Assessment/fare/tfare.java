package fare;
import fourwheelers.*;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
public class tfare implements parkingfare
{
    public tfare(String st1)
    {
        boolean found=false;
        try
        {
        BufferedReader fin=new BufferedReader(new FileReader("C:\\Users\\arshit.nandan\\Desktop\\LOT E.txt"));
        String ticket;
        while((ticket=fin.readLine())!=null)
        {
            ticket=ticket.trim();
            String parts[]=ticket.split(",");
            if(parts[0].equalsIgnoreCase(st1.trim()))
            {
                System.out.println("Your Vehicle is Parked in FLOOR E,LOT "+st1.substring(2));
                LocalTime tout=LocalTime.now();  
                DateTimeFormatter format=DateTimeFormatter.ofPattern("HH:mm:ss"); 
                String outtime=tout.format(format);
                System.out.print("Vehicle In-time:"+parts[1].trim());
                System.out.println(" Vehicle Out-time:"+outtime);
                fare();
                found=true;
                truck.vehicleleft();
                break;
            }
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        if(!found)
        {
            System.out.println("Vehicle Not found");
        }
    }

    public void fare()
    {
        System.out.println("The Parking Fare for your Truck --- 300Rs");
        
    }
}
