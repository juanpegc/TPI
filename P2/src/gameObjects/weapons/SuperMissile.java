package gameObjects.weapons;

import exceptions.FileContentsException;
import gameObjects.GameObject;
import tp.p1.FileContentsVerifier;
import tp.p1.Game;

public class SuperMissile extends Weapon{

	public static final int DAMAGE = 2;
	
	public SuperMissile(Game game, int row, int col) {
		super(game, row, col, DAMAGE);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void computerAction() {		
	}

	@Override
	public void move() {
		if (row >= 0) {
			row--;
			if (row < 0)
				onDelete();
		}
	}

	@Override
	public String toString() {
		return " 88 ";
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
	public String toPlainText() {
		return "X;" + row + "," + col + "\n";
	}

	@Override
	protected GameObject parse(String stringFromFile, Game game, FileContentsVerifier verifier) throws FileContentsException {
		SuperMissile supermissile = null;
		if(verifier.verifyWeaponString(stringFromFile, game)) {
			supermissile = new SuperMissile(game, row, col);
			Weapon.game = game;
			supermissile.row = getRowFromString(stringFromFile);
			supermissile.col = getColFromString(stringFromFile);
		} else throw new FileContentsException(": SuperMissile incorrect format");
		return supermissile;
	}

}
