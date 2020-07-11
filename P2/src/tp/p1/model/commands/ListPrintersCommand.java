package tp.p1.model.commands;

import tp.p1.Game;
import tp.p1.model.PrinterTypes;

public class ListPrintersCommand extends Command{

	public ListPrintersCommand() {
		super("listPrinters", "lp", "ListPrinters", "Show the list of printers");
	}

	@Override
	public boolean execute(Game game) {
		System.out.println(PrinterTypes.printerHelp(game));
		return false;
	}

	@Override
	public Command parse(String[] commandWords) {
		if (matchCommandName(commandWords[0]))
			return this;
		return null;
	}

}
