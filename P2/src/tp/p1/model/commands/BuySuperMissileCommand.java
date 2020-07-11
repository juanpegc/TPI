package tp.p1.model.commands;

import exceptions.CommandExecuteException;
import exceptions.NotEnoughPointsException;
import tp.p1.Game;

public class BuySuperMissileCommand extends Command{

	public BuySuperMissileCommand() {
		super("supermissile", "sm", "SuperMissile", "Buy a SuperMissile");
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException{
		try {
			game.buySuperMissile();
			return true;
		}catch(NotEnoughPointsException e) {
			throw new CommandExecuteException("Cannot fire supermissile" + e.getMessage());
		}
	}

	@Override
	public Command parse(String[] commandWords) {
		if(matchCommandName(commandWords[0])) return this;
		return null;
	}
	
}
