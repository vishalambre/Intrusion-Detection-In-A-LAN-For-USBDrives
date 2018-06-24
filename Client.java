import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException
    {
	  int check=2;
	  String domain;
    String[] letters = new String[]{ "A", "B", "C", "D", "E", "F", "G", "H", "I","J"};
    File[] drives = new File[letters.length];
    boolean[] isDrive = new boolean[letters.length];
    Socket s=new Socket("127.0.0.1",1342);
    PrintStream p=new PrintStream(s.getOutputStream());



    for ( int i = 0; i < letters.length; ++i )
        {
        drives[i] = new File(letters[i]+":/");

        isDrive[i] = drives[i].canRead();
        }



     while(true)
        {

        for ( int i = 0; i < letters.length; ++i )
            {
            boolean pluggedIn = drives[i].canRead();


            if ( pluggedIn != isDrive[i] )
                {
                if ( pluggedIn )
                {
	       check=1;								
                    domain=System.getenv("userdomain");
                    p.println(check);
	       p.println(domain);								
                }
                else
                {

	       check=0;								
                    domain=System.getenv("userdomain");
                    p.println(check);
	       p.println(domain);
										

                }

                isDrive[i] = pluggedIn;
                }
            }

        // wait before looping
        try { Thread.sleep(100); }
        catch (InterruptedException e) { /* do nothing */ }

        }
    }


}
