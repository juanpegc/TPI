package tp.p1.model.commands;

import exceptions.CommandExecuteException;
import exceptions.NoShockwaveException;
import tp.p1.Game;

public class ShockwaveCommand extends Command {

	public ShockwaveCommand() {
		super("superpower", "p", "SuperPower", "UCM-Ship releases a shock wave.");
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException{
		try {
			game.shockWave();
			return true;
		}catch(NoShockwaveException e) {
			throw new CommandExecuteException("Cannot release shockwave" + e.getMessage());
		}
	}

	@Override
	public Command parse(String[] commandWords) {
		if(matchCommandName(commandWords[0])) return this;
		return null;
	}

}
