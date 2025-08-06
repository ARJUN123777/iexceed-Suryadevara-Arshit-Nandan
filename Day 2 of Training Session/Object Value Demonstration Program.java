public class test {
    public void getobjectvalue(test obj)
    {
        System.out.println("Value of the object is:"+this);
    }
    public void getobject()
    {
        getobjectvalue(this);
    }
}
class driver{
    public static void main(String args[])
    {
        test obj=new test();
        obj.getobject();
        System.out.println("Value of the object outside the class is "+obj);
    }
}
