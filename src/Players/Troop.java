package Players;

public class Troop {
	protected int movementSpeed; // how fast the troop walks/changes position
	protected int attackSpeed; // how fast the troop attacks
	protected int range; // how far can the troop reach to attack
	protected double damage; // amount of damage inflicted per shot
	protected double hitpoints; // amount of health; amount of damage to be inflicted on the troop before it dies
	private int x, y; // x- and y-position in the game frame
	protected Defense focus; // defense building the troop is set to attack
	private int inEnemyCampNo; //enemy camp where the troop is deployed
	protected int type; //0- barbarian, 1- archer, 2-giant, 3- wizard, 4- dragon, 5- wallbreaker, 6- hogrider
	boolean inPosition = false; //toggles true if focus building is in range of the troop; if true, attack begins
	
	// getters
	int getType(){
		return type;
	}
	int getEnemyCamp(){
		return inEnemyCampNo;
	}
	int getX(){
		return x;
	}

	int getY(){
		return y;
	}
	
	int getResultingX(){ //get resulting X position if troop move towards building
		if(focus.getX()*2 > x) return x+1;
		else if(focus.getX()*2 < x) return x-1;
		else return x;
	}

	int getResultingY(){ //get resulting Y position if troop move towards building
		if(focus.getY()*2 > y) return y+1;
		else if(focus.getY()*2 < y) return y-1;
		else return y;
	}
	
	int getMovementSpeed(){
		return movementSpeed;
	}

	int getAttackSpeed(){
		return attackSpeed;
	}

	int getRange(){
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
	
	void move(){ //changes position, towards focus building
		if(focus.getX()*2 > x) x++;
		else if(focus.getX()*2 < x) x--;
		if(focus.getY()*2 > y) y++;
		else if(focus.getY()*2 < y) y--;
	}
	
	void attack(){
		focus.receiveAttack(this);
	}
	
	void receiveAttack(Defense d){
		hitpoints = hitpoints - d.getDamage();
	}
	
}
