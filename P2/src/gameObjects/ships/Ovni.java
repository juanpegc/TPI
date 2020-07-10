package gameObjects.ships;

import gameObjects.GameObject;
import gameObjects.IExecuteRandomActions;
import tp.p1.Game;
import tp.p1.Move;

public class Ovni extends EnemyShip implements IExecuteRandomActions {

	public static final int SHIELD = 1;
	public static final int POINTS = 25;
	public static final int HARM = 0;

	public Ovni(Game game, int row, int col) {
		super(game, row, col, SHIELD, POINTS);
		move = Move.LEFT;
	}

	private void reset() {
		col = Game.COLUMN;
		live = SHIELD;
	}

	@Override
	public String toString() {
		return "O[" + live + "]";
	}

	@Override
	public void move() {
		if (isAlive()) {
			super.move(move);
			if (col == -1)
				live = 0;
			GameObject go = game.isSomethingHere(row, col);
			if(go != null && go != this)go.performAttack(this);
		}
	}

	@Override
	public boolean receiveMissileAttack(int damage) {
		getDamage(damage);
		return true;
	}

	@Override
	public boolean receiveShockWaveAttack(int damage) {
		getDamage(damage);
		return true;
	}

	@Override
	public void computerAction() {
		if (!isAlive() && IExecuteRandomActions.canGenerateRandomOvni(game)) {
			reset();
		}
	}

	@Override
	public void onDelete() {
		super.onDelete();
		col = -1;
		game.enableShockWave();
	}

	public void deactivate() {
		live = 0;
	}

}
