package Players;

import java.util.ArrayList;

public class Camp3 extends Camp{
	public Camp3(){
		int i;
		barbarians = new ArrayList<Barbarian>();
		archers = new ArrayList<Archer>();
		giants = new ArrayList<Giant>();
		wizards = new ArrayList<Wizard>();
		dragons = new ArrayList<Dragon>();
		wallBreakers = new ArrayList<WallBreaker>();
		hogRiders = new ArrayList<HogRider>();
		cannons = new ArrayList<Cannon>();
		archerTowers = new ArrayList<ArcherTower>();
		walls = new ArrayList<Wall>();
		mortars = new ArrayList<Mortar>();
		wizardTowers = new ArrayList<WizardTower>();
		townHall = new TownHall();
		
		for(i=0; i<38; i++) barbarians.add(new Barbarian());
		for(i=0; i<15; i++) archers.add(new Archer());
		for(i=0; i<7; i++) giants.add(new Giant());
		for(i=0; i<12; i++) wizards.add(new Wizard());
		for(i=0; i<1; i++) dragons.add(new Dragon());
		for(i=0; i<6; i++) wallBreakers.add(new WallBreaker());
		for(i=0; i<5; i++) hogRiders.add(new HogRider());
		for(i=0; i<3; i++) cannons.add(new Cannon());
		for(i=0; i<3; i++) archerTowers.add(new ArcherTower());
		for(i=0; i<75; i++) walls.add(new Wall());
		mortars.add(new Mortar());
		wizardTowers.add(new WizardTower());
		
		// positioned buildings/deployed troops
		barbariansP = new ArrayList<Barbarian>();
		archersP = new ArrayList<Archer>();
		giantsP = new ArrayList<Giant>();
		wizardsP = new ArrayList<Wizard>();
		dragonsP = new ArrayList<Dragon>();
		wallBreakersP = new ArrayList<WallBreaker>();
		hogRidersP = new ArrayList<HogRider>();
		cannonsP = new ArrayList<Cannon>();
		archerTowersP = new ArrayList<ArcherTower>();
		wallsP = new ArrayList<Wall>();
		mortarsP = new ArrayList<Mortar>();
		wizardTowersP = new ArrayList<WizardTower>();
	}
}
