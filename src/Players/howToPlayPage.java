package Players;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class HowToPlayPage extends JPanel{
	JLabel title;
	JTextArea content;
	JButton back;
	
	public HowToPlayPage(){
		title = new JLabel("How To Play");
		content = new JTextArea();
		content.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc ultricies id ante eu egestas. Integer egestas vel turpis non lobortis. Aliquam maximus risus vel urna ornare, non suscipit ipsum fermentum. Donec faucibus elit velit, ut rutrum sapien pulvinar ac. Donec egestas lorem et ultricies tincidunt. Vestibulum finibus dui lectus, auctor bibendum magna rutrum ac. Aenean eget justo magna. Vestibulum convallis ex tellus, sit amet scelerisque eros blandit in. Donec lobortis molestie risus. Curabitur imperdiet elementum tempus. Proin vitae odio ut justo lacinia tempor quis ut enim. Vestibulum non neque pellentesque dui fermentum pretium in vitae diam. Vestibulum imperdiet sit amet eros at rhoncus. Nunc vel mi purus. Proin augue ex, aliquam eu viverra nec, porta sit amet velit. Nunc justo quam, volutpat quis mattis eu, convallis eu mi. Mauris ullamcorper dolor sit amet sagittis pellentesque. Pellentesque vulputate, nibh at varius ullamcorper, enim ligula faucibus libero, vitae commodo nibh quam nec odio. Vestibulum sollicitudin quam non ipsum tincidunt euismod. Sed volutpat, odio efficitur viverra eleifend, sapien metus viverra neque, a consequat lectus sapien vitae mauris. Mauris vulputate consectetur mollis. Etiam non volutpat quam. Fusce pretium volutpat diam convallis fermentum. Sed nec ultrices metus, vel pulvinar est. Sed vel maximus tellus, et tempor enim.");
		content.setEditable(false);
		content.setLineWrap(true);
		back = new JButton("BACK");
		
		setLayout(new BorderLayout());
		add(title, BorderLayout.NORTH);
		add(content, BorderLayout.CENTER);
		add(back, BorderLayout.SOUTH);
	}
}
