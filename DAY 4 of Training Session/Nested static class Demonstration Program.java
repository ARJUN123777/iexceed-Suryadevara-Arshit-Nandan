class wrapperclass       //top level classes can not be static
{
static class staticclass1 //For the outer class to be a static class then the outer static class must be wrapped within the wrapper class
{
    private String st1="REGRESSION MODELS IN PYTHON";
    private static int i=90;               
    double d=45;
    float fl=81.2938f;
    static class staticclass2
    {
        String st2="GEN AI IS THE NEXT BIG THING IN THE INDUSTRY";
        private static double r=3.141589914212;
        boolean f1=false;
        static void display2()
        {
            System.out.println("Data inside the Inner static class");
            System.out.println(new staticclass2().st2);
            System.out.println("The Value of Pi is : "+r);
            System.out.println("The Default value of boolean is: "+new staticclass2().f1);
            System.out.println("The value of Float from the outer class is :"+new staticclass1().fl);
        }
    }
      static void display1()
    {
            System.out.println("Data inside the Outer Static class");
            System.out.println(new staticclass1().st1);
            System.out.println("The value of Integer is :"+i);
            System.out.println("The value of double is :"+new staticclass1().d); //To use the non static variable inside the static method we need to call the non static varaiable by the object
    }
} 
  public static void main(String[] args)
    {
        staticclass1.display1();
        staticclass1.staticclass2.display2();
    }
}
