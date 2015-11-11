package Chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;

public class ChatBox extends JPanel implements ActionListener, KeyListener {

	private Client client;
	private JPanel main_chat_panel, chat_area_panel, message_area_panel;
	public JTextField chat_area;
	public JTextArea message_area;
	private JButton send_button;
	
	public ChatBox() { 
		this.setUpGUI();
	}
	
	public ChatBox(Client client) {
		this.client = client;
		this.setUpGUI();
	}
	
	public void setUpGUI() {
		main_chat_panel = new JPanel(new BorderLayout());
		main_chat_panel.setPreferredSize(new Dimension(250, 450));
				
		message_area_panel = new JPanel(new BorderLayout());
		message_area_panel.setBorder(new EmptyBorder(5, 5, 0, 0));
		
		message_area = new JTextArea();
		message_area.setEditable(false);
		message_area.setBackground(Color.WHITE);
		
		DefaultCaret caret = (DefaultCaret) message_area.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		
		message_area_panel.add(new JScrollPane(message_area), BorderLayout.CENTER);
		
		chat_area_panel = new JPanel(new BorderLayout());
		chat_area_panel.setBorder(new EmptyBorder(3, 0, 0, 0));
		
		chat_area = new JTextField(50);
		chat_area.setBackground(Color.WHITE);
		chat_area.addKeyListener(this);

		send_button = new JButton("SEND");
		send_button.addActionListener(this);
		
		chat_area_panel.add(chat_area, BorderLayout.CENTER);
		chat_area_panel.add(send_button, BorderLayout.EAST);	
		
		main_chat_panel.add(message_area_panel, BorderLayout.CENTER);
		main_chat_panel.add(chat_area_panel, BorderLayout.SOUTH);
		
		this.add(main_chat_panel);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == send_button) {
			this.client.out.println(chat_area.getText());
			chat_area.setText("");
		}
	}

	public void keyTyped(KeyEvent e) {}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == 10) {
			this.client.out.println(chat_area.getText());
			chat_area.setText("");
		}
	}

	public void keyReleased(KeyEvent e) {}
}
