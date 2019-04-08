import java.io.*;
import java.net.*;
class udpclient
{
public static void main(String args[])throws Exception
	{
	InputStreamReader isr=new InputStreamReader(System.in);
	BufferedReader bf=new BufferedReader(isr);
	DatagramSocket ds=new DatagramSocket();
	byte[] send=new byte[1024];
	byte[] rec=new byte[1024];
	InetAddress ip=InetAddress.getByName("127.0.0.1");
	String req="";
		do
		{
		System.out.println("\nEnter message: ");
		req=bf.readLine();
		send=req.getBytes();
		DatagramPacket dp=new DatagramPacket(send,send.length,ip,9875);
		ds.send(dp);
		DatagramPacket rdp=new DatagramPacket(rec,rec.length);
		ds.receive(rdp);
		String res=new String(rdp.getData());
		System.out.println("\nFrom server: "+res+"\n");
		}
		while(!req.equals("quit"));
ds.close();
	}
}
