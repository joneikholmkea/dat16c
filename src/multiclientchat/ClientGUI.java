package multiclientchat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientGUI extends JFrame
{
	private int PORT=6780;
	private Socket socket=null;
	private InetAddress host=null;
	private DataInputStream dataInputStream=null;
	private DataOutputStream dataOutputStream=null;
	
	private JTextArea textArea=new JTextArea();
	private JTextField textField=new JTextField();
	private JTextField textFieldName=new JTextField();
	
	
	public static void main(String[] args)
	{
		new ClientGUI();
	}

	public ClientGUI(){
		super("basic chat");
		setSize(400, 400);
		setLayout(new BorderLayout());
		add("North", textFieldName);
		add("Center", textArea);
		add("South", textField);
		setVisible(true);
		try
		{
			host=InetAddress.getLocalHost();
			socket=new Socket(host, PORT);
			dataInputStream=new DataInputStream(socket.getInputStream());
			dataOutputStream=new DataOutputStream(socket.getOutputStream());
		} catch (UnknownHostException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		textField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				String msg=textField.getText();
				String name = textFieldName.getText();
				try
				{
					dataOutputStream.writeUTF(name+" "+msg);
				} catch (IOException e)
				{
					e.printStackTrace();
				}
				if(msg.equalsIgnoreCase("quit"))
					System.exit(0);
				textField.setText("");
			}
		});
		receiveMessages();
		
	}

	private void receiveMessages()
	{
		String fromNetwork="";
		do
		{
			try
			{
				fromNetwork=dataInputStream.readUTF();
				textArea.append(fromNetwork);
			} catch (IOException e)
			{
				e.printStackTrace();
				textArea.append("network error");
			}
			
		} while (true);
	}
}
