package tp.p1.model.commands;

import tp.p1.Game;

public class ShootCommand extends Command {

	private boolean superMissile;

	public ShootCommand() {
		super("shoot", "s", "Shoot", "<SuperMissile> UCM-Ship launches a missile.");
		superMissile = false;
	}

	public void setSuperMissile() {
		superMissile = true;
	}

	@Override
	public boolean execute(Game game) {
		if (!superMissile)
			return game.shootMissile();
		else {
			return game.shootSuperMissile();
		}
	}

	@Override
	public Command parse(String[] commandWords) {
		if (matchCommandName(commandWords[0])) {
			if (commandWords.length == 1) {
				return this;
			} else {
				if (commandWords[1].toLowerCase().equals("supermissile")) {
					ShootCommand shootCommand = new ShootCommand();
					shootCommand.setSuperMissile();
					return shootCommand;
				}
			}

		}

		String command = commandWords[0].toLowerCase();
		if (command.equals(name) || command.equals(shortcut))
			return this;
		return null;
	}

}
