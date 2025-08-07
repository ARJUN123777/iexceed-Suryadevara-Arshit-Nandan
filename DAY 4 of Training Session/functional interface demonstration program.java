//functional interface takes only one method and restricts multiple methods
interface functionalinterface
{
    public void method1();                          //when we use the anonymous class there is no need to use the implements/extends keyword 
}
class functionalclass
{
    public static void main(String args[])
    {
        new functionalinterface()
        {
           public void method1()
            {
                System.out.println("Methods inside the functional interface ");
            }
        }.method1();
    }
}
