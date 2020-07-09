package gameObjects.ships;

import tp.p1.Game;

public abstract class AlienShip extends EnemyShip{
	
	public AlienShip(Game game, int row, int col, int live, int points) {
		super(game, row, col, live, points);
		// TODO Auto-generated constructor stub
	}

	public static boolean haveLanded() {
		return row == Game.ROW;
	}

	public static boolean allDead() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public static int numberAliens() {
		return 0;
	}

}
