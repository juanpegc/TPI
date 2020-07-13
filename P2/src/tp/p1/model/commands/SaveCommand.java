package tp.p1.model.commands;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import exceptions.CommandExecuteException;
import exceptions.CommandParseException;
import tp.p1.Game;
import tp.p1.model.Stringifier;

public class SaveCommand extends Command {

	public SaveCommand() {
		super("save", "sv", "Save", "Save game in a file");
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		String fileName;
		Scanner sc = new Scanner(System.in);
		System.out.print("Write the file name: ");
		fileName = sc.nextLine() + ".dat";
		try {
			FileWriter file = new FileWriter(fileName);
			BufferedWriter bw = new BufferedWriter(file);
			Stringifier printer = new Stringifier();
			bw.write(printer.toString(game));
			System.out.println("Game successfully saved in file " + fileName + ". Use the load command to reload it");
			bw.close();
		} catch (IOException e) {
			throw new CommandExecuteException("Cannot save the game state: There was a problem with the file");
		}

		return true;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		if (matchCommandName(commandWords[0]))
			return this;
		return null;
	}

}
