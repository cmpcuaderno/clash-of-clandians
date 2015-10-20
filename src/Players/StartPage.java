package Players;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;

import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/*
 *  Buttons:
 *  	- Start (will lead to Choose Camp page)
 *  		* require number of players
 *  	- How to Play (will lead to How to Play page)
 *  	- Exit (will close the window)
 *  Field:
 *  	- Number of players
 */

public class StartPage extends JPanel{
	JButton start, howToPlay, exit;
	JTextField inputIP; //accepts integers from 2 to 6
	JLabel ipAddress, bg; //text
	Icon howIcon = new ImageIcon("../Assets/HowToPlay.png");
	Icon startIcon = new ImageIcon("../Assets/start.png"); 
	Icon quitIcon = new ImageIcon("../Assets/quit.png"); 
	Icon background = new ImageIcon("../Assets/cover.png"); 
	JPanel getIP = new JPanel();
	JPanel bgPanel = new JPanel();
	JPanel buttonsPanel = new JPanel();
	JPanel mainPanel = new JPanel();
	private int players = 2;
	
	public StartPage() {
		bg = new JLabel();
		bg.setIcon(background);
		bgPanel.add(bg);
		
		buttonsPanel.setLayout(new GridLayout(4,1));
		mainPanel.setLayout(new GridLayout(2,2));
		buttonsPanel.setPreferredSize(new Dimension(210,200));
		buttonsPanel.setMaximumSize(buttonsPanel.getSize());
		buttonsPanel.setBackground(Color.BLACK);
		mainPanel.setPreferredSize(new Dimension(640,480));
		mainPanel.setBackground(Color.BLUE);

		
		//noOfPlayers text field
		inputIP = new JTextField();
		inputIP.setEditable(true);
		inputIP.setText("127.0.0.0"); //minimum number of players
		
		//buttons
		start = new JButton();
		start.setPreferredSize(new Dimension(210,40));
		start.setIcon(startIcon);
		start.setMaximumSize(start.getSize());
		start.setBackground(Color.BLACK);
		howToPlay = new JButton();
		howToPlay.setIcon(howIcon);
		howToPlay.setContentAreaFilled(false);
		howToPlay.setBorderPainted(false);
		//howToPlay.setPreferredSize(new Dimension(210,40));
		
		exit = new JButton();
		exit.setIcon(quitIcon);
		exit.setContentAreaFilled(false);
		exit.setBorderPainted(false);
		//exit.setPreferredSize(new Dimension(210,40));
		
		
		
		//label
		ipAddress = new JLabel("Server's IP Address: ");
		
		getIP.add(ipAddress);
		getIP.add(inputIP);
		
		buttonsPanel.add(getIP);
		buttonsPanel.add(start);
		buttonsPanel.add(howToPlay);
		buttonsPanel.add(exit);
		
		mainPanel.add(new JLabel(""));
		mainPanel.add(new JLabel(""));
		mainPanel.add(new JLabel(""));
		mainPanel.add(buttonsPanel);

		add(mainPanel);
	}

	int getNumberOfPlayers(){
		return players;
	}
	
	
	
	
}
