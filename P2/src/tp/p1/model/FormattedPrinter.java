package tp.p1.model;

import gameObjects.ships.AlienShip;
import gameObjects.ships.DestroyerAlien;
import gameObjects.ships.Ovni;
import gameObjects.ships.RegularAlien;
import gameObjects.ships.UCMShip;
import gameObjects.weapons.Bomb;
import gameObjects.weapons.UCMMissile;
import tp.p1.Game;

public class FormattedPrinter extends GamePrinter {

	private int numRows = Game.ROW;
	private int numCols = Game.COLUMN;

	private String getInfo(Game game) {
		String value = "Life: " + game.getUCMShip().getLive() + "\n";
		value += "Number of cycles: " + game.getCycles() + "\n";
		value += "Points: " + game.getPoints() + "\n";
		value += "Remaining aliens: " + AlienShip.numberAliens() + "\n";
		value += "Superpower: " + (game.getUCMShip().hasSuperPower() ? "Yes" : "No") + "\n";
		return value;
	}

	private String getBoard(Game game) {
		int cellSize = 7;
		String vDelimiter = "|";
		String hDelimiter = "-";
		String value = "";
		String rowDelimiter = "";
		String space = " ";
		int i;

		for (i = numCols * cellSize; i >= 0; i--)
			rowDelimiter += hDelimiter;

		for (i = 0; i < numRows; i++) {
			value += rowDelimiter + "\n";
			for (int e = 0; e < numCols; e++) {
				value += vDelimiter;
				value += space + game.positionToString(i, e) + space;
			}
			value += vDelimiter + "\n";
		}
		value += rowDelimiter + "\n";

		return value;
	}

	public String drawList(Game game) {
		String value = "[R]egular ship: Points: " + RegularAlien.POINTS + " - Harm: " + RegularAlien.HARM
				+ " - Shield: " + RegularAlien.SHIELD + "\n";
		value += "[D]estroyer ship: Points: " + DestroyerAlien.POINTS + " - Harm: " + Bomb.DAMAGE + " - Shield: "
				+ DestroyerAlien.SHIELD + "\n";
		value += "[O]vni: Points: " + Ovni.POINTS + " - Harm: " + Ovni.HARM + " - Shield: " + Ovni.SHIELD + "\n";
		value += game.getUCMShip().toString() + ": Harm: " + UCMMissile.DAMAGE + " - Shield: " + UCMShip.SHIELD + "\n";
		return value;
	}

	public String toString(Game game) {
		if (!game.isFinished())
			return getInfo(game) + getBoard(game);
		else
			return game.getWinnerMessage();
	}

}
