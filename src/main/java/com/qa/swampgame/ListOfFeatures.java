package com.qa.swampgame;

public enum ListOfFeatures {
	TREASURECHEST ("Treasure Chest"),
	AWAYOUT ("A way out of the Swamp");
	
	private String featureName;

	private ListOfFeatures(String featureName) {
		this.featureName = featureName;
	}

	public String getFeatureName() {
		return featureName;
	}
	
	
}
