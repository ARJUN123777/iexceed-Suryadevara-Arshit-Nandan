//Program to demonstrate the usage of interfaces in java
interface interface1 {
    public void method1();
}
interface interface2
{
    public void method2();
}
class childclass implements interface1,interface2  //a class uses the implents keyword to implement the interfaces
{
    childclass()
    {
        method1();
        method2();
    }
    public void method1()
    {
        System.out.println("Method overriden from interface 1");
    }
    public void method2()
    {
        System.out.println("Method Overriden from interface 2");
    }
}
class driverclass 
{
    public static void main(String args[])
    {
        childclass obj=new childclass();
    }
}

//Scenario when one interface extends the other interface
interface interface3
{
    public void methodfrominterface3();
}
interface interface4 extends interface3 //an interface uses the extends keyword to extend the other interface
{
  public void methodfrominterface4();
}
class childclass1 implements interface4
{
    childclass1()
    {
        methodfrominterface3();
        methodfrominterface4();
    }
    public void methodfrominterface3()
    {
        System.out.println("Method overriden from interface 3");
    }
    public void methodfrominterface4()
    {
        System.out.println("Method overriden from interface 4");
    }
}
class drivingclass
{
    public static void main(String args[])
    {
        new childclass1();
    }
}

// Program to display the data of Mahindra Company using interfaces
interface mahindra
{
  public void displayCategory();
  public void displaymodel();
  public void displayyear();
  static  String location="India";  
}
class tractor implements mahindra
{
    String cat="Tractors";
    String model="Mahindra XP Plus";
    int year=2018;
    tractor()
    {
        displayCategory();
        displaymodel();
        displayyear();
    }
    public void displayCategory()
    {
        System.out.println("Name of the category: "+cat);
    }
    public void displaymodel()
    {
        System.out.println("Name of the Model: "+model);
    }
    public void displayyear()
    {
        System.out.println("Launched in the year "+year+" in "+location);
    }
}
class car implements mahindra
{
    String cat="Cars";
    String model="Mahindra Xuv";
    int year=2015;
    car()
    {
        displayCategory();
        displaymodel();
        displayyear();
    }
    public void displayCategory()
    {
        System.out.println("Name of the category: "+cat);
    }
    public void displaymodel()
    {
        System.out.println("Name of the Model: "+model);
    }
    public void displayyear()
    {
        System.out.println("Launched in the year "+year+" in "+location);
    }
}
class implementingfunction
{
    public static void main(String args[])
    {
        tractor obj=new tractor();
        car obj1=new car();

    }
}

