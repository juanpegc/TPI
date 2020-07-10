package tp.p1.model.commands;

import tp.p1.Game;

public class UpdateCommand extends Command {

	public UpdateCommand() {
		super("none", "n", "[None]", "Skips one cycle.");
	}

	@Override
	public boolean execute(Game game) {
		return true;
	}

	@Override
	public Command parse(String[] commandWords) {
		if (matchCommandName(commandWords[0]) || commandWords[0].equals(""))
			return this;
		return null;
	}

}
