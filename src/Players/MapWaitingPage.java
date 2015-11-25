package Players;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MapWaitingPage extends JPanel{
	JLabel[] p;
	Background WaitingPage = new Background(new ImageIcon("Assets/camp_background.jpg").getImage());
	Icon[] queue = {
			new ImageIcon("Assets/1.png"),
			new ImageIcon("Assets/2.png"),
			new ImageIcon("Assets/3.png"),
			new ImageIcon("Assets/4.png"),
			new ImageIcon("Assets/5.png"),
			new ImageIcon("Assets/6.png")
	};
	
	Icon[] queue_glow = {
			new ImageIcon("Assets/1_glow.png"),
			new ImageIcon("Assets/2_glow.png"),
			new ImageIcon("Assets/3_glow.png"),
			new ImageIcon("Assets/4_glow.png"),
			new ImageIcon("Assets/5_glow.png"),
			new ImageIcon("Assets/6_glow.png")
	};
	public MapWaitingPage(){
		
		// players (pakipalitan ito ng kung anumang magrerepresent sa bawat player)
		p = new JLabel[6];
		for(int i=0; i<6; i++) { //initializing each player grid
			p[i] = new JLabel();
			p[i].setIcon(queue[i]);
		}
		
	
		
	}
	
	void setMap(int players) {
		removeAll(); //removes all contents of the panel
		updateUI();
		WaitingPage.setLayout(new GridLayout(2,3));
		for(int i=0; i<players; i++) { //initializing each player grid
			WaitingPage.add(p[i]);
		}
		p[0].setIcon(queue_glow[0]);
		add(WaitingPage);
		setOpaque(false);
	}
}
