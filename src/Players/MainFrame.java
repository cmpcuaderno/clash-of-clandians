
package Players;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame implements ActionListener{
	JPanel mainPanel;
	StartPage Start;
	HowToPlayPage HowToPlay;
	ChooseCampPage ChooseCamp;
	MapWaitingPage Map;
	HomeCamp Home;
	EnemyCamp Enemy1;
	Camp enemyCamp; //dummy data
	int campNo, numberOfPlayers = 4;
	String ipAd;
	boolean startGame;
	
	public MainFrame() {
		setTitle("Clash of Clandians");
		GUI();
		startGame = false;
	}
	
	void GUI() {
		setPreferredSize(new Dimension(640,500));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel = new JPanel();
		
		//frames
		Start = new StartPage();
		HowToPlay = new HowToPlayPage();
		ChooseCamp = new ChooseCampPage();
		Map = new MapWaitingPage();
		
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
	
	HomeCamp createCamp(int campNo){
		HomeCamp h;
		if(campNo == 1) h = new HomeCamp(new Camp1());
		else if(campNo == 2) h = new HomeCamp(new Camp2());
		else h = new HomeCamp(new Camp3());
		h.attack.addActionListener(this);
		return h;
	}

	void goToHomeCamp(){
		mainPanel.removeAll();
		mainPanel.add(Home);
		repaint();
		revalidate();
	}
	
	void dummyData() { //dummy enemy camp
		Random rX = new Random(), rY = new Random();
		int randomX = rX.nextInt(25), randomY = rY.nextInt(20);
		enemyCamp = new Camp1();
		Enemy1 = new EnemyCamp(enemyCamp, Home.camp, 1);
		Enemy1.home.addActionListener(this);
		
		while(enemyCamp.cannons.size() != 0) {
			while(Enemy1.field.tile[randomY][randomX].isOccupied){
				randomY = rY.nextInt(20);
				randomX = rX.nextInt(20);
			}
			enemyCamp.cannons.get(0).position(randomX, randomY);
			Enemy1.field.tile[randomY][randomX].occupy(enemyCamp.cannons.get(0), Enemy1.field);
			enemyCamp.cannonsP.add(enemyCamp.cannons.remove(0));
		}
		while(enemyCamp.archerTowers.size() != 0) {
			while(Enemy1.field.tile[randomY][randomX].isOccupied){
				randomY = rY.nextInt(20);
				randomX = rX.nextInt(20);
			}
			enemyCamp.archerTowers.get(0).position(randomX, randomY);
			Enemy1.field.tile[randomY][randomX].occupy(enemyCamp.archerTowers.get(0), Enemy1.field);
			enemyCamp.archerTowersP.add(enemyCamp.archerTowers.remove(0));
		}
		while(enemyCamp.mortars.size() != 0) {
			while(Enemy1.field.tile[randomY][randomX].isOccupied){
				randomY = rY.nextInt(20);
				randomX = rX.nextInt(20);
			}
			enemyCamp.mortars.get(0).position(randomX, randomY);
			Enemy1.field.tile[randomY][randomX].occupy(enemyCamp.mortars.get(0), Enemy1.field);
			enemyCamp.mortarsP.add(enemyCamp.mortars.remove(0));
		}
		while(enemyCamp.wizardTowers.size() != 0) {
			while(Enemy1.field.tile[randomY][randomX].isOccupied){
				randomY = rY.nextInt(20);
				randomX = rX.nextInt(20);
			}
			enemyCamp.wizardTowers.get(0).position(randomX, randomY);
			Enemy1.field.tile[randomY][randomX].occupy(enemyCamp.wizardTowers.get(0), Enemy1.field);
			enemyCamp.wizardTowersP.add(enemyCamp.wizardTowers.remove(0));
		}
		while(enemyCamp.walls.size() != 0) {
			while(Enemy1.field.tile[randomY][randomX].isOccupied){
				randomY = rY.nextInt(20);
				randomX = rX.nextInt(20);
			}
			enemyCamp.walls.get(0).position(randomX, randomY);
			Enemy1.field.tile[randomY][randomX].occupy(enemyCamp.walls.get(0), Enemy1.field);
			enemyCamp.wallsP.add(enemyCamp.walls.remove(0));
		}
		Enemy1.field.tile[enemyCamp.townHall.getY()][enemyCamp.townHall.getX()].occupy(enemyCamp.townHall, Home.field);
	}

	public void actionPerformed(ActionEvent e) {
		//START PAGE
		if(e.getSource() == Start.start) { // Start button
			ipAd = Start.inputIP.getText();
			System.out.println(ipAd);
			mainPanel.remove(Start);
			mainPanel.add(ChooseCamp);
			repaint();
			revalidate();
		}
		
		else if(e.getSource() == Start.howToPlay) { // How to Play button
			mainPanel.remove(Start);
			mainPanel.add(HowToPlay);
			repaint();
			revalidate();
		}

		else if(e.getSource() == Start.exit) { //Exit button
			System.exit(0);
		}
		
		
		// HOW TO PLAY PAGE
		else if(e.getSource() == HowToPlay.back) { // back button
			mainPanel.remove(HowToPlay);
			mainPanel.add(Start);
			repaint();
			revalidate();
		}
		
		// CHOOSE CAMP PAGE
		else if(e.getSource() == ChooseCamp.back) { // back button for choose camp
			mainPanel.remove(ChooseCamp);
			mainPanel.add(Start);
			repaint();
			revalidate();
		}

		else if(e.getSource() == ChooseCamp.camp1) { // choosing camp 1
			campNo = 1; // predefined camp 1
			mainPanel.remove(ChooseCamp);
			Map.setMap(numberOfPlayers);
			mainPanel.add(Map);
			repaint();
			revalidate();
			startGame = true; //server should change this
		}

		else if(e.getSource() == ChooseCamp.camp2) { // choosing camp 2
			campNo = 2; // predefined camp 2
			mainPanel.remove(ChooseCamp);
			Map.setMap(numberOfPlayers);
			mainPanel.add(Map);
			repaint();
			revalidate();
			startGame = true; //server should change this
		}

		else if(e.getSource() == ChooseCamp.camp3) { // choosing camp 3
			campNo = 3; // predefined camp 3
			mainPanel.remove(ChooseCamp);
			Map.setMap(numberOfPlayers);
			mainPanel.add(Map);
			repaint();
			revalidate();
			startGame = true; //server should change this
		}
		
		else if(e.getSource() == Home.attack) { // going to enemy camp
			mainPanel.remove(Home);
			mainPanel.add(Enemy1);
			repaint();
			revalidate();
		}
		
		else if(e.getSource() == Enemy1.home) { // going to enemy camp
			goToHomeCamp();
		}
	}
}

