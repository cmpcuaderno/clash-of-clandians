package Players;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class CampField extends JPanel{
	
	Color cannonC, archerTowerC, mortarC, wizardTowerC, wallC, townC; //colors of the buildings
	Color barbarianC, archerC, giantC, wizardC, dragonC, wallbreakerC, hogriderC; //colors of the troops
	Camp camp, home;
	boolean isHome;
	int enemyNo; //if in enemy terrirtory, value is 1-6; otherwise, value is 0
	
	public CampField(Camp camp, boolean isHome, Camp home, int enemyNo) { //isHome == true if camp is own camp, otherwise, it is an enemy camp
		this.camp = camp;
		this.home = home;
		this.isHome = isHome;
		
		//colors of the buildings
		cannonC =  new Color(0,255,0);
		archerTowerC =  new Color(255,255,0);
		mortarC =  new Color(255,0,255);
		wizardTowerC =  new Color(100,100,0);
		wallC =  new Color(0,255,255);
		townC = new Color(0,255,255);
		
		//colors of troops
		barbarianC =  new Color(100, 150, 200);
		archerC =  new Color(200, 150, 100);
		giantC =  new Color(194, 140, 102);
		wizardC =  new Color(83, 184, 105);
		dragonC =  new Color(29, 176, 145);
		wallbreakerC =  new Color(174, 100, 76);
		hogriderC =  new Color(245, 106, 200);
		
		setPreferredSize(new Dimension(500, 400));
		setBackground(Color.WHITE);
		
	}
	
	public void paintComponent(Graphics g){
		g.clearRect(0, 0, getWidth(), getHeight());
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		//positioning cannons
		g2d.setColor(cannonC);
		for(Cannon c: camp.cannonsP) //put rectangle in panel
			g2d.fillRect(Math.round(c.getX()), Math.round(c.getY()), 10, 10);
		
		//positioning archer towers
		g2d.setColor(archerTowerC);
		for(ArcherTower a: camp.archerTowersP) //put rectangle in panel
			g2d.fillRect(Math.round(a.getX()), Math.round(a.getY()), 10, 10);
		
		//positioning mortars
		g2d.setColor(mortarC);
		for(Mortar m: camp.mortarsP) //put rectangle in panel
			g2d.fillRect(Math.round(m.getX()), Math.round(m.getY()), 10, 10);

		//positioning wizardTower
		g2d.setColor(wizardTowerC);
		for(WizardTower w: camp.wizardTowersP) //put rectangle in panel
			g2d.fillRect(Math.round(w.getX()), Math.round(w.getY()), 10, 10);

		//positioning walls
		g2d.setColor(wallC);
		for(Wall w: camp.wallsP) //put rectangle in panel
			g2d.fillRect(Math.round(w.getX()), Math.round(w.getY()), 10, 10);
		
		//if in enemy territory, position troops
		if(!isHome) {
			//positioning barbarians
			g2d.setColor(barbarianC);
			for(Barbarian b: home.barbariansP){ //put oval in panel
				if(b.getEnemyCamp() == enemyNo)
					g2d.fillOval(Math.round(b.getX()), Math.round(b.getY()), 10, 10);
			}
			
			//positioning archers
			g2d.setColor(archerC);
			for(Archer a: home.archersP){ //put oval in panel
				if(a.getEnemyCamp() == enemyNo)
					g2d.fillOval(Math.round(a.getX()), Math.round(a.getY()), 10, 10);
			}

			//positioning giants
			g2d.setColor(giantC);
			for(Giant gt: home.giantsP){ //put oval in panel
				if(gt.getEnemyCamp() == enemyNo)
					g2d.fillOval(Math.round(gt.getX()), Math.round(gt.getY()), 10, 10);
			}

			//positioning wizards
			g2d.setColor(wizardC);
			for(Wizard w: home.wizardsP){ //put oval in panel
				if(w.getEnemyCamp() == enemyNo)
					g2d.fillOval(Math.round(w.getX()), Math.round(w.getY()), 10, 10);
			}

			//positioning dragons
			g2d.setColor(dragonC);
			for(Dragon d: home.dragonsP){ //put oval in panel
				if(d.getEnemyCamp() == enemyNo)
					g2d.fillOval(Math.round(d.getX()), Math.round(d.getY()), 10, 10);
			}

			//positioning wallbreakers
			g2d.setColor(wallbreakerC);
			for(WallBreaker w: home.wallBreakersP){ //put oval in panel
				if(w.getEnemyCamp() == enemyNo)
					g2d.fillOval(Math.round(w.getX()), Math.round(w.getY()), 10, 10);
			}

			//positioning hogriders
			g2d.setColor(hogriderC);
			for(HogRider h: home.hogRidersP){ //put oval in panel
				if(h.getEnemyCamp() == enemyNo)
					g2d.fillOval(Math.round(h.getX()), Math.round(h.getY()), 10, 10);
			}
		}
	}
}
