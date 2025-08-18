package fare;
import fourwheelers.*;
import java.io.DataInputStream;
import java.io.FileInputStream;
public class tfare implements parkingfare
{
    public tfare(String st1)
    {
        boolean found=false;
        try
        {
        DataInputStream fin=new DataInputStream(new FileInputStream("D:\\OneDrive\\Desktop\\Lot E.txt"));
        while(fin.available()>0)
        {
            String ticket=fin.readUTF();
            if(ticket.equals(st1))
            {
                System.out.println("Your Vehicle is Parked in FLOOR A,LOT "+(ticket).substring(2));
                fare();
                found=true;
                truck.vehicleleft();
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
        System.out.println("The Parking Fare for your Truck --- 300Rs");
        
    }
}
