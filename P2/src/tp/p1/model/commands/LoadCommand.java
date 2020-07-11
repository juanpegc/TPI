package tp.p1.model.commands;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import exceptions.CommandExecuteException;
import exceptions.CommandParseException;
import exceptions.FileContentsException;
import tp.p1.Game;

public class LoadCommand extends Command {

	public LoadCommand() {
		super("load", "ld", "Load", "Load game from file");
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		String fileName;
		Scanner sc = new Scanner(System.in);
		System.out.println("Write the file name: ");
		fileName = sc.nextLine() + ".dat";
		try {
			FileReader file = new FileReader(fileName);
			BufferedReader br = new BufferedReader(file);
			if (br.readLine().equals("— Space Invaders v2.0 —") && br.readLine().equals("")) {
				game.load(br);
				br.close();
			} else {
				br.close();
				throw new CommandExecuteException("Cannot load the game: The file is incorrect");
			}
			System.out.println("Game successfully loaded from file " + fileName);
		} catch (FileNotFoundException e) {
			throw new CommandExecuteException("Cannot load the game: The file couldnt be found");
		} catch (IOException e) {
			throw new CommandExecuteException("Cannot load the game: There was a problem with the file");
		} catch (FileContentsException e) {
			throw new CommandExecuteException("Cannot load the game: " + e.getMessage());
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
