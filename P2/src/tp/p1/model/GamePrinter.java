package tp.p1.model;

import gameObjects.ships.DestroyerAlien;
import gameObjects.ships.Ovni;
import gameObjects.ships.RegularAlien;
import gameObjects.ships.UCMShip;
import gameObjects.weapons.Bomb;
import gameObjects.weapons.UCMMissile;
import tp.p1.Game;

public abstract class GamePrinter {

	public static String drawList(Game game) {
		String value = "[R]egular ship: Points: " + RegularAlien.POINTS + " - Harm: " + RegularAlien.HARM
				+ " - Shield: " + RegularAlien.SHIELD + "\n";
		value += "[E]xplosive alien: Points: " + RegularAlien.POINTS + " - Harm: " + RegularAlien.HARM + " - Shield: "
				+ RegularAlien.SHIELD + "\n";
		value += "[D]estroyer ship: Points: " + DestroyerAlien.POINTS + " - Harm: " + Bomb.DAMAGE + " - Shield: "
				+ DestroyerAlien.SHIELD + "\n";
		value += "[O]vni: Points: " + Ovni.POINTS + " - Harm: " + Ovni.HARM + " - Shield: " + Ovni.SHIELD + "\n";
		value += game.getUCMShip().toString() + ": Harm: " + UCMMissile.DAMAGE + " - Shield: " + UCMShip.SHIELD + "\n";
		return value;
	}

}
