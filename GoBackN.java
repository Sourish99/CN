package pracs;
import java.util.*;
import java.lang.*;
public class GoBackN {
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the max window size");
		int n=sc.nextInt();
		int frame=(int)Math.pow(2,n);
		int transmit[]=new int[frame];
		int transmit_flag[]=new int[frame];
		int receive[]=new int[frame-1];
		int count1=0;
		int count2=0;
		int index=0;
		
		for(int c=0;c<n;c++)
		{
			transmit[c]=c;
			transmit_flag[c]=0;
		}
		int inp=1;
		do
		{
			System.out.println("\n1.Execute  2.EXIT");
inp=sc.nextInt();
switch(inp)
{
case 1:
{
count1=0;
count2=0;
System.out.println("\nFrames allowed");
for(int c=index;c<n;c++)
{
	if(count1!=n-1)
	{
		System.out.println(transmit[c] +" ");
		count1+=1;
	}
	
}
if(count1!=n-1)
{
	for(int d=0, l=1;l<=n-count1;d++,l++)
	{
		System.out.println(transmit[d] + " ");
		count1+=1;
	}
}


	
System.out.println("/nThe tansmitted frames");
for(int c=0;c<n-1;c++)
{
	receive[c]=sc.nextInt();
}
System.out.println("\nMax window size reached "+index);
for(int c=0;c<n-1;c++)
{
	if(receive[c]==transmit[index])
	{
		transmit_flag[index]=1;
		System.out.println(receive[c]+" IS ACCEPTED");
		if(index==n-1)
		{
			index=0;
		}
		else
		{
			index+=1;
		}
	}
	else
	{
		System.out.println(receive[c]+" IS NOT ACCEPTED");
		break;
	}
}

for(int c=index;c<n;c++)
{
	transmit_flag[c]=0;
	count2+=1;
}
if(count2!=n)
{
	for(int d=0,l=1;l<=n-count2;d++,l++)
	{
		transmit_flag[d]=0;
	}
}
break;

}
case 2:
{
	System.out.println("\nEXITED");
	break;
}
default:
{
	System.out.println("\nInvalid input");
	break;
}
}		
		}while(inp!=2);
		}
	}
