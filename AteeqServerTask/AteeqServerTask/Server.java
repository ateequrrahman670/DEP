import java.io.*;
import java.awt.*;
import java.net.*;
import java.awt.event.*;
import javax.swing.*;

public class Server extends JFrame{

	private JTextField userText;
	private JTextArea chatWindow;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private ServerSocket server;
	private Socket connection;

	public Server(){

		super("Chat Application");
		userText = new JTextField();
		userText.setEditable(false);
		
		userText.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent event){
				sendMessage(event.getActionCommand());
				userText.setText("");
			}
		});

		add(userText,BorderLayout.NORTH);
		chatWindow = new JTextArea();

		add(new JScrollPane(chatWindow));
		setSize(300,150);
		setVisible(true);
	}

	public void startRunning(){
		try{

			server = new ServerSocket(6789,100);
			while(true){
				try{

					waitForConnection();
					setupStreams();
					whileChatting();

				}catch(Exception ex){
					showMessage("\n Server Ended");
				}finally{
					closeCrap();
				}
			}
		}catch(Exception ex){
			System.out.println(ex);
		}
	}

	private void waitForConnection() throws IOException{
		showMessage("Waiting for someone to connect");
		connection = server.accept();
		showMessage(" Now connected to "+ connection.getInetAddress().getHostName());

	}

	private void setupStreams() throws IOException{
		output = new ObjectOutputStream(connection.getOutputStream());

		output.flush();

		try {
			input = new ObjectInputStream(connection.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		showMessage("\n Streams are not setup! \n");
	}

	private void whileChatting(){
		String message = "You are connected!";
		sendMessage(message);
		ableToType(true);

		do{

			try{

				message = (String) input.readObject();
				showMessage("\n"+message);

			}catch(Exception ex){
				showMessage("\n Something went wrong");
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