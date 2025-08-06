//Program to demonstrate nested class in java
class outerclass  //outer class
{                  //outer class should be of public access specifier
    private String st="LARGE LANGUAGE MODELS";    //these variables can be accessed by the inner class 
    private double d=3.14159265359;            
    class innerclass     //inner class is also called as non-static class
    {                      //inner class can be of any access specifier
        String st1; 
        int i;
        innerclass(String st1,int i)
        {
            this.st1=st1;
            this.i=i;
        }
        public void display()
        {
            System.out.println("Welcome to the Inner Loop");
            System.out.println(st1+" is the No"+i+" fintech company in Bangalore");
        }
    }
    public void outdisplay()
    {
        System.out.println("Welcome to Outer Loop");
        System.out.println("We deal with "+st);
        System.out.println("The Value of pi is "+d);
    }
    
}
class drivingfunction
{
    public static void main(String args[])
    {
        new outerclass().outdisplay();        //displaying the method from the outer class
        outerclass.innerclass obj=new outerclass().new innerclass("iexceed",1);     //creating an object for the inner class
        obj.display();                       //displaying the method from the inner class
    }
}
