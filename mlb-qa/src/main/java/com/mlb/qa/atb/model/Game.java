package com.mlb.qa.atb.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "row")
@XmlAccessorType(XmlAccessType.NONE)
public class Game implements Item {
	public static final String GAME_TIME_LOCAL_FORMAT_PATTERN = "MM/dd/yyyy hh:mm:ss a";
	public static final String GAME_STATUS_SCHEDULED = "Scheduled";

	@XmlAttribute(name = "game_id")
	private String gameId;
	@XmlAttribute(name = "game_time_local")
	private String gameTimeLocal;
	@XmlAttribute(name = "game_status_text", required = false)
	private String gameStatus;
	@XmlAttribute(name = "home_team_id")
	private String homeTeamId;
	@XmlAttribute(name = "home_team_full")
	private String homeTeamFull;
	@XmlAttribute(name = "home_team_brief", required = false)
	private String homeTeamBrief;
	@XmlAttribute(name = "home_score", required = false)
	private String homeTeamScore;
	@XmlAttribute(name = "home_result", required = false)
	private String homeResult;
	@XmlAttribute(name = "venue_id")
	private String venueId;
	@XmlAttribute(name = "venue")
	private String venue;
	@XmlAttribute(name = "venue_short")
	private String venueShort;
	@XmlAttribute(name = "away_team_id")
	private String awayTeamId;
	@XmlAttribute(name = "away_team_full")
	private String awayTeamFull;
	@XmlAttribute(name = "away_team_brief", required = false)
	private String awayTeamBrief;
	@XmlAttribute(name = "away_score", required = false)
	private String awayTeamScore;
	@XmlAttribute(name = "away_result", required = false)
	private String awayResult;

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
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

	public String getVenueShort() {
		return venueShort;
	}

	public void setVenueShort(String venueShort) {
		this.venueShort = venueShort;
	}

	public String getHomeTeamScore() {
		return homeTeamScore;
	}

	public void setHomeTeamScore(String homeTeamScore) {
		this.homeTeamScore = homeTeamScore;
	}

	public String getAwayTeamScore() {
		return awayTeamScore;
	}

	public void setAwayTeamScore(String awayTeamScore) {
		this.awayTeamScore = awayTeamScore;
	}

	public String getHomeResult() {
		return homeResult;
	}

	public void setHomeResult(String homeResult) {
		this.homeResult = homeResult;
	}

	public String getAwayResult() {
		return awayResult;
	}

	public void setAwayResult(String awayResult) {
		this.awayResult = awayResult;
	}

	public String getHomeTeamBrief() {
		return homeTeamBrief;
	}

	public void setHomeTeamBrief(String homeTeamBrief) {
		this.homeTeamBrief = homeTeamBrief;
	}

	public String getAwayTeamBrief() {
		return awayTeamBrief;
	}

	public void setAwayTeamBrief(String awayTeamBrief) {
		this.awayTeamBrief = awayTeamBrief;
	}

	public String getGameStatus() {
		return gameStatus;
	}

	public void setGameStatus(String gameStatus) {
		this.gameStatus = gameStatus;
	}

	@Override
	public String toString() {
		return "Game [gameId=" + gameId + ", gameTimeLocal=" + gameTimeLocal + ", gameStatus=" + gameStatus
				+ ", homeTeamId=" + homeTeamId + ", homeTeamFull=" + homeTeamFull + ", homeTeamBrief=" + homeTeamBrief
				+ ", homeTeamScore=" + homeTeamScore + ", homeResult=" + homeResult
				+ ", venueId=" + venueId + ", venue=" + venue + ", venueShort=" + venueShort + ", awayTeamId="
				+ awayTeamId + ", awayTeamFull=" + awayTeamFull + ", awayTeamBrief=" + awayTeamBrief
				+ ", awayTeamScore=" + awayTeamScore + ", awayResult=" + awayResult
				+ "]";
	}
}
