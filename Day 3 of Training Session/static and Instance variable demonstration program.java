//program to demonstrate the use of static variable 
import java.util.*;
class staticclass
{
    int k1=2;  //the value remains the same and does not change when calling the object
    static int k2=8; //the value changes evrytime when the object is called
    staticclass()
    {
        k1++;
        k2++;
        System.out.println("k1 "+"k2");
        System.out.print(k1+" ");
        System.out.println(k2);
    }
}
class drivingclass
{
    public static void main(String args[])
    {
        staticclass sc=new staticclass();
        staticclass sc1=new staticclass();
    }
}

//program to demonstrate the use od static block
class sampleclass
{
    int x=19;   //instance variable
    //Static Context
    static String st="TERMINATOR";   //Static variable
    sampleclass()
    {
    }
    public void display()
    {
        System.out.println("Instance Method");
        System.out.println("integer= "+x);
        System.out.println("string= "+st);
    }
    static void display1()
    {
        System.out.println("Static method");
         System.out.println("integer= "+new sampleclass().x);   //the instance variable can not be used inside the static method
        System.out.println("string= "+st);   //To use the instance variable we need to call the object
    }
    public static void main(String args[])
    {
        new sampleclass().display();
        display1(); //
    }
}
