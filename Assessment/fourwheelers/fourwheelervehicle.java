package fourwheelers;
import java.util.*;
public class fourwheelervehicle
{
    Scanner sc=new Scanner(System.in);
    int type;
    public fourwheelervehicle()
    {
        System.out.println("===============================================");
        System.out.println("Please Select your Four wheeler Type");
        System.out.println("TYPE 1---CAR");
        System.out.println("TYPE 2---VAN");
        System.out.println("TYPE 3---TRUCK");
        System.out.print("Your choice : " );
        int type=sc.nextInt();
        this.type=type;
        if(this.type==1)
        {
           new cars();
        }
        else if(this.type==2)
        {
            new van();
        }
        else if(this.type==3)
        {
            new truck();
        }
        else
        {
            System.out.println("Invalid Input");
        }
    }
}

