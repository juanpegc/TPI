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

	public void removeObject(GameObject object) {
		board.remove(object, board.getIndex(object.getRow(), object.getCol()));
	}
	
	public String positionToString(int row, int col) {
		return board.toString(row, col);
	}
	
	public GameObject isSomethingHere(int row, int col) {
		return board.getObjectInPosition(row, col);
	}

	public boolean isFinished() {
		return playerWin() || aliensWin() || doExit;
	}

	public boolean aliensWin() {
		return !player.isAlive() || AlienShip.HAVE_LANDED;
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
		return row >= -1 && row <= ROW && col >= 0 && col < COLUMN - 1;
	}

	public void exit() {
		doExit = true;
	}
	/*
	 * public String infoToString() { return cadena estado−juego para imprimir junto
	 * con el tablero ; }
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
		if (ucmMissile != null) {
			addObject(ucmMissile);
			return true;
		}
		return false;
	}

	@Override
	public boolean shockWave() {
		return player.shockwave();
	}

	@Override
	public void receivePoints(int points) {
		this.points += points;
	}

	@Override
	public void enableShockWave() {
		player.setShockwave(this);
	}

	@Override
	public void enableMissile() {
		// TODO implement
	}

	public void list() {
		// System.out.println(gamePrinter.drawList());
	}

	public int getCycles() {
		return currentCycle;
	}

	public int getPoints() {
		return points;
	}

	public UCMShip getUCMShip() {
		return player;
	}

	public GameObjectBoard getGameObjectBoard() {
		return board;
	}

	public void laseToAll() {
		board.laseToAll();
	}

	public boolean buySupermissile() {
		if(points >= 20) {
			points-=20;
			player.setSuperMissile();
			return true;
		}
		return false;
	}

	@Override
	public boolean shootSuperMissile() {
		GameObject superMissile = player.shootSupermissile();
		if(superMissile != null) {
			addObject(superMissile);
			return true;
		}
		return false;
	}
}
