package tp.p1.model.commands;

import tp.p1.Game;

public class ListCommand extends Command {

	public ListCommand() {
		super("list", "l", "List", "Prints the list of available ships.");
	}

	@Override
	public boolean execute(Game game) {
		game.list();
		return false;
	}

	@Override
	public Command parse(String[] commandWords) {
		if(matchCommandName(commandWords[0])) return this;
		return null;
	}

}
