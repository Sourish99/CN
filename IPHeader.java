package pracs;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class IPHeader {
	public static void main(String args[]) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter hex dump");
		String input=br.readLine();
		String Ver=input.substring(0,1);
		if(Ver.equals("4"))
		{
			System.out.println("Version: 4");
		}
		if(Ver.equals("6")) {
			System.out.println("Version: 6");
		}
		
		String H_len=input.substring(1,2);
		System.out.println("Header length: "+ (4*Integer.parseInt(H_len,16) +"Bytes"));
		
		String s_type=input.substring(2,4);
		String s_t_bin=Integer.toBinaryString(Integer.parseInt(s_type,16));
		while(s_t_bin.length()<8)
		{
			s_t_bin="0"+s_t_bin;
		}
		System.out.println("Service Type" +Integer.parseInt(s_t_bin.substring(0,3),2));
		
		if(s_t_bin.charAt(3)=='1')
		{
			System.out.println("Minimize Delay requested");
		}
		if(s_t_bin.charAt(4)=='1')
		{
			System.out.println("Maximize Throughput requested");
		}
		if(s_t_bin.charAt(5)=='1')
		{
			System.out.println("Maximize Reliability requested");
		}
		if(s_t_bin.charAt(6)=='1')
		{
			System.out.println("Minimize cost requested");
		}
		
		String tot=input.substring(4,8);
		System.out.println("Total Length"+ Integer.parseInt(tot,16) +"Bytes");

		String id=input.substring(8,12);
		System.out.println("Identification" +Integer.parseInt(id,16));
		
		String frag=input.substring(12,16);
		String frag_bin=Integer.toBinaryString(Integer.parseInt(frag,16));
		while(frag_bin.length()<16)
		{
			frag_bin="0"+frag_bin;
		}
		String frag_flags=frag_bin.substring(0,3);
		if(frag_flags.charAt(1)=='1')
		{
			System.out.println("Do not fragment packet");
		}
		else
		{
			System.out.println(" fragment packet");
		}
		if(frag_flags.charAt(2)=='1')
		{
			System.out.println("More fragments pending");
		}
		else {
			System.out.println("No more fragments pending");
		}
		
		System.out.println("Fragment offset" +((8*Integer.parseInt(frag_bin.substring(3,16),2)) -(4*Integer.parseInt(H_len,16))));
		
		String tol=input.substring(16,18);
		System.out.println("Time to live" + Integer.parseInt(tol,16));
		
		String protocol=input.substring(18,20);
		if(Integer.parseInt(protocol,16)==1)
		{
			System.out.println("Protocol:ICMP");
		}
		if(Integer.parseInt(protocol,16)==2)
		{
			System.out.println("Protocol:IGMP");
		}
		if(Integer.parseInt(protocol,16)==89)
		{
			System.out.println("Protocol:OSPF");
		}
		if(Integer.parseInt(protocol,16)==6)
		{
			System.out.println("Protocol:TCP");
		}
		if(Integer.parseInt(protocol,16)==17)
		{
			System.out.println("Protocol:UDP");
		}
		
		String checksum=input.substring(20,24);
		System.out.println("Header checksum is "+Integer.parseInt(checksum,16));
		
		String s_port=input.substring(24,32);
		String s_port_bin=Long.toBinaryString(Long.parseLong(s_port,16));
		while(s_port_bin.length()<32)
		{
			s_port_bin="0"+s_port_bin;
		}
		System.out.println("Source Port Address");
		System.out.println(Integer.parseInt(s_port_bin.substring(0,8),2) + ".");
		System.out.println(Integer.parseInt(s_port_bin.substring(8,16),2) +".");
		System.out.println(Integer.parseInt(s_port_bin.substring(16,24),2) +".");
		System.out.println(Integer.parseInt(s_port_bin.substring(24,32),2));
	 String d_port=input.substring(32,40);
	 String d_port_bin=Long.toBinaryString(Long.parseLong(d_port,16));
	 while(d_port.length()<32)
	 {
		 d_port="0"+d_port;
	 }
	 System.out.println("Destination Port :");
	 System.out.println(Integer.parseInt(d_port_bin.substring(0,8),2) +".");
	 System.out.println(Integer.parseInt(d_port_bin.substring(8,16),2)+ ".");
	 System.out.println(Integer.parseInt(d_port_bin.substring(16,24),2)+".");
	 System.out.println(Integer.parseInt(d_port_bin.substring(24,32),2));
	
	}

}
