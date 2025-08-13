import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
class assignment 
{
   public static void main(String args[]) throws Exception
   {
    int i1=0;
    System.out.println("Before Modifying the content in the File");
      FileInputStream fin=new FileInputStream(args[0]);
      while((i1=fin.read())!=-1)
      {
        System.out.print((char)i1);
      }
   FileOutputStream fout=new FileOutputStream(args[0]);
   String msg="Your Journey to the Software industry starts here as Graduate Engineer Trainee";
   byte bytemsg[]=msg.getBytes();
   fout.write(bytemsg);
   fout.close();
   System.out.println("\nAfter Modifying the content in the File");
   int i2=0;
   FileInputStream fin1=new FileInputStream(args[0]);
   while((i2=fin1.read())!=-1)
   {
    System.out.print((char)i2);
   }
}
}
