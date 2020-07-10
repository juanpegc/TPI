package gameObjects.ships;

import gameObjects.IExecuteRandomActions;
import gameObjects.weapons.Bomb;
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

	
	
	
}
