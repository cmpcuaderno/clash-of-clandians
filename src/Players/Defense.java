package Players;

public class Defense {
	protected double hitpoints; // amount of damage to be inflicted on the building before it is destroyed
	protected double damage; // amount of damage it can inflict on a troop
	protected double attackSpeed; // how fast the defense throw in attacks on the troops	
	protected int x, y; // x- and y-position in the game frame
	private Troop focus; // troop the defense building is set to attack
	
	//getters
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
	void setFocus(Troop t){
		focus = t;
	}
	
	void attack() { //attack troops
		focus.receiveAttack(this);
	}
	
	void receiveAttack(Troop t) { //receive attack from troop
		hitpoints = hitpoints - t.getDamage();
	}
	
}
