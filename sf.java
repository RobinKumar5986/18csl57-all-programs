import java.net.ServerSocket;
import java.io.*;
import java.net.Socket;
import java.util.*;
class sf{
	public static void main(String args[])
	{
	try{
		System.out.println("Wating for connection....");
		ServerSocket ss=new ServerSocket(8000);
		Socket soc=ss.accept();
		System.out.println("connected....");
		Scanner sc=new Scanner(soc.getInputStream());
		String fName=sc.next();
		File f=new File(fName);
		Scanner fr=new Scanner(f);
		PrintWriter out=new PrintWriter(soc.getOutputStream(),true);
		while(fr.hasNextLine())
		{
			out.println(fr.nextLine());
			
		}
	}catch(Exception e){}
	}
}
