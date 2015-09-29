package Players;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class mainFrame extends JFrame implements ActionListener{
	startPage Start;
	howToPlayPage HowToPlay;
	chooseCampPage ChooseCamp;
	mapPage Map;
	int numberOfPlayers, campNo;
	
	public mainFrame() {
		setTitle("Clash of Clandians");
		GUI();
	}
	
	void GUI() {
		setPreferredSize(new Dimension(640,480));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//frames
		Start = new startPage();
		HowToPlay = new howToPlayPage();
		ChooseCamp = new chooseCampPage();
		Map = new mapPage();
		
		//button listeners
		Start.start.addActionListener(this);
		Start.howToPlay.addActionListener(this);
		Start.exit.addActionListener(this);
		HowToPlay.back.addActionListener(this);
		ChooseCamp.camp1.addActionListener(this);
		ChooseCamp.camp2.addActionListener(this);
		ChooseCamp.camp3.addActionListener(this);
		ChooseCamp.back.addActionListener(this);
		
		add(Start);
		pack();
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		
		//START PAGE
		if(e.getSource() == Start.start) { // Start button
			numberOfPlayers = Start.getNumberOfPlayers();
			remove(Start);
			add(ChooseCamp);
			repaint();
			revalidate();
		}
		
		if(e.getSource() == Start.howToPlay) { // How to Play button
			remove(Start);
			add(HowToPlay);
			repaint();
			revalidate();
		}

		if(e.getSource() == Start.exit) { //Exit button
			System.exit(0);
		}
		
		
		// HOW TO PLAY PAGE
		if(e.getSource() == HowToPlay.back) { // back button
			remove(HowToPlay);
			add(Start);
			repaint();
			revalidate();
		}
		
		// CHOOSE CAMP PAGE
		if(e.getSource() == ChooseCamp.back) { // back button for choose camp
			remove(ChooseCamp);
			add(Start);
			repaint();
			revalidate();
		}

		if(e.getSource() == ChooseCamp.camp1) { // choosing camp 1
			campNo = 1; // predefined camp 1
			remove(ChooseCamp);
			Map.setMap(numberOfPlayers);
			add(Map);
			repaint();
			revalidate();
		}

		if(e.getSource() == ChooseCamp.camp2) { // choosing camp 2
			campNo = 2; // predefined camp 2
			remove(ChooseCamp);
			Map.setMap(numberOfPlayers);
			add(Map);
			repaint();
			revalidate();
		}

		if(e.getSource() == ChooseCamp.camp3) { // choosing camp 3
			campNo = 3; // predefined camp 3
			remove(ChooseCamp);
			Map.setMap(numberOfPlayers);
			add(Map);
			repaint();
			revalidate();
		}
	}
}
