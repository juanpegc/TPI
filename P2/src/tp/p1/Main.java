package tp.p1;

import java.util.Random;
import java.util.Scanner;

import tp.p1.controller.Controller;

public class Main {

	
	public static void main(String[] args) {
		String levelName = "";
		Random seed;
		Level level = Level.EASY;
		int menuOption;
		Scanner scanner = new Scanner(System.in);
		Game game;
		Controller controller;

		try {
			levelName = args[0];
			seed = new Random(Integer.parseInt(args[1]));
		} catch (NumberFormatException e) {
			System.out.println("(Introduced seed not valid)");
			seed = new Random((int) System.currentTimeMillis());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("(Missing arguments)");
			seed = new Random((int) System.currentTimeMillis());
		}

		if (!levelName.equals("")) {
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
					if (levelName.toUpperCase().equals("HARD"))
						level = Level.HARD;
					else if (levelName.toUpperCase().equals("INSANE"))
						level = Level.INSANE;
					else if(levelName.toUpperCase().equals("EASY"))
						level = Level.EASY;
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
