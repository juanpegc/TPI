package tp.p1.model.commands;

import tp.p1.Game;

public class HelpCommand extends Command {

	public HelpCommand() {
		super("help", "h", "Help", "Prints this help message.");
	}

	@Override
	public boolean execute(Game game) {
		System.out.println(CommandGenerator.commandHelp());
		return false;
	}

	@Override
	public Command parse(String[] commandWords) {
		if(matchCommandName(commandWords[0])) return this;
		return null;
	}

}
