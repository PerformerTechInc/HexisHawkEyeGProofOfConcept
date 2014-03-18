package com.mlb.qa.android.atb.model;

import com.mlb.qa.android.atb.service.lookup.LookupItem;

/**
 * Ballpark bean<br>
 */
public class Ballpark implements LookupItem{
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
