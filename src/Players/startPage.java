package Players;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 *  Buttons:
 *  	- Start (will lead to Choose Camp page)
 *  		* require number of players
 *  	- How to Play (will lead to How to Play page)
 *  	- Exit (will close the window)
 *  Field:
 *  	- Number of players
 */

public class startPage extends JPanel implements ActionListener{
	JButton start, howToPlay, exit, less, more;
	JTextField noOfPlayers; //accepts integers from 2 to 6
	JLabel numberOfPlayers; //text
	private int players = 2;
	
	public startPage() {
		
		//noOfPlayers text field
		noOfPlayers = new JTextField();
		noOfPlayers.setEditable(false);
		noOfPlayers.setText("2"); //minimum number of players
		
		//buttons
		start = new JButton("START");
		start.addActionListener(this);
		howToPlay = new JButton("HOW TO PLAY");
		howToPlay.addActionListener(this);
		exit = new JButton("EXIT");
		exit.addActionListener(this);
		less = new JButton("-");
		less.addActionListener(this);
		more = new JButton("+");
		more.addActionListener(this);
		
		//label
		numberOfPlayers = new JLabel("Number of Players: ");
		
		add(start);
		add(numberOfPlayers);
		add(noOfPlayers);
		add(less);
		add(more);
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
