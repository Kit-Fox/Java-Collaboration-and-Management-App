package appmain;
import java.net.*;
import java.io.*;

public class ClientCode 
{
	//Initialize sockets
	private Socket socket = null;
	private DataInputStream input = null;
	private DataOutputStream out = null;
	
	//Constructor to put IP address and port
	public void Client(String address, int port) 
	{
		
		//Establish connection
		try
		{
			socket = new Socket(address, port);
			System.out.println("Connected");
			
			//Take input from Terminal -- Will Be Phased Out Later
			input = new DataInputStream(System.in);
			
			//Send output to socket -- Will Be Reworked Later
			out = new DataOutputStream(socket.getOutputStream());
			
		}
		catch(UnknownHostException u)
		{
			System.out.println(u);
		} 
		catch (IOException i) 
		{
			System.out.println(i);
		}
		
		//String To Read Message Input From
	}
}
