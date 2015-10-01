package Players;

public class Troop {
	protected int movementSpeed; // how fast the troop walks/changes position
	protected double attackSpeed; // how fast the troop attacks
	protected double range; // how far can the troop reach to attack
	protected double damage; // amount of damage inflicted per shot
	protected double hitpoints; // amount of health; amount of damage to be inflicted on the troop before it dies
	private int x, y; // x- and y-position in the game frame
	protected Defense focus; // defense building the troop is set to attack
	private int inEnemyCampNo; //enemy camp where the troop is deployed
	
	// getters
	int getEnemyCamp(){
		return inEnemyCampNo;
	}
	int getX(){
		return x;
	}

	int getY(){
		return y;
	}
	
	int getMovementSpeed(){
		return movementSpeed;
	}

	double getAttackSpeed(){
		return attackSpeed;
	}

	double getRange(){
		return range;
	}

	double getDamage(){
		return damage;
	}

	double getHitPoints(){
		return hitpoints;
	}
	
	//methods
	void deploy(int enemy) {
		this.inEnemyCampNo = enemy;
	}
	
	void position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	void setFocus(Defense d){
		focus = d;
	}
	
	void move(int x, int y){ //changes position
		this.x = x;
		this.y = y;
	}
	
	void attack(){
		focus.receiveAttack(this);
	}
	
	void receiveAttack(Defense d){
		hitpoints = hitpoints - d.getDamage();
	}
	
}
