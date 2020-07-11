package tp.p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Random;

import exceptions.FileContentsException;
import exceptions.MissileInFlightException;
import exceptions.NoShockwaveException;
import exceptions.NotEnoughPointsException;
import exceptions.OffWorldException;
import gameObjects.GameObject;
import gameObjects.GameObjectGenerator;
import gameObjects.ships.AlienShip;
import gameObjects.ships.UCMShip;
import tp.p1.model.FormattedPrinter;

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
	public void move(Move move) throws OffWorldException {
		player.move(move);
	}

	@Override
	public void shootMissile() throws MissileInFlightException {
		GameObject ucmMissile = player.shoot();
		if (ucmMissile != null) {
			addObject(ucmMissile);
		} else
			throw new MissileInFlightException(": missile already exists on board");
	}

	@Override
	public void shockWave() throws NoShockwaveException {
		boolean valid = player.shockwave();
		if (!valid)
			throw new NoShockwaveException(": no shockwave available");
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
		System.out.println(FormattedPrinter.drawList(this));
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

	@Override
	public void shootSuperMissile() throws MissileInFlightException {
		GameObject superMissile = player.shootSupermissile();
		if (superMissile != null)
			addObject(superMissile);
		else
			throw new MissileInFlightException(": no supermissile available");
	}

	@Override
	public void buySuperMissile() throws NotEnoughPointsException {
		boolean valid = false;
		if (points >= 20) {
			points -= 20;
			player.setSuperMissile();
			valid = true;
		}
		if (!valid)
			throw new NotEnoughPointsException(": not enought points to buy supermissile");
	}

	public void load(BufferedReader br) throws FileContentsException {
		String line;
		boolean loading;
		FileContentsVerifier verifier = new FileContentsVerifier();

		loading = false;
		try {
			line = br.readLine().trim();
			while (line != null && !line.isEmpty()) {
				GameObject gameObject = GameObjectGenerator.parse(line, this, verifier);
				if (gameObject == null) {
					throw new FileContentsException("invalid file, " + "unrecognised line prefix");
				}
				board.add(gameObject);
				line = br.readLine().trim();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
