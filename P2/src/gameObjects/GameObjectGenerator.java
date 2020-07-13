package gameObjects;

import exceptions.FileContentsException;
import gameObjects.ships.DestroyerAlien;
import gameObjects.ships.ExplosiveAlien;
import gameObjects.ships.Ovni;
import gameObjects.ships.RegularAlien;
import gameObjects.ships.UCMShip;
import gameObjects.weapons.Bomb;
import gameObjects.weapons.Shockwave;
import gameObjects.weapons.SuperMissile;
import gameObjects.weapons.UCMMissile;
import tp.p1.FileContentsVerifier;
import tp.p1.Game;

public class GameObjectGenerator {

	private static GameObject[] availableGameObjects = {
			new UCMShip(null, 0, 0),
			new Ovni(null, 0, 0),
			new RegularAlien(null, 0, 0),
			new DestroyerAlien(null, 0, 0),
			new ExplosiveAlien(null, 0, 0, null, 0, 0, 0),
			new Shockwave(null, 0, 0),
			new Bomb(null, 0, 0, 0),
			new UCMMissile(null, 0, 0),
			new SuperMissile(null, 0, 0)
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

}
