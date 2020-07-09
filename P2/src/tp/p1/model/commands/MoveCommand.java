package tp.p1.model.commands;

import tp.p1.Game;
import tp.p1.Move;

public class MoveCommand extends Command {

	private Move move;

	public MoveCommand() {
		super("move", "m", "Move", "Moves UCM-Ship to the indicated direction.");
	}

	public MoveCommand(Move move) {
		super("move", "m", "Move", "Moves UCM-Ship to the indicaten direction.");
		this.move = move;
	}
	
	@Override
	public boolean execute(Game game) {
		game.move(move);
		return true;
	}

	@Override
	public Command parse(String[] commandWords) {
		boolean valid = false;
		if (commandWords.length == 3 && commandWords[0].toLowerCase().equals(name)) {
			String direction = commandWords[1].toLowerCase();
			String lines = commandWords[2].toLowerCase();

			if (direction.equals("left") && lines.equals("1")) {
				move = Move.LEFT;
				valid = true;
			} else if (direction.equals("left") && lines.equals("2")) {
				move = Move.LEFT2;
				valid = true;
			} else if (direction.equals("right") && lines.equals("1")) {
				move = Move.RIGHT;
				valid = true;
			} else if (direction.equals("right") && lines.equals("2")) {
				move = Move.RIGHT2;
				valid = true;
			}
			if(valid) return new MoveCommand(move);
	
		}
		return null;
	}

}
