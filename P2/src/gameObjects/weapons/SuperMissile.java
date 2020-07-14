package gameObjects.weapons;

import exceptions.FileContentsException;
import gameObjects.GameObject;
import tp.p1.FileContentsVerifier;
import tp.p1.Game;

public class SuperMissile extends Weapon{

	public static final int DAMAGE = 2;
	
	public SuperMissile(Game game, int row, int col) {
		super(game, row, col, DAMAGE);
	}

	@Override
	public void computerAction() {		
	}

	@Override
	public void move() {
		if (row >= 0) {
			row--;
			if (row < 0) {
				onDelete();
				game.setSupermissile();
			}
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
		if(verifier.verifyWeaponString(stringFromFile, game) && stringFromFile.split(";")[0].equals("X")) {
			supermissile = new SuperMissile(game, row, col);
			Weapon.game = game;
			supermissile.row = getRowFromString(stringFromFile);
			supermissile.col = getColFromString(stringFromFile);
			game.setSupermissileOnAir();
		}
		return supermissile;
	}


	@Override
	public int getNumber() {
		return -1;
	}

}
