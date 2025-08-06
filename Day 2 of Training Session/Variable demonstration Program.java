//Program to Demonstrate var
class baseclass 
{
    //var can only be used inside the block
    public void iterator()
    {
      for(var i=0;i<10;i++)
      {
        System.out.print(i+ " ");
      }
    }
  public void display()
  {
    var variable="Variable";
    System.out.println(variable);
  }
}
class imp
{
    public static void main(String args[])
    {
        baseclass bc=new baseclass();
        bc.iterator();
        bc.display();
    }
}
