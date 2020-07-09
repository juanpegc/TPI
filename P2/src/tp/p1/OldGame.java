package tp.p1;
/*
import java.util.Random;
import java.util.Scanner;

import gameObjects.weapons.UCMMissile;
import tp.p1.model.GamePrinter;
import tp.p1.model.objects.BombList;
import tp.p1.model.objects.DestroyerShipList;
import tp.p1.model.objects.Ovni;
import tp.p1.model.objects.RegularShipList;
import tp.p1.model.objects.UCMShip;
import tp.p1.model.objects.UCMShipLase;

public class OldGame {

	public static final int ROW = 8;
	public static final int COLUMN = 9;

	private int cycles;
	private int points;

	private Level level;
	private Random seed;
	private GamePrinter gamePrinter;

	private boolean gameOver;

	private UCMShip player;
	private UCMShipLase lase;
	private BombList bombList;
	private RegularShipList regularShipList;
	private DestroyerShipList destroyerShipList;
	private Ovni ovni;

	private boolean reset;

	public OldGame(String level, Random seed) {
		if (level.equals("HARD"))
			this.level = Level.HARD;
		else if (level.equals("INSANE"))
			this.level = Level.INSANE;
		else
			this.level = Level.EASY;

		this.seed = seed;

		launch();
	}

	private void launch() {
		cycles = 0;
		points = 0;
		player = new UCMShip(this);
		lase = null;
		bombList = new BombList(level, this);
		regularShipList = new RegularShipList(level, this);
		destroyerShipList = new DestroyerShipList(level, this, seed);
		gamePrinter = new GamePrinter(this);
		ovni = null;
		reset = false;
	}

	public int getCycles() {
		return cycles;
	}
	
	public int getPoints() {
		return points;
	}

	public void addPoints(int points) {
		this.points += points;
	}

	public int getAliens() {
		return regularShipList.getNumberOfShips() + destroyerShipList.getNumberOfShips();
	}

	public boolean getSuperPower() {
		return player.hasSuperPower();
	}

	public UCMShip getPlayer() {
		return player;
	}

	public UCMMissile getLase() {
		return lase;
	}

	public RegularShipList getRegularShipList() {
		return regularShipList;
	}

	public DestroyerShipList getDestroyerShipList() {
		return destroyerShipList;
	}

	public Ovni getOvni() {
		return ovni;
	}

	public BombList getBombList() {
		return bombList;
	}
	
	public String toString() {
		return gamePrinter.toString();
	}

	private void drawList() {
		System.out.println(gamePrinter.drawList());
	}
	
	public void move(Move move) {
		player.move(move);
	}
	
	public void shoot() {
		if (lase == null || !lase.isActive())
			lase = new UCMShipLase(player.getRow(), player.getCol());
	}
	
	public void superPower() {
		player.superPower();
	}
	
	public void reset() {
		reset = true;
	}
	
	public void list() {
		drawList();
	}
	
	public void exit() {
		gameOver = true;
	}
	
	public void computerAction() {
		if (destroyerShipList.getNumberOfShips() > 0 && !destroyerShipList.dropBombs())
			if (ovni == null || !ovni.isActive() && seed.nextDouble() <= level.getOVNIProbality())
				ovni = new Ovni(this);
	}

	public void update() {
		if (reset)
			launch();
		else if (!gameOver) {
			cycles++;
			if (lase != null)
				lase.update();
			bombList.update();
			destroyerShipList.checkDamage();
			regularShipList.checkDamage();
			Move move = regularShipList.update();
			destroyerShipList.update(move);
			if (move == Move.DOWN)
				bombList.updateBombsUnderShips();
			if (ovni != null)
				ovni.update();
			gameOver = player.isDead() || regularShipList.isInTheEnd() || destroyerShipList.isInTheEnd()
					|| (!regularShipList.hasRegularShips() && !destroyerShipList.hasDestroyerShips());
		}
	}

	public void laseToAll() {
		regularShipList.laseToAll();
		destroyerShipList.laseToAll();
	}

	public boolean isFinished() {
		return gameOver;
	}

	public boolean playerWin() {
		return !regularShipList.hasRegularShips() && !destroyerShipList.hasDestroyerShips();
	}
	
}*/
