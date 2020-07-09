package gameObjects.weapons;

import gameObjects.GameObject;
import tp.p1.Game;

public class UCMMissile extends Weapon {

	public static final int DAMAGE = 1;

	public UCMMissile(Game game, int row, int col) {
		super(game, row, col, DAMAGE);

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

}
