import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

class MultiServer implements Runnable{
	ServerSocket ss;
	void acceptSocket(ServerSocket st)
	{
		ss=st;
	}

	@Override
	public void run() {
		int flag;
		String domain;
		Socket s = null;
		try {
			s = ss.accept();
		} catch (IOException e) {


		}
		Scanner sc = null;
		try {
			sc = new Scanner(s.getInputStream());
		} catch (IOException e) {
			
		}
		while(true)
		{
		flag=sc.nextInt();
		domain=sc.next();

		if(flag==1)
		statpluggedin(domain);

		if(flag==0)
		statpluggedout(domain);
		}

	}

	static void statpluggedin(String domain)
	{
		System.out.println("USB Drive is detected"+domain);
	}
	static void statpluggedout(String domain)
	{
		System.out.println("USB Drive unplugged"+domain);
	}



	}
