package tp.p1.model.commands;

import exceptions.CommandExecuteException;
import exceptions.MissileInFlightException;
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
	public boolean execute(Game game) throws CommandExecuteException {
		try {
			if (!superMissile)
				game.shootMissile();
			else {
				game.shootSuperMissile();
			}
			return true;
		} catch (MissileInFlightException e) {
			throw new CommandExecuteException("Cannot fire missile" + e.getMessage());
		}
	}

	@Override
	public Command parse(String[] commandWords){
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
		return null;
	}

}
