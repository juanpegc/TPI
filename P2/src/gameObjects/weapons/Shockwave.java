package gameObjects.weapons;

import gameObjects.GameObject;
import tp.p1.Game;

public class Shockwave extends Weapon {

	public static final int DAMAGE = 1;
	
	public Shockwave(Game game, int row, int col, int damage) {
		super(game, row, col, DAMAGE);
	}

	@Override
	public String toString() {
		return null;
	}

	@Override
	public void move() {}

	@Override
	public boolean performAttack(GameObject other) {
		other.receiveShockWaveAttack(DAMAGE);
		onDelete();
		return true;
	}

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}
	
}
