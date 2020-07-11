package tp.p1;

import java.util.Random;
import java.util.Scanner;

import exceptions.ParametersException;
import tp.p1.controller.Controller;

public class Main {

	public static void main(String[] args) {
		Random seed;
		Level level = null;
		int menuOption;
		Scanner scanner = new Scanner(System.in);
		Game game;
		Controller controller;
		try {
			if (args.length == 0 || args.length > 2)
				throw new ParametersException("");
			level = Level.parse(args[0]);
			if (level == null)
				throw new ParametersException(": level must be one of: EASY, HARD, INSANE");
			try {
				seed = new Random(Integer.parseInt(args[1]));
			} catch (NumberFormatException e) {
				System.out.println("(Introduced seed not valid)");
				seed = new Random((int) System.currentTimeMillis());
			}
		} catch (ParametersException e) {
			System.out.println("Usage: Main <EASY|HARD|INSANE> [seed]" + e.getMessage());
			seed = new Random((int) System.currentTimeMillis());
		}
		
		if (level != null) {
			do {
				showIntro();
				showMenu();
				try {
					menuOption = scanner.nextInt();
				} catch (Exception e) {
					scanner.nextLine();
					menuOption = -1;
				}
				switch (menuOption) {
				case 0:
					System.out.println("Bye!");
					break;
				case 1:
					scanner.nextLine();
					game = new Game(level, seed);
					controller = new Controller(scanner, game);
					controller.run();
					break;

				default:
					System.out.println("Invalid choice.");
					break;
				}
			} while (menuOption != 0);
		}
	}

	private static void showIntro() {
		System.out.println("------------------------------");
		System.out.println("        ##          ##        ");
		System.out.println("          ##      ##          ");
		System.out.println("        ##############        ");
		System.out.println("      ####  ######  ####      ");
		System.out.println("    ######################    ");
		System.out.println("    ##  ##############  ##    ");
		System.out.println("    ##  ##          ##  ##    ");
		System.out.println("          ####  ####          ");
		System.out.println("------------------------------");
		System.out.println("| WELCOME TO SPACE INVADERS! |");
		System.out.println("------------------------------");
	}

	private static void showMenu() {
		System.out.println("0.-Exit.");
		System.out.println("1.-Play.");
	}

}
