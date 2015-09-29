package Players;

public class mainGame {
	
	public static void main(String[] args){
		boolean startGame = false; // toggles true once all players are ready
		mainFrame game = new mainFrame();
		
		if(startGame) {
			game.remove(game.Map);
		}
	}
}
