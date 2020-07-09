package tp.p1.model.commands;

import tp.p1.Game;

public class ListCommand extends Command {

	public ListCommand() {
		super("list", "l", "List", "Prints the list of available ships.");
	}

	@Override
	public boolean execute(Game game) {
		game.list();
		return true;
	}

	@Override
	public Command parse(String[] commandWords) {
		String command = commandWords[0].toLowerCase();
		if(command.equals(name) || command.equals(shortcut)) return this;
		return null;
	}

}
