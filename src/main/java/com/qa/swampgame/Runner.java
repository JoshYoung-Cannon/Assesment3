package com.qa.swampgame;

public class Runner {
	public static void main(String[] args) {
		GameplayLoop game = new GameplayLoop(true);
		System.out.println("Starting Game!");
		game.gameplay();
	}
}
