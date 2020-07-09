/*package tp.p1.model.objects;

import tp.p1.OldGame;

public class UCMShip {
	
	public static final int HARM = 1;
	public static final int SHIELD = 3;

	private int row;
	private int column;
	private int resistance;
	private OldGame game;
	private boolean superPower;

	public UCMShip(OldGame game) {
		row = 7;
		column = 4;
		resistance = SHIELD;
		this.game = game;
		superPower = false;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return column;
	}

	public int getResistance() {
		return resistance;
	}

	public void superPower() {
		if (superPower) {
			game.laseToAll();
			superPower = false;
		}
	}

	public void setSuperPower() {
		superPower = true;
	}

	public boolean hasSuperPower() {
		return superPower;
	}
	
	public void damage(int damage) {
		resistance -= damage;
	}

	public void move(String[] parameters) {
		if (parameters[1].equals("left")) {
			if (parameters[2].equals("1") && column >= 1) {
				column--;
			} else if (parameters[2].equals("2") && column > 1) {
				column -= 2;
			}
		} else if (parameters[1].equals("right")) {
			if (parameters[2].equals("1") && column < OldGame.COLUMN - 1) {
				column ++;
			} else if (parameters[2].equals("2") && column < OldGame.COLUMN - 2) {
				column += 2;
			}
		}
	}

	public boolean isHere(int row, int column) {
		return this.row == row && this.column == column;
	}

	public static String getDraw() {
		return "^__^";
	}

	public boolean isDead() {
		return resistance == 0;
	}
}*/