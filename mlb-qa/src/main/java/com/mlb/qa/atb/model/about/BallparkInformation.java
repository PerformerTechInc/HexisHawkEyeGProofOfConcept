package com.mlb.qa.atb.model.about;

public class BallparkInformation {

	private String ballparkTextDescription;

	public String getBallparkTextDescription() {
		return ballparkTextDescription;
	}

	public void setBallparkTextDescription(String ballparkTextDescription) {
		this.ballparkTextDescription = ballparkTextDescription;
	}

	@Override
	public String toString() {
		return "BallparkInformation [ballparkTextDescription=" + ballparkTextDescription + "]";
	}
}
