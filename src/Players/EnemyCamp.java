package Players;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
	JPanel buttons; //panels
	CampField field;
	Camp allyCamp, enemyCamp;
	boolean toPlaceTroop; //true if there is a troop selected to deploy
	Troop troopToPlace; //selected troop to deploy
	int troopType; //type of troop to deploy; 1=barbarian, 2=archer, 3=giant, 4=wizard, 5=dragon, 6=wallbreaker, 7=hogrider
	int enemyNo; //identification
	boolean gameOver = false;
	
	public EnemyCamp(Camp enemyCamp, Camp allyCamp, int enemyNo) {
		//camps
		this.allyCamp = allyCamp;
		this.enemyCamp = enemyCamp;
		this.enemyNo = enemyNo;
		
		
		//panels
		this.setLayout(new BorderLayout());
		field = new CampField(enemyCamp, false, allyCamp, enemyNo);
		field.addMouseListener(this);
		buttons = new JPanel(new GridLayout(2,4,1,1));
		buttons.setPreferredSize(new Dimension(500,50));
		
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
		home.setBackground(Colors.unselected);
		barbarian.setBackground(Colors.unselected);
		archer.setBackground(Colors.unselected);
		giant.setBackground(Colors.unselected);
		wizard.setBackground(Colors.unselected);
		dragon.setBackground(Colors.unselected);
		wallbreaker.setBackground(Colors.unselected);
		hogrider.setBackground(Colors.unselected);
		
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
		if(allyCamp.barbarians.size() == 0) barbarian.setBackground(Colors.empty);
		if(allyCamp.archers.size() == 0) archer.setBackground(Colors.empty);
		if(allyCamp.giants.size() == 0) giant.setBackground(Colors.empty);
		if(allyCamp.wizards.size() == 0) wizard.setBackground(Colors.empty);
		if(allyCamp.dragons.size() == 0) dragon.setBackground(Colors.empty);
		if(allyCamp.wallBreakers.size() == 0) wallbreaker.setBackground(Colors.empty);
		if(allyCamp.hogRiders.size() == 0) hogrider.setBackground(Colors.empty);
	}

	public void mouseClicked(MouseEvent e) {
		if(!gameOver && enemyCamp.townHall != null && toPlaceTroop && field.tile[e.getY()/20][e.getX()/20].getOccupant() == null && field.tile[e.getY()/20][e.getX()/20].t[(((e.getY()/10)%20)%2)*2 + ((e.getX()/10)%20)%2] == null){
			if(troopType == 1 && allyCamp.barbarians.size() != 0) { //to position barbarian from queue
				troopToPlace = allyCamp.barbarians.remove(0);
				if(allyCamp.barbarians.size() == 0) {
					troopType = 0; //if queue is empty, deselect
					toPlaceTroop = false;
				}
				troopToPlace.position(e.getX()/10, e.getY()/10);
				troopToPlace.deploy(enemyNo); //deploy in enemy camp
				allyCamp.barbariansP.add((Barbarian) troopToPlace); //remove from queue, add to "positioned" list
				field.tile[troopToPlace.getY()/2][troopToPlace.getX()/2].occupy(troopToPlace, (troopToPlace.getY()%2)*2 + troopToPlace.getX()%2);
				barbarian.setText("Barbarians (" + allyCamp.barbarians.size() + ")");
			}
			
			if(troopType == 2 && allyCamp.archers.size() != 0) { //to position archer from queue
				troopToPlace = allyCamp.archers.remove(0);
				if(allyCamp.archers.size() == 0) {
					troopType = 0; //if queue is empty, deselect
					toPlaceTroop = false;
				}
				troopToPlace.position(e.getX()/10, e.getY()/10);
				troopToPlace.deploy(enemyNo); //deploy in enemy camp
				allyCamp.archersP.add((Archer) troopToPlace); //remove from queue, add to "positioned" list
				field.tile[troopToPlace.getY()/2][troopToPlace.getX()/2].occupy(troopToPlace, (troopToPlace.getY()%2)*2 + troopToPlace.getX()%2);
				archer.setText("Archers (" + allyCamp.archers.size() + ")");
			}

			if(troopType == 3 && allyCamp.giants.size() != 0) { //to position giant from queue
				troopToPlace = allyCamp.giants.remove(0);
				if(allyCamp.giants.size() == 0) {
					troopType = 0; //if queue is empty, deselect
					toPlaceTroop = false;
				}
				troopToPlace.position(e.getX()/10, e.getY()/10);
				troopToPlace.deploy(enemyNo); //deploy in enemy camp
				allyCamp.giantsP.add((Giant) troopToPlace); //remove from queue, add to "positioned" list
				field.tile[troopToPlace.getY()/2][troopToPlace.getX()/2].occupy(troopToPlace, (troopToPlace.getY()%2)*2 + troopToPlace.getX()%2);
				giant.setText("Giants (" + allyCamp.giants.size() + ")");
			}

			if(troopType == 4 && allyCamp.wizards.size() != 0) { //to position wizard from queue
				troopToPlace = allyCamp.wizards.remove(0);
				if(allyCamp.wizards.size() == 0) {
					troopType = 0; //if queue is empty, deselect
					toPlaceTroop = false;
				}
				troopToPlace.position(e.getX()/10, e.getY()/10);
				troopToPlace.deploy(enemyNo); //deploy in enemy camp
				allyCamp.wizardsP.add((Wizard) troopToPlace); //remove from queue, add to "positioned" list
				field.tile[troopToPlace.getY()/2][troopToPlace.getX()/2].occupy(troopToPlace, (troopToPlace.getY()%2)*2 + troopToPlace.getX()%2);
				wizard.setText("Wizards (" + allyCamp.wizards.size() + ")");
			}

			if(troopType == 5 && allyCamp.dragons.size() != 0) { //to position dragon from queue
				troopToPlace = allyCamp.dragons.remove(0);
				if(allyCamp.dragons.size() == 0) {
					troopType = 0; //if queue is empty, deselect
					toPlaceTroop = false;
				}
				troopToPlace.position(e.getX()/10, e.getY()/10);
				troopToPlace.deploy(enemyNo); //deploy in enemy camp
				allyCamp.dragonsP.add((Dragon) troopToPlace); //remove from queue, add to "positioned" list
				field.tile[troopToPlace.getY()/2][troopToPlace.getX()/2].occupy(troopToPlace, (troopToPlace.getY()%2)*2 + troopToPlace.getX()%2);
				dragon.setText("Dragons (" + allyCamp.dragons.size() + ")");
			}

			if(troopType == 6 && allyCamp.wallBreakers.size() != 0) { //to position wallbreaker from queue
				troopToPlace = allyCamp.wallBreakers.remove(0);
				if(allyCamp.wallBreakers.size() == 0) {
					troopType = 0; //if queue is empty, deselect
					toPlaceTroop = false;
				}
				troopToPlace.position(e.getX()/10, e.getY()/10);
				troopToPlace.deploy(enemyNo); //deploy in enemy camp
				allyCamp.wallBreakersP.add((WallBreaker) troopToPlace); //remove from queue, add to "positioned" list
				field.tile[troopToPlace.getY()/2][troopToPlace.getX()/2].occupy(troopToPlace, (troopToPlace.getY()%2)*2 + troopToPlace.getX()%2);
				wallbreaker.setText("Wall Breakers (" + allyCamp.wallBreakers.size() + ")");
			}

			if(troopType == 7 && allyCamp.hogRiders.size() != 0) { //to position hogrider from queue
				troopToPlace = allyCamp.hogRiders.remove(0);
				if(allyCamp.hogRiders.size() == 0) {
					troopType = 0; //if queue is empty, deselect
					toPlaceTroop = false;
				}
				troopToPlace.position(e.getX()/10, e.getY()/10);
				troopToPlace.deploy(enemyNo); //deploy in enemy camp
				allyCamp.hogRidersP.add((HogRider) troopToPlace); //remove from queue, add to "positioned" list
				field.tile[troopToPlace.getY()/2][troopToPlace.getX()/2].occupy(troopToPlace, (troopToPlace.getY()%2)*2 + troopToPlace.getX()%2);
				hogrider.setText("Hog Riders (" + allyCamp.hogRiders.size() + ")");
			}
			
			disableButtons(); //check for empty queues
			field.findClosestBuilding(troopToPlace);
			troopToPlace.mover = new TroopMove(troopToPlace, field); //make troop move
			troopToPlace.attacker = new TroopAttack(troopToPlace, field, enemyCamp, troopToPlace.mover.timer);
		}
	}

	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == barbarian && allyCamp.barbarians.size() != 0) { //if barbarian is selected and queue is not empty
			if(troopType == 1) {
				toPlaceTroop = false; //deselect if same button is clicked
				barbarian.setBackground(Colors.unselected); //reset color
				troopType = 0; //no button selected
			}
			else{
				//reset colors of other buttons
				archer.setBackground(Colors.unselected);
				giant.setBackground(Colors.unselected);
				wizard.setBackground(Colors.unselected);
				dragon.setBackground(Colors.unselected);
				wallbreaker.setBackground(Colors.unselected);
				hogrider.setBackground(Colors.unselected);
				disableButtons();
				toPlaceTroop = true; //selects barbarians button
				troopType = 1; //to place barbarian
				barbarian.setBackground(Colors.troopColor[0]);
			}
		}
		
		else if(e.getSource() == archer && allyCamp.archers.size() != 0) { //if archer is selected and queue is not empty
			if(troopType == 2) {
				toPlaceTroop = false; //deselect if same button is clicked
				archer.setBackground(Colors.unselected); //reset color
				troopType = 0; //no button selected
			}
			else{
				//reset colors of other buttons
				barbarian.setBackground(Colors.unselected);
				giant.setBackground(Colors.unselected);
				wizard.setBackground(Colors.unselected);
				dragon.setBackground(Colors.unselected);
				wallbreaker.setBackground(Colors.unselected);
				hogrider.setBackground(Colors.unselected);
				disableButtons();
				toPlaceTroop = true; //selects archer button
				troopType = 2; //to place archer
				archer.setBackground(Colors.troopColor[1]);
			}
		}

		else if(e.getSource() == giant && allyCamp.giants.size() != 0) { //if giant is selected and queue is not empty
			if(troopType == 3) {
				toPlaceTroop = false; //deselect if same button is clicked
				giant.setBackground(Colors.unselected); //reset color
				troopType = 0; //no button selected
			}
			else{
				//reset colors of other buttons
				barbarian.setBackground(Colors.unselected);
				archer.setBackground(Colors.unselected);
				wizard.setBackground(Colors.unselected);
				dragon.setBackground(Colors.unselected);
				wallbreaker.setBackground(Colors.unselected);
				hogrider.setBackground(Colors.unselected);
				disableButtons();
				toPlaceTroop = true; //selects giant button
				troopType = 3; //to place giant
				giant.setBackground(Colors.troopColor[2]);
			}
		}

		else if(e.getSource() == wizard && allyCamp.wizards.size() != 0) { //if wizard is selected and queue is not empty
			if(troopType == 4) {
				toPlaceTroop = false; //deselect if same button is clicked
				wizard.setBackground(Colors.unselected); //reset color
				troopType = 0; //no button selected
			}
			else{
				//reset colors of other buttons
				barbarian.setBackground(Colors.unselected);
				archer.setBackground(Colors.unselected);
				giant.setBackground(Colors.unselected);
				dragon.setBackground(Colors.unselected);
				wallbreaker.setBackground(Colors.unselected);
				hogrider.setBackground(Colors.unselected);
				disableButtons();
				toPlaceTroop = true; //selects wizard button
				troopType = 4; //to place wizard
				wizard.setBackground(Colors.troopColor[3]);
			}
		}

		else if(e.getSource() == dragon && allyCamp.dragons.size() != 0) { //if dragon is selected and queue is not empty
			if(troopType == 5) {
				toPlaceTroop = false; //deselect if same button is clicked
				dragon.setBackground(Colors.unselected); //reset color
				troopType = 0; //no button selected
			}
			else{
				//reset colors of other buttons
				barbarian.setBackground(Colors.unselected);
				archer.setBackground(Colors.unselected);
				giant.setBackground(Colors.unselected);
				wizard.setBackground(Colors.unselected);
				wallbreaker.setBackground(Colors.unselected);
				hogrider.setBackground(Colors.unselected);
				disableButtons();
				toPlaceTroop = true; //selects dragon button
				troopType = 5; //to place dragon
				dragon.setBackground(Colors.troopColor[4]);
			}
		}

		else if(e.getSource() == wallbreaker && allyCamp.wallBreakers.size() != 0) { //if wall breaker is selected and queue is not empty
			if(troopType == 6) {
				toPlaceTroop = false; //deselect if same button is clicked
				wallbreaker.setBackground(Colors.unselected); //reset color
				troopType = 0; //no button selected
			}
			else{
				//reset colors of other buttons
				barbarian.setBackground(Colors.unselected);
				archer.setBackground(Colors.unselected);
				giant.setBackground(Colors.unselected);
				wizard.setBackground(Colors.unselected);
				dragon.setBackground(Colors.unselected);
				hogrider.setBackground(Colors.unselected);
				disableButtons();
				toPlaceTroop = true; //selects wallbreaker button
				troopType = 6; //to place wallbreaker
				wallbreaker.setBackground(Colors.troopColor[5]);
			}
		}

		else if(e.getSource() == hogrider && allyCamp.hogRiders.size() != 0) { //if hog rider is selected and queue is not empty
			if(troopType == 7) {
				toPlaceTroop = false; //deselect if same button is clicked
				hogrider.setBackground(Colors.unselected); //reset color
				troopType = 0; //no button selected
			}
			else{
				//reset colors of other buttons
				barbarian.setBackground(Colors.unselected);
				archer.setBackground(Colors.unselected);
				giant.setBackground(Colors.unselected);
				wizard.setBackground(Colors.unselected);
				dragon.setBackground(Colors.unselected);
				wallbreaker.setBackground(Colors.unselected);
				disableButtons();
				toPlaceTroop = true; //selects hogrider button
				troopType = 7; //to place hogrider
				hogrider.setBackground(Colors.troopColor[6]);
			}
		}
	}
}

