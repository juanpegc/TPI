package tp.p1;

import exceptions.MissileInFlightException;
import exceptions.NoShockwaveException;
import exceptions.NotEnoughPointsException;
import exceptions.OffWorldException;

public interface IPlayerController {
// PLAYER ACTIONS
	public void move(Move move) throws OffWorldException;
	public void shootMissile() throws MissileInFlightException;
	public void shockWave() throws NoShockwaveException;
	public void shootSuperMissile()throws MissileInFlightException;
	public void buySuperMissile() throws NotEnoughPointsException;

// CALLBACKS
	public void receivePoints(int points);
	public void enableShockWave();
	public void enableMissile();
}
