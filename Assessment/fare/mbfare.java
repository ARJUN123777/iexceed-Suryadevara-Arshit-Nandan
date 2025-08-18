package fare;
import java.io.DataInputStream;
import java.io.FileInputStream;
import twowheelers.*;
//Dependecy Inversion Principle
interface parkingfare     //Functional Interface takes only one method
{
    public void fare();
}
public class mbfare implements parkingfare
{
   public mbfare(String st1)
    {
        boolean found=false;
        try
        {
        DataInputStream fin=new DataInputStream(new FileInputStream("D:\\OneDrive\\Desktop\\Lot B.txt"));
        while(fin.available()>0)
        {
            String ticket=fin.readUTF();
            if(ticket.equals(st1))
            {
                System.out.println("Your Vehicle is Parked in FLOOR B,LOT "+(ticket).substring(2));
                fare();
                found=true;
                motorbike.vehicleleft();
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
        System.out.println("The Parking Fare for your Bike --- 150Rs");
        
    }
}
