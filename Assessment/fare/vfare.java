package fare;
import fourwheelers.*;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
public class vfare implements parkingfare
{
    public vfare(String st1)
    {
        boolean found=false;
        try
        {
        BufferedReader fin=new BufferedReader(new FileReader("C:\\Users\\arshit.nandan\\Desktop\\LOT D.txt"));
        String ticket;
        while((ticket=fin.readLine())!=null)
        {
            ticket=ticket.trim();
            String parts[]=ticket.split(",");
            if(parts[0].equalsIgnoreCase(st1))
            {
                System.out.println("Your Vehicle is Parked in FLOOR D,LOT "+st1.substring(2));
                LocalTime tout=LocalTime.now();  
                DateTimeFormatter format=DateTimeFormatter.ofPattern("HH:mm:ss"); 
                String outtime=tout.format(format);
                System.out.print("Vehicle In-time:"+parts[1]);
                System.out.println(" Vehicle Out-time:"+outtime);
                fare();
                found=true;
                van.vehicleleft();
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
        System.out.println("The Parking Fare for your Van --- 250Rs");
        
    }
}
