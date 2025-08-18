package twowheelers;
import java.util.*;
public class twowheelervehicle
{
    Scanner sc=new Scanner(System.in);
    int type;
    public twowheelervehicle()
    {
        System.out.println("===============================================");
        System.out.println("Please select your Two Wheeler Type");
        System.out.println("TYPE 1---MOTOR BIKE");
        System.out.println("TYPE 2---CYCLE");
        System.out.print("Your choice: ");
        this.type=sc.nextInt();
        if(this.type==1)
        {
           new motorbike();
        }
        else if(this.type==2)
        {
          new cycle();
        }
    }
}
