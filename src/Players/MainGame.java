package Players;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import Chat.ChatBox;
import Client.*;

public class MainGame implements ActionListener{
	JLabel time; //display of timer
	JLabel trophyCount;
	int remainingTime = 900; //remaining time in game, in seconds
	Timer timer;
	MainFrame game;
	
	
	public MainGame(Client client) {
//		JPanel topPanel = new JPanel(new BorderLayout());
//		timer = new Timer(1000, this); //one second
//		time = new JLabel("15:00");
//		game = new MainFrame();
//		while(!game.startGame) {System.out.print("");} // waiting for other players
//		game.add(topPanel, BorderLayout.NORTH);
//		game.Home = game.createCamp(game.campNo);
//		game.dummyData();
//		game.goToHomeCamp();
//		trophyCount = new JLabel("Trophy Count: " + game.Home.camp.getTrophyCount() + "\t\t\t\t\t");
//		topPanel.add(trophyCount, BorderLayout.EAST);
//		topPanel.add(time, BorderLayout.WEST);
//		timer.start();
		
//		JPanel top_panel = new JPanel(new BorderLayout());
//		timer = new Timer(1000, this);
		
		game = new MainFrame(client);
		
//		while(!game.startGame) { System.out.println(""); }
		
//		game.add(top_panel);
		
//		game.Home = game.createCamp(game.campNo);
		
//		game.dummyData();
		
//		game.goToHomeCamp();
		
//		trophyCount = new JLabel("Trophy Count: " + game.Home.camp.getTrophyCount() + "\t\t\t\t\t");
//		
//		top_panel.add(trophyCount, BorderLayout.EAST);
//		top_panel.add();
		
	}
	

	public ChatBox getChatBox() {
		return game.chat_box;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		trophyCount.setText("Trophy Count: " + game.Home.camp.getTrophyCount() + "\t\t\t\t\t");
		remainingTime--; //decrease remaining time
		time.setText(remainingTime/60 + ":" + remainingTime%60);
		
		if(remainingTime/60 < 10 && remainingTime%60 >= 10)
			time.setText("0" + remainingTime/60 + ":" + remainingTime%60);
		else if(remainingTime/60 < 10 && remainingTime%60 < 10)
			time.setText("0" + remainingTime/60 + ":0" + remainingTime%60);
		else if(remainingTime/60 >= 10 && remainingTime%60 < 10)
			time.setText(remainingTime/60 + ":0" + remainingTime%60);
		else time.setText(remainingTime/60 + ":" + remainingTime%60);
		if(remainingTime == 0) { //if time runs out, end game
			timer.stop();
			time.setText("00:00 \t\t GAME OVER! Huhubels.");
			game.Home.gameOver = true;
			game.Enemy1.gameOver = true;
			//stop all attacking and moving of all camps
			for(Troop t: game.Home.camp.barbariansP){
				t.mover.timer.stop();
				t.attacker.timer.stop();
			}
			for(Troop t: game.Home.camp.archersP){
				t.mover.timer.stop();
				t.attacker.timer.stop();
			}
			for(Troop t: game.Home.camp.giantsP){
				t.mover.timer.stop();
				t.attacker.timer.stop();
			}
			for(Troop t: game.Home.camp.wizardsP){
				t.mover.timer.stop();
				t.attacker.timer.stop();
			}
			for(Troop t: game.Home.camp.dragonsP){
				t.mover.timer.stop();
				t.attacker.timer.stop();
			}
			for(Troop t: game.Home.camp.wallBreakersP){
				t.mover.timer.stop();
				t.attacker.timer.stop();
			}
			for(Troop t: game.Home.camp.hogRidersP){
				t.mover.timer.stop();
				t.attacker.timer.stop();
			}
			for(Defense d: game.Home.camp.cannonsP) d.attacker.timer.stop();
			for(Defense d: game.Home.camp.archerTowersP) d.attacker.timer.stop();
			for(Defense d: game.Home.camp.mortarsP) d.attacker.timer.stop();
			for(Defense d: game.Home.camp.wizardTowersP) d.attacker.timer.stop();
			for(Defense d: game.Home.camp.wallsP) d.attacker.timer.stop();
			
			//enemiesssss
			for(Troop t: game.Enemy1.enemyCamp.barbariansP){
				t.mover.timer.stop();
				t.attacker.timer.stop();
			}
			for(Troop t: game.Enemy1.enemyCamp.archersP){
				t.mover.timer.stop();
				t.attacker.timer.stop();
			}
			for(Troop t: game.Enemy1.enemyCamp.giantsP){
				t.mover.timer.stop();
				t.attacker.timer.stop();
			}
			for(Troop t: game.Enemy1.enemyCamp.wizardsP){
				t.mover.timer.stop();
				t.attacker.timer.stop();
			}
			for(Troop t: game.Enemy1.enemyCamp.dragonsP){
				t.mover.timer.stop();
				t.attacker.timer.stop();
			}
			for(Troop t: game.Enemy1.enemyCamp.wallBreakersP){
				t.mover.timer.stop();
				t.attacker.timer.stop();
			}
			for(Troop t: game.Enemy1.enemyCamp.hogRidersP){
				t.mover.timer.stop();
				t.attacker.timer.stop();
			}
			for(Defense d: game.Enemy1.enemyCamp.cannonsP) d.attacker.timer.stop();
			for(Defense d: game.Enemy1.enemyCamp.archerTowersP) d.attacker.timer.stop();
			for(Defense d: game.Enemy1.enemyCamp.mortarsP) d.attacker.timer.stop();
			for(Defense d: game.Enemy1.enemyCamp.wizardTowersP) d.attacker.timer.stop();
			for(Defense d: game.Enemy1.enemyCamp.wallsP) d.attacker.timer.stop();
		}
	}
}
