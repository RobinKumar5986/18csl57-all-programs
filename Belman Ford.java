import java.util.*;
class Main{
    public static int max=999;
    int[] d;
    int n;
    public void set(int n)
    {
        this.n=n;
        d=new int[n+1];
    }
    public void shortest(int[][] a,int s)
    {
        for(int i=1;i<=n;i++)
            d[i]=max;
        d[s]=0;
        for(int k=1;k<=n-1;k++)
        {
            for(int i=1;i<=n;i++)
            {
                for(int j=1;j<=n;j++)
                {
                    if(d[j]>(d[i]+a[i][j]))
                        d[j]=d[i]+a[i][j];
                }
            }
        }
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(a[i][j]!=max)
                {
                    if(d[j]>d[i]+a[i][j]){
                        System.out.println("The graph contains -ve edge cycle ");
                        return;
                    }
                }
            }
        }
        for(int i=1;i<=n;i++)
        {
            System.out.println("Distance from source "+s+" to Destination "+i+" is "+d[i]);
        }
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=0,s;
        System.out.print("Enter the No. of nodes : ");
        n=sc.nextInt();
        int a[][]=new int[n+1][n+1];
        Main b = new Main();
        b.set(n);
        
        System.out.println("Enter the metrix : ");
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {
                a[i][j]=sc.nextInt();
                if(i==j)
                {
                    a[i][j]=0;
                    continue;
                }
                if(a[i][j]==0)
                {
                    a[i][j]=max;
                }
            }
        }
        System.out.print("Enter the Source : ");
        s=sc.nextInt();
        b.shortest(a,s);
    }
}