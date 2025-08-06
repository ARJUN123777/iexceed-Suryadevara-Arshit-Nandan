//Program to demonstrate the use of default block inside the interface 
interface myinterface
{
    default void display()
    {
      System.out.println("Statements inside the default block");
    }
    public void display1();
}
class childclass implements myinterface
{
   childclass()
   {
   display1();
   myinterface.super.display();
    }
    public void display1()
    {
        System.out.println("Method is overriden from the interface");
    }
}
class drivingfunction
{
    public static void main(String args[])
    {
        new childclass();
    }
}

//Program to describe the usage of deafult block with diamond problem
interface interface1
{
    default void displays()
    {
        System.out.println("Statement inside ths interface block");
    }
    public void display2();
}
interface interface2
{
    default void displays()
    {
        System.out.println("Statement inside the second interface block");
    }
    public void display3();
}
class derivedclass implements interface1,interface2
{
    derivedclass()
    { 
        display2();
        display3();
    }
    public void displays()
    {
        interface1.super.displays();
        interface2.super.displays();
    }
    public void display2()
    {
      System.out.println("Method overriden from the first Interface");
    }
    public void display3()
    {
        System.out.println("Method overriden form the Second Interface");
    }
}
class anotherfunction
{
    public static void main(String args[])
    {
       derivedclass obj= new derivedclass();
    }
}
