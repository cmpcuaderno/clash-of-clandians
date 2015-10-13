package Players;


public class MainGame {
	
	public static void main(String[] args){
		MainFrame game = new MainFrame();
		
		while(!game.startGame) {} // waiting for other players
		game.Home = game.createCamp(game.campNo);
		game.dummyData();
		game.goToHomeCamp();
	}
}
