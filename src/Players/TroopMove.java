package Players;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class TroopMove implements ActionListener{
	Troop t; //troop to move
	CampField enemyCamp; // enemy territory where troop is deployed
	Timer timer;
	
	public TroopMove(Troop t, CampField enemyCamp) {
		this.t = t;
		this.enemyCamp = enemyCamp;
		timer = new Timer(5000/t.getMovementSpeed(), this);
		timer.setInitialDelay(5000/t.getMovementSpeed());
		timer.start();
	}
	
	public void actionPerformed(ActionEvent e) {
		if(enemyCamp.getDistance(t, t.focus) <= t.getRange()){
			System.out.println("Type " + t.getType() + " is in position.");
			timer.stop();
			t.inPosition = true; //ready to attack
		}
		else enemyCamp.moveTroop(t);
	}

}
