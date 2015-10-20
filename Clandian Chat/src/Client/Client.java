package Client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;

public class Client extends JFrame implements ActionListener {
	private BufferedReader in;
	private PrintWriter out;
	private JPanel main_chat_panel, chat_area_panel, message_area_panel;
	private JTextField chat_area;
	private JTextArea message_area;
	private JButton send_button, connect_button;
	private Socket socket;
	
	public Client() {
		main_chat_panel = new JPanel(new BorderLayout());
		main_chat_panel.setPreferredSize(new Dimension(400, 500));
		
//		info_area_panel = new JPanel(new GridLayout(2, 1));
//		info_area_panel.setBorder(new EmptyBorder(10, 15, 5, 15));
//		
//		info_area_panel_server = new JPanel(new GridLayout(1, 2));
//		
//		server_address = new JTextField(40);
//		client_name = new JTextField(40);
//		
//		info_area_panel_server.add(server_address);
//		info_area_panel_server.add(client_name);
//		
//		connect_button = new JButton("CONNECT");
//		connect_button.addActionListener(this);
//
//		info_area_panel.add(info_area_panel_server);
//		info_area_panel.add(connect_button);

				
		message_area_panel = new JPanel(new BorderLayout());
		message_area_panel.setBorder(new EmptyBorder(10, 15, 10, 15));
		
		message_area = new JTextArea();
		message_area.setEditable(false);
		message_area.setBackground(Color.WHITE);
		
		DefaultCaret caret = (DefaultCaret) message_area.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		
		message_area_panel.add(new JScrollPane(message_area), BorderLayout.CENTER);
		
		chat_area_panel = new JPanel(new BorderLayout());
		chat_area_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		chat_area = new JTextField(50);
		chat_area.setBackground(Color.WHITE);
		chat_area.setEditable(false);
		
		chat_area.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				out.println(chat_area.getText());
				chat_area.setText("");
			}
		});
		
		send_button = new JButton("SEND");
		send_button.addActionListener(this);
		
		chat_area_panel.add(chat_area, BorderLayout.CENTER);
		chat_area_panel.add(send_button, BorderLayout.EAST);	
		
//		main_chat_panel.add(info_area_panel, BorderLayout.NORTH);
		main_chat_panel.add(message_area_panel, BorderLayout.CENTER);
		main_chat_panel.add(chat_area_panel, BorderLayout.SOUTH);
		
		this.add(main_chat_panel);
		this.pack();
		this.setTitle("Clash of Clandian Chat");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == send_button) {
			out.println(chat_area.getText());
			chat_area.setText("");
		}
		
		else if(e.getSource() == connect_button)  {

		}
	}
	
    private String getClientName() {
        return JOptionPane.showInputDialog(
            this,
            "Enter a unique username:",
            "Clash of Clandian Chat",
            JOptionPane.PLAIN_MESSAGE);
    }
    
	private String getServerAddress() {
        return JOptionPane.showInputDialog(
                this,
                "Enter IP Address of the Server:",
                "Clash of Clandian Chat",
                JOptionPane.QUESTION_MESSAGE);
	}
	
    private void run() throws IOException {
        socket = new Socket(getServerAddress(), 9001);
        in = new BufferedReader(new InputStreamReader(
            socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
               
        while (true) {
            String line = in.readLine();
            if (line.startsWith("SUBMITNAME")) {
                out.println(getClientName());
            } 
            
            else if (line.startsWith("NAMEACCEPTED")) {
                chat_area.setEditable(true);
            } 
            
            else if (line.startsWith("MESSAGE")) {
                message_area.append(line.substring(8) + "\n");
            }
        }
    }

	public static void main(String[] args) throws IOException {
		Client chat = new Client();
		chat.run();
	}
}
