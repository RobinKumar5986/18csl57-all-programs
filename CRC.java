import java.util.*;
class Main{
    
    void div(int[] a,int k)
    {
        int gp[]={1,0,0,0,1,0,1,1,0,1,1,0,0,0,1,1,0};
        int count=0;
        for(int i=0;i<k;i++)
        {
            if(a[i]==1)
            {
                for(int j=i;j<gp.length;j++)
                {
                    a[j]=a[j]^gp[count++];
                }
                count=0;
            }
        }
    }
    public static void main(String args[])
    {
    //---------sender---------------------//
        Scanner sc=new Scanner(System.in);
        Main ob=new Main();
        int[] a=new int[100];
        int[] b=new int[100];
        
        int k,len,flag=0;
        
        System.out.print("Enter the Data length : ");
        
        k=sc.nextInt();
        len=k+16;
        System.out.println("Enter The Data : ");
        for(int i=0;i<k;i++)
            a[i]=sc.nextInt();
        for(int i=0;i<len;i++)
            b[i]=a[i];
        
        ob.div(a,k);
        for(int i=0;i<len;i++)
            a[i]=a[i]^b[i];
        System.out.println("Transmited Data....");
        for(int i=0;i<len;i++)
            System.out.print(a[i]+" ");
        System.out.println();
    //----------------reciver-----------------//
        System.out.println("Enter Recived Data....");
        for(int i=0;i<len;i++)
            a[i]=sc.nextInt();
        ob.div(a,k);
        for(int i=0;i<len;i++)
        {
            if(a[i]!=0)
            {
                flag=1;
                break;
            }
        }
        if(flag==1)
            System.out.println("Error in the Data...");
        else
            System.out.println("No Error in the Data...");
    }
}