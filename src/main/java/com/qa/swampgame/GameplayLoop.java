package com.qa.swampgame;

public class GameplayLoop {
	private boolean playing;
	private String intro;

	public GameplayLoop(boolean playing) {
		super();
		this.playing = playing;
		this.intro = "You are in a flat infinite grey swamp! You can move 'north', 'south', 'east' and 'west'. You have a small dial telling you a distance, what could it mean?";
	}

	public boolean isPlaying() {
		return playing;
	}

	public void setPlaying(boolean playing) {
		this.playing = playing;
	}

	public void gameplay() {
		String movementString;
		int[] movementInt = {0,0};
		PointOfInterest poi = new PointOfInterest(ListOfFeatures.TREASURECHEST.getFeatureName(), 1, 1);
		System.out.println(this.intro);
		while (playing) {
			poi.getZ();
			System.out.println("The dial reads: " + poi.getDistance(0) + "." + poi.getDistance(1) + "m");
			movementString = Utils.input();
			if (movementString.equals(Directions.NORTH.getCoOrdChange())) {
				movementInt[0] = 0;
				movementInt[1] = -1;
			} else if (movementString.equals(Directions.SOUTH.getCoOrdChange())) {
				movementInt[0] = 0;
				movementInt[1] = 1;
			} else if (movementString.equals(Directions.EAST.getCoOrdChange())) {
				movementInt[0] = -1;
				movementInt[1] = 0;
			} else if (movementString.equals(Directions.WEST.getCoOrdChange())) {
				movementInt[0] = 1;
				movementInt[1] = 0;
			}
			poi.setX(movementInt[0]);
			poi.setY(movementInt[1]);
			if (poi.getZ() == 0) {
				playing = false;
			}
		}
		System.out.println("You see a " + poi.getNameOfInterest() + "! Congratulations you WIN!");
	}
}
