package com.mlb.qa.at_bat.model.standings;

import com.mlb.qa.common.exception.TestRuntimeException;

public enum Season {
	REGULAR_SEASON("divisional"),
	WILD_CARD("wildcard"),
	SPRING_TRAINING("spring");
	
	private String seasonText;
	
	private Season(String seasonText) {
		this.seasonText = seasonText;
	}

	public String getSeasonText() {
		return this.seasonText;
	}
	
	public static Season getSeasonEnum(String seasonText) {
		for (Season season: values()) {
			if (season.getSeasonText().equalsIgnoreCase(seasonText)) {
				return season;
			}
		}
		throw new TestRuntimeException(String.format("Season Mode is not Found: %s", seasonText));
	}
}
