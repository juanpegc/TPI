package gameObjects;

import tp.p1.Game;
import tp.p1.Move;

public abstract class GameObject implements IAttack {

	protected int row;
	protected int col;
	protected int live;
	protected Game game;
	protected Move move;

	public GameObject(Game game, int row, int col, int live) {
		this.row = row;
		this.col = col;
		this.game = game;
		this.live = live;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public boolean isAlive() {
		return live > 0;
	}

	public int getLive() {
		return live;
	}

	public boolean isHere(int row, int col) {
		if (this.row == row && this.col == col)
			return true;
		return false;
	}

	public void getDamage(int damage) {
		live -= damage;
		if (live <= 0) {
			onDelete();
		}
	}

	public boolean isOut() {
		return !game.isOnBoard(row, col);
	}

	public abstract void computerAction();
	public abstract void onDelete();
	public abstract void move();
	public abstract String toString();
}
