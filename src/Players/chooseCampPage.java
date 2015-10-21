package Players;
import java.awt.Dimension;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ChooseCampPage extends JPanel{
	JButton camp1, camp2, camp3, back;
	Icon howIcon = new ImageIcon("../Assets/HowToPlay.png");
	public ChooseCampPage(){

		camp1 = new JButton("CAMP 1");
		camp2 = new JButton("CAMP 2");
		camp3 = new JButton("CAMP 3");
		back = new JButton("BACK");
		setPreferredSize(new Dimension(640, 480));

		camp1.setIcon(howIcon);

		

		add(camp1);
		add(camp2);
		add(camp3);
		add(back);
		
	}
}
