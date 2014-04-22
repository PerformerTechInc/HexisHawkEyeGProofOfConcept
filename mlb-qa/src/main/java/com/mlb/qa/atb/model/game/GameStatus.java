package com.mlb.qa.atb.model.game;

import com.mlb.qa.common.exception.TestRuntimeException;

public enum GameStatus {
	FINAL("Final"),
	POSTPONED("Postponed"),
	SCHEDULED("Scheduled"),
	DELAYED_START("Delayed Start"),
	
	;

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
		throw new TestRuntimeException(String.format("No GameStatus found for the value %s", statusText));
	}
}
