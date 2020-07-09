package tp.p1.model.commands;

import tp.p1.Game;

public class HelpCommand extends Command {

	public HelpCommand() {
		super("help", "h", "Help", "Prints this help message.");
	}

	@Override
	public boolean execute(Game game) {
		System.out.println(CommandGenerator.commandHelp());
		return true;
	}

	@Override
	public Command parse(String[] commandWords) {
		String command = commandWords[0].toLowerCase();
		if(command.equals(name) || command.equals(shortcut)) return this;
		return null;
	}

}
