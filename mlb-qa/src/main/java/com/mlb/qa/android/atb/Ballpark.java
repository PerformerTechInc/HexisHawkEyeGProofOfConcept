package com.mlb.qa.android.atb;

/**
 * Ballpark bean
 */
public class Ballpark {
	private String name;
	private String teamName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	@Override
	public String toString() {
		return "Ballpark [name=" + name + ", teamName=" + teamName + "]";
	}

}