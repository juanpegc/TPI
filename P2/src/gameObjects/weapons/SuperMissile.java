package gameObjects.weapons;

import gameObjects.GameObject;
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

}
