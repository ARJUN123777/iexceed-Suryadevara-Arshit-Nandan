//Program to demonstrate the use of DataInputStream and DataOutputStream in java
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
class datainputstream 
{
  public static void main(String args[])throws Exception
  {
    File f=new File("C:\\Users\\arshit.nandan\\Desktop\\Sample File.txt");
    f.createNewFile();
    FileOutputStream fout=new FileOutputStream(f);
    DataOutputStream dout=new DataOutputStream(fout);
    dout.writeUTF("Name- ");
    dout.writeUTF("James Bond");
    dout.writeUTF("Number- ");
    dout.writeInt(007);
    dout.writeUTF("Height- ");
    dout.writeDouble(6.1);
    dout.close();
    FileInputStream fin=new FileInputStream(f);
    DataInputStream din=new DataInputStream(fin);
    System.out.print(din.readUTF());
    System.out.println(din.readUTF());
    System.out.print(din.readUTF());
    System.out.println(din.readInt());
    System.out.print(din.readUTF());
    System.out.println(din.readDouble());
  }
}
