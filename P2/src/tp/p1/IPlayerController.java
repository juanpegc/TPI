package tp.p1;

public interface IPlayerController {
// PLAYER ACTIONS
	public boolean move(Move move);
	public boolean shootMissile();
	public boolean shockWave();

// CALLBACKS
	public void receivePoints(int points);
	public void enableShockWave();
	public void enableMissile();
}
