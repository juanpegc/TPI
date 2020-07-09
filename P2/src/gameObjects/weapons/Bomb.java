package gameObjects.weapons;

import gameObjects.GameObject;
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

}
