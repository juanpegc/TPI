package tp.p1.model;

import tp.p1.Game;

public class Stringifier extends GamePrinter{
	
	private String getBoard(Game game) {
		String value = "";
		
		value += "— Space Invaders v2.0 —\n";
		value += "\n";
		value += "G;" + game.getCycles() + "\n";
		value += "L;" + game.getLevel().name() + "\n";
		
		value += game.getGameObjectBoard().toPlainText();
		
		return value;
	}
	
	public String toString(Game game) {
		return getBoard(game);
	}
	
}
