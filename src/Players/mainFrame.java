package Players;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class mainFrame extends JFrame implements ActionListener{
	JPanel mainPanel;
	startPage Start;
	howToPlayPage HowToPlay;
	chooseCampPage ChooseCamp;
	mapPage Map;
	homeCamp HomeCamp;
	int numberOfPlayers, campNo;
	boolean startGame;
	
	public mainFrame() {
		setTitle("Clash of Clandians");
		GUI();
		startGame = false;
	}
	
	void GUI() {
		setPreferredSize(new Dimension(640,480));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel = new JPanel();
		
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
		
		mainPanel.add(Start);
		add(mainPanel);
		pack();
		setVisible(true);
	}
	
	homeCamp createCamp(int campNo){
		if(campNo == 1) return new homeCamp(new Camp1());
		else if(campNo == 2) return new homeCamp(new Camp2());
		else return new homeCamp(new Camp3());
	}

	void goToHomeCamp(){
		mainPanel.removeAll();
		HomeCamp = createCamp(campNo);
		mainPanel.add(HomeCamp);
		repaint();
		revalidate();
	}

	public void actionPerformed(ActionEvent e) {
		
		//START PAGE
		if(e.getSource() == Start.start) { // Start button
			numberOfPlayers = Start.getNumberOfPlayers();
			mainPanel.remove(Start);
			mainPanel.add(ChooseCamp);
			repaint();
			revalidate();
		}
		
		if(e.getSource() == Start.howToPlay) { // How to Play button
			mainPanel.remove(Start);
			mainPanel.add(HowToPlay);
			repaint();
			revalidate();
		}

		if(e.getSource() == Start.exit) { //Exit button
			System.exit(0);
		}
		
		
		// HOW TO PLAY PAGE
		if(e.getSource() == HowToPlay.back) { // back button
			mainPanel.remove(HowToPlay);
			mainPanel.add(Start);
			repaint();
			revalidate();
		}
		
		// CHOOSE CAMP PAGE
		if(e.getSource() == ChooseCamp.back) { // back button for choose camp
			mainPanel.remove(ChooseCamp);
			mainPanel.add(Start);
			repaint();
			revalidate();
		}

		if(e.getSource() == ChooseCamp.camp1) { // choosing camp 1
			campNo = 1; // predefined camp 1
			mainPanel.remove(ChooseCamp);
			Map.setMap(numberOfPlayers);
			mainPanel.add(Map);
			repaint();
			revalidate();
			startGame = true; //server should change this
			HomeCamp = new homeCamp(new Camp1());
		}

		if(e.getSource() == ChooseCamp.camp2) { // choosing camp 2
			campNo = 2; // predefined camp 2
			mainPanel.remove(ChooseCamp);
			Map.setMap(numberOfPlayers);
			mainPanel.add(Map);
			repaint();
			revalidate();
			startGame = true; //server should change this
			HomeCamp = new homeCamp(new Camp2());
		}

		if(e.getSource() == ChooseCamp.camp3) { // choosing camp 3
			campNo = 3; // predefined camp 3
			mainPanel.remove(ChooseCamp);
			Map.setMap(numberOfPlayers);
			mainPanel.add(Map);
			repaint();
			revalidate();
			startGame = true; //server should change this
			HomeCamp = new homeCamp(new Camp3());
		}
	}
}
