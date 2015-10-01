package Players;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class homeCamp extends JPanel implements ActionListener, MouseListener{
	JButton cannon, archerTower, mortar, wizardTower, wall; //defense buildings
	Camp camp; //type of camp
	boolean toPlaceDef; //if player is to position/reposition a building
	Defense defToPlace; //defense building to position; will be repositioned if toPlaceDef==true
	int defType = 0; //type of defense (button) selected; 1=cannon, 2=archerTower, 3=mortar, wizardTower=4, wall=5
	Color unselected, empty; // buttons
	Color cannonC, archerC, mortarC, wizardC, wallC; //buildings
	JPanel field, buttons;
	
	public homeCamp(Camp camp) {
		//colors
		unselected = new Color(255,255,255);
		empty = new Color(175,175,175);
		cannonC =  new Color(0,255,0);
		archerC =  new Color(255,255,0);
		mortarC =  new Color(255,0,255);
		wizardC =  new Color(100,100,0);
		wallC =  new Color(0,255,255);
		
		//panels
		setLayout(new BorderLayout());
		field = new homeCampField(camp); //actual game field
		field.addMouseListener(this);
		buttons = new JPanel(); //buttons for positioning buildings
		
		this.camp = camp;
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
		cannon.setBackground(unselected);
		archerTower.setBackground(unselected);
		mortar.setBackground(unselected);
		wizardTower.setBackground(unselected);
		wall.setBackground(unselected);
		
		// adding to panel
		buttons.add(cannon);
		buttons.add(archerTower);
		buttons.add(mortar);
		buttons.add(wizardTower);
		buttons.add(wall);
		add(buttons, BorderLayout.SOUTH);
		add(field, BorderLayout.CENTER);
		
	}
	
	void disableButtons(){ //checks for empty queues, disables button
		if(camp.cannons.size() == 0) cannon.setBackground(empty);
		if(camp.archerTowers.size() == 0) archerTower.setBackground(empty);
		if(camp.mortars.size() == 0) mortar.setBackground(empty);
		if(camp.wizardTowers.size() == 0) wizardTower.setBackground(empty);
		if(camp.walls.size() == 0) wall.setBackground(empty);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cannon && camp.cannons.size() != 0) { //if cannon button is selected and cannon queue is not empty
			if(defType == 1) {
				toPlaceDef = false; //deselect if same button is clicked
				cannon.setBackground(unselected); //reset color
				defType = 0; //no button selected
			}
			else{
				//reset colors of other buttons
				archerTower.setBackground(unselected);
				mortar.setBackground(unselected);
				wizardTower.setBackground(unselected);
				wall.setBackground(unselected);
				disableButtons();
				toPlaceDef = true; //selects cannon button
				defType = 1; //to place cannon
				cannon.setBackground(cannonC);
			}
		}
		
		if(e.getSource() == archerTower && camp.archerTowers.size() != 0) { //if archerTower button is selected and archerTower queue is not empty
			if(defType == 2) {
				toPlaceDef = false; //deselect if same button is clicked
				archerTower.setBackground(unselected); //reset color
				defType = 0; //no button selected
			}
			else{
				//reset colors of other buttons
				cannon.setBackground(unselected);
				mortar.setBackground(unselected);
				wizardTower.setBackground(unselected);
				wall.setBackground(unselected);
				disableButtons();
				toPlaceDef = true; //selects archerTower button
				defType = 2; //to place archerTower
				archerTower.setBackground(archerC);
			}
		}
		
		if(e.getSource() == mortar && camp.mortars.size() != 0) { //if mortar button is selected and mortar queue is not empty
			if(defType == 3) {
				toPlaceDef = false; //deselect if same button is clicked
				mortar.setBackground(unselected); //reset color
				defType = 0; //no button selected
			}
			else{
				//reset colors of other buttons
				cannon.setBackground(unselected);
				archerTower.setBackground(unselected);
				wizardTower.setBackground(unselected);
				wall.setBackground(unselected);
				disableButtons();
				toPlaceDef = true; //selects mortar button
				defType = 3; //to place mortar
				mortar.setBackground(mortarC);
			}
		}
		
		if(e.getSource() == wizardTower && camp.wizardTowers.size() != 0) { //if wizardTower button is selected and wizardTower queue is not empty
			if(defType == 4) {
				toPlaceDef = false; //deselect if same button is clicked
				wizardTower.setBackground(unselected); //reset color
				defType = 0; //no button selected
			}
			else{
				//reset colors of other buttons
				cannon.setBackground(unselected);
				archerTower.setBackground(unselected);
				mortar.setBackground(unselected);
				wall.setBackground(unselected);
				disableButtons();
				toPlaceDef = true; //selects wizardTower button
				defType = 4; //to place wizardTower
				wizardTower.setBackground(wizardC);
			}
		}

		if(e.getSource() == wall && camp.walls.size() != 0) { //if wall button is selected and wall queue is not empty
			if(defType == 5) {
				toPlaceDef = false; //deselect if same button is clicked
				wall.setBackground(unselected); //reset color
				defType = 0; //no button selected
			}
			else{
				//reset colors of other buttons
				cannon.setBackground(unselected);
				archerTower.setBackground(unselected);
				mortar.setBackground(unselected);
				wizardTower.setBackground(unselected);
				disableButtons();
				toPlaceDef = true; //selects wall button
				defType = 5; //to place wall
				wall.setBackground(wallC);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(toPlaceDef){
			if(defType == 1 && camp.cannons.size() != 0) { //to position cannon from queue
				defToPlace = camp.cannons.remove(0);
				if(camp.cannons.size() == 0) {
					defType = 0; //if queue is empty, deselect
					toPlaceDef = false;
				}
				defToPlace.position(e.getX(), e.getY());
				camp.cannonsP.add((Cannon) defToPlace); //remove from queue, add to "positioned" list
				field.paint(getGraphics());
				cannon.setText("Cannons (" + camp.cannons.size() + ")");
			}

			if(defType == 2 && camp.archerTowers.size() != 0) { //to position archer tower from queue
				defToPlace = camp.archerTowers.remove(0);
				if(camp.archerTowers.size() == 0) {
					defType = 0; //if queue is empty, deselect
					toPlaceDef = false;
				}
				defToPlace.position(e.getX(), e.getY());
				camp.archerTowersP.add((ArcherTower) defToPlace); //remove from queue, add to "positioned" list
				field.paint(getGraphics());
				archerTower.setText("Archer Towers (" + camp.archerTowers.size() + ")");
			}

			if(defType == 3 && camp.mortars.size() != 0) { //to position mortar from queue
				defToPlace = camp.mortars.remove(0);
				if(camp.mortars.size() == 0) {
					defType = 0; //if queue is empty, deselect
					toPlaceDef = false;
				}
				defToPlace.position(e.getX(), e.getY());
				camp.mortarsP.add((Mortar) defToPlace); //remove from queue, add to "positioned" list
				field.paint(getGraphics());
				mortar.setText("Mortars (" + camp.mortars.size() + ")");
			}

			if(defType == 4 && camp.wizardTowers.size() != 0) { //to position wizard tower from queue
				defToPlace = camp.wizardTowers.remove(0);
				if(camp.wizardTowers.size() == 0) {
					defType = 0; //if queue is empty, deselect
					toPlaceDef = false;
				}
				defToPlace.position(e.getX(), e.getY());
				camp.wizardTowersP.add((WizardTower) defToPlace); //remove from queue, add to "positioned" list
				field.paint(getGraphics());
				wizardTower.setText("Wizard Towers (" + camp.wizardTowers.size() + ")");
			}

			if(defType == 5 && camp.walls.size() != 0) { //to position wall from queue
				defToPlace = camp.walls.remove(0);
				if(camp.walls.size() == 0) {
					defType = 0; //if queue is empty, deselect
					toPlaceDef = false;
				}
				defToPlace.position(e.getX(), e.getY());
				camp.wallsP.add((Wall) defToPlace); //remove from queue, add to "positioned" list
				field.paint(getGraphics());
				wall.setText("Walls (" + camp.walls.size() + ")");
			}
			
			disableButtons(); //check for empty queues
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
}
