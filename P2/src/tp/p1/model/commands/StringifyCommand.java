package tp.p1.model.commands;

import tp.p1.Game;
import tp.p1.model.Stringifier;

public class StringifyCommand extends Command{

	public StringifyCommand() {
		super("stringify", "st", "Stringify", "Prints the game as plain text");
	}

	@Override
	public boolean execute(Game game) {
		Stringifier printer = new Stringifier();
		System.out.println(printer.toString(game));
		return true;
	}

	@Override
	public Command parse(String[] commandWords) {
		if (matchCommandName(commandWords[0]))
			return this;
		return null;
	}

}
