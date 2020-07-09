package tp.p1;

import gameObjects.ships.DestroyerAlien;
import gameObjects.ships.Ovni;
import gameObjects.ships.RegularAlien;

public class BoardInitializer {

	private Level level;
	private GameObjectBoard board;
	private Game game;

	public GameObjectBoard initialize(Game game, Level level) {
		this.level = level;
		this.game = game;
		board = new GameObjectBoard(Game.ROW, Game.COLUMN);
		initializeOvni();
		initializeRegularAliens();
		initializeDestroyerAliens();
		return board;
	}

	private void initializeOvni() {
		Ovni ovni = new Ovni(game, 0, Game.COLUMN);
		ovni.deactivate();
		board.add(ovni);
	}

	private void initializeRegularAliens() {
		int maxShipsRow = 4;
		int row = level.getRegularShipRow(), col = level.getRegularShipCol(), aux = 0;
		for (int i = 0; i < level.getRegularShipNumber(); i++) {
			if (aux != i)
				if (aux < maxShipsRow - 1)
					aux++;
				else {
					aux = 0;
					row++;
				}
			RegularAlien regularAlien = new RegularAlien(game, row, col + aux);
			board.add(regularAlien);
		}
	}

	private void initializeDestroyerAliens() {
		int row = level.getDestroyerShipRow(), col = level.getDestroyerShipCol();
		for (int i = 0; i < level.getDestroyerShipNumber(); i++) {
			DestroyerAlien destroyerAlien = new DestroyerAlien(game, row, col + i);
			board.add(destroyerAlien);
		}
	}

}
