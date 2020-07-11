package gameObjects.ships;

import exceptions.FileContentsException;
import gameObjects.GameObject;
import tp.p1.FileContentsVerifier;
import tp.p1.Game;
import tp.p1.Move;

public class ExplosiveAlien extends AlienShip{

	
	
	public ExplosiveAlien(Game game, int row, int col, Move direction, int live, int points, int cyclesToMove) {
		super(game, row, col, live, points);
		cycles = cyclesToMove;
		move = direction;
	}
	
	@Override
	public void move() {
		super.move();
	}

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "E[" + live + "]";
	}
	
	@Override
	public void onDelete() {
		super.onDelete();
	}

	@Override
	public String toPlainText() {
		return "E;" + row + "," + col + ";" + live + ";" + cycles + ";" + move.name() + "\n";
	}

	@Override
	protected GameObject parse(String stringFromFile, Game game, FileContentsVerifier verifier) throws FileContentsException {
		ExplosiveAlien explosive = null;
		if(verifier.verifyAlienShipString(stringFromFile, game, RegularAlien.SHIELD)) {
			explosive = new ExplosiveAlien(game, row, col, move, live, points, cycles);
			explosive.game = game;
			explosive.row = getRowFromString(stringFromFile);
			explosive.col = getColFromString(stringFromFile);
			explosive.live = Integer.parseInt(stringFromFile.split(";")[2]);
			explosive.cycles = Integer.parseInt(stringFromFile.split(";")[3]);
			explosive.move = Move.parse(stringFromFile.split(";")[4]);
		} else throw new FileContentsException(": Explosive Alien incorrect format");
		return explosive;
	}

}
