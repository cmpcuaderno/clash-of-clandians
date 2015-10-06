package Players;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class BuildingTile extends JPanel{ //one 20x20 pixel tile where buildings are positioned
	private int positionX, positionY; //tile's position in the field/canvas
	private Defense occupant; //building that occupies the tile
	Troop[] t; //troops that occupy the tile, 10x10 each
	boolean isOccupied = false; //if true, tile is occupied by either building or troop, and player cannot place another building on it
	JPanel troopTile[];
	
	public BuildingTile(int x, int y) {
		this.positionX = x;
		this.positionY = y;
		setLayout(new GridLayout(2,2));
		t = new Troop[4];
		
		//size of one tile
		setPreferredSize(new Dimension(20,20));
		
		//one tile divided into four for each troop
		troopTile = new JPanel[4];
		for(int i=0; i<4; i++) {
			troopTile[i] = new JPanel();
			troopTile[i].setPreferredSize(new Dimension(10,10));
			troopTile[i].setBackground(Color.WHITE);
			add(troopTile[i]);
		}
		
	}
	
	int getpositionX() {
		return positionX*4;
	}
	
	int getpositionY() {
		return positionY*4;
	}
	
	void occupy(Defense d) { //place building on tile
		occupant = d;
		isOccupied = true;
		
		//coloring the tile
		for(int i=0; i<4; i++) troopTile[i].setBackground(Colors.buildingColor[d.getType()]);
		revalidate();
		repaint();
	}
	
	void occupy(Troop t, int position) { //place troop in tile; position determines which part of the tile is to be occupied by the troop
		this.t[position] = t;
		/* Positions of 10x10 troop in 20x20 tile:
		 *	0	1
		 *	2	3
		 * */
		//coloring tile
		troopTile[position].setBackground(Colors.troopColor[t.getType()]);
		revalidate();
		repaint();
		isOccupied = true; //no building is allowed to be put in the occupied tile
	}
	
	void destroyBuilding() { //if building is destroyed, vacate tile
		occupant = null;
		isOccupied = false;
		for(int i=0; i<4; i++) troopTile[i].setBackground(Color.WHITE); //reset color
		revalidate();
		repaint();
	}
	
	void removeTroop(int position) { //if troop moves out of the position or is killed
		t[position] = null;
		if(t[0] == null && t[1] == null && t[2] == null && t[3] == null)
			isOccupied = false; // if no troop occupies the tile, vacate
		troopTile[position].setBackground(Color.WHITE); //reset color
		revalidate();
		repaint();
	}
}
