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
import gameObjects.ships.ExplosiveAlien;
import gameObjects.ships.RegularAlien;
import gameObjects.ships.UCMShip;
import gameObjects.weapons.SuperMissile;
import gameObjects.weapons.UCMMissile;
import tp.p1.model.GamePrinter;

public class Game implements IPlayerController {

	public static final int ROW = 8;
	public static final int COLUMN = 9;

	private int currentCycle;
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
		AlienShip.SAME_MOVE = 0;
		AlienShip.ALIEN_SHIPS_ALIVE = 0;
		AlienShip.moveTmp = Move.LEFT;
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
		player.receivePoints(points);
	}

	@Override
	public void enableShockWave() {
		player.setShockwave(this);
	}

	@Override
	public void enableMissile() {
		player.setSuperMissile();
	}

	public void list() {
		System.out.println(GamePrinter.drawList(this));
	}

	public int getCycles() {
		return currentCycle;
	}

	public int getPoints() {
		return player.getPoints();
	}

	public UCMShip getUCMShip() {
		return player;
	}
	
	public void setUCMShip(UCMShip player) {
		this.player = player;
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
		player.buySuperMissile();
	}

	public void load(BufferedReader br) throws FileContentsException {
		int cycles;
		Level level;
		GameObjectBoard boardAux = new GameObjectBoard(Game.ROW, Game.COLUMN);
		UCMShip ucmShipAux = getUCMShip();
		FileContentsVerifier verifier = new FileContentsVerifier();
		int alienShipsAlive = AlienShip.ALIEN_SHIPS_ALIVE;

		try {
			String line = br.readLine().trim();
			if (verifier.verifyCycleString(line)) {
				cycles = Integer.parseInt(line.split(";")[1]);
			} else
				throw new FileContentsException("Invalid cycles number");
			line = br.readLine().trim();
			if (verifier.verifyLevelString(line)) {
				level = Level.parse(line.split(";")[1]);
			} else
				throw new FileContentsException("Invalid Level");
			line = br.readLine().trim();
			while (line != null && !line.isEmpty()) {
				GameObject gameObject = GameObjectGenerator.parse(line, this, verifier);
				if (gameObject == null) {
					String error = line.split(";")[0];
					if (error.equals("P"))
						throw new FileContentsException(": UCMShip invalid format");
					else if (error.equals("R"))
						throw new FileContentsException(": Regular Alien invalid format");
					else if (error.equals("E"))
						throw new FileContentsException(": Explosive Alien invalid format");
					else if (error.equals("D"))
						throw new FileContentsException(": Destroyer Alien invalid format");
					else if (error.equals("M"))
						throw new FileContentsException(": UCMMissile invalid format");
					else if (error.equals("X"))
						throw new FileContentsException(": Supermissile invalid format");
					else if (error.equals("O"))
						throw new FileContentsException(": Ovni invalid format");
					else if (error.equals("B"))
						throw new FileContentsException(": Bomb invalid format");
					else
						throw new FileContentsException("invalid file, " + "unrecognised line prefix");
				}
				boardAux.add(gameObject);
				line = br.readLine();
				if (line != null)
					line.trim();
			}
			currentCycle = cycles;
			this.level = level;
			this.board = boardAux;

		} catch (IOException e) {
			throw new FileContentsException("There was a problem with the file");
		}catch(FileContentsException e) {
			setUCMShip(ucmShipAux);
			AlienShip.ALIEN_SHIPS_ALIVE = alienShipsAlive;
			
			throw new FileContentsException("");
		}

	}

	public boolean hasBomb(int number) {
		return board.hasBomb(number);
	}

	public void setUCMShipMissile(UCMMissile missile) {
		player.setUCMShipMissile(missile);
	}
	
	public void setSupermissile(SuperMissile supermissile) {
		board.add(supermissile);
	}

	public void replaceObject(RegularAlien regularAlien, ExplosiveAlien explosiveAlien) {
		board.replaceObject(regularAlien, explosiveAlien);
	}
}
