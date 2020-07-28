package gameObjects.ships;

import tp.p1.Game;
import tp.p1.Move;

public abstract class EnemyShip extends Ship {

	int points;

	public EnemyShip(Game game, int row, int col, int live, int points) {
		super(game, row, col, live);
		this.points = points;
	}

	public void move(Move move) {
		if (move == Move.LEFT)
			col--;
		else if (move == Move.RIGHT)
			col++;
		else if (move == Move.DOWN)
			row++;
		if (game.isSomethingHere(row, col) != null)
			if (game.positionToString(row, col).equals(" oo "))
				receiveMissileAttack(1);
			else if (game.positionToString(row, col).equals(" 88 "))
				receiveMissileAttack(2);

	}

	@Override
	public void onDelete() {
		super.onDelete();
		game.receivePoints(points);
	}

	@Override
	public boolean receiveMissileAttack(int damage) {
		if (isAlive()) {
			getDamage(damage);
			return true;
		}
		return false;
	}

	@Override
	public boolean receiveShockWaveAttack(int damage) {
		if (isAlive()) {
			getDamage(damage);
			return true;
		}
		return false;
	}

	@Override
	public boolean receiveExplosionAttack(int damage) {
		if (isAlive()) {
			getDamage(damage);
		}
		return true;
	}

}
