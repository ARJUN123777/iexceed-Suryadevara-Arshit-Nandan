import fourwheelers.*;
import java.util.*;
import search.searchvehicle;
import twowheelers.*;
class vehicle
{
    int type;
    twowheelervehicle t;
    fourwheelervehicle f;
    public vehicle(int type)
    {
        this.type = type;
        if(this.type == 1)
        {
            t=new twowheelervehicle();     //Calling a Method from another class present in another package
        }
        else
        {
           f= new fourwheelervehicle();  //Calling a method from another class present in another package
        }
    }
}
class mainprogram
{
    public static void main(String args[])
    {
        while (true) 
        { 
            
        Scanner sc = new Scanner(System.in);
        System.out.println("===============================================");
        System.out.println("WELCOME TO PARKING AREA");
        System.out.println("1.Park your Vehicle");
        System.out.println("2.Search your Vehicle");
        System.out.print("Your Choice: ");
        int c1=sc.nextInt();
        if(c1==1)
        {
        System.out.println("Select your vehicle");
        System.out.println("1.TWO-WHEELER");
        System.out.println("2.FOUR-WHEELER");
        System.out.print("Your choice: ");
        int s=sc.nextInt();
        new vehicle(s);
        System.out.println("================================================");
        }
        else
        {
        sc.nextLine();
        System.out.print("PLEASE ENTER YOUR TICKET NO: ");
        String ticketNo=sc.nextLine();
        System.out.println("================================================");
        searchvehicle sr;
        sr=new searchvehicle(ticketNo);
        }
        }
    }
}

