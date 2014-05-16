package com.mlb.qa.atb.model.game;

import com.mlb.qa.common.exception.TestRuntimeException;

public enum GameStatus {
	FINAL("Final"),
	POSTPONED("Postponed"),
	SCHEDULED("Scheduled"),
	IN_PROGRESS("In Progress"), 
	OTHER("Other");

	private String statusText;

	private GameStatus(String statusText) {
		this.statusText = statusText;
	}

	public String getStatusText() {
		return this.statusText;
	}

	public static GameStatus getByStatusText(String statusText) {
		for (GameStatus value : values()) {
			if (value.getStatusText().equals(statusText)) {
				return value;
			}
		}
		if (statusText != null) {
			if (statusText.matches("Bot .*") || statusText.matches("Top .*") || statusText.matches("End .*")
					|| statusText.matches("Mid .*") || statusText.matches("Warmup")) {
				return IN_PROGRESS;
			}
			else if (statusText.equalsIgnoreCase("Game Over")) {
				return FINAL;
			}
			else if (statusText.equalsIgnoreCase("Delayed Start") || statusText.matches("Pre-Game")) {
				return SCHEDULED;
			}
		}
		return OTHER;
		//throw new TestRuntimeException(String.format("No GameStatus found for the value %s", statusText));
	}
}
