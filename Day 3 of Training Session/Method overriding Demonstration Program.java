//Program to demonstrate method overriding in java
class superclass {
    superclass()
    {
    }
    public void method()
    {
        System.out.println("Method of super class");
    }
}
class childclass extends superclass{
    childclass()
    {

    }
    public void method()
    {
        System.out.println("Method of child class");
    }
}
class driverclass
{
    public static void main(String args[])
    { 
        superclass obj;
        superclass obj1=new superclass();
        childclass obj2=new childclass();
        obj2=obj1; //We use the Dynamic Dispatch Method to overide the Methods in super class and the child class
        obj2.method();
    }
}

