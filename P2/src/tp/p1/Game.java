package tp.p1;

import java.util.Random;

import gameObjects.GameObject;
import gameObjects.ships.AlienShip;
import gameObjects.ships.UCMShip;

public class Game implements IPlayerController {

	public static final int ROW = 8;
	public static final int COLUMN = 9;

	private int currentCycle;
	private int points;
	private Random rand;
	private Level level;
	GameObjectBoard board;
	private UCMShip player;
	private boolean doExit;
	private BoardInitializer initializer;

	public Game(Level level, Random random) {
		this.rand = random;
		this.level = level;
		initializer = new BoardInitializer();
		initGame();
	}

	public void initGame() {
		currentCycle = 0;
		points = 0;
		board = initializer.initialize(this, level);
		player = new UCMShip(this, ROW - 1, COLUMN / 2);
		addObject(player);
	}

	public Random getRandom() {
		return rand;
	}

	public Level getLevel() {
		return level;
	}

	public void reset() {
		initGame();
	}

	public void addObject(GameObject object) {
		board.add(object);
	}

	public String positionToString(int row, int col) {
		return board.toString(row, col);
	}

	public boolean isFinished() {
		return playerWin() || aliensWin() || doExit;
	}

	public boolean aliensWin() {
		return !player.isAlive() || AlienShip.haveLanded();
	}

	private boolean playerWin() {
		return AlienShip.allDead();
	}

	public void update() {
		board.computerAction();
		board.update();
		currentCycle += 1;
	}

	public boolean isOnBoard(int row, int col) {
		return row >= 0 && row < ROW && col >= 0 && col < COLUMN - 1;
	}

	public void exit() {
		doExit = true;
	}
/*
	public String infoToString() {
		return  cadena estado−juego para imprimir junto con el tablero ;
	}
*/

	public String getWinnerMessage() {
		if (playerWin())
			return "Player win!";
		else if (aliensWin())
			return "Aliens win!";
		else if (doExit)
			return "Player exits the game";
		else
			return "This should not happen";
	}

	@Override
	public boolean move(Move move) {
		player.move(move);
		return true;
	}

	@Override
	public boolean shootMissile() {
		GameObject ucmMissile = player.shoot();
		if(ucmMissile != null) {
			addObject(ucmMissile);
			return true;
		}
		return false;
	}

	@Override
	public boolean shockWave() {
		if (player.hasSuperPower()) {

			// do the superpower
			return true;
		}
		return false;
	}

	@Override
	public void receivePoints(int points) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enableShockWave() {
		player.setShockwave(this);
	}

	@Override
	public void enableMissile() {
		//TODO implement
	}

	public void list() {
		//System.out.println(gamePrinter.drawList());
	}

	public int getCycles() {
		return currentCycle;
	}

	public int getPoints() {
		return points;
	}
	
	public void setPoints(int points) {
		this.points += points;
	}
	
	public UCMShip getUCMShip() {
		return player;
	}

	public GameObjectBoard getGameObjectBoard() {
		return board;
	}
}
