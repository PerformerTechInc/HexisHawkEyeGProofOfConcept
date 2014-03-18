package com.mlb.qa.android.atb.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.mlb.qa.android.atb.service.lookup.LookupItem;

@XmlRootElement(name = "row")
@XmlAccessorType(XmlAccessType.NONE)
public class Game implements LookupItem {
	@XmlAttribute(name = "game_id")
	private String gameId;
	@XmlAttribute(name = "game_date")
	private String gameDate;
	@XmlAttribute(name = "game_time_local")
	private String gameTimeLocal;
	@XmlAttribute(name = "home_team_id")
	private String homeTeamId;
	@XmlAttribute(name = "home_team_full")
	private String homeTeamFull;
	@XmlAttribute(name = "venue_id")
	private String venueId;
	@XmlAttribute(name = "venue")
	private String venue;
	@XmlAttribute(name = "away_team_id")
	private String awayTeamId;
	@XmlAttribute(name = "away_team_full")
	private String awayTeamFull;

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public String getGameDate() {
		return gameDate;
	}

	public void setGameDate(String gameDate) {
		this.gameDate = gameDate;
	}

	public String getGameTimeLocal() {
		return gameTimeLocal;
	}

	public void setGameTimeLocal(String gameTimeLocal) {
		this.gameTimeLocal = gameTimeLocal;
	}

	public String getHomeTeamId() {
		return homeTeamId;
	}

	public void setHomeTeamId(String homeTeamId) {
		this.homeTeamId = homeTeamId;
	}

	public String getHomeTeamFull() {
		return homeTeamFull;
	}

	public void setHomeTeamFull(String homeTeamFull) {
		this.homeTeamFull = homeTeamFull;
	}

	public String getVenueId() {
		return venueId;
	}

	public void setVenueId(String venueId) {
		this.venueId = venueId;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getAwayTeamId() {
		return awayTeamId;
	}

	public void setAwayTeamId(String awayTeamId) {
		this.awayTeamId = awayTeamId;
	}

	public String getAwayTeamFull() {
		return awayTeamFull;
	}

	public void setAwayTeamFull(String awayTeamFull) {
		this.awayTeamFull = awayTeamFull;
	}

	@Override
	public String toString() {
		return "Game [gameId=" + gameId + ", gameDate=" + gameDate
				+ ", gameTimeLocal=" + gameTimeLocal + ", homeTeamId="
				+ homeTeamId + ", homeTeamFull=" + homeTeamFull + ", venueId="
				+ venueId + ", venue=" + venue + ", awayTeamId=" + awayTeamId
				+ ", awayTeamFull=" + awayTeamFull + "]";
	}
}
