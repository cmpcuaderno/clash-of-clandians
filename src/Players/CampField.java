package Players;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class CampField extends JPanel{
	
	Color cannonC, archerTowerC, mortarC, wizardTowerC, wallC, townC; //colors of the buildings
	Color barbarianC, archerC, giantC, wizardC, dragonC, wallbreakerC, hogriderC; //colors of the troops
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
}
