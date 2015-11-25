
package Players;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Chat.ChatBox;
import Client.Client;

public class MainFrame extends JFrame implements ActionListener{
	JPanel mainPanel;
	Background Start;
	Background Grass;
	Background BackgroundChooseCamp , WaitingPage;
	Buttons ButtonsStart;
	HowToPlayPage HowToPlay;
	ChooseCampPage ChooseCamp;
	MapAttackPage MapAttack;
	MapWaitingPage Map;
	HomeCamp Home;
	EnemyCamp Enemy1;
	Camp enemyCamp; //dummy data
	int campNo, numberOfPlayers, connected = 0;
	String ipAd;
	boolean startGame;
	JPanel dummy, sample;
	
	
	
	ChatBox chat_box;
	
	public MainFrame(Client client, int noOfPlayers) {
		this.numberOfPlayers = noOfPlayers;
		GUI(client);
		startGame = false;
	}
	
	void GUI(Client client) {
		mainPanel = new JPanel(new BorderLayout());
		this.setPreferredSize(new Dimension(890, 575));
//		//panels
		Start = new Background(new ImageIcon("Assets/cover.png").getImage());
		Grass = new Background(new ImageIcon("Assets/grass.png").getImage());
		BackgroundChooseCamp =  new Background(new ImageIcon("Assets/camp_background.jpg").getImage());
		WaitingPage =  new Background(new ImageIcon("Assets/camp_background.jpg").getImage());
//		dummy = new JPanel();
//		dummy.setPreferredSize(new Dimension(250, 20));
//		dummy.setOpaque(false);
//
		ButtonsStart = new Buttons();
		HowToPlay = new HowToPlayPage();
		ChooseCamp = new ChooseCampPage();
		Map = new MapWaitingPage();
		MapAttack = new MapAttackPage();
//		
//		//button listeners
		ButtonsStart.start.addActionListener(this);
		ButtonsStart.howToPlay.addActionListener(this);
		ButtonsStart.exit.addActionListener(this);
		HowToPlay.back.addActionListener(this);
		ChooseCamp.camp1.addActionListener(this);
		ChooseCamp.camp2.addActionListener(this);
		ChooseCamp.camp3.addActionListener(this);
		ChooseCamp.back.addActionListener(this);
		for(int i=0; i<6; i++) {
			//if(i != campNo)
			MapAttack.p[i].addActionListener(this);
		}

		Start.setLayout(new GridLayout(2,2));
		Start.add(new JLabel(" "));
		Start.add(new JLabel(" "));
		Start.add(new JLabel(" "));
		Start.add(ButtonsStart);
//
//		mainPanel.add(Start, BorderLayout.CENTER);
		
		sample = new JPanel(new BorderLayout(10, 10));
		Start.setPreferredSize(new Dimension(720, 480));
		Start.setOpaque(false);
		sample.setBackground(Color.GREEN);
		
		mainPanel.add(Start, BorderLayout.CENTER);
		
		chat_box = new ChatBox(client);
		chat_box.setOpaque(false);
		mainPanel.add(chat_box, BorderLayout.WEST);
		
				
		this.add(mainPanel);
		this.pack();
		this.setTitle("Clash of Clandian");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		
	}
	
	HomeCamp createCamp(int campNo){
		HomeCamp h;
		if(campNo == 1) h = new HomeCamp(new Camp1(connected++));
		else if(campNo == 2) h = new HomeCamp(new Camp2(connected++));
		else h = new HomeCamp(new Camp3(connected++));
		h.attack.addActionListener(this);
		return h;
	}

	void goToHomeCamp(){
		mainPanel.remove(Map);
		mainPanel.remove(Enemy1);
		mainPanel.add(Home);
		repaint();
		revalidate();
	}
	
	void dummyData() { //dummy enemy camp
		Random rX = new Random(), rY = new Random();
		int randomX = rX.nextInt(25), randomY = rY.nextInt(20);
		enemyCamp = new Camp1(connected++);
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
		if(e.getSource() == ButtonsStart.start) { // Start button
			//ipAd = ButtonsStart.inputIP.getText();
			//System.out.println(ipAd);
			BackgroundChooseCamp.setLayout(new BorderLayout());
			ChooseCamp.setOpaque(false);

			//BackgroundChooseCamp.add(dummy, BorderLayout.NORTH);
			BackgroundChooseCamp.add(ChooseCamp.back, BorderLayout.SOUTH);
		    BackgroundChooseCamp.add(new JLabel(" "), BorderLayout.EAST);
		    BackgroundChooseCamp.add(new JLabel(" "), BorderLayout.WEST);
		    BackgroundChooseCamp.add(ChooseCamp, BorderLayout.CENTER);
	   
			mainPanel.remove(Start);
			mainPanel.add(BackgroundChooseCamp);
			repaint();
			revalidate();
		}
		
		else if(e.getSource() == ButtonsStart.howToPlay) { // How to Play button
			mainPanel.remove(Start);
			mainPanel.add(HowToPlay);
			repaint();
			revalidate();
		}

		else if(e.getSource() == ButtonsStart.exit) { //Exit button
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
			mainPanel.remove(BackgroundChooseCamp);
			mainPanel.add(Start);
			repaint();
			revalidate();
		}

		else if(e.getSource() == ChooseCamp.camp1) { // choosing camp 1
			//campNo = 1; // predefined camp 1
			Home = createCamp(1);
			Map.setMap(numberOfPlayers);
			mainPanel.remove(BackgroundChooseCamp);
			//WaitingPage.setLayout(new GridLayout(1, 1));
			//WaitingPage.add(Map);
			mainPanel.add(Map);			
			repaint();
			revalidate();
			//startGame = true; //server should change this
		}

		else if(e.getSource() == ChooseCamp.camp2) { // choosing camp 2
			campNo = 2; // predefined camp 2
			Home = createCamp(2);
			Map.setMap(numberOfPlayers);
			mainPanel.remove(BackgroundChooseCamp);
			//WaitingPage.setLayout(new GridLayout(1, 1));
			//WaitingPage.add(Map);
			mainPanel.add(Map);			
			repaint();
			revalidate();
			//startGame = true; //server should change this
		}

		else if(e.getSource() == ChooseCamp.camp3) { // choosing camp 3
			campNo = 3; // predefined camp 3
			Home = createCamp(3);
			Map.setMap(numberOfPlayers);
			mainPanel.remove(BackgroundChooseCamp);
			//WaitingPage.setLayout(new GridLayout(1, 1));
			//WaitingPage.add(Map);
			mainPanel.add(Map);			
			repaint();
			revalidate();
			//startGame = true; //server should change this
		}
		
		else if(e.getSource() == Home.attack) { // going to enemy camp
			mainPanel.remove(Home);
			MapAttack.setMap(numberOfPlayers);
			//WaitingPage.setLayout(new GridLayout(1, 1));
			//WaitingPage.add(Map);
			mainPanel.add(MapAttack);			
			repaint();
			revalidate();
			//mainPanel.add(MapAttack);
			//mainPanel.add(Enemy1);
			
		}
		
		else if(e.getSource() == Enemy1.home) { // going to enemy camp
			goToHomeCamp();
		}
		
		if(connected == numberOfPlayers) {
			mainPanel.remove(Map);
			startGame = true;
		}
		
		//MAP ATTACK PAGE
		for(int i=0; i<6; i++) {
			if(e.getSource() == MapAttack.p[i]) {
				mainPanel.remove(MapAttack);
				mainPanel.add(Enemy1); //change this to camp of selected enemy
				repaint();
				revalidate();
			}
		}
	}
}

