package com.qa.swampgame;

import java.util.Scanner;

public class Utils {
	public static String input() {
		Directions choice = null;
		String currentInput;
		Scanner scanner = new Scanner(System.in);

		while (choice == null) {
			currentInput = scanner.nextLine().toUpperCase();
			if ((currentInput.equals("NORTH")) || currentInput.equals("N")) {
				choice = Directions.NORTH;
			} else if ((currentInput.equals("SOUTH")) || currentInput.equals("S")) {
				choice = Directions.SOUTH;
			} else if ((currentInput.equals("EAST")) || currentInput.equals("E")) {
				choice = Directions.EAST;
			} else if ((currentInput.equals("WEST")) || currentInput.equals("W")) {
				choice = Directions.WEST;
			} else {
				System.out.println("Please enter either 'north', 'south', 'east' or 'west'");
			}
		}
		return choice.getCoOrdChange();
	}
}