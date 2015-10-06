package Players;

public class Defense {
	protected double hitpoints; // amount of damage to be inflicted on the building before it is destroyed
	protected double damage; // amount of damage it can inflict on a troop
	protected double attackSpeed; // how fast the defense throw in attacks on the troops	
	protected int x, y; // x- and y-position in the game frame
	private Troop focus; // troop the defense building is set to attack
	protected int type; // 1- cannon; 2- archer tower; 3- mortar; 4- wizard tower; 5- wall; 6- town hall
	
	//getters
	int getType(){
		return type;
	}
	
	double getHitpoints(){
		return hitpoints;
	}

	double getDamage(){
		return damage;
	}
	
	double getAttackSpeed(){
		return attackSpeed;
	}
	
	int getX(){
		return x;
	}
	
	int getY(){
		return y;
	}
	
	//methods
	void position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	void setFocus(Troop t){
		focus = t;
	}
	
	void attack() { //attack troops
		focus.receiveAttack(this);
	}
	
	void receiveAttack(Troop t) { //receive attack from troop
		hitpoints = hitpoints - t.getDamage();
		System.out.println("Type " + type + " hp remaining: " + hitpoints);
	}
	
}
