package gameObjects.weapons;

import gameObjects.GameObject;
import tp.p1.FileContentsVerifier;
import tp.p1.Game;

public class Shockwave extends Weapon {

	public static final int DAMAGE = 1;
	private boolean active;

	public Shockwave(Game game, int row, int col) {
		super(game, row, col, DAMAGE);
		active = true;
	}

	@Override
	public String toString() {
		return null;
	}

	@Override
	public void move() {
	}

	@Override
	public boolean performAttack(GameObject other) {
		other.receiveShockWaveAttack(DAMAGE);
		return true;
	}

	@Override
	public void computerAction() {
	}

	public void deactivate() {
		active = false;
	}

	public boolean getActive() {
		return active;
	}

	@Override
	public String toPlainText() {
		return "";
	}

	@Override
	protected GameObject parse(String stringFromFile, Game game, FileContentsVerifier verifier) {
		// TODO Auto-generated method stub
		return null;
	}

}
