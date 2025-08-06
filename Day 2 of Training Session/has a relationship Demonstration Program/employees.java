class employee
{
 String name,dept,gender;
 int age;
 address ad;
 employee(String name,int age,String dept,String gender,address ad)
 {
    this.name=name;
    this.age=age;
    this.dept=dept;
    this.gender=gender;
    this.ad=ad;
    display();
 }
 public void display()
 {
    System.out.println("Name "+name);
    System.out.println("Age "+age);
    System.out.println("Department "+dept);
    System.out.println("Gender "+gender);
    ad.displaydetails();
 }
}
class driver
{
    public static void main(String args[])
    {
        address a=new address("Hormavu","Bengaluru",540023);
        employee o=new employee("Arjun",23,"IT","M",a);

    }
}
