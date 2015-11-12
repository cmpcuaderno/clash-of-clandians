package Players;

import java.awt.Dimension;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;


public class Buttons extends JPanel{
	JButton start, howToPlay, exit;
	Icon howIcon = new ImageIcon("Assets/HowToPlay.png");
	Icon startIcon = new ImageIcon("Assets/start.png"); 
	Icon quitIcon = new ImageIcon("Assets/quit.png"); 
	JTextField inputIP; 
	JLabel ipAddress, bg; 
	JPanel getIP = new JPanel();


	public Buttons(){
		setOpaque(false);

		start = new JButton();
		start.setPreferredSize(new Dimension(210,40));
		start.setIcon(startIcon);
		start.setMaximumSize(start.getSize());
		start.setContentAreaFilled(false);
		start.setBorderPainted(false);

		howToPlay = new JButton();
		howToPlay.setIcon(howIcon);
		howToPlay.setContentAreaFilled(false);
		howToPlay.setBorderPainted(false);
		
		exit = new JButton();
		exit.setIcon(quitIcon);
		exit.setContentAreaFilled(false);
		exit.setBorderPainted(false);

//		inputIP = new JTextField();
//		inputIP.setEditable(true);
//		inputIP.setText("127.0.0.0"); 
//		
//
//		ipAddress = new JLabel("Server's IP Address: ");
//		
//		getIP.add(ipAddress);
//		getIP.add(inputIP);
//		getIP.setOpaque(false);
//		add(getIP);
		add(start);
		add(howToPlay);
		add(exit);

	}
}