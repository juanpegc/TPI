package gameObjects.ships;

import exceptions.FileContentsException;
import gameObjects.GameObject;
import gameObjects.IExecuteRandomActions;
import gameObjects.weapons.Bomb;
import tp.p1.FileContentsVerifier;
import tp.p1.Game;
import tp.p1.Move;

public class DestroyerAlien extends AlienShip implements IExecuteRandomActions{

	public static final int SHIELD = 1;
	public static final int POINTS = 10;
	private Bomb bomb;
	
	public DestroyerAlien(Game game, int row, int col) {
		super(game, row, col, SHIELD, POINTS);
		this.live = SHIELD;
		move = Move.LEFT;
		AlienShip.ALIEN_SHIPS_ALIVE++;
	}

	@Override
	public void move() {
		super.move();
	}

	@Override
	public String toString() {
		return "D[" + live + "]";
	}

	@Override
	public void computerAction() {
		if((bomb == null || !bomb.isAlive()) && IExecuteRandomActions.canGenerateRandomBomb(game)) {
			bomb = new Bomb(game, row, col);
			game.addObject(bomb);
		}
	}

	@Override
	public void onDelete() {
		super.onDelete();	
	}

	@Override
	public String toPlainText() {
		return "D;" + row + "," + col + ";" + live + ";" + cycles + ";" + move.name() + "\n";
	}

	@Override
	protected GameObject parse(String stringFromFile, Game game, FileContentsVerifier verifier) throws FileContentsException {
		DestroyerAlien destroyer = null;
		if(verifier.verifyAlienShipString(stringFromFile, game, SHIELD)) {
			destroyer = new DestroyerAlien(game, row, col);
			destroyer.game = game;
			destroyer.row = getRowFromString(stringFromFile);
			destroyer.col = getColFromString(stringFromFile);
			destroyer.live = Integer.parseInt(stringFromFile.split(";")[2]);
			destroyer.cycles = Integer.parseInt(stringFromFile.split(";")[3]);
			destroyer.move = Move.parse(stringFromFile.split(";")[4]);
		} else throw new FileContentsException(": Destroyer Alien incorrect format");
		return destroyer;
	}

	
	
	
}
