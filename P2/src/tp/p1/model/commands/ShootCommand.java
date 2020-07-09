package tp.p1.model.commands;

import tp.p1.Game;

public class ShootCommand extends Command {

	public ShootCommand() {
		super("shoot", "s", "Shoot", "UCM-Ship launches a missile.");
	}

	@Override
	public boolean execute(Game game) {
		return game.shootMissile();
	}

	@Override
	public Command parse(String[] commandWords) {
		String command = commandWords[0].toLowerCase();
		if (command.equals(name) || command.equals(shortcut)) return this;
		return null;
	}

}
