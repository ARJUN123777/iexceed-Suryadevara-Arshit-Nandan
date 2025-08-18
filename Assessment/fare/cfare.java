package fare;
import java.io.DataInputStream;
import java.io.FileInputStream;
import twowheelers.*;
public class cfare implements parkingfare
{
     public cfare(String st1)
    {
        boolean found=false;
        try
        {
        DataInputStream fin=new DataInputStream(new FileInputStream("D:\\OneDrive\\Desktop\\Lot A.txt"));
        while(fin.available()>0)
        {
            String ticket=fin.readUTF();
            if(ticket.equals(st1))
            {
                System.out.println("Your Vehicle is Parked in FLOOR A,LOT "+(ticket).substring(2));
                fare();
                found=true;
                cycle.vehicleleft();
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
        System.out.println("The Parking Fare for your Cycle --- 100Rs");
        
    }
}
