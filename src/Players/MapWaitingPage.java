package Players;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MapWaitingPage extends JPanel{
	JLabel[] p;
	public MapWaitingPage(){
		setLayout(new GridLayout(2,3));
		
		// players (pakipalitan ito ng kung anumang magrerepresent sa bawat player)
		p = new JLabel[6];
		for(int i=0; i<6; i++) { //initializing each player grid
			p[i] = new JLabel("Waiting for Player " + Integer.toString(i+1));
		}
		setOpaque(false);
		
	}
	
	void setMap(int players) {
		removeAll(); //removes all contents of the panel
		updateUI();
		for(int i=0; i<players; i++) { //initializing each player grid
			add(p[i]);
		}
	}
}
