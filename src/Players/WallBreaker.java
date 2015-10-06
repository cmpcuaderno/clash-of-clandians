package Players;

public class WallBreaker extends Troop{	
	public WallBreaker() {
		movementSpeed = 24;
		attackSpeed = 1;
		range = 1;
		damage = 480;
		hitpoints = 20;
		type = 5;
	}
	
	void attack() {
		focus.receiveAttack(this);
		hitpoints = 0; //suicide bomber
	}
}
