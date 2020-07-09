package tp.p1.model.commands;

import tp.p1.Game;

public class ResetCommand extends Command {

	public ResetCommand() {
		super("reset", "r", "Reset", "Starts a new game.");
	}

	@Override
	public boolean execute(Game game) {
		game.reset();
		return true;
	}

	@Override
	public Command parse(String[] commandWords) {
		String command = commandWords[0].toLowerCase();
		if(command.equals(name) || command.equals(shortcut)) return this;
		return null;
	}

}
