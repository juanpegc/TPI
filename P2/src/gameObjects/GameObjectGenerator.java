/*package gameObjects;

import gameObjects.ships.DestroyerAlien;
import gameObjects.ships.Ovni;
import gameObjects.ships.RegularAlien;
import gameObjects.ships.UCMShip;
import gameObjects.weapons.Bomb;
import gameObjects.weapons.Shockwave;
import gameObjects.weapons.UCMMissile;
import tp.p1.Game;

public class GameObjectGenerator {

	private static GameObject[] availableGameObjects = {
			new UCMShip(),
			new Ovni(),
			new RegularAlien(),
			new DestroyerAlien(),
			//new ExplosiveAlien(),
			new Shockwave(),
			new Bomb(),
			new UCMMissile()
			//new Supermissile()
			};

	public static GameObject parse(String stringFromFile, Game game, FileContentsVerifier verifier)
			throws FileContentsException {
		GameObject gameObject = null;
		for (GameObject go : availableGameObjects) {
			gameObject = go.parse(stringFromFile, game, verifier);
			if (gameObject != null)
				break;
		}
		return gameObject;
	}

}*/
