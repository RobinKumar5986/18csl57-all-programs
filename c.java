import java.util.*;
import java.net.Socket;
class c{
	public static void main(String args[])
	{
		try{
			System.out.println("Client Started...");
			Socket soc=new Socket("localhost",4000);
			Scanner sc=new Scanner(soc.getInputStream());
			String msg=sc.nextLine();
			System.out.println("Msg from Server : "+msg);
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
