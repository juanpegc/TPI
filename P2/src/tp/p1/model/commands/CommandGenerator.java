package tp.p1.model.commands;

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
			new BuySuperMissileCommand()
			};
	
	public static Command parseCommand(String[] commandWords) {
		int i = 0;
		Command command = null;
		while(command == null && i < availableCommands.length) {
			command = availableCommands[i].parse(commandWords);
			i++;
		}
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
