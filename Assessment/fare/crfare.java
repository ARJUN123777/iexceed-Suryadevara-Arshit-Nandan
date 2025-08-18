package fare;
import fourwheelers.*;
import java.io.*;
public class crfare implements parkingfare
{
    public crfare(String st1)
    {
        boolean found=false;
        try
        {
        DataInputStream fin=new DataInputStream(new FileInputStream("D:\\OneDrive\\Desktop\\Lot C.txt"));
        while(fin.available()>0)
        {
            String ticket=fin.readUTF();
            if(ticket.equals(st1))
            {
                System.out.println("Your Vehicle is Parked in FLOOR C,LOT "+(ticket).substring(2));
                fare();
                found=true;
                cars.vehicleleft();
                break;
            }
        }
        }catch(Exception e){};
        if(!found)
        {
            System.out.println("Vehicle No found");
        }
    }

    public void fare()
    {
        System.out.println("The Parking Fare for your Car --- 200Rs");
        
    }
}
