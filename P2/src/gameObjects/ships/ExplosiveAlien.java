package gameObjects.ships;

import tp.p1.Game;
import tp.p1.Move;

public class ExplosiveAlien extends AlienShip{

	
	public ExplosiveAlien(Game game, int row, int col, Move direction, int live, int points, int cyclesToMove) {
		super(game, row, col, live, points);
		cycles = cyclesToMove;
		move = direction;
	}
	
	@Override
	public void move() {
		super.move();
	}

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "E[" + live + "]";
	}
	
	@Override
	public void onDelete() {
		super.onDelete();
	}

	@Override
	public String toPlainText() {
		return "D;" + row + "," + col + ";" + live + ";" + cycles + ";" + move.name() + "\n";
	}

}
