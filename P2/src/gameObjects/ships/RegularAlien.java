package gameObjects.ships;

import tp.p1.Game;

public class RegularAlien extends AlienShip{

	public static final int SHIELD = 2;
	public static final int POINTS = 5;
	public static final int HARM = 0;
	
	
	public RegularAlien(Game game, int row, int col) {
		super(game, row, col, SHIELD, POINTS);
		this.live = SHIELD;
	}

	@Override
	public String toString() {
		return "C[" + live + "]";
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
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
