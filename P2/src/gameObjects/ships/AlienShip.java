package gameObjects.ships;

import tp.p1.Game;
import tp.p1.Move;

public abstract class AlienShip extends EnemyShip {

	public static int SAME_MOVE = 0;
	public static int READY_TO_MOVE;
	public static boolean HAVE_LANDED;
	public static int ALIEN_SHIPS_ALIVE;
	protected Move move;
	protected int cycles;

	public AlienShip(Game game, int row, int col, int live, int points) {
		super(game, row, col, live, points);
		HAVE_LANDED = false;
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
			if (READY_TO_MOVE == 0 && SAME_MOVE > 0) {
				super.move(Move.DOWN);
				SAME_MOVE--;
				if (move == Move.LEFT)
					move = Move.RIGHT;
				else if (move == Move.RIGHT)
					move = Move.LEFT;
				HAVE_LANDED = HAVE_LANDED || row == Game.ROW - 1;
			} else {
				super.move(move);

				if (READY_TO_MOVE > 0)
					READY_TO_MOVE--;
				else if (col == 0) {
					SAME_MOVE = ALIEN_SHIPS_ALIVE;
					READY_TO_MOVE = ALIEN_SHIPS_ALIVE - 1;
				} else if (col == Game.COLUMN - 1) {
					SAME_MOVE = ALIEN_SHIPS_ALIVE;
					READY_TO_MOVE = ALIEN_SHIPS_ALIVE - 4;
				}
			}
		}
	}
	
	@Override
	public void onDelete() {
		super.onDelete();
		AlienShip.ALIEN_SHIPS_ALIVE--;
	}

}
