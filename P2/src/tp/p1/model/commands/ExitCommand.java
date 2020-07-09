package tp.p1.model.commands;

import tp.p1.Game;

public class ExitCommand extends Command {

	public ExitCommand() {
		super("exit", "e", "Exit", "Terminates the program.");
	}

	@Override
	public boolean execute(Game game) {
		game.exit();
		return true;
	}

	@Override
	public Command parse(String[] commandWords) {
		String command = commandWords[0].toLowerCase();
		if(command.equals(name) || command.equals(shortcut)) return this;
		return null;
	}

}
