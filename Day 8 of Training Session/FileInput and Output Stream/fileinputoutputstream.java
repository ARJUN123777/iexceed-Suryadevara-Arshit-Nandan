import java.io.FileInputStream;
import java.io.File;
import java.io.FileOutputStream;
class fileinputoutputstream
{
  public static void main(String args[]) throws Exception
  {
    FileOutputStream fout=new FileOutputStream("C:\\Users\\arshit.nandan\\Desktop\\Test file.txt");
    String msg="This is going to be the one of my beautiful experience in the Software Industry";
    byte bytemsg[]=msg.getBytes();
    fout.write(bytemsg);
    fout.close();  //The file must be closed after it has been modified
    FileInputStream fi=new FileInputStream("C:\\Users\\arshit.nandan\\Desktop\\Test file.txt");
    int i=0;
    fi.skip(8);
    while((i=fi.read())!=-1)
    {
       System.out.print((char)i);
    }

  }
}
