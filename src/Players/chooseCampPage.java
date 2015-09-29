package Players;

import javax.swing.JButton;
import javax.swing.JPanel;

public class chooseCampPage extends JPanel{
	JButton camp1, camp2, camp3, back;
	
	public chooseCampPage(){
		camp1 = new JButton("CAMP 1");
		camp2 = new JButton("CAMP 2");
		camp3 = new JButton("CAMP 3");
		back = new JButton("BACK");
		
		add(camp1);
		add(camp2);
		add(camp3);
		add(back);
		
	}
}
