package Players;

import java.util.ArrayList;

public class Camp1 extends Camp{
	public Camp1(){
		int i;
		barbarians = new ArrayList<Barbarian>();
		archers = new ArrayList<Archer>();
		giants = new ArrayList<Giant>();
		wizards = new ArrayList<Wizard>();
		dragons = new ArrayList<Dragon>();
		wallBreakers = new ArrayList<WallBreaker>();
		hogRiders = new ArrayList<HogRider>();
		
		mortar = new Mortar();
		wizardTower = new WizardTower();
		townHall = new TownHall();
		
		for(i=0; i<37; i++) barbarians.add(new Barbarian());
		for(i=0; i<30; i++) archers.add(new Archer());
		for(i=0; i<3; i++) giants.add(new Giant());
		for(i=0; i<9; i++) wizards.add(new Wizard());
		for(i=0; i<2; i++) dragons.add(new Dragon());
		for(i=0; i<6; i++) wallBreakers.add(new WallBreaker());
		for(i=0; i<3; i++) hogRiders.add(new HogRider());
		for(i=0; i<3; i++) cannons.add(new Cannon());
		for(i=0; i<3; i++) archerTowers.add(new ArcherTower());
		for(i=0; i<75; i++) walls.add(new Wall());
	}
}
