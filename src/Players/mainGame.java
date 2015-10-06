package Players;

import javax.swing.UIManager;

public class MainGame {
	
	public static void main(String[] args){
		try {
            // Set cross-platform Java L&F (also called "Metal")
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        }
        catch (Exception e) {}		
		MainFrame game = new MainFrame();
		while(!game.startGame) {System.out.print(":)");} // waiting for other players
		game.Home = game.createCamp(game.campNo);
		game.dummyData();
		game.goToHomeCamp();
	}
}
