package multiclientchat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable
{
	Socket socket=null;
	ChatServer server=null;
	
	public ClientHandler(Socket s, ChatServer c){
		socket=s;
		server=c;
		
	}
	
	public void run(){  // runs forever, or until we call removeSocket()
		try
		{
			DataInputStream dataInputStream=new DataInputStream(socket.getInputStream());
			String fromClient="";
			do
			{
				fromClient=dataInputStream.readUTF();
				server.sendToAllClients(fromClient);  
				System.out.println("server: "+fromClient);
			} while (!fromClient.equalsIgnoreCase("quit"));
			server.removeSocket(socket);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
