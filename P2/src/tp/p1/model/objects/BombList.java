/*package tp.p1.model.objects;

import tp.p1.OldGame;
import tp.p1.Level;

public class BombList {
	
	private Bomb [] listBombs;
	private OldGame game;

	public BombList(Level level, OldGame game) {
		listBombs = new Bomb[level.getDestroyerShipNumber()];
		this.game = game;
	}

	public void addBomb(Bomb bomb) {
		int i = 0;
		boolean free = false;;
		while (!free && i < listBombs.length) {
			free = listBombs[i] == null || !listBombs[i].isActive();
			i++;
		}
		listBombs[i - 1] = bomb;
	}

	public boolean isBombHere(int row, int col) {
		int i = 0;
		boolean exist = false;
		while (!exist && i < listBombs.length) {
			exist = listBombs[i] != null && listBombs[i].isHere(row, col);
			i++;
		}
		return exist;
	}

	public void update() {
		for (int i = 0; i < listBombs.length; i++) {
			if (listBombs[i] != null && listBombs[i].isActive())
				listBombs[i].update(game.getLase(), game.getPlayer());
		}
	}

	public void updateBombsUnderShips() {
		for (int i = 0; i < listBombs.length; i++) {
			Bomb bomb = listBombs[i];
			if (bomb != null && bomb.isActive() && game.getDestroyerShipList().isDestroyerShipHere(bomb.getRow(), bomb.getCol()) != null)
				bomb.update(game.getLase(), game.getPlayer());
		}
	}

}*/
