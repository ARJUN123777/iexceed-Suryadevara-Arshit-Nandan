//Program to demonstrate the dependency inversion principle in java 
interface employee    //employee is high level module
{                         //We use the abstract method or the interfaces to prevent the dependency of the high level modules on the low modules
  public void empdetails(String name,int id,int Age,char gen,String Address);
  public int doj(); 
}    
class hr implements employee    //hr is low level module and should be depend on the abstract class called employee
{
    String name,Address;
    int id,age;
    char gen;
    hr(int id,String name,int Age,char gen,String Address)
    {
        this.name=name;
        this.id=id;
        this.age=Age;
        this.gen=gen;
        this.Address=Address;
        System.out.println("HR DEPARTMENT");
        empdetails(this.name,this.id,this.age,this.gen,this.Address);
        int y=doj();
        System.out.println("This Employee joined in the year "+y);
    }
    public void empdetails(String name,int id,int age,char gen,String Address)
    {
      System.out.println("Name- "+this.name);
      System.out.println("Id- "+this.id);
      System.out.println("Age- "+this.age);
      System.out.println("Gender- "+this.gen);
      System.out.println("Address- "+this.Address);
    }
    public int doj()
    {
        return 2015;
    }
}
class it implements employee   //it is low level module and should be depend on the abstract class employee
{
    String name,Address;
    int id,age;
    char gen;
    it(int id,String name,int Age,char gen,String Address)
    {
        this.name=name;
        this.id=id;
        this.age=Age;
        this.gen=gen;
        this.Address=Address;
        System.out.println("IT DEPARTMENT");
        empdetails(this.name,this.id,this.age,this.gen,this.Address);
        int y=doj();
        System.out.println("This Employee joined in the year "+y);
    }
    public void empdetails(String name,int id,int age,char gen,String Address)
    {
      System.out.println("Name- "+this.name);
      System.out.println("Id- "+this.id);
      System.out.println("Age- "+this.age);
      System.out.println("Gender- "+this.gen);
      System.out.println("Address- "+this.Address);
    }
    public int doj()
    {
        return 2019;
    }
}
class driver
{
    public static void main(String args[])
    {
       new hr(1056,"Arushi",32,'F',"DELHI");
       new it(8092,"MURUGAN",29,'M',"CHENNAI");
    }
}
//Thye above code is compliant with the dependency inversion principle 