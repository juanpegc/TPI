package gameObjects.ships;

import gameObjects.GameObject;
import tp.p1.Game;

public abstract class Ship extends GameObject{

	
	public Ship(Game game, int row, int col, int live) {
		super(game, row, col, live);

	}
	
	@Override
	public void onDelete() {
		live = 0;
	}

	@Override
	public int getNumber() {
		return -1;
	}

	
}
