package Players;

public class mainGame {
	
	public static void main(String[] args){
		mainFrame game = new mainFrame();
		
		while(!game.startGame) {} // waiting for other players
		game.goToHomeCamp();
	}

	
}
