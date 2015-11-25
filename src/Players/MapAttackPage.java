package Players;

import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MapAttackPage extends JPanel{
	JButton[] p;
	Background AttackPage = new Background(new ImageIcon("Assets/camp_background.jpg").getImage());
	Icon[] queue = {
			new ImageIcon("Assets/1.png"),
			new ImageIcon("Assets/2.png"),
			new ImageIcon("Assets/3.png"),
			new ImageIcon("Assets/4.png"),
			new ImageIcon("Assets/5.png"),
			new ImageIcon("Assets/6.png")
	};

	public MapAttackPage(){
		
		// players (pakipalitan ito ng kung anumang magrerepresent sa bawat player)
		p = new JButton[6];
		for(int i=0; i<6; i++) { //initializing each player grid
			p[i] = new JButton();
			p[i].setIcon(queue[i]);
			p[i].setMaximumSize(p[i].getSize());
			p[i].setContentAreaFilled(false);
			p[i].setBorderPainted(false);
		}
		
	
		
	}
	
	void setMap(int players) {
		removeAll(); //removes all contents of the panel
		updateUI();
		AttackPage.setLayout(new GridLayout(2,3));
		for(int i=0; i<players; i++) { //initializing each player grid
			AttackPage.add(p[i]);
		}
		//p[0].setIcon(queue_glow[0]);
		add(AttackPage);
		
		setOpaque(false);
	}
}
