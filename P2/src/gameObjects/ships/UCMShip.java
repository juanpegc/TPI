package gameObjects.ships;

import exceptions.FileContentsException;
import exceptions.NotEnoughPointsException;
import exceptions.OffWorldException;
import gameObjects.GameObject;
import gameObjects.weapons.Shockwave;
import gameObjects.weapons.SuperMissile;
import gameObjects.weapons.UCMMissile;
import tp.p1.FileContentsVerifier;
import tp.p1.Game;
import tp.p1.Move;

public class UCMShip extends Ship {

	public static final int SHIELD = 3;
	private Shockwave shockwave;
	private UCMMissile ucmMissile;
	private int supermissile;
	private boolean supermissileOnAir;
	private int points;

	public UCMShip(Game game, int row, int col) {
		super(game, row, col, SHIELD);
		this.game = game;
		this.row = row;
		this.col = col;
		this.live = SHIELD;
		this.points = 0;
		supermissileOnAir = false;
	}

	@Override
	public String toString() {
		return "^__^";
	}

	public void move(Move move) throws OffWorldException {
		boolean valid = false;
		if (move == Move.LEFT && col >= 1) {
			col--;
			valid = true;
		} else if (move == Move.LEFT2 && col > 1) {
			col -= 2;
			valid = true;
		} else if (move == Move.RIGHT && col < Game.COLUMN - 1) {
			col++;
			valid = true;
		} else if (move == Move.RIGHT2 && col < Game.COLUMN - 2) {
			col += 2;
			valid = true;
		}
		if (!valid)
			throw new OffWorldException(":ship too near to border");
	}

	@Override
	public void move() {
	}

	public boolean hasShockwave() {
		return shockwave != null && shockwave.getActive();
	}

	public void setShockwave(Game game) {
		if (!hasShockwave())
			shockwave = new Shockwave(game, -1, -1);
		this.game = game;
	}

	public boolean shockwave() {
		if (hasShockwave()) {
			shockwave.deactivate();
			shockwave = null;
			game.laseToAll();
			return true;
		} else
			return false;
	}

	@Override
	public boolean receiveBombAttack(int damage) {
		getDamage(damage);
		return true;
	}

	@Override
	public void computerAction() {
	}

	@Override
	public void onDelete() {
		super.onDelete();
	}
	
	public int getPoints() {
		return points;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}
	
	public void buySuperMissile() throws NotEnoughPointsException {
		boolean valid = false;
		if (points >= 20) {
			points -= 20;
			setSuperMissile();
			valid = true;
		}
		if (!valid)
			throw new NotEnoughPointsException(": not enought points to buy supermissile");
	}

	public void receivePoints(int points) {
		this.points += points;
	}

	public UCMMissile shoot() {
		if (ucmMissile == null || !ucmMissile.isAlive()) {
			ucmMissile = new UCMMissile(game, row, col);
			return ucmMissile;
		}
		return null;
	}

	public SuperMissile shootSupermissile() {
		if (supermissile > 0 && !supermissileOnAir) {
			supermissile--;
			return new SuperMissile(game, row, col);
		}
		return null;
	}

	public int getSupermissile() {
		return supermissile;
	}

	public void setSuperMissile() {
		supermissile++;
	}

	@Override
	public String toPlainText() {
		return "P;" + row + "," + col + ";" + live + ";" + getPoints() + ";"
				+ ((shockwave == null) ? false : shockwave) + ";" + supermissile + "\n";
	}

	@Override
	protected GameObject parse(String stringFromFile, Game game, FileContentsVerifier verifier)
			throws FileContentsException {
		UCMShip player = null;
		if (verifier.verifyPlayerString(stringFromFile, game, SHIELD)) {
			player = new UCMShip(game, row, col);
			player.game = game;
			player.row = getRowFromString(stringFromFile);
			player.col = getColFromString(stringFromFile);
			player.live = Integer.parseInt(stringFromFile.split(";")[2]);
			player.points = Integer.parseInt(stringFromFile.split(";")[3]);
			if (Boolean.parseBoolean(stringFromFile.split(";")[4]))
				setShockwave(game);
			player.supermissile = Integer.parseInt(stringFromFile.split(";")[5]);
			game.setUCMShip(player);
		}
		return player;
	}
	
	@Override
	public boolean receiveExplosionAttack(int damage) {
		getDamage(damage);
		return true;
	}

	public void setUCMShipMissile(UCMMissile missile) {
		this.ucmMissile = missile;
	}
	
	public void setSupermissileOnAir() {
		supermissileOnAir = true;
	}

	public void setSupermissileAvailable() {
		supermissileOnAir = false;
		
	}
}
