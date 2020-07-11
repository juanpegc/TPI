package tp.p1.model.commands;

import exceptions.CommandParseException;

public class CommandGenerator {
	
	private static Command[] availableCommands = {
			new ListCommand(),
			new HelpCommand(),
			new ResetCommand(),
			new ExitCommand(),
			new UpdateCommand(),
			new MoveCommand(),
			new ShockwaveCommand(),
			new ShootCommand(),
			new BuySuperMissileCommand(),
			new StringifyCommand(),
			new ListPrintersCommand(),
			new SaveCommand(),
			new LoadCommand()
			};
	
	public static Command parseCommand(String[] commandWords) throws CommandParseException{
		int i = 0;
		Command command = null;
		while(command == null && i < availableCommands.length) {
			command = availableCommands[i].parse(commandWords);
			i++;
		}
		if(command == null) throw new CommandParseException("Unknown command");
		return command;
	}
	
	public static String commandHelp() {
		String help = "";
		for(int i = 0; i < availableCommands.length; i++) {
			help += availableCommands[i].helpText();
		}
		return help;
	}
	
}
