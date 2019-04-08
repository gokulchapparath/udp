import java.io.*;
import java.net.*;
class udpserver
	{
	public static void main(String args[])throws Exception
		{
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader bf=new BufferedReader(isr);
		DatagramSocket ds=new DatagramSocket(9875);
		byte[] send=new byte[1024];
		byte[] rec=new byte[1024];
		while(true)
			{
			DatagramPacket drec=new DatagramPacket(rec,rec.length);
			ds.receive(drec);
			String req=new String(drec.getData());
			System.out.println("From client: "+req);
			System.out.println("\nServer: ");
			String res=bf.readLine();
			send=res.getBytes();
			DatagramPacket dp=new DatagramPacket(send,send.length,drec.getAddress(),drec.getPort());
			ds.send(dp);
			}
		}
	}
