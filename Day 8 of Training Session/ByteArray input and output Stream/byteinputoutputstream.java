//Program to demonstrate the ByteArrayOutput Operations in java
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
class byteoutputstream
{
 public static void main(String args[]) throws Exception
 {
    File f1=new File("C:\\Users\\arshit.nandan\\Desktop\\File1.txt");
    File f2=new File("C:\\Users\\arshit.nandan\\Desktop\\File2.txt");
    ByteArrayOutputStream bout=new ByteArrayOutputStream();
    bout.writeBytes("This data is very crucial for the System and must be embedded into all the files".getBytes());
    FileOutputStream fout1=new FileOutputStream(f1);
    FileOutputStream fout2=new FileOutputStream(f2);
    bout.writeTo(fout1);
    bout.writeTo(fout2);
 }
}
