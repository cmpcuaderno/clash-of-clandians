package Players;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
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

public class StartPage extends JPanel implements ActionListener{
	JButton start, howToPlay, exit, less, more;
	JTextField noOfPlayers; //accepts integers from 2 to 6
	JLabel numberOfPlayers; //text
	Icon howIcon = new ImageIcon("../Assets/HowToPlay.png");
	Icon startIcon = new ImageIcon("../Assets/start.png"); 
	Icon quitIcon = new ImageIcon("../Assets/quit.png"); 
	JPanel numPlayers = new JPanel();

	private int players = 2;
	
	public StartPage() {
		this.setLayout(new GridLayout(4,3));
		//noOfPlayers text field
		noOfPlayers = new JTextField();
		noOfPlayers.setEditable(false);
		noOfPlayers.setText("2"); //minimum number of players
		
		//buttons
		start = new JButton();
		start.addActionListener(this);
		start.setIcon(startIcon);
		start.setContentAreaFilled(false);
		start.setBorderPainted(false);
		howToPlay = new JButton();
		howToPlay.setIcon(howIcon);
		howToPlay.addActionListener(this);
		howToPlay.setContentAreaFilled(false);
		howToPlay.setBorderPainted(false);
		exit = new JButton();
		exit.addActionListener(this);
		exit.setIcon(quitIcon);
		exit.setContentAreaFilled(false);
		exit.setBorderPainted(false);
		less = new JButton("-");
		less.addActionListener(this);
		more = new JButton("+");
		more.addActionListener(this);
		
		//label
		numberOfPlayers = new JLabel("Number of Players: ");
		
		numPlayers.add(numberOfPlayers);
		numPlayers.add(noOfPlayers);
		numPlayers.add(more);
		numPlayers.add(less);
		add(numPlayers);
		add(start);
		add(howToPlay);
		add(exit);
	}

	int getNumberOfPlayers(){
		return players;
	}
	
	private int decreasePlayers(){
		players--;
		return players;
	}
	
	private int increasePlayers(){
		players++;
		return players;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == less){ //decreases number of players
			players = Integer.parseInt(noOfPlayers.getText());
			if(players > 2) //minimum number is 2
				noOfPlayers.setText(Integer.toString(decreasePlayers()));
			repaint();
		}
		
		if(e.getSource() == more){ //increases number of players
			players = Integer.parseInt(noOfPlayers.getText());
			if(players < 6) //minimum number is 2
				noOfPlayers.setText(Integer.toString(increasePlayers()));
			repaint();
		}
	}
}
