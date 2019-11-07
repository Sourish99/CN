import java.util.*;

class hamming
{
    public static void main(String args[])
    {
        int i,g[],h[];
        g = new int[20];
        h = new int[20];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the 7 bits :");
        for(i=1;i<=11;i++)
        {
            if( i==1 || i==2 || i==4 || i==8)
                h[i]=-1;
            else
                h[i]= sc.nextInt();
        }

        h[1]=(h[3]+h[5]+h[7]+h[9]+h[11])%2;
        h[2]=(h[3]+h[6]+h[7]+h[10]+h[11])%2;
        h[4]=(h[5]+h[6]+h[7])%2;
        h[8]=(h[9]+h[10]+h[11])%2;

        System.out.println("The sent bits are:");
        for(i=1;i<=11;i++)
            System.out.println(h[i]+" ");

        System.out.println("The received bits are:");
        for(i=1;i<=11;i++)
            g[i]=sc.nextInt();
        for(i=1;i<=11;i++)
        {
            if(h[i]!=g[i])
            {
                System.out.println("Error at position"+i);
                break;
            }
            else
            {
                System.out.println("No error");
            }    
        }
    }
}
