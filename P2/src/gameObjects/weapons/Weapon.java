package gameObjects.weapons;

import gameObjects.GameObject;
import tp.p1.Game;

public abstract class Weapon extends GameObject{

	protected static Game game;
	protected int damage;
	
	public Weapon(Game game, int row, int col, int damage) {
		super(game, row, col, damage);
		// TODO Auto-generated constructor stub
	}
	
	public int getDamage() {
		return damage;
	}
	
	@Override
	public void onDelete() {
		live = 0;
	}

}
