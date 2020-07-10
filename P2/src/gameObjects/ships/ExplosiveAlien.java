package gameObjects.ships;

import tp.p1.Game;

public class ExplosiveAlien extends AlienShip{

	public static final int POINTS = 5;
	public static final int SHIELD = 1;
	
	public ExplosiveAlien(Game game, int row, int col) {
		super(game, row, col, SHIELD, POINTS);
		// TODO Auto-generated constructor stub
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
		AlienShip.ALIEN_SHIPS_ALIVE--;
	}

}
