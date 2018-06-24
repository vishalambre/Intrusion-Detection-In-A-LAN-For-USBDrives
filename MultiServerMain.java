import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServerMain {

	public static void main(String args[]) throws IOException
	{	
		Socket s[]=new Socket[2];
		ServerSocket ss=new ServerSocket(1342);
		MultiServer ms=new MultiServer();
		ms.acceptSocket(ss);
		Thread t[]=new Thread[10];
		for(int i=0;i<10;i++)
		{
			t[i]=new Thread(ms);
			t[i].start();
		}
	}
}
