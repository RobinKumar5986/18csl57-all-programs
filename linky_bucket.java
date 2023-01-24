import java.util.*;
public class link {
    public static void main(String []args){
        int a[]=new int[20];
        int buc_cap=4,rate=3,sent,recv,rem=0;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of packets : ");
        int n=in.nextInt();
        for(int i=1;i<=n;i++)
        a[i]=in.nextInt();
        System.out.println("Clock Size\tPAcket Size\treceives\tsent\tremaining");
        for(int i=1;i<=n;i++)
        {
            if(a[i]!=0){
                if(rem+a[i]>buc_cap)
                recv=-1;
                else{
                    recv=a[i];
                    rem=rem+a[i];
                }
            }
            else
            recv=0;
            if(rem!=0){
            if (rem<rate){
                sent=rem;
                rem=0;
            }
            else{
                sent=rate;
                rem=rem-rate;
            }
        }
        else{
            sent=0;
        }
        if(recv==-1){
            System.out.println(i+"\t"+a[i]+"\t"+"Dropped"+"\t"+sent+"\t"+rem);
        }
        else{
            System.out.println(i+"\t"+a[i]+"\t"+recv+"\t"+sent+"\t"+rem);

        }
        }  
        in.close();  
    }
}