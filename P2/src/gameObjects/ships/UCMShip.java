package gameObjects.ships;

import gameObjects.weapons.Shockwave;
import gameObjects.weapons.UCMMissile;
import tp.p1.Game;
import tp.p1.Move;

public class UCMShip extends Ship {

	public static final int SHIELD = 3;
	private Shockwave shockwave;
	private UCMMissile ucmMissile;

	public UCMShip(Game game, int row, int col) {
		super(game, row, col, SHIELD);
		this.game = game;
		this.row = row;
		this.col = col;
		this.live = SHIELD;
	}

	@Override
	public String toString() {
		return "^__^";
	}

	public void move(Move move) {
		if (move == Move.LEFT && col >= 1)
			col--;
		else if (move == Move.LEFT2 && col > 1)
			col -= 2;
		else if (move == Move.RIGHT && col < Game.COLUMN - 1)
			col++;
		else if (move == Move.RIGHT2 && col < Game.COLUMN - 2)
			col += 2;
	}

	@Override
	public void move() {
	}

	public boolean hasShockwave() {
		return shockwave.getActive();
	}

	public void setShockwave(Game game) {
		if (!hasShockwave())
			shockwave = new Shockwave(game, -1, -1);
		this.game = game;
	}

	public boolean shockwave() {
		if (hasShockwave()) {
			game.laseToAll();
			shockwave.deactivate();
			shockwave = null;
			return true;
		}
		else return false;
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
		// TODO Auto-generated method stub

	}

	public UCMMissile shoot() {
		if (ucmMissile == null || !ucmMissile.isAlive()) {
			ucmMissile = new UCMMissile(game, row, col);
			return ucmMissile;
		}
		return null;
	}

}
