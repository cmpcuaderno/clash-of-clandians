package Players;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class HomeCamp extends JPanel implements ActionListener, MouseListener{
	JButton cannon, archerTower, mortar, wizardTower, wall; //defense buildings
	JButton attack; // go to enemy camp
	Camp camp; //type of camp
	boolean toPlaceDef; //if player is to position/reposition a building
	Defense defToPlace; //defense building to position; will be repositioned if toPlaceDef==true
	int defType = 0; //type of defense (button) selected; 1=cannon, 2=archerTower, 3=mortar, wizardTower=4, wall=5
	JPanel buttons;
	CampField field;
	boolean gameOver = false;
	
	public HomeCamp(Camp camp) {		
		//panels
		setLayout(new BorderLayout());
		field = new CampField(camp, true, camp, 0); //actual game field
		field.addMouseListener(this);
		buttons = new JPanel(); //buttons for positioning buildings
		buttons.setLayout(new GridLayout(2,3,1,1));
		buttons.setPreferredSize(new Dimension(500,50));
		
		//position town hall
		field.tile[camp.townHall.getY()][camp.townHall.getX()].occupy(camp.townHall, field);
		
		this.camp = camp;
		attack = new JButton("Attack!");
		cannon = new JButton("Cannons (" + this.camp.cannons.size() + ")");
		archerTower = new JButton("Archer Towers (" + this.camp.archerTowers.size() + ")");
		mortar = new JButton("Mortars (" + this.camp.mortars.size() + ")");
		wizardTower = new JButton("Wizard Towers (" + this.camp.wizardTowers.size() + ")");
		wall = new JButton("Walls (" + this.camp.walls.size() + ")");
		
		//action listeners
		cannon.addActionListener(this);
		archerTower.addActionListener(this);
		mortar.addActionListener(this);
		wizardTower.addActionListener(this);
		wall.addActionListener(this);
		
		//default color if not selected = white
		cannon.setBackground(Colors.unselected);
		archerTower.setBackground(Colors.unselected);
		mortar.setBackground(Colors.unselected);
		wizardTower.setBackground(Colors.unselected);
		wall.setBackground(Colors.unselected);
		
		// adding to panel
		buttons.add(cannon);
		buttons.add(archerTower);
		buttons.add(mortar);
		buttons.add(wizardTower);
		buttons.add(wall);
		buttons.add(attack);
		add(buttons, BorderLayout.SOUTH);
		add(field, BorderLayout.CENTER);
		
	}
	
	void disableButtons(){ //checks for empty queues, disables button
		if(camp.cannons.size() == 0) cannon.setBackground(Colors.empty);
		if(camp.archerTowers.size() == 0) archerTower.setBackground(Colors.empty);
		if(camp.mortars.size() == 0) mortar.setBackground(Colors.empty);
		if(camp.wizardTowers.size() == 0) wizardTower.setBackground(Colors.empty);
		if(camp.walls.size() == 0) wall.setBackground(Colors.empty);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cannon && camp.cannons.size() != 0) { //if cannon button is selected and cannon queue is not empty
			if(defType == 1) {
				toPlaceDef = false; //deselect if same button is clicked
				cannon.setBackground(Colors.unselected); //reset color
				defType = 0; //no button selected
			}
			else{
				//reset colors of other buttons
				archerTower.setBackground(Colors.unselected);
				mortar.setBackground(Colors.unselected);
				wizardTower.setBackground(Colors.unselected);
				wall.setBackground(Colors.unselected);
				disableButtons();
				toPlaceDef = true; //selects cannon button
				defType = 1; //to place cannon
				cannon.setBackground(Colors.buildingColor[0]);
			}
		}
		
		if(e.getSource() == archerTower && camp.archerTowers.size() != 0) { //if archerTower button is selected and archerTower queue is not empty
			if(defType == 2) {
				toPlaceDef = false; //deselect if same button is clicked
				archerTower.setBackground(Colors.unselected); //reset color
				defType = 0; //no button selected
			}
			else{
				//reset colors of other buttons
				cannon.setBackground(Colors.unselected);
				mortar.setBackground(Colors.unselected);
				wizardTower.setBackground(Colors.unselected);
				wall.setBackground(Colors.unselected);
				disableButtons();
				toPlaceDef = true; //selects archerTower button
				defType = 2; //to place archerTower
				archerTower.setBackground(Colors.buildingColor[1]);
			}
		}
		
		if(e.getSource() == mortar && camp.mortars.size() != 0) { //if mortar button is selected and mortar queue is not empty
			if(defType == 3) {
				toPlaceDef = false; //deselect if same button is clicked
				mortar.setBackground(Colors.unselected); //reset color
				defType = 0; //no button selected
			}
			else{
				//reset colors of other buttons
				cannon.setBackground(Colors.unselected);
				archerTower.setBackground(Colors.unselected);
				wizardTower.setBackground(Colors.unselected);
				wall.setBackground(Colors.unselected);
				disableButtons();
				toPlaceDef = true; //selects mortar button
				defType = 3; //to place mortar
				mortar.setBackground(Colors.buildingColor[2]);
			}
		}
		
		if(e.getSource() == wizardTower && camp.wizardTowers.size() != 0) { //if wizardTower button is selected and wizardTower queue is not empty
			if(defType == 4) {
				toPlaceDef = false; //deselect if same button is clicked
				wizardTower.setBackground(Colors.unselected); //reset color
				defType = 0; //no button selected
			}
			else{
				//reset colors of other buttons
				cannon.setBackground(Colors.unselected);
				archerTower.setBackground(Colors.unselected);
				mortar.setBackground(Colors.unselected);
				wall.setBackground(Colors.unselected);
				disableButtons();
				toPlaceDef = true; //selects wizardTower button
				defType = 4; //to place wizardTower
				wizardTower.setBackground(Colors.buildingColor[3]);
			}
		}

		if(e.getSource() == wall && camp.walls.size() != 0) { //if wall button is selected and wall queue is not empty
			if(defType == 5) {
				toPlaceDef = false; //deselect if same button is clicked
				wall.setBackground(Colors.unselected); //reset color
				defType = 0; //no button selected
			}
			else{
				//reset colors of other buttons
				cannon.setBackground(Colors.unselected);
				archerTower.setBackground(Colors.unselected);
				mortar.setBackground(Colors.unselected);
				wizardTower.setBackground(Colors.unselected);
				disableButtons();
				toPlaceDef = true; //selects wall button
				defType = 5; //to place wall
				wall.setBackground(Colors.buildingColor[4]);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(!gameOver && !field.tile[e.getY()/20][e.getX()/20].isOccupied && toPlaceDef){
			if(defType == 1 && camp.cannons.size() != 0) { //to position cannon from queue
				defToPlace = camp.cannons.remove(0);
				if(camp.cannons.size() == 0) {
					defType = 0; //if queue is empty, deselect
					toPlaceDef = false;
				}
				defToPlace.position(e.getX()/20, e.getY()/20);
				camp.cannonsP.add((Cannon) defToPlace); //remove from queue, add to "positioned" list
				field.tile[defToPlace.getY()][defToPlace.getX()].occupy(defToPlace, field);
				cannon.setText("Cannons (" + camp.cannons.size() + ")");
			}

			if(defType == 2 && camp.archerTowers.size() != 0) { //to position archer tower from queue
				defToPlace = camp.archerTowers.remove(0);
				if(camp.archerTowers.size() == 0) {
					defType = 0; //if queue is empty, deselect
					toPlaceDef = false;
				}
				defToPlace.position(e.getX()/20, e.getY()/20);
				camp.archerTowersP.add((ArcherTower) defToPlace); //remove from queue, add to "positioned" list
				field.tile[defToPlace.getY()][defToPlace.getX()].occupy(defToPlace, field);
				archerTower.setText("Archer Towers (" + camp.archerTowers.size() + ")");
			}

			if(defType == 3 && camp.mortars.size() != 0) { //to position mortar from queue
				defToPlace = camp.mortars.remove(0);
				if(camp.mortars.size() == 0) {
					defType = 0; //if queue is empty, deselect
					toPlaceDef = false;
				}
				defToPlace.position(e.getX()/20, e.getY()/20);
				camp.mortarsP.add((Mortar) defToPlace); //remove from queue, add to "positioned" list
				field.tile[defToPlace.getY()][defToPlace.getX()].occupy(defToPlace, field);
				mortar.setText("Mortars (" + camp.mortars.size() + ")");
			}

			if(defType == 4 && camp.wizardTowers.size() != 0) { //to position wizard tower from queue
				defToPlace = camp.wizardTowers.remove(0);
				if(camp.wizardTowers.size() == 0) {
					defType = 0; //if queue is empty, deselect
					toPlaceDef = false;
				}
				defToPlace.position(e.getX()/20, e.getY()/20);
				camp.wizardTowersP.add((WizardTower) defToPlace); //remove from queue, add to "positioned" list
				field.tile[defToPlace.getY()][defToPlace.getX()].occupy(defToPlace, field);
				wizardTower.setText("Wizard Towers (" + camp.wizardTowers.size() + ")");
			}

			if(defType == 5 && camp.walls.size() != 0) { //to position wall from queue
				defToPlace = camp.walls.remove(0);
				if(camp.walls.size() == 0) {
					defType = 0; //if queue is empty, deselect
					toPlaceDef = false;
				}
				defToPlace.position(e.getX()/20, e.getY()/20);
				camp.wallsP.add((Wall) defToPlace); //remove from queue, add to "positioned" list
				field.tile[defToPlace.getY()][defToPlace.getX()].occupy(defToPlace, field);
				wall.setText("Walls (" + camp.walls.size() + ")");
			}
			
			disableButtons(); //check for empty queues
		}
	}

	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
}
