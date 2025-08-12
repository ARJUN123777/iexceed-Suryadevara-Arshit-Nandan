//Program to demonstrate the interface segregation principle in java
interface chemistry 
{
    public void teachchemistry();
}
interface physics
{
    public void teachphysics();
}
interface maths
{
    public void teachmaths();
}
interface biology
{
    public void teachbiology();
}
class mpc implements maths,physics,chemistry
{
    mpc()
    {
        System.out.println("MPC LECTURER");
        teachmaths();
        teachphysics();
        teachchemistry();
    }
    public void teachmaths()
    {
        System.out.println("Teaches Maths");
    }
    public void teachphysics()
    {
        System.out.println("Teaches Physics");
    }
    public void teachchemistry()
    {
        System.out.println("Teaches Chemistry");
    }
}
class bipc implements biology,physics,chemistry
{
    bipc()
    {
        System.out.println("BIPC LECTURER");
        teachbiology();
        teachphysics();
        teachchemistry();
    }
    public void teachbiology()
    {
        System.out.println("Teaches Biology");
    }
    public void teachphysics()
    {
        System.out.println("Teaches Physics");
    }
    public void teachchemistry()
    {
        System.out.println("Teaches Chemistry");
    }
}
class drivers
{
    public static void main(String args[])
    {
        new mpc();
        new bipc();
    }
}