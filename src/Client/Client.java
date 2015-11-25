package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import Players.MainGame;

public class Client {

	private JFrame frame;
	private Socket socket;
	private BufferedReader in;
	public PrintWriter out;
	private MainGame main_game;
	String noOfPlayers;
	
	public Client() { }
	
	 private String getClientName() {
	        return JOptionPane.showInputDialog(
	            frame,
	            "Enter a unique username:",
	            "Clash of Clandian Chat",
	            JOptionPane.PLAIN_MESSAGE);
	    }
	    
		private String getServerAddress() {
	        return JOptionPane.showInputDialog(
	                frame,
	                "Enter IP Address of the Server:",
	                "Clash of Clandian Chat",
	                JOptionPane.PLAIN_MESSAGE);
	        
		}
		private String getNumOfPlayers() {
	        return JOptionPane.showInputDialog(
	                frame,
	                "Number of Players:",
	                "Clash of Clandian Chat",
	                JOptionPane.PLAIN_MESSAGE);
	        
		}
		
		
	    private void run() throws IOException, IOException  {
	        socket = new Socket(getServerAddress(), 1234);
	        
	        in = new BufferedReader(new InputStreamReader(
	            socket.getInputStream()));
	        out = new PrintWriter(socket.getOutputStream(), true);
	               
	        while (true) {
	            String line = in.readLine();
	            if (line.startsWith("SUBMITNAME")) {
	                out.println(getClientName());
	            } 
	            
	            else if (line.startsWith("NAMEACCEPTED")) {
	            	main_game = new MainGame(this, Integer.parseInt(noOfPlayers));
	            } 
	            
	            else if (line.startsWith("MESSAGE")) {
	                main_game.getChatBox().message_area.append(line.substring(8) + "\n");
	            }
	            else if(line.startsWith("NUMBEROFPLAYERS")) {
	            	out.println(noOfPlayers = getNumOfPlayers());
	            }
	        }
	    }
	    
	    
	    public static void main(String[] args) throws IOException {
	    	try{
	    		UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
	    	}catch(Exception e){}
			Client c = new Client();
			c.run();
		}
	
}
