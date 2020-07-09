package gameObjects.ships;

import tp.p1.Game;

public abstract class EnemyShip extends Ship{

	int points;
	
	public EnemyShip(Game game, int row, int col, int live, int points) {
		super(game, row, col, live);
		this.points = points;
	}
	
	@Override
	public void onDelete() {
		super.onDelete();
		game.receivePoints(points);
	}

	@Override
	public boolean receiveMissileAttack(int damage) {
		if(isAlive()) {
			getDamage(damage);
			return true;
		}
		return false;
	}

	@Override
	public boolean receiveShockWaveAttack(int damage) {
		if(isAlive()) {
			getDamage(damage);
			return true;
		}
		return false;
	}
	
	
}
