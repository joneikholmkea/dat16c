package multiclientchat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Hashtable;

public class ChatServer
{
	private ServerSocket serverSocket=null;
	private int PORT=6780;
	Hashtable<Socket, DataOutputStream> outStreams= new Hashtable<Socket, DataOutputStream>();
	
	public static void main(String[] args)
	{
		new ChatServer();
	}
	public ChatServer(){
		try
		{
			serverSocket=new ServerSocket(PORT);
			do
			{
				Socket socket=serverSocket.accept();  // 1
				DataOutputStream dataOutputStream=new DataOutputStream(socket.getOutputStream());
				outStreams.put(socket, dataOutputStream);
				ClientHandler handler=new ClientHandler(socket, this);
				Thread thread = new Thread (handler);
				thread.start();
				
			} while (true);
			
			
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public synchronized void removeSocket(Socket socket){
		outStreams.remove(socket);
	}
	
	public synchronized void sendToAllClients(String message){
		for(Enumeration<DataOutputStream> stream=outStreams.elements();stream.hasMoreElements(); ){
			DataOutputStream dos=stream.nextElement();
			try
			{
				dos.writeUTF(message+'\n');
			} catch (IOException e)
			{
				e.printStackTrace();
			}
			
		}
		
	}
}
