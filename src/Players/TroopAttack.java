package Players;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class TroopAttack implements ActionListener{
	Troop t; //troop to attack
	Timer timer; //attack speed of the troop
	CampField field;
	Camp enemy, ally;
	Timer mover; //resumes movement once building is destroyed
	int enemyNo;
		
	public TroopAttack(Troop t, CampField field, Camp enemy, Camp ally, Timer mover) {
		this.t = t;
		this.field = field;
		this.enemy = enemy;
		this.ally = ally;
		this.mover = mover;
		this.enemyNo = t.getEnemyCamp();
		timer = new Timer(1000/t.getAttackSpeed(), this);
		timer.setInitialDelay(1000/t.getAttackSpeed());
		timer.start();
	}

	public void actionPerformed(ActionEvent e) {
		if(t.inPosition) t.attack(); //if building is in range, attack!
		if(t.focus.getHitpoints() <= 0) { //if building is destroyed
			if(t.focus.getType() == 5) { //if enemy town hall is destroyed, end attacking of all troops
				ally.acquireTrophy(); //ally camp gets trophy
				for(Barbarian tr: ally.barbariansP) { //for every barbarian deployed, halt attacking
					if(tr.getEnemyCamp() == enemyNo){
						tr.mover.timer.stop();
						tr.attacker.timer.stop();
					}
				}	
				for(Archer tr: ally.archersP) { //for every archer deployed, halt attacking
					if(tr.getEnemyCamp() == enemyNo){
						tr.mover.timer.stop();
						tr.attacker.timer.stop();
					}
				}	
				for(Giant tr: ally.giantsP) { //for every giant deploed, halt attacking
					if(tr.getEnemyCamp() == enemyNo){
						tr.mover.timer.stop();
						tr.attacker.timer.stop();
					}
				}	
				for(Wizard tr: ally.wizardsP) { //for every wizard deployed, halt attacking
					if(tr.getEnemyCamp() == enemyNo){
						tr.mover.timer.stop();
						tr.attacker.timer.stop();
					}
				}	
				for(Dragon tr: ally.dragonsP) { //for every dragon deployed, halt attacking
					if(tr.getEnemyCamp() == enemyNo){
						tr.mover.timer.stop();
						tr.attacker.timer.stop();
					}
				}	
				for(WallBreaker tr: ally.wallBreakersP) { //for every wall breaker deployed, halt attacking
					if(tr.getEnemyCamp() == enemyNo){
						tr.mover.timer.stop();
						tr.attacker.timer.stop();
					}
				}	
				for(HogRider tr: ally.hogRidersP) { //for every hog rider deployed, halt attacking
					if(tr.getEnemyCamp() == enemyNo){
						tr.mover.timer.stop();
						tr.attacker.timer.stop();
					}
				}
				for(Cannon db: enemy.cannonsP)  //for every cannon positioned, halt attacking
					db.attacker.timer.stop();
				for(ArcherTower db: enemy.archerTowersP)  //for every archer tower positioned, halt attacking
					db.attacker.timer.stop();
				for(Mortar db: enemy.mortarsP)  //for every mortar positioned, halt attacking
					db.attacker.timer.stop();
				for(WizardTower db: enemy.wizardTowersP)  //for every wizard tower positioned, halt attacking
					db.attacker.timer.stop();
				for(Wall db: enemy.wallsP)  //for every cannon wall, halt attacking
					db.attacker.timer.stop();
			}
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
