package tp.p1.model.commands;

import tp.p1.Game;

public class BuySuperMissileCommand extends Command{

	public BuySuperMissileCommand() {
		super("supermissile", "sm", "SuperMissile", "Buy a SuperMissile");
	}

	@Override
	public boolean execute(Game game) {
		return game.buySupermissile();
	}

	@Override
	public Command parse(String[] commandWords) {
		if(matchCommandName(commandWords[0])) return this;
		return null;
	}
	
}
