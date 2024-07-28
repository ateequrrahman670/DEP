import java.io.*;
import java.awt.*;
import java.net.*;
import java.awt.event.*;
import javax.swing.*;

public class Client extends JFrame{

	private JTextField userText;
	private JTextArea chatWindow;
	private ObjectInputStream input;
	private ObjectOutputStream output;
	private String message = "";
	private String serverIP = "";
	private Socket connection;

	public Client(String host){
		super("Client");
		serverIP = host;
		userText = new JTextField();
		userText.setEditable(false);
		userText.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				sendMessage(event.getActionCommand());
				userText.setText("");
			}
		});

		add(userText, BorderLayout.NORTH);
		chatWindow = new JTextArea();
		add(new JScrollPane(chatWindow),BorderLayout.CENTER);

		setSize(300,150);
		setVisible(true);


	}

	public void startRunning(){
		try{

			connectToServer();
			setupStreams();
			whileChatting();
		}catch(Exception ex){
			showMessage("\n Client terminated connecition");
		}finally{
			closeCrap();
		}
	}

	private void connectToServer() throws UnknownHostException, IOException{
		showMessage("Attempting connection...\n");
		connection = new Socket(InetAddress.getByName(serverIP),6789);
		showMessage("Connected to: " + connection.getInetAddress().getHostName());
	}

	private void setupStreams() throws IOException{
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush();

		input = new ObjectInputStream(connection.getInputStream());
		showMessage("\n Stream is opened");


	}

	private void whileChatting(){
		ableToType(true);

		do{
			try{

				message = (String) input.readObject();
				showMessage("\n"+ message);

			}catch(Exception ex){

			}
		}while(!message.equals("EXIT"));
	}

	private void closeCrap(){
		showMessage("\n Closing connectoins....\n");
		ableToType(false);

		try{

			output.close();
			input.close();
			connection.close();
		}catch(Exception ex){

		}
	}

	private void sendMessage(String message){

		try{
			output.writeObject("SERVER - "+message);
			output.flush();
			showMessage("\nSERVER - "+ message);
		}catch(Exception ex){

		}
	}

	private void showMessage(final String text){

		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				chatWindow.append(text);
			}
		});
	}

	private void ableToType(final boolean tof){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				userText.setEditable(tof);
			}
		});
	}
}