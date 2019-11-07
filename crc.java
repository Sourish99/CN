import java.util.*;

class crc
{
    int EXOR(int x,int y)
    {
        if(x==y)
            return 0;
        else
            return 1;
    }	
    
    public static void main(String args[])
    {
        int i,j,k,m,n,gen[],store[],fr[],flag;
        fr = new int[20];
        store = new int[20];
        gen = new int[20];
        crc ob1 = new crc();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of bits in generator and frame");
        n = sc.nextInt();
        m = sc.nextInt();

        System.out.println("Enter the bits in generator");
        for (i=1;i<=n;i++)
            gen[i] = sc.nextInt();

        System.out.println("Enter the bits in frame");
        for (i=1;i<=m;i++)
        {
            fr[i] = sc.nextInt();
            store[i] = fr[i];
        }

        for (i=m+1;i<=m+n-1;i++)                        //dataword ke baad ke (n-1)zeros
            fr[i]=0;

        for (j=1;j<=m;j++)
        {
            if(fr[j]==0)
                for (k=1;k<=n;k++)
                    fr[j+k-1] = ob1.EXOR(fr[j+k-1], gen[k]);
            for (k=1;k<=n;k++)
                fr[j+k-1] = ob1.EXOR(fr[j+k-1], gen[k]);
        }

        for (i=m+1;i<=m+n-1;i++)
            store[i]=fr[i];
        
        System.out.println("The Transmitted bits are: ");
        for (i=1;i<=m+n-1;i++)
            System.out.println(store[i]+" ");

        System.out.println("\nEnter the recieved bits");
        for (i=1;i<=m+n-1;i++)
            fr[i]=sc.nextInt();

        for (j=1;j<=m;j++)
        {
            if(fr[j]==0)
                for (k=1;k<=n;k++)
                    fr[j+k-1] = ob1.EXOR(fr[j+k-1], gen[k]);
            for (k=1;k<=n;k++)
                fr[j+k-1] = ob1.EXOR(fr[j+k-1], gen[k]);
        }
    
        flag=0;
        for (i=m+1;i<=m+n-1;i++)
            if(fr[i]==1)
                flag=1;

        if(flag==0)
            System.out.println("No error");
        else
            System.out.println("Error");
        
    }
    
}
