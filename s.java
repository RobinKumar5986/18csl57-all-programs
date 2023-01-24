import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.util.*;
class s{
	public static void main(String[] args)
	{
		try{
			System.out.println("Wating for connection.... ");
			ServerSocket ss=new ServerSocket(4000);
			Socket soc=ss.accept();
			System.out.println("Connected ;-)");
			System.out.println("Enter The msg :");
			Scanner sc=new Scanner(System.in);
			String msg=sc.nextLine();
			PrintWriter out=new PrintWriter(soc.getOutputStream(),true);
			out.println(msg);
			
		}catch(Exception e){}
	}
}
