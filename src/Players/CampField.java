package Players;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class CampField extends JPanel{
	Camp camp, home;
	boolean isHome;
	int enemyNo; //if in enemy territory, value is 1-6; otherwise, value is 0
	BuildingTile[][] tile; //one 20x20 tile
	
	public CampField(Camp camp, boolean isHome, Camp home, int enemyNo) { //isHome == true if camp is own camp, otherwise, it is an enemy camp
		this.camp = camp;
		this.home = home;
		this.isHome = isHome;
		setLayout(new GridLayout(20,25, 1, 1));
		
		//tiles
		tile = new BuildingTile[20][25];
		for(int i=0; i<20; i++) { //each row of tiles
			for(int j=0; j<25; j++) { //each tile
				tile[i][j] = new BuildingTile(i,j);
				add(tile[i][j]);
			}
		}
		
		setPreferredSize(new Dimension(500, 400));
		setBackground(Color.BLACK);
		
	}
	
	void moveTroop(Troop t){ //walking troop
		int resultingX = t.getResultingX(), resultingY = t.getResultingY();
		if(tile[resultingY/2][resultingX/2].getOccupant() == null
			&& tile[resultingY/2][resultingX/2].t[(resultingY%2)*2 + resultingX%2] == null) {
			int oldX = t.getX(), oldY = t.getY();
			t.move(); //troop moves one tile towards the defense building
			//remove troop from old position
			tile[oldY/2][oldX/2].removeTroop((oldY%2)*2 + oldX%2);
			//troop occupies new position/tile
			tile[t.getY()/2][t.getX()/2].occupy(t, (t.getY()%2)*2 + t.getX()%2);
		}
	}
	
	int getDistance(Troop t, Defense d) {
		int distance, positionXd, positionYd;
		positionXd = d.getX() * 2;
		positionYd = d.getY() * 2;
		if(t.getX() >= positionXd+1) positionXd++;
		if(t.getY() >= positionYd+1) positionYd++;
		distance = (int) Math.ceil(Math.sqrt(Math.pow(t.getX()-positionXd, 2) + Math.pow(t.getY()-positionYd, 2)));
		
		return distance; //Euclidean distance
	}
	
	void findClosestBuilding(Troop t) { //finds positioned enemy building closest to troop t
		Defense d = null;
		int i = 0;
		
		while(i != camp.cannonsP.size()) { //for each cannon
			if(i == 0) d = camp.cannonsP.get(0);
			else {
				if(getDistance(t, d) > getDistance(t, camp.cannonsP.get(i)))
					d = camp.cannonsP.get(i);
			}
			i++;
		}
		
		i = 0;
		while(i != camp.archerTowersP.size()) { //for each archer tower
			if(d == null) d = camp.archerTowersP.get(0);
			else {
				if(getDistance(t, d) > getDistance(t, camp.archerTowersP.get(i)))
					d = camp.archerTowersP.get(i);
			}
			i++;
		}

		i = 0;
		while(i != camp.mortarsP.size()) { //for each mortar
			if(d == null) d = camp.mortarsP.get(0);
			else {
				if(getDistance(t, d) > getDistance(t, camp.mortarsP.get(i)))
					d = camp.mortarsP.get(i);
			}
			i++;
		}

		i = 0;
		while(i != camp.wizardTowersP.size()) { //for each wizard tower
			if(d == null) d = camp.wizardTowersP.get(0);
			else {
				if(getDistance(t, d) > getDistance(t, camp.wizardTowersP.get(i)))
					d = camp.wizardTowersP.get(i);
			}
			i++;
		}

		i = 0;
		while(i != camp.wallsP.size()) { //for each wall
			if(d == null) d = camp.wallsP.get(0);
			else {
				if(getDistance(t, d) > getDistance(t, camp.wallsP.get(i)))
					d = camp.wallsP.get(i);
			}
			i++;
		}
		
		if(d == null || getDistance(t, d) > getDistance(t, camp.townHall)) d = camp.townHall;
		
		t.setFocus(d); //troop sets focus on closest building
	}
}
