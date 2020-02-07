package com.qa.swampgame;

public class PointOfInterest {
	private Integer x = null, y = null;
	private int startMin, startMax, z, scale = 1000;
	private int[] distance = {0,0};
	private String nameOfInterest;

	/**
	 * PointOfInterest holds the name, distance (z) and coordinates of a goal
	 * relative to a player. The startMin/Max values represent how many digits the
	 * starting x/y values can be be, e.g. min 1 max 1 => x/y range: 1 to 9, min 2
	 * max 3 => x/y range: 10 to 999, min 1 max 5 => x/y range: 1 to 99999
	 * 
	 * @param nameOfInterest
	 * @param startXMin
	 * @param startYMin
	 * @param startXMax
	 * @param startYMax
	 */

	public PointOfInterest(String nameOfInterest, int startMin, int startMax) {
		super();
		this.startMin = startMin;
		this.startMax = startMax;
		this.nameOfInterest = nameOfInterest;

		startMin = 1;
		startMax = 1;
		for (int i = 0; i < this.startMin; i++) {
			startMin = startMin * 10;
		}
		for (int i = 0; i < this.startMax; i++) {
			startMax = startMax * 10;
		}

		int randVal;
		while ((this.x == null) || (this.y == null)) {
			while (this.x == null) {
				randVal = (int) (Math.random() * startMax);
				if (((randVal / startMin) != 0) || (this.startMin == this.startMax)) {
					if (((int) (Math.random() * 100)) % 2 == 0) {
						this.x = randVal;
					} else {
						this.x = 0 - randVal;
					}
				}
			}
			while (this.y == null) {
				randVal = (int) (Math.random() * startMax);
				if (((randVal / startMin) != 0) || (this.startMin == this.startMax)) {
					if (((int) (Math.random() * 100)) % 2 == 0) {
						this.y = randVal;
					} else {
						this.y = 0 - randVal;
					}
				}
			}
		}

	}

	public int getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x += x;
	}

	public int getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y += y;
	}

	public int getZ() {
		/**
		 * getZ() returns the distance between the player and the goal based on scale
		 * 
		 * @return
		 */
		z = (int) (Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2)) * this.scale);
		return z;
	}

	public int getScale() {
		/**
		 * scale decides the number of decimals in the converted output from z e.g.
		 * scale set to 1000: z returns 1234mm converted out = 1.234m
		 */
		return scale;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}

	public int getDistance(int wholeOrDecimal) {
		/**
		 * converts z into a decimal output based on scale
		 */
		distance[0] = this.z / this.scale;
		distance[1] = this.z % this.scale;
		if (wholeOrDecimal == 0) {
			return distance[0];
		} else {
			return distance[1];
		}
	}

	public String getNameOfInterest() {
		return nameOfInterest;
	}

}
