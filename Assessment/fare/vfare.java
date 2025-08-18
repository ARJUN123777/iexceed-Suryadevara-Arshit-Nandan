package fare;
import fourwheelers.*;
import java.io.DataInputStream;
import java.io.FileInputStream;
public class vfare implements parkingfare
{
    public vfare(String st1)
    {
        boolean found=false;
        try
        {
        DataInputStream fin=new DataInputStream(new FileInputStream("D:\\OneDrive\\Desktop\\Lot D.txt"));
        while(fin.available()>0)
        {
            String ticket=fin.readUTF();
            if(ticket.equals(st1))
            {
                System.out.println("Your Vehicle is Parked in FLOOR D,LOT "+(ticket).substring(2));
                fare();
                found=true;
                van.vehicleleft();
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
        System.out.println("The Parking Fare for your Van --- 250Rs");
        
    }
}
