package Players;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class TroopAttack implements ActionListener{
	Troop t; //troop to attack
	Timer timer; //attack speed of the troop
	CampField field;
	Camp enemy;
	Timer mover; //resumes movement once building is destroyed
		
	public TroopAttack(Troop t, CampField field, Camp enemy, Timer mover) {
		this.t = t;
		this.field = field;
		this.enemy = enemy;
		this.mover = mover;
		timer = new Timer(1000/t.getAttackSpeed(), this);
		timer.setInitialDelay(1000/t.getAttackSpeed());
		timer.start();
	}

	public void actionPerformed(ActionEvent e) {
		if(t.inPosition) t.attack(); //if building is in range, attack!
		if(t.focus.getHitpoints() <= 0) { //if building is destroyed
			//stop attacking
			t.focus.attacker.timer.stop();
			//vacate tile from field
			field.tile[t.focus.getY()][t.focus.getX()].destroyBuilding();
			//remove from linked list of positioned buildings
			if(t.focus.getType() == 0) enemy.cannonsP.remove(t.focus);
			else if(t.focus.getType() == 1) enemy.archerTowersP.remove(t.focus);
			else if(t.focus.getType() == 2) enemy.mortarsP.remove(t.focus);
			else if(t.focus.getType() == 3) enemy.wizardTowersP.remove(t.focus);
			else if(t.focus.getType() == 4) enemy.wallsP.remove(t.focus);
			else if(t.focus.getType() == 5) enemy.townHall = null;
			//troop is no longer in position to attack
			t.inPosition = false;
			//troop finds new building to destroy <-- Aww. :(
			field.findClosestBuilding(t);
			//troop starts to approach building
			mover.start();
		}
	}
}
