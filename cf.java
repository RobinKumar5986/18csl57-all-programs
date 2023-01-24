import java.io.*;
import java.util.*;
import java.net.Socket;

class cf{
	public static void main(String[] args)
	{
	try{
		System.out.println("Client is started....");
		Socket soc=new Socket("localhost",8000);
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the file Name : ");
		String fn=sc.next();
		PrintWriter out=new PrintWriter(soc.getOutputStream(),true);
		out.println(fn);
		Scanner data=new Scanner(soc.getInputStream());
		while(data.hasNextLine())
		{
			System.out.println(data.nextLine());
		}
		
	}catch(Exception e){}
	}
}
