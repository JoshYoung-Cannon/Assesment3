package com.qa.swampgame;

public enum Directions {
	NORTH ("0,-1"),
	EAST ("-1,0"),
	SOUTH ("0,1"),
	WEST ("1,0");
	
	private String coOrdChange;

	/**
	 * Enum of cardinal directions the player can make.
	 * coOrdChange is a string which holds details of how the players relative coordinate position has changed
	 * @param coOrdChange
	 */
	
	private Directions(String coOrdChange) {
		this.coOrdChange = coOrdChange;
	}

	public String getCoOrdChange() {
		return coOrdChange;
	}
	
}