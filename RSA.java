import java.util.*;
import java.io.*;

public class Main
{
    public static int gcd(int m,int n)
    {
        while(n!=0)
        {
            int r=m%n;
            m=n;
            n=r;
        }
        return m;
    }
	public static void main(String[] args) {
		int p=0,q=0,n=0,e=0,d=0,phi=0;
		int num[]=new int[100];
		int enc[]=new int[100];
		int dec[]=new int[100];
		int i=0,j=0,len=0;
		
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the messege to Encrypt :\n");
		String msg=sc.nextLine();
		System.out.println("Enter the Value of p and q :");
		p=sc.nextInt();
		q=sc.nextInt();
		n=p*q;
		phi=(p-1)*(q-1);
		for(i=2;i<phi;i++)
		{
		    if(gcd(i,phi)==1)
		    {
		        break;
		    }
		}
		e=i;
		for(i=2;i<phi;i++)
		{
		    if((e*i-1)%phi==0)
		    {
		        break;
		    }
		}
		d=i;
		for(i=0;i<msg.length();i++)
		{
		    char c=msg.charAt(i);
		    int a=(int)c;
		    num[i]=a-96;
		}
		len=msg.length();
		for(i=0;i<len;i++)
		{
		    enc[i]=1;
		    for(j=0;j<e;j++)
		    {
		        enc[i]=(enc[i]*num[i])%n;
		    }
		}
		System.out.println("Encryptde data is : ");
		for(i=0;i<len;i++)
		{
		    System.out.print(enc[i]+" ");
		    System.out.print((char)(enc[i]+96)+" ");
		}
		System.out.println();
        for(i=0;i<len;i++)
        {
            dec[i]=1;
            for(j=0;j<d;j++)
            {
                dec[i]=(enc[i]*dec[i])%n;
            }
        }
        System.out.println("Decrypted Data : ");
        for(i=0;i<len;i++)
        {
            System.out.print((char)(dec[i]+96));
        }
	}
}
