package tp.p1.controller;

import java.util.Scanner;

import tp.p1.Game;
import tp.p1.model.FormattedPrinter;
import tp.p1.model.commands.Command;
import tp.p1.model.commands.CommandGenerator;

public class Controller {
	private Scanner sc;
	private Game game;
	private static final String PROMPT  = "Command >";
	private static final String unknownCommandMsg = "Invalid command.";
	
	public Controller(Scanner sc, Game game) {
		this.sc = sc;
		this.game = game;
	}

	public void run() {
		while (!game.isFinished()) {
			printGame();
			System.out.print(PROMPT);
			String[] words = sc.nextLine().toLowerCase().trim().split("\\s+");
			Command command = CommandGenerator.parseCommand(words);
			if (command != null) {
				if (command.execute(game)) {
					game.update();
				}
			} else {
				System.out.format(unknownCommandMsg);
			}
		}
	}
	
	public void printGame() {
		FormattedPrinter printer = new FormattedPrinter();
		System.out.println(printer.toString(game));
	}

}
