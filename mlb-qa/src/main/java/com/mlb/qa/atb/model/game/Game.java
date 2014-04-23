package com.mlb.qa.atb.model.game;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.joda.time.DateTime;

import com.mlb.qa.atb.model.Item;
import com.mlb.qa.atb.model.game.adapter.GameDateAdapter;
import com.mlb.qa.atb.model.game.adapter.GameStatusAdapter;
import com.mlb.qa.atb.model.game.adapter.GameTimeGmtAdapter;
import com.mlb.qa.atb.model.game.adapter.GameTimeLocalAdapter;

@XmlRootElement(name = "row")
@XmlAccessorType(XmlAccessType.NONE)
public class Game implements Item {

	public static final String GAME_TIME_LOCAL_FORMAT_PATTERN = "MM/dd/yyyy hh:mm:ss a";
	public static final String GAME_TIME_GMT_FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ssZ";
	public static final String GAME_DATE_FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss";

	@XmlAttribute(name = "game_id")
	private String gameId;
	@XmlAttribute(name = "game_date", required = false)
	@XmlJavaTypeAdapter(value = GameDateAdapter.class)
	private DateTime gameDate;
	@XmlAttribute(name = "game_time_local")
	@XmlJavaTypeAdapter(value = GameTimeLocalAdapter.class)
	private DateTime gameTimeLocal;
	@XmlAttribute(name = "game_time_gmt", required = false)
	@XmlJavaTypeAdapter(value = GameTimeGmtAdapter.class)
	private DateTime gameTimeGmt;
	@XmlAttribute(name = "game_status_text", required = false)
	@XmlJavaTypeAdapter(value = GameStatusAdapter.class)
	private GameStatus gameStatus;
	@XmlAttribute(name = "home_team_id")
	private String homeTeamId;
	@XmlAttribute(name = "home_team_full")
	private String homeTeamFull;
	@XmlAttribute(name = "home_team_brief", required = false)
	private String homeTeamBrief;
	@XmlAttribute(name = "home_team_abbrev", required = false)
	private String homeTeamAbbrev;
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
	@XmlAttribute(name = "away_team_abbrev", required = false)
	private String awayTeamAbbrev;
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

	public DateTime getGameTimeLocal() {
		return gameTimeLocal;
	}

	public void setGameTimeLocal(DateTime gameTimeLocal) {
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

	public GameStatus getGameStatus() {
		return gameStatus;
	}

	public void setGameStatus(GameStatus gameStatus) {
		this.gameStatus = gameStatus;
	}

	public String getHomeTeamAbbrev() {
		return homeTeamAbbrev;
	}

	public void setHomeTeamAbbrev(String homeTeamAbbrev) {
		this.homeTeamAbbrev = homeTeamAbbrev;
	}

	public String getAwayTeamAbbrev() {
		return awayTeamAbbrev;
	}

	public void setAwayTeamAbbrev(String awayTeamAbbrev) {
		this.awayTeamAbbrev = awayTeamAbbrev;
	}

	public DateTime getGameTimeGmt() {
		return gameTimeGmt;
	}

	public void setGameTimeGmt(DateTime gameTimeGmt) {
		this.gameTimeGmt = gameTimeGmt;
	}

	public DateTime getGameDate() {
		return gameDate;
	}

	public void setGameDate(DateTime gameDate) {
		this.gameDate = gameDate;
	}

	@Override
	public String toString() {
		return "Game [gameId=" + gameId + ", gameDate=" + gameDate + ", gameTimeLocal=" + gameTimeLocal
				+ ", gameTimeGmt=" + gameTimeGmt + ", gameStatus=" + gameStatus + ", homeTeamId=" + homeTeamId
				+ ", homeTeamFull=" + homeTeamFull + ", homeTeamBrief=" + homeTeamBrief + ", homeTeamAbbrev="
				+ homeTeamAbbrev + ", homeTeamScore=" + homeTeamScore + ", homeResult=" + homeResult + ", venueId="
				+ venueId + ", venue=" + venue + ", venueShort=" + venueShort + ", awayTeamId=" + awayTeamId
				+ ", awayTeamFull=" + awayTeamFull + ", awayTeamBrief=" + awayTeamBrief + ", awayTeamAbbrev="
				+ awayTeamAbbrev + ", awayTeamScore=" + awayTeamScore + ", awayResult=" + awayResult + "]";
	}

}
