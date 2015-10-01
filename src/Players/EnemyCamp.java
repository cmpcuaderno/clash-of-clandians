package Players;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class EnemyCamp extends JPanel implements MouseListener, ActionListener{
	JButton barbarian, archer, giant, wizard, dragon, wallbreaker, hogrider; //troop buttons
	JButton home; //go back to home camp
	Color barbarianC, archerC, giantC, wizardC, dragonC, wallbreakerC, hogriderC, cannonC, archerTowerC, mortarC, wizardTowerC, wallC; //colors for each troop
	Color unselected, empty; //buttons
	JPanel field, buttons; //panels
	Camp allyCamp, enemyCamp;
	boolean toPlaceTroop; //true if there is a troop selected to deploy
	Troop troopToPlace; //selected troop to deploy
	int troopType; //type of troop to deploy; 1=barbarian, 2=archer, 3=giant, 4=wizard, 5=dragon, 6=wallbreaker, 7=hogrider
	int enemyNo; //identification
	
	public EnemyCamp(Camp enemyCamp, Camp allyCamp) {
		//camps
		this.allyCamp = allyCamp;
		this.enemyCamp = enemyCamp;
		
		//colors of buttons
		unselected = new Color(255,255,255);
		empty = new Color(175,175,175);
		
		//colors of buildings
		cannonC =  new Color(0,255,0);
		archerC =  new Color(255,255,0);
		mortarC =  new Color(255,0,255);
		wizardC =  new Color(100,100,0);
		wallC =  new Color(0,255,255);
		
		//colors of troops
		barbarianC =  new Color(100, 150, 200);
		archerC =  new Color(200, 150, 100);
		giantC =  new Color(194, 140, 102);
		wizardC =  new Color(83, 184, 105);
		dragonC =  new Color(29, 176, 145);
		wallbreakerC =  new Color(174, 100, 76);
		hogriderC =  new Color(245, 106, 200);
		
		//panels
		this.setLayout(new BorderLayout());
		field = new CampField(enemyCamp, false, allyCamp, enemyNo);
		field.addMouseListener(this);
		buttons = new JPanel(new GridLayout(2,4,1,1));
		
		//construction of buttons
		home = new JButton("Home");
		barbarian = new JButton("Barbarians (" + allyCamp.barbarians.size() + ")");
		archer = new JButton("Archers (" + allyCamp.archers.size() + ")");
		giant = new JButton("Giants (" + allyCamp.giants.size() + ")");
		wizard = new JButton("Wizards (" + allyCamp.wizards.size() + ")");
		dragon = new JButton("Dragons (" + allyCamp.dragons.size() + ")");
		wallbreaker = new JButton("Wall Breakers (" + allyCamp.wallBreakers.size() + ")");
		hogrider = new JButton("Hog Riders (" + allyCamp.hogRiders.size() + ")");
		
		//setting colors
		home.setBackground(unselected);
		barbarian.setBackground(unselected);
		archer.setBackground(unselected);
		giant.setBackground(unselected);
		wizard.setBackground(unselected);
		dragon.setBackground(unselected);
		wallbreaker.setBackground(unselected);
		hogrider.setBackground(unselected);
		
		//action listeners
		home.addActionListener(this);
		barbarian.addActionListener(this);
		archer.addActionListener(this);
		giant.addActionListener(this);
		wizard.addActionListener(this);
		dragon.addActionListener(this);
		wallbreaker.addActionListener(this);
		hogrider.addActionListener(this);
		
		//adding buttons to panels
		buttons.add(barbarian);
		buttons.add(archer);
		buttons.add(giant);
		buttons.add(wizard);
		buttons.add(dragon);
		buttons.add(wallbreaker);
		buttons.add(hogrider);
		buttons.add(home);
		add(field, BorderLayout.CENTER);
		add(buttons, BorderLayout.SOUTH);
	}
	
	void disableButtons(){ //checks for empty queues, disables button
		if(allyCamp.barbarians.size() == 0) barbarian.setBackground(empty);
		if(allyCamp.archers.size() == 0) archer.setBackground(empty);
		if(allyCamp.giants.size() == 0) giant.setBackground(empty);
		if(allyCamp.wizards.size() == 0) wizard.setBackground(empty);
		if(allyCamp.dragons.size() == 0) dragon.setBackground(empty);
		if(allyCamp.wallBreakers.size() == 0) wallbreaker.setBackground(empty);
		if(allyCamp.hogRiders.size() == 0) hogrider.setBackground(empty);
	}

	public void mouseClicked(MouseEvent e) {
		if(toPlaceTroop){
			if(troopType == 1 && allyCamp.barbarians.size() != 0) { //to position barbarian from queue
				troopToPlace = allyCamp.barbarians.remove(0);
				if(allyCamp.barbarians.size() == 0) {
					troopType = 0; //if queue is empty, deselect
					toPlaceTroop = false;
				}
				troopToPlace.position(e.getX(), e.getY());
				troopToPlace.deploy(enemyNo); //deploy in enemy camp
				allyCamp.barbariansP.add((Barbarian) troopToPlace); //remove from queue, add to "positioned" list
				field.paint(getGraphics());
				barbarian.setText("Barbarians (" + allyCamp.barbarians.size() + ")");
			}
			
			if(troopType == 2 && allyCamp.archers.size() != 0) { //to position archer from queue
				troopToPlace = allyCamp.archers.remove(0);
				if(allyCamp.archers.size() == 0) {
					troopType = 0; //if queue is empty, deselect
					toPlaceTroop = false;
				}
				troopToPlace.position(e.getX(), e.getY());
				troopToPlace.deploy(enemyNo); //deploy in enemy camp
				allyCamp.archersP.add((Archer) troopToPlace); //remove from queue, add to "positioned" list
				field.paint(getGraphics());
				archer.setText("Archers (" + allyCamp.archers.size() + ")");
			}

			if(troopType == 3 && allyCamp.giants.size() != 0) { //to position giant from queue
				troopToPlace = allyCamp.giants.remove(0);
				if(allyCamp.giants.size() == 0) {
					troopType = 0; //if queue is empty, deselect
					toPlaceTroop = false;
				}
				troopToPlace.position(e.getX(), e.getY());
				troopToPlace.deploy(enemyNo); //deploy in enemy camp
				allyCamp.giantsP.add((Giant) troopToPlace); //remove from queue, add to "positioned" list
				field.paint(getGraphics());
				giant.setText("Giants (" + allyCamp.giants.size() + ")");
			}

			if(troopType == 4 && allyCamp.wizards.size() != 0) { //to position wizard from queue
				troopToPlace = allyCamp.wizards.remove(0);
				if(allyCamp.wizards.size() == 0) {
					troopType = 0; //if queue is empty, deselect
					toPlaceTroop = false;
				}
				troopToPlace.position(e.getX(), e.getY());
				troopToPlace.deploy(enemyNo); //deploy in enemy camp
				allyCamp.wizardsP.add((Wizard) troopToPlace); //remove from queue, add to "positioned" list
				field.paint(getGraphics());
				wizard.setText("Wizards (" + allyCamp.wizards.size() + ")");
			}

			if(troopType == 5 && allyCamp.dragons.size() != 0) { //to position dragon from queue
				troopToPlace = allyCamp.dragons.remove(0);
				if(allyCamp.dragons.size() == 0) {
					troopType = 0; //if queue is empty, deselect
					toPlaceTroop = false;
				}
				troopToPlace.position(e.getX(), e.getY());
				troopToPlace.deploy(enemyNo); //deploy in enemy camp
				allyCamp.dragonsP.add((Dragon) troopToPlace); //remove from queue, add to "positioned" list
				field.paint(getGraphics());
				dragon.setText("Dragons (" + allyCamp.dragons.size() + ")");
			}

			if(troopType == 6 && allyCamp.wallBreakers.size() != 0) { //to position wallbreaker from queue
				troopToPlace = allyCamp.wallBreakers.remove(0);
				if(allyCamp.wallBreakers.size() == 0) {
					troopType = 0; //if queue is empty, deselect
					toPlaceTroop = false;
				}
				troopToPlace.position(e.getX(), e.getY());
				troopToPlace.deploy(enemyNo); //deploy in enemy camp
				allyCamp.wallBreakersP.add((WallBreaker) troopToPlace); //remove from queue, add to "positioned" list
				field.paint(getGraphics());
				wallbreaker.setText("Wall Breakers (" + allyCamp.wallBreakers.size() + ")");
			}

			if(troopType == 7 && allyCamp.hogRiders.size() != 0) { //to position hogrider from queue
				troopToPlace = allyCamp.hogRiders.remove(0);
				if(allyCamp.hogRiders.size() == 0) {
					troopType = 0; //if queue is empty, deselect
					toPlaceTroop = false;
				}
				troopToPlace.position(e.getX(), e.getY());
				troopToPlace.deploy(enemyNo); //deploy in enemy camp
				allyCamp.hogRidersP.add((HogRider) troopToPlace); //remove from queue, add to "positioned" list
				field.paint(getGraphics());
				hogrider.setText("Hog Riders (" + allyCamp.hogRiders.size() + ")");
			}
			
			disableButtons(); //check for empty queues
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == barbarian && allyCamp.barbarians.size() != 0) { //if barbarian is selected and queue is not empty
			if(troopType == 1) {
				toPlaceTroop = false; //deselect if same button is clicked
				barbarian.setBackground(unselected); //reset color
				troopType = 0; //no button selected
			}
			else{
				//reset colors of other buttons
				archer.setBackground(unselected);
				giant.setBackground(unselected);
				wizard.setBackground(unselected);
				dragon.setBackground(unselected);
				wallbreaker.setBackground(unselected);
				hogrider.setBackground(unselected);
				disableButtons();
				toPlaceTroop = true; //selects barbarians button
				troopType = 1; //to place barbarian
				barbarian.setBackground(barbarianC);
			}
		}
		
		else if(e.getSource() == archer && allyCamp.archers.size() != 0) { //if archer is selected and queue is not empty
			if(troopType == 2) {
				toPlaceTroop = false; //deselect if same button is clicked
				archer.setBackground(unselected); //reset color
				troopType = 0; //no button selected
			}
			else{
				//reset colors of other buttons
				barbarian.setBackground(unselected);
				giant.setBackground(unselected);
				wizard.setBackground(unselected);
				dragon.setBackground(unselected);
				wallbreaker.setBackground(unselected);
				hogrider.setBackground(unselected);
				disableButtons();
				toPlaceTroop = true; //selects archer button
				troopType = 2; //to place archer
				archer.setBackground(archerC);
			}
		}

		else if(e.getSource() == giant && allyCamp.giants.size() != 0) { //if giant is selected and queue is not empty
			if(troopType == 3) {
				toPlaceTroop = false; //deselect if same button is clicked
				giant.setBackground(unselected); //reset color
				troopType = 0; //no button selected
			}
			else{
				//reset colors of other buttons
				barbarian.setBackground(unselected);
				archer.setBackground(unselected);
				wizard.setBackground(unselected);
				dragon.setBackground(unselected);
				wallbreaker.setBackground(unselected);
				hogrider.setBackground(unselected);
				disableButtons();
				toPlaceTroop = true; //selects giant button
				troopType = 3; //to place giant
				giant.setBackground(giantC);
			}
		}

		else if(e.getSource() == wizard && allyCamp.wizards.size() != 0) { //if wizard is selected and queue is not empty
			if(troopType == 4) {
				toPlaceTroop = false; //deselect if same button is clicked
				wizard.setBackground(unselected); //reset color
				troopType = 0; //no button selected
			}
			else{
				//reset colors of other buttons
				barbarian.setBackground(unselected);
				archer.setBackground(unselected);
				giant.setBackground(unselected);
				dragon.setBackground(unselected);
				wallbreaker.setBackground(unselected);
				hogrider.setBackground(unselected);
				disableButtons();
				toPlaceTroop = true; //selects wizard button
				troopType = 4; //to place wizard
				wizard.setBackground(wizardC);
			}
		}

		else if(e.getSource() == dragon && allyCamp.dragons.size() != 0) { //if dragon is selected and queue is not empty
			if(troopType == 5) {
				toPlaceTroop = false; //deselect if same button is clicked
				dragon.setBackground(unselected); //reset color
				troopType = 0; //no button selected
			}
			else{
				//reset colors of other buttons
				barbarian.setBackground(unselected);
				archer.setBackground(unselected);
				giant.setBackground(unselected);
				wizard.setBackground(unselected);
				wallbreaker.setBackground(unselected);
				hogrider.setBackground(unselected);
				disableButtons();
				toPlaceTroop = true; //selects dragon button
				troopType = 5; //to place dragon
				dragon.setBackground(dragonC);
			}
		}

		else if(e.getSource() == wallbreaker && allyCamp.wallBreakers.size() != 0) { //if wall breaker is selected and queue is not empty
			if(troopType == 6) {
				toPlaceTroop = false; //deselect if same button is clicked
				wallbreaker.setBackground(unselected); //reset color
				troopType = 0; //no button selected
			}
			else{
				//reset colors of other buttons
				barbarian.setBackground(unselected);
				archer.setBackground(unselected);
				giant.setBackground(unselected);
				wizard.setBackground(unselected);
				dragon.setBackground(unselected);
				hogrider.setBackground(unselected);
				disableButtons();
				toPlaceTroop = true; //selects wallbreaker button
				troopType = 6; //to place wallbreaker
				wallbreaker.setBackground(wallbreakerC);
			}
		}

		else if(e.getSource() == hogrider && allyCamp.hogRiders.size() != 0) { //if hog rider is selected and queue is not empty
			if(troopType == 7) {
				toPlaceTroop = false; //deselect if same button is clicked
				hogrider.setBackground(unselected); //reset color
				troopType = 0; //no button selected
			}
			else{
				//reset colors of other buttons
				barbarian.setBackground(unselected);
				archer.setBackground(unselected);
				giant.setBackground(unselected);
				wizard.setBackground(unselected);
				dragon.setBackground(unselected);
				wallbreaker.setBackground(unselected);
				disableButtons();
				toPlaceTroop = true; //selects hogrider button
				troopType = 7; //to place hogrider
				hogrider.setBackground(hogriderC);
			}
		}
	}
}
