package Players;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;


public class MainGame implements ActionListener{
	JLabel time; //display of timer
	int remainingTime = 900; //remaining time in game, in seconds
	Timer timer;
	MainFrame game;
	
	public MainGame() {
		timer = new Timer(1000, this); //one second
		time = new JLabel("15:00");
		game = new MainFrame();
		while(!game.startGame) {System.out.print("");} // waiting for other players
		game.Home = game.createCamp(game.campNo);
		game.dummyData();
		game.goToHomeCamp();
		game.add(time, BorderLayout.NORTH);
		timer.start();
	}
	
	public static void main(String[] args){
		MainGame g = new MainGame();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		remainingTime--; //decrease remaining time
		time.setText(remainingTime/60 + ":" + remainingTime%60);
		if(remainingTime/60 < 10 && remainingTime%60 >= 10)
			time.setText("0" + remainingTime/60 + ":" + remainingTime%60);
		else if(remainingTime%60 < 10 && remainingTime%60 < 10)
			time.setText("0" + remainingTime/60 + ":0" + remainingTime%60);
		else if(remainingTime%60 >= 10 && remainingTime%60 < 10)
			time.setText(remainingTime/60 + ":0" + remainingTime%60);
		else time.setText(remainingTime/60 + ":" + remainingTime%60);
		if(remainingTime == 0) { //if time runs out, end game
			timer.stop();
			time.setText("00:00 ----- GAME OVER! Huhubels.");
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
