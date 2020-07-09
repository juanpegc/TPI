package gameObjects;

import tp.p1.Game;

public interface IExecuteRandomActions {
	
	static boolean canGenerateRandomOvni(Game game) {
		return game.getRandom().nextDouble() < game.getLevel().getOVNIProbality();
	}

	static boolean canGenerateRandomBomb(Game game) {
		return game.getRandom().nextDouble() < game.getLevel().getShootingFrequency();
	}
}
