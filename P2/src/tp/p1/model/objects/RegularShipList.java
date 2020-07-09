/*package tp.p1.model.objects;

import tp.p1.OldGame;
import tp.p1.Move;
import tp.p1.Level;

public class RegularShipList {

	private int maxShipsRow;
	private RegularShip[] list;
	private Level level;
	private Move move;
	private OldGame game;
	private boolean end;
	private int cycles;

	public RegularShipList(Level level, OldGame game) {
		maxShipsRow = 4;
		this.level = level;
		this.game = game;
		move = Move.LEFT;
		loadShips();
		end = false;
		cycles = 1;
	}

	private void loadShips() {
		int row = level.getRegularShipRow(), col = level.getRegularShipCol(), aux = 0;
		list = new RegularShip[level.getRegularShipNumber()];
		for (int i = 0; i < list.length; i++) {
			if (aux != i)
				if (aux < maxShipsRow - 1)
					aux++;
				else {
					aux = 0;
					row++;
				}
			list[i] = new RegularShip(row, col + aux, game);
		}
	}

	public String isRegularShipHere(int row, int col) {
		int i = 0;
		boolean exist = false;
		while (!exist && i < list.length) {
			exist = list[i].isHere(row, col);
			i++;
		}
		if (exist)
			return list[i - 1].toString();
		else
			return null;
	}

	public Move update() {
		if (cycles == level.getSpeed()) {
			cycles = 1;
			int i = 0;
			boolean change = false;
			Move moveTmp = move;
			while (!(change && end) && i < list.length) {
				RegularShip regularShip = list[i];
				if (!change)
					change = regularShip.hasToChange(move);
				if (change && !end)
					end = regularShip.isNextToFinal();
				i++;
			}
	
			if (!end) {
				if (change) {
					moveTmp = Move.DOWN;
					if (move == Move.LEFT)
						move = Move.RIGHT;
					else {
						move = Move.LEFT;
					}
				}
				for (i = 0; i < list.length; i++)
					list[i].move(moveTmp);
				checkDamage();
				
			}
			return moveTmp;
		} else {
			cycles++;
			return null;
		}
	}

	public void checkDamage() {
		UCMShipLase lase = game.getLase();
		if (lase != null && lase.isActive())
			for (int i = 0; i < list.length; i++) {
				RegularShip regularShip = list[i];
				if (lase != null && regularShip.isHere(lase.getRow(), lase.getCol())) {
					regularShip.decreaseResistance(UCMShip.HARM);
					lase.deactivate();
				}
			}
	}

	public boolean hasRegularShips() {
		int i = 0;
		boolean active = false;
		while (!active && i < list.length) {
			active = list[i].isActive();
			i++;
		}
		return active;
	}

	public int getNumberOfShips() {
		int cont = 0;
		for (int i = 0; i < list.length; i++) {
			if (list[i].isActive())
				cont++;
		}
		return cont;
	}

	public void laseToAll() {
		for (int i = 0; i < list.length; i++) {
			list[i].decreaseResistance(1);
		}
	}

	public boolean isInTheEnd() {
		return end;
	}

}*/
