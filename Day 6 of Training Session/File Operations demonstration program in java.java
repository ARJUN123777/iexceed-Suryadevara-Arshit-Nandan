//Progra to demonstrate the file operations in java
import java.io.File;
class Main 
{
    public static void main(String args[])
    {
        File f=new File("C:/Users/arshit.nandan/Desktop/Day 6 Training Program/new file.txt"); //Adding the file path to create the file
        f.createNewFile();
        System.out.println(f.isAbsolute());
        System.out.println(f.getAbsolutePath());
        System.out.println("Does the file exists? "+f.exists());
        if(f.exists())
        {
            System.out.println("Can we Read the file ? "+f.canRead());
            System.out.println("Can we Write the file ? "+f.canWrite());
        }
    }
}
