/*package tp.p1.model.objects;

import tp.p1.OldGame;
import tp.p1.Move;

public class RegularShip {

	public static final int POINTS = 5;
	public static final int HARM = 0;
	public static final int SHIELD = 2;

	private int row;
	private int column;
	private int resistance;
	private boolean active;
	private OldGame game;

	public RegularShip(int row, int column, OldGame game) {
		this.row = row;
		this.column = column;
		resistance = SHIELD;
		active = true;
		this.game = game;
	}

	public void move(Move move) {
		if (active)
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

	public boolean isHere(int row, int col) {
		if (active) return this.row == row && this.column == col;
		else return false;
	}
	
	public String toString() {
		return "C[" + resistance + "]";
	}

	public boolean hasToChange(Move move) {
		boolean change = false;
		if (active) {
			if (move == Move.LEFT)
				change =  column == 0;
			else if (move == Move.RIGHT)
				change = column == OldGame.COLUMN - 1;
		}
		return change;
	}

	public boolean isNextToFinal() {
		if (active) return row + 1 == OldGame.ROW-1;
		else return false;
	}

	public void decreaseResistance(int decrease) {
		if (active && resistance > 0) {
			resistance-=decrease;
			active = resistance > 0;
			if (!active) game.addPoints(POINTS);
		}
		
	}

	public boolean isActive() {
		return active;
	}
}*/
