/*package tp.p1.model.objects;

import tp.p1.OldGame;

public class Ovni {

	public static final int POINTS = 25;
	public static final int HARM = 0;
	public static final int SHIELD = 1;

	private int row;
	private int column;
	private int resistance;
	private boolean active;
	private OldGame game;

	public Ovni(OldGame game) {
		row = 0;
		column = OldGame.COLUMN;
		resistance = SHIELD;
		active = true;
		this.game = game;
	}

	public void update() {
		if (active) {
			UCMShipLase lase = game.getLase();
			column--;
			active = lase == null || (row != lase.getRow() || column != lase.getCol());
			if (!active) {
				game.addPoints(POINTS);
				game.getPlayer().setSuperPower();
				lase.deactivate();
			} else
				active = column >= 0;
		}
	}

	public boolean isHere(int row, int col) {
		if (active) return this.row == row && this.column == col;
		else return false;
	}
	
	public String toString() {
		return "O[" + resistance + "]";
	}

	public boolean isActive() {
		return active;
	}
}*/
