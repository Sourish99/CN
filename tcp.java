import java.io.*;

public class TCPHeader
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the hex dump :");
        String input = br.readLine();

        //Source port
        String SPort = input.substring(0,4);
        System.out.println("Source Port :"+ Integer.parseInt(SPort,16));

        //Destination port
        String DPort = input.substring(4,8);
        System.out.println("Destination Port :"+ Integer.parseInt(DPort,16));

        //Sequence number
        String seq_no = input.substring(8,16);
        System.out.println("Sequence Number :"+ Integer.parseInt(seq_no,16));

        //Acknowledgement number
        String ack_no = input.substring(16,24);
        System.out.println("Acknowledgement Number :"+ Integer.parseInt(ack_no,16));

        //Header Length
        String h_len = input.substring(24,25);
        System.out.println("Header Length :"+ (4 * Integer.parseInt(h_len,16)) + "Bytes");

        //FLags
        String flags = input.substring(26,28);
        String flags_bin = Integer.toBinaryString(Integer.parseInt(flags,16));
        while(flags_bin.length() < 8)
            flags_bin = "0" + flags_bin;
        
        flags_bin = flags_bin.substring(2,8);

        if(flags_bin.charAt(0) == '1')
            System.out.println("Urgent pointer is valid");
        if(flags_bin.charAt(1) == '1')
            System.out.println("Acknowledegment pointer is valid");
        if(flags_bin.charAt(2) == '1')
            System.out.println("Packet needs to be delivered to the receiving application as soon as possible");
        if(flags_bin.charAt(3) == '1')
            System.out.println("Sender is aborting the connection");
        if(flags_bin.charAt(4) == '1')
            System.out.println("Sender is attempting to synchronize the connection");
        if(flags_bin.charAt(5) == '1')
            System.out.println("No more data from the sender");
        
        //Window size
        String win_size = input.substring(28,32);
        System.out.println("Window Size :"+ Integer.parseInt(win_size,16) + "Bytes");

        //Header Checksum
        String checksum = input.substring(32,36);
        System.out.println("Header Checksum :"+ Integer.parseInt(checksum,16));

        //Urgent Pointer
        String urg = input.substring(36,40);
        System.out.println("Urgent Pointer :"+ Integer.parseInt(urg,16));

    }
}
