package Players;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;

import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/*
 *  Buttons:
 *  	- Start (will lead to Choose Camp page)
 *  		* require number of players
 *  	- How to Play (will lead to How to Play page)
 *  	- Exit (will close the window)
 *  Field:
 *  	- Number of players
 */

public class Background extends JPanel{
	
	
	JPanel bgPanel = new JPanel();
	JPanel buttonsPanel = new JPanel();
	JPanel mainPanel = new JPanel();
	private int players = 2;
	private Image img;

	public Background(String img) {
    this(new ImageIcon(img).getImage());
  }
	
	public Background(Image img) {
		this.img = img;
    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
    setPreferredSize(size);
    setMinimumSize(size);
    setMaximumSize(size);
    setSize(size);
    setLayout(null);
	}

	public void paintComponent(Graphics g) {
    g.drawImage(img, 0, 0, null);
  }

	
	
	
	
}
