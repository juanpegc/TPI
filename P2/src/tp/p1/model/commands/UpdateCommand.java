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
		String command = commandWords[0].toLowerCase();
		if (command.equals(this.name) || command.equals(this.shortcut) || command.equals(""))
			return this;
		return null;
	}

}
