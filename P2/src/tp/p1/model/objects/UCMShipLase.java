/*package tp.p1.model.objects;

public class UCMShipLase {

	private int row;
	private int column;
	private boolean active;

	public UCMShipLase(int row, int column) {
		this.row = row;
		this.column = column;
		active = true;
	}

	public int getRow() {
		if (active)	return row;
		else return -1;
	}

	public int getCol() {
		if (active) return column;
		else return -1;
	}

	public void update() {
		if (active) {
			if (row >= 0)
				row--;
			active = row >= 0;
		}
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
		return " oo ";
	}

}*/
