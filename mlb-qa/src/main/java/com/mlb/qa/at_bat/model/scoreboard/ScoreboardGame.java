package com.mlb.qa.at_bat.model.scoreboard;

import javax.xml.bind.annotation.XmlAttribute;

import com.mlb.qa.atb.model.Item;

public class ScoreboardGame implements Item {

	@XmlAttribute(name = "source")
	private String source;
	@XmlAttribute(name = "id")
	private String gameId;
	@XmlAttribute(name = "venue")
	private String venueName;
	@XmlAttribute(name = "game_pk")
	private String gamepk;
	@XmlAttribute(name = "time")
	private String gameTime;
	@XmlAttribute(name = "time_date")
	private String gameTimeDate;
//	@XmlAttribute(name = "time_date_aw_lg")
//	private String gameTimeDateAwLg;
//	@XmlAttribute(name = "time_date_hm_lg")
//	private String gameTimeDateHmLg;
	@XmlAttribute(name = "time_zone")
	private String timeZone;
	@XmlAttribute(name = "ampm")
	private String gameAmPm;
	@XmlAttribute(name = "first_pitch_et")
	private String gameFirstPitch;
	@XmlAttribute(name = "away_time")
	private String gameAwayTime;
	@XmlAttribute(name = "away_time_zone")
	private String gameAwayTimeZone;
	@XmlAttribute(name = "away_ampm")
	private String gameAwayAmPm;
	@XmlAttribute(name = "home_time")
	private String gameHomeTime;
	@XmlAttribute(name = "home_time_zone")
	private String gameHomeTimeZone;
	@XmlAttribute(name = "home_ampm")
	private String gameHomeAmPm;
	@XmlAttribute(name = "game_type")
	private String gameType;
	@XmlAttribute(name = "tiebreaker_sw")
	private String gameTieBreaker;
	@XmlAttribute(name = "resume_date")
	private String gameResumeDate;
	@XmlAttribute(name = "original_date")
	private String gameOriginalDate;
//	@XmlAttribute(name = "time_zone_aw_lg")
//	private String gameAwayTimeZoneLG;
//	@XmlAttribute(name = "time_zone_hm_lg")
//	private String gameHomeTimeZoneLG;
//	@XmlAttribute(name = "time_aw_lg")
//	private String gameAwayTimeLG;
//	@XmlAttribute(name = "aw_lg_ampm")
//	private String gameAwayAmPmLG;
//	@XmlAttribute(name = "tz_aw_lg_gen")
//	private String gameAwayTimeZoneLGGen;
//	@XmlAttribute(name = "time_hm_lg")
//	private String gameHomeTimeLG;
//	@XmlAttribute(name = "hm_lg_ampm")
//	private String gameHomeAmPmLG;
//	@XmlAttribute(name = "tz_hm_lg_gen")
//	private String gameHomeTimeZoneLGGen;
	@XmlAttribute(name = "venue_id")
	private String gameVenueId;
	@XmlAttribute(name = "scheduled_innings")
	private String gameScheduledInnings;
	@XmlAttribute(name = "description")
	private String gameDescription;
	@XmlAttribute(name = "away_name_abbrev")
	private String gameAwayTeamNameAbbrev;
	@XmlAttribute(name = "home_name_abbrev")
	private String gameHomeTeamNameAbbrev;
	@XmlAttribute(name = "away_code")
	private String gameAwayTeamCode;
	@XmlAttribute(name = "away_file_code")
	private String gameAwayTeamFileCode;
	@XmlAttribute(name = "away_team_id")
	private String gameAwayTeamId;
	@XmlAttribute(name = "away_team_city")
	private String gameAwayTeamCity;
	@XmlAttribute(name = "away_team_name")
	private String gameAwayTeamName;
	@XmlAttribute(name = "away_division")
	private String gameAwayTeamDivision;
	@XmlAttribute(name = "away_league_id")
	private String gameAwayTeamLeagueId;
	@XmlAttribute(name = "away_sport_code")
	private String gameAwayTeamSportCode;
	@XmlAttribute(name = "home_code")
	private String gameHomeTeamCode;
	@XmlAttribute(name = "home_file_code")
	private String gameHomeTeamFileCode;
	@XmlAttribute(name = "home_team_id")
	private String gameHomeTeamId;
	@XmlAttribute(name = "home_team_city")
	private String gameHomeTeamCity;
	@XmlAttribute(name = "home_team_name")
	private String gameHomeTeamName;
	@XmlAttribute(name = "home_division")
	private String gameHomeTeamDivision;
	@XmlAttribute(name = "home_league_id")
	private String gameHomeTeamLeagueId;
	@XmlAttribute(name = "home_sport_code")
	private String gameHomeTeamSportCode;
	@XmlAttribute(name = "day")
	private String day;
	@XmlAttribute(name = "gameday_sw")
	private String gamedaySW;
	@XmlAttribute(name = "double_header_sw")
	private String gameDoubleHeaderSW;
	@XmlAttribute(name = "game_nbr")
	private String gameNumber;
	@XmlAttribute(name = "tbd_flag")
	private String gameTBD;
	@XmlAttribute(name = "away_games_back")
	private String gameAwayTeamGamesBack;
	@XmlAttribute(name = "home_games_back")
	private String gameHomeTeamGamesBack;
	@XmlAttribute(name = "away_games_back_wildcard")
	private String gameAwayTeamGamesBackWildCard;
	@XmlAttribute(name = "home_games_back_wildcard")
	private String gameHomeTeamGamesBackWildCard;
	@XmlAttribute(name = "venue_w_chan_loc")
	private String gameVenueLoc;
	@XmlAttribute(name = "gameday")
	private String gameday;
	@XmlAttribute(name = "away_win")
	private String gameAwayWin;
	@XmlAttribute(name = "away_loss")
	private String gameAwayLoss;
	@XmlAttribute(name = "home_win")
	private String gameHomeWin;
	@XmlAttribute(name = "home_loss")
	private String gameHomeLoss;
	@XmlAttribute(name = "game_data_directory")
	private String gameDataDirectory;
	
	@Override
	public String toString() {
		return "ScoreboardGame [id = " + gameId + ", venueName = " + venueName + ", "
				+ "gamepk = " + gamepk + ", gameHomeTeamName = " + gameHomeTeamName + ", "
						+ "gameAwayTeamName = " + gameAwayTeamName + ", gameTime = " + gameTime + ", timeZone = " + timeZone + "]";
	}
}
