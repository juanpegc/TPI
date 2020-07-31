package tp.p1.model.commands;

import tp.p1.Game;

public class ResetCommand extends Command {

	public ResetCommand() {
		super("reset", "r", "Reset", "Starts a new game.");
	}

	@Override
	public boolean execute(Game game) {
		game.reset();
		return false;
	}

	@Override
	public Command parse(String[] commandWords) {
		if(matchCommandName(commandWords[0])) return this;
		return null;
	}

}
