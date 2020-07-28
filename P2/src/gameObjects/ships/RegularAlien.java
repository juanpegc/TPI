package gameObjects.ships;

import exceptions.FileContentsException;
import gameObjects.GameObject;
import gameObjects.IExecuteRandomActions;
import tp.p1.FileContentsVerifier;
import tp.p1.Game;
import tp.p1.Move;

public class RegularAlien extends AlienShip implements IExecuteRandomActions{

	public static final int SHIELD = 2;
	public static final int POINTS = 5;
	public static final int HARM = 0;

	public RegularAlien(Game game, int row, int col) {
		super(game, row, col, SHIELD, POINTS);
		this.live = SHIELD;
		AlienShip.ALIEN_SHIPS_ALIVE++;
	}

	@Override
	public String toString() {
		return "C[" + live + "]";
	}

	@Override
	public void computerAction() {
		if(isAlive() && IExecuteRandomActions.canGenerateExplosiveAlien(game)) {
			ExplosiveAlien explosiveAlien = new ExplosiveAlien(game, row, col, move, live, POINTS, cycles);
			game.replaceObject(this, explosiveAlien);
		}
	}

	@Override
	public void move() {
		super.move();
	}

	@Override
	public void onDelete() {
		super.onDelete();
	}

	@Override
	public String toPlainText() {
		return "R;" + row + "," + col + ";" + live + ";" + cycles + ";" + move.name() + "\n";
	}

	@Override
	protected GameObject parse(String stringFromFile, Game game, FileContentsVerifier verifier) throws FileContentsException {
		RegularAlien regular = null;
		if(verifier.verifyAlienShipString(stringFromFile, game, SHIELD) && stringFromFile.split(";")[0].equals("R")) {
			regular = new RegularAlien(game, row, col);
			regular.game = game;
			regular.row = getRowFromString(stringFromFile);
			regular.col = getColFromString(stringFromFile);
			regular.live = Integer.parseInt(stringFromFile.split(";")[2]);
			regular.cycles = Integer.parseInt(stringFromFile.split(";")[3]);
			regular.move = Move.parse(stringFromFile.split(";")[4]);
			ALIEN_SHIPS_LOAD++;
		}
		return regular;
	}

}
