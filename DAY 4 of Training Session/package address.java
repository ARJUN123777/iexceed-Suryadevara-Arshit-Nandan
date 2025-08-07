//Program to demonstrate the uasge of class 
package mypackage;
class studentaddress 
{
    private String area,building,flat;
    int pincode;
    studentaddress(String f,String Building,String area,int pincode)
    {
        this.flat=f;
        this.building=Building;
        this.area=area;
        this.pincode=pincode;
        displaydetails();
    }
    private void displaydetails()
    {
        System.out.println("Student Address");
        System.out.println("Flat No- "+flat);
        System.out.println("Apartment- "+building);
        System.out.println("Area- "+area);
        System.out.println("Pincode- "+pincode);
    }
}
