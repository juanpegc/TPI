package gameObjects.ships;

import exceptions.FileContentsException;
import gameObjects.GameObject;
import tp.p1.FileContentsVerifier;
import tp.p1.Game;
import tp.p1.Move;

public class ExplosiveAlien extends AlienShip {

	private int damage = 1;

	public ExplosiveAlien(Game game, int row, int col, Move direction, int live, int points, int cyclesToMove) {
		super(game, row, col, live, points);
		cycles = cyclesToMove;
		move = direction;
	}

	@Override
	public void move() {
		super.move();
	}

	@Override
	public void computerAction() {
	}

	@Override
	public String toString() {
		return "E[" + live + "]";
	}

	@Override
	public void onDelete() {
		super.onDelete();
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				GameObject go = game.isSomethingHere(row + i, col + j);
				if (go != null)
					performAttack(go);
			}
		}
	}

	@Override
	public boolean performAttack(GameObject other) {
		if (!isAlive())
			other.receiveExplosionAttack(damage);
		return true;
	}

	@Override
	public String toPlainText() {
		return "E;" + row + "," + col + ";" + live + ";" + cycles + ";" + move.name() + "\n";
	}

	@Override
	protected GameObject parse(String stringFromFile, Game game, FileContentsVerifier verifier)
			throws FileContentsException {
		ExplosiveAlien explosive = null;
		if (verifier.verifyAlienShipString(stringFromFile, game, RegularAlien.SHIELD)
				&& stringFromFile.split(";")[0].equals("E")) {
			explosive = new ExplosiveAlien(game, row, col, move, live, points, cycles);
			explosive.game = game;
			explosive.row = getRowFromString(stringFromFile);
			explosive.col = getColFromString(stringFromFile);
			explosive.live = Integer.parseInt(stringFromFile.split(";")[2]);
			explosive.cycles = Integer.parseInt(stringFromFile.split(";")[3]);
			explosive.move = Move.parse(stringFromFile.split(";")[4]);
		}
		return explosive;
	}

}
