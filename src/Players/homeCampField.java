package Players;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class homeCampField extends JPanel{
	
	Color cannonC, archerC, mortarC, wizardC, wallC, townC;
	Camp camp;
	
	public homeCampField(Camp camp) {
		this.camp = camp;
		//colors of the buildings
		cannonC =  new Color(0,255,0);
		archerC =  new Color(255,255,0);
		mortarC =  new Color(255,0,255);
		wizardC =  new Color(100,100,0);
		wallC =  new Color(0,255,255);
		townC = new Color(0,255,255);
		
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
		g2d.setColor(archerC);
		for(ArcherTower a: camp.archerTowersP) //put rectangle in panel
			g2d.fillRect(Math.round(a.getX()), Math.round(a.getY()), 10, 10);
		
		//positioning mortars
		g2d.setColor(mortarC);
		for(Mortar m: camp.mortarsP) //put rectangle in panel
			g2d.fillRect(Math.round(m.getX()), Math.round(m.getY()), 10, 10);

		//positioning wizardTower
		g2d.setColor(wizardC);
		for(WizardTower w: camp.wizardTowersP) //put rectangle in panel
			g2d.fillRect(Math.round(w.getX()), Math.round(w.getY()), 10, 10);

		//positioning mortars
		g2d.setColor(wallC);
		for(Wall w: camp.wallsP) //put rectangle in panel
			g2d.fillRect(Math.round(w.getX()), Math.round(w.getY()), 10, 10);
	}
}
