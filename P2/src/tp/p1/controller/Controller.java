package tp.p1.controller;

import java.util.Scanner;

import exceptions.CommandExecuteException;
import exceptions.CommandParseException;
import tp.p1.Game;
import tp.p1.model.FormattedPrinter;
import tp.p1.model.commands.Command;
import tp.p1.model.commands.CommandGenerator;

public class Controller {
	private Scanner sc;
	private Game game;
	private final String PROMPT = "Command >";
	private FormattedPrinter printer;

	public Controller(Scanner sc, Game game) {
		this.sc = sc;
		this.game = game;
	}

	public void run() {
		while (!game.isFinished()) {
			printGame();
			System.out.print(PROMPT);
			String[] words = sc.nextLine().toLowerCase().trim().split("\\s+");
			try {
				Command command = CommandGenerator.parseCommand(words);
				if (command.execute(game))
					game.update();
			} catch (CommandParseException | CommandExecuteException e) {
				System.out.println(e.getMessage() + "\n\n");
			}
		}
		System.out.println(printer.toString(game));
	}

	public void printGame() {
		printer = new FormattedPrinter();
		System.out.println(printer.toString(game));
	}

}
