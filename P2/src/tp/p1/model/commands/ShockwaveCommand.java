package tp.p1.model.commands;

import tp.p1.Game;

public class ShockwaveCommand extends Command {

	public ShockwaveCommand() {
		super("superpower", "p", "SuperPower", "UCM-Ship releases a shock wave.");
	}

	@Override
	public boolean execute(Game game) {
		return game.shockWave();
	}

	@Override
	public Command parse(String[] commandWords) {
		if(matchCommandName(commandWords[0])) return this;
		return null;
	}

}
