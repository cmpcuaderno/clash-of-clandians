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
		timer = new Timer(t.getMovementSpeed()*100, this);
		timer.setInitialDelay(t.getMovementSpeed()*100);
		timer.start();
	}
	
	public void actionPerformed(ActionEvent e) {
		if(t.focus.getHitpoints() == 0 || enemyCamp.getDistance(t, t.focus) <= (int) t.getRange()){
			timer.stop();
			t.inPosition = true; //ready to attack
		}
		else enemyCamp.moveTroop(t);
		System.out.println(enemyCamp.getDistance(t, t.focus));
	}

}
