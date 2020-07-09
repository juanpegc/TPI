/*package tp.p1.model.objects;

import tp.p1.OldGame;

public class Bomb {

	private int row;
	private int column;
	private boolean active;
	
	public Bomb(int row, int column) {
		this.row = row;
		this.column = column;
		active = true;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return column;
	}
	
	public void update(UCMShipLase lase, UCMShip ucmShip) {
		if (active) {
			if (row <= OldGame.ROW) {
				checkDamage(lase);
				if (active) {
					row++;
					if (!checkDamage(lase)) {
						if (ucmShip.isHere(row, column)) {
							ucmShip.damage(DestroyerShip.HARM);
							deactivate();
						}
						active = row < OldGame.ROW;
					}
				}
			}
		}
	}
	
	private boolean checkDamage(UCMShipLase lase) {
		boolean damage = lase != null && lase.isHere(row, column);
		if (damage) {
			lase.deactivate();
			deactivate();
		}
		return damage;
	}
	
	public void deactivate() {
		active = false;
	}
	

	public boolean isActive() {
		return active;
	}
	
	public boolean isHere(int row, int column) {
		if (!isActive()) return false;
		else return this.row == row && this.column == column;
	}

	public static String getDraw() {
		return " .  ";
	}
	
}
*/