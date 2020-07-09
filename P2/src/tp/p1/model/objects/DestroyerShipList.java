/*package tp.p1.model.objects;

import java.util.Random;

import tp.p1.OldGame;
import tp.p1.Move;
import tp.p1.Level;

public class DestroyerShipList {

	private DestroyerShip[] list;
	private Level level;
	private Move move;
	private OldGame game;
	private boolean end;
	private Random seed;

	public DestroyerShipList(Level level, OldGame game, Random seed) {
		this.level = level;
		this.game = game;
		move = Move.LEFT;
		end = false;
		this.seed = seed;
		loadShips();
	}

	private void loadShips() {
		int row = level.getDestroyerShipRow(), col = level.getDestroyerShipCol();
		list = new DestroyerShip[level.getDestroyerShipNumber()];
		for (int i = 0; i < list.length; i++) {
			list[i] = new DestroyerShip(row, col + i, game);
		}
	}

	public String isDestroyerShipHere(int row, int col) {
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

	public boolean dropBombs() {
		boolean dropped = false;
		for (int i = 0; i < list.length; i++)
			if (!list[i].hasBomb() && seed.nextDouble() <= level.getShootingFrequency()) {
				game.getBombList().addBomb(list[i].dropBomb());
				if (!dropped)
					dropped = true;
			}
		return dropped;
	}

	public void update(Move move) {
		if (move != null) {
			int i = 0;
			Move moveTmp = move;
			if (move == Move.DOWN)
				while (!end && i < list.length) {
					end = list[i].isNextToFinal();
					i++;
				}

			if (!end) {
				if (move == Move.DOWN) {
					if (this.move == Move.LEFT)
						this.move = Move.RIGHT;
					else {
						this.move = Move.LEFT;
					}
				}

				for (i = 0; i < list.length; i++)
					list[i].move(moveTmp);
				checkDamage();
			}
		}
	}

	public void checkDamage() {
		UCMShipLase lase = game.getLase();
		if (lase != null && lase.isActive())
			for (int i = 0; i < list.length; i++) {
				DestroyerShip destroyerShip = list[i];
				if (destroyerShip.isHere(lase.getRow(), lase.getCol())) {
					destroyerShip.decreaseResistance(UCMShip.HARM);
					lase.deactivate();
				}
			}
	}

	public boolean hasDestroyerShips() {
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
