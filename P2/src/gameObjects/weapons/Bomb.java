package gameObjects.weapons;

import exceptions.FileContentsException;
import gameObjects.GameObject;
import tp.p1.FileContentsVerifier;
import tp.p1.Game;

public class Bomb extends Weapon {

	public static final int DAMAGE = 1;
	public static final String DRAW = " .  ";
	private int owner;

	public Bomb(Game game, int row, int col, int owner) {
		super(game, row, col, DAMAGE);
		this.owner = owner;
	}

	@Override
	public String toString() {
		return DRAW;
	}

	public void move() {
		if (isAlive() && row <= Game.ROW) {
			row++;
			if(row == Game.ROW) onDelete();
		}
	}
	
	public void setAlive() {
		this.live = 1;
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
		return "B;" + row + "," + col + ";" + owner + "\n";
	}

	@Override
	protected GameObject parse(String stringFromFile, Game game, FileContentsVerifier verifier) throws FileContentsException {
		Bomb bomb = null;
		if(verifier.verifyBombString(stringFromFile, game)) {
			bomb = new Bomb(game, row, col, owner);
			Weapon.game = game;
			bomb.row = getRowFromString(stringFromFile);
			bomb.col = getColFromString(stringFromFile);
			bomb.owner = Integer.parseInt(stringFromFile.split(";")[2]);
		}
		return bomb;
	}

	@Override
	public int getNumber() {
		return owner;
	}

}
