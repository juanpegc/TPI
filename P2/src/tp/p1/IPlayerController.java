package tp.p1;

import exceptions.CommandExecuteException;

public interface IPlayerController {
// PLAYER ACTIONS
	public boolean move(Move move) throws CommandExecuteException;
	public boolean shootMissile();
	public boolean shockWave();
	public boolean shootSuperMissile();

// CALLBACKS
	public void receivePoints(int points);
	public void enableShockWave();
	public void enableMissile();
}
