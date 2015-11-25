package Players;
import java.awt.Dimension;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ChooseCampPage extends JPanel{
	JButton camp1, camp2, camp3, back;
	Icon howIcon = new ImageIcon("Assets/HowToPlay.png");
	Icon backIcon = new ImageIcon("Assets/back.png");
	Icon camp1_icon = new ImageIcon("Assets/camp_1.jpg");
	Icon camp2_icon = new ImageIcon("Assets/camp_2.jpg");
	Icon camp3_icon = new ImageIcon("Assets/camp_3.jpg");
	public ChooseCampPage(){

		camp1 = new JButton();
		camp2 = new JButton();
		camp3 = new JButton();
		back = new JButton();
		setPreferredSize(new Dimension(600, 480));

		camp1.setIcon(camp1_icon);
		camp2.setIcon(camp2_icon);
		camp3.setIcon(camp3_icon);
		back.setIcon(backIcon);
		
		camp1.setMaximumSize(camp1.getSize());		//remove button borders
		camp1.setContentAreaFilled(false);
		camp1.setBorderPainted(false);

		camp2.setMaximumSize(camp2.getSize());		//remove button borders
		camp2.setContentAreaFilled(false);
		camp2.setBorderPainted(false);

		camp3.setMaximumSize(camp3.getSize());		//remove button borders
		camp3.setContentAreaFilled(false);
		camp3.setBorderPainted(false);

		back.setPreferredSize(new Dimension(131, 100));		//remove button borders
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);

		add(camp1);
		add(camp2);
		add(camp3);
		add(back);
		
	}
}
