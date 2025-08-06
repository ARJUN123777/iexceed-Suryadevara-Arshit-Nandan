class demoblock
{
    {
        System.out.println("Statement inside a Instance block");
    }
    static
    {
        System.out.println("Statement inside a static block");
    }
    demoblock()
    {
        System.out.println("STATEMENT INSIDE A CONSTRUCTOR BLOCK");
    }
    public void display()
    {
        System.out.println("Statement inside the method block");
    }
}
class driverfunction
{
    public static void main(String args[])
    {
        demoblock db=new demoblock();
        db.display();
    } 
}

