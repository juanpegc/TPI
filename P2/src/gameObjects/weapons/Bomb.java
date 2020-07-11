package gameObjects.weapons;

import exceptions.FileContentsException;
import gameObjects.GameObject;
import gameObjects.ships.Ovni;
import tp.p1.FileContentsVerifier;
import tp.p1.Game;

public class Bomb extends Weapon {

	public static final int DAMAGE = 1;

	public Bomb(Game game, int row, int col) {
		super(game, row, col, DAMAGE);
	}

	@Override
	public String toString() {
		return " .  ";
	}

	public void move() {
		if (isAlive() && row <= Game.ROW) {
			row++;
			if(row == Game.ROW) onDelete();
		}
	}

	@Override
	public boolean performAttack(GameObject other) {
		other.receiveBombAttack(DAMAGE);
		onDelete();
		return true;
	}

	@Override
	public boolean receiveMissileAttack(int damage) {
		onDelete();
		return true;
	}

	@Override
	public void computerAction() {
	}

	@Override
	public String toPlainText() {
		return "B;" + row + "," + col + "\n";
	}

	@Override
	protected GameObject parse(String stringFromFile, Game game, FileContentsVerifier verifier) throws FileContentsException {
		Bomb bomb = null;
		if(verifier.verifyWeaponString(stringFromFile, game)) {
			bomb = new Bomb(game, row, col);
			Weapon.game = game;
			bomb.row = getRowFromString(stringFromFile);
			bomb.col = getColFromString(stringFromFile);
		} else throw new FileContentsException(": Bomb incorrect format");
		return bomb;
	}

}
