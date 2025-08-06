//Program to demonstrate the abstract methods in java
abstract class abstractclass 
{
     abstract void method1();
     abstract void method2();
}
class childclass extends abstractclass 
{
    void method1()
    {
        System.out.println("Statement overriden by child class");
    }
    void method2()
    {
        System.out.println("Statement overriden by child class for second time");
    }
}
class fun
{
    public static void main(String args[])
    {
        childclass obj=new childclass();
        obj.method1();
        obj.method2(); 
    }
}
