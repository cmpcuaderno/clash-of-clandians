package Players;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class HowToPlayPage extends JPanel{
	JLabel title;
	JTextArea content;
	JButton back;
	JPanel backPanel;
	JPanel contentPanel;
	Icon backIcon;
	public HowToPlayPage(){
		backIcon = new ImageIcon("Assets/back.png");
		back = new JButton();
		contentPanel = new JPanel();
		backPanel = new JPanel();
		title = new JLabel("How To Play");
		content = new JTextArea();
		
		content.setText("1. Player chooses a predefined camp of his liking." + "\n" + "\n" + "2. Player prepares his troops for attack and sets up his camp for defense based on the attributes of each camp." + "\n" + "\n"+ "3. Player attacks another player's camp in attempt to destroy the other player's town hall. If attack is successful, the player is rewarded trophies and will continue the game, while the opposing player is removed from the game. Otherwise, the opposing player is rewarded trophies for the successful defense." + "\n"+ "\n" + "4. While the player is still qualified to play, Repeat 3." + "\n" + "\n"+ "5. Player wins if he has successfully attacked all players or if he has the most  number of trophies once the time expires.");
		content.setFont(new Font("Monospaced",Font.PLAIN,16));
		content.setEditable(false);
		content.setLineWrap(true);
		content.setPreferredSize(new Dimension(620, 440));
		contentPanel.add(content);
		
		
		back = new JButton();
		back.setIcon(backIcon);
		back.setPreferredSize(new Dimension(625, 94));
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		backPanel.add(back);
		
		setLayout(new BorderLayout());
		add(title, BorderLayout.NORTH);
		add(contentPanel, BorderLayout.CENTER);
		add(backPanel, BorderLayout.SOUTH);
		setOpaque(false);
	}

	public void paintComponent(Graphics g) {
        g.setColor(getBackground());
        Rectangle r = g.getClipBounds();
        g.fillRect(r.x, r.y, r.width, r.height);
        super.paintComponent(g);
    }

}

