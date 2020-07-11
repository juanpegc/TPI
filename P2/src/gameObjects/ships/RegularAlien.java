package gameObjects.ships;

import gameObjects.IExecuteRandomActions;
import tp.p1.Game;
import tp.p1.Move;

public class RegularAlien extends AlienShip implements IExecuteRandomActions{

	public static final int SHIELD = 2;
	public static final int POINTS = 5;
	public static final int HARM = 0;

	public RegularAlien(Game game, int row, int col) {
		super(game, row, col, SHIELD, POINTS);
		this.live = SHIELD;
		move = Move.LEFT;
		AlienShip.ALIEN_SHIPS_ALIVE++;
	}

	@Override
	public String toString() {
		return "C[" + live + "]";
	}

	@Override
	public void computerAction() {
		if(isAlive() && IExecuteRandomActions.canGenerateExplosiveAlien(game)) {
			game.addObject(new ExplosiveAlien(game, row, col, move, live, POINTS, cycles));
			game.removeObject(this);
		}
	}

	@Override
	public void move() {
		super.move();
	}

	@Override
	public void onDelete() {
		super.onDelete();
	}

	@Override
	public String toPlainText() {
		return "R;" + row + "," + col + ";" + live + ";" + cycles + ";" + move.name() + "\n";
	}

}
