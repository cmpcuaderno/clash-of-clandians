package Players;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class BuildingAttack implements ActionListener{
	Timer timer; //attacking troops
	Defense d; //the building to attack
	CampField field; //field of battle
	Camp ally; //player's camp
	
	
	public BuildingAttack(Defense d, CampField field, Camp ally) {
		this.d = d;
		this.field = field;
		this.ally = ally;
		field.findClosestTroop(this.d);
		timer = new Timer(1000/d.getAttackSpeed(), this);
		timer.setInitialDelay(1000/d.getAttackSpeed());
		timer.start();
	}


	public void actionPerformed(ActionEvent e) {
		field.findClosestTroop(d); //finds closest troop
		if(d.getFocus() != null){ //if defense building has a troop to attack
			if(d.getRange() >= field.getDistance(d.getFocus(), d)) //attack only when troop is in range
				d.attack();
			if(d.getFocus().getHitPoints() <= 0) { //if building is destroyed
				//stop attacking
				d.getFocus().mover.timer.stop();
				d.getFocus().attacker.timer.stop();
				//vacate tile from field
				field.tile[d.getFocus().getY()/2][d.getFocus().getX()/2].removeTroop((d.getFocus().getY()%2)*2 + d.getFocus().getX()%2);
				//remove from linked list of positioned buildings
				if(d.getFocus().getType() == 0) ally.barbariansP.remove(d.getFocus());
				else if(d.getFocus().getType() == 1) ally.archersP.remove(d.getFocus());
				else if(d.getFocus().getType() == 2) ally.giantsP.remove(d.getFocus());
				else if(d.getFocus().getType() == 3) ally.wizardsP.remove(d.getFocus());
				else if(d.getFocus().getType() == 4) ally.dragonsP.remove(d.getFocus());
				else if(d.getFocus().getType() == 5) ally.wallBreakersP.remove(d.getFocus());
				else if(d.getFocus().getType() == 5) ally.hogRidersP.remove(d.getFocus());
				//building finds new troop to attack <-- Aww. :(
				field.findClosestTroop(d);
			}
		}
	}
}
