package gameObjects.ships;

import tp.p1.Game;
import tp.p1.Move;

public abstract class AlienShip extends EnemyShip {

	public static int SAME_MOVE = 0;
	public static boolean HAVE_LANDED;
	public static int ALIEN_SHIPS_ALIVE;
	public static Move moveTmp = Move.LEFT;
	protected Move move;
	protected int cycles;

	public AlienShip(Game game, int row, int col, int live, int points) {
		super(game, row, col, live, points);
		HAVE_LANDED = false;
		move = Move.LEFT;
		if (game != null)
			cycles = game.getLevel().getNumCyclesToMoveOneCell();
	}

	public static boolean allDead() {
		return ALIEN_SHIPS_ALIVE == 0;
	}

	public static int numberAliens() {
		return ALIEN_SHIPS_ALIVE;
	}

	@Override
	public void move() {
		cycles--;
		if (cycles == 0) {
			cycles = game.getLevel().getNumCyclesToMoveOneCell();
			if (move == Move.DOWN && SAME_MOVE > 0) {
				super.move(move);
				SAME_MOVE--;
				if (col == 0) {
					move = Move.RIGHT;
					moveTmp = move;
				} else if (col == Game.COLUMN - 1) {
					move = Move.LEFT;
					moveTmp = move;
				} else
					move = moveTmp;
				HAVE_LANDED = HAVE_LANDED || row == Game.ROW - 1;
			} else {
				super.move(move);
				if (SAME_MOVE > 0) {
					move = Move.DOWN;
					moveTmp = move;
				}
				else if ((move == Move.LEFT && col == 0) || (move == Move.RIGHT && col == Game.COLUMN - 1)) {
					SAME_MOVE = ALIEN_SHIPS_ALIVE;
					move = Move.DOWN;
					moveTmp = move;
				}
			}
		}
		if(move != moveTmp) move = moveTmp;
	}

	@Override
	public void onDelete() {
		super.onDelete();
	}

}
