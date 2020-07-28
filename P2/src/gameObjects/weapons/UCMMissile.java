package gameObjects.weapons;

import exceptions.FileContentsException;
import gameObjects.GameObject;
import tp.p1.FileContentsVerifier;
import tp.p1.Game;

public class UCMMissile extends Weapon {

	public static final int DAMAGE = 1;
	private Game game;

	public UCMMissile(Game game, int row, int col) {
		super(game, row, col, DAMAGE);
		this.game = game;
	}

	public void checkDamage() {
		GameObject go = game.isSomethingHere(row, col);
		if (isAlive() && go != null && !go.equals(this) && !go.toString().equals(game.getUCMShip().toString())) {
			performAttack(go);
		}
	}

	@Override
	public void move() {
		checkDamage();
		if (isAlive() && row >= 0) {
			row--;
			if (row < 0)
				onDelete();
		}
		checkDamage();
	}

	@Override
	public String toString() {
		return " oo ";
	}

	@Override
	public boolean performAttack(GameObject other) {
		other.receiveMissileAttack(DAMAGE);
		onDelete();
		return true;
	}

	@Override
	public boolean receiveBombAttack(int damage) {
		getDamage(damage);
		return true;
	}

	@Override
	public void computerAction() {
	}

	@Override
	public String toPlainText() {
		return "M;" + row + "," + col + "\n";
	}

	@Override
	protected GameObject parse(String stringFromFile, Game game, FileContentsVerifier verifier)
			throws FileContentsException {
		UCMMissile missile = null;
		if (verifier.verifyWeaponString(stringFromFile, game) && stringFromFile.split(";")[0].equals("M")) {
			missile = new UCMMissile(game, row, col);
			Weapon.game = game;
			missile.row = getRowFromString(stringFromFile);
			missile.col = getColFromString(stringFromFile);
			game.setUCMShipMissile(missile);
		}
		return missile;
	}

	@Override
	public int getNumber() {
		return -1;
	}

}
