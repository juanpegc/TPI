/*package tp.p1.model.objects;

import tp.p1.OldGame;
import tp.p1.Move;

public class DestroyerShip {

	public static final int POINTS = 10;
	public static final int HARM = 1;
	public static final int SHIELD = 1;

	private int row;
	private int column;
	private int resistance;
	private boolean active;
	private OldGame game;
	private Bomb bomb;

	public DestroyerShip(int row, int column, OldGame game) {
		this.row = row;
		this.column = column;
		resistance = SHIELD;
		active = true;
		this.game = game;
	}

	public boolean hasBomb() {
		return bomb != null && bomb.isActive();
	}

	public Bomb dropBomb() {
		if (active) {
			bomb = new Bomb(row, column);
			return bomb;
		}
		return null;
	}

	public void move(Move move) {
		if (active) {
			switch (move) {
			case LEFT:
				column--;
				break;

			case RIGHT:
				column++;
				break;

			case DOWN:
				row++;
			}
		}
	}

	public boolean isHere(int row, int col) {
		if (active)
			return this.row == row && this.column == col;
		else
			return false;
	}

	public String toString() {
		return "D[" + resistance + "]";
	}

	public boolean hasToChange(Move move) {
		boolean change = false;
		if (active) {
			if (move == Move.LEFT)
				change = column == 0;
			else if (move == Move.RIGHT)
				change = column == OldGame.COLUMN - 1;
		}
		return change;
	}

	public boolean isNextToFinal() {
		if (active)
			return row + 1 == OldGame.ROW - 1;
		else
			return false;
	}

	public void decreaseResistance(int decrease) {
		if (active && resistance > 0) {
			resistance -= decrease;
			active = resistance > 0;
			if (!active)
				game.addPoints(POINTS);
		}

	}

	public boolean isActive() {
		return active;
	}

}*/
