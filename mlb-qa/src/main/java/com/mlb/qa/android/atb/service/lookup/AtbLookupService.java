package com.mlb.qa.android.atb.service.lookup;

import java.io.IOException;
import java.util.List;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;

import com.mlb.qa.android.atb.model.Game;
import com.mlb.qa.android.atb.model.Team;
import com.mlb.qa.android.atb.service.http.HttpHelper;
import com.mlb.qa.android.atb.service.http.HttpResult;
import com.mlb.qa.android.atb.utils.AtbParameter;
import com.mlb.qa.android.atb.utils.DateUtils;

/**
 * Lookup service<br>
 */
public class AtbLookupService {
	private static final Logger logger = Logger
			.getLogger(AtbLookupService.class);

	// queries
	public static final String INCOMING_GAMES_BY_TEAM_ID_QUERY = "named.schedule_vw_complete.bam?schedule_vw_complete.col_in=game_id&schedule_vw_complete.col_in=game_date&schedule_vw_complete.col_in=game_time_local&schedule_vw_complete.col_in=home_team_id&schedule_vw_complete.col_in=home_team_full&schedule_vw_complete.col_in=venue_id&schedule_vw_complete.col_in=venue&schedule_vw_complete.col_in=venue_short&schedule_vw_complete.col_in=away_team_id&schedule_vw_complete.col_in=away_team_full&team_id=%s&end_date=%s&start_date=%s&venue_id=%s&sort_order=asc&season=%s&game_type='W'&game_type='F'&game_type='D'&game_type='R'&game_type='L'&game_type='A'&schedule_vw_complete.recPP=1&schedule_vw_complete.recSP=1";
	public static final String TEAM_BY_ABBREV_QUERY = "named.team_all_season.bam?team_all_season.col_in=venue_id&team_all_season.col_in=name_display_full&team_all_season.col_in=team_id&team_all_season.col_in=name&team_all_season.col_in=name_short&team_all_season.col_in=name_abbrev&team_all_season.col_in=city&team_all_season.col_in=venue_name&name_abbrev='%s'&season=%s&sport_id=1";
	// date formats
	public static final String LOOKUP_INPUT_DATE_FORMAT = "yyyyMMdd";

	private static final String QUERYNG_RESULT_RESPONSE_REGEXP = ".*<queryResults.*</queryResults>.*";

	/**
	 * * Lookup for the game by home team id and return the first found
	 * 
	 * @param teamId
	 * @param venueId
	 * @param startDate
	 * @param endDate
	 * @param season
	 * @return
	 * @throws IOException
	 * @throws IllegalStateException
	 */
	public Game lookupNearestIncomingHomeGame(String teamId, String venueId,
			DateTime startDate, DateTime endDate, String season) {
		logger.info(String
				.format("Lookup for the nearest incoming game by team id '%s' and venue id '%s' for the season '%s' and return first found. Start/end dates: %s/%s",
						teamId, venueId, season, startDate, endDate));
		String getQueryRequest = AtbParameter.MLB_ATB_LOOKUP_SERVICE.getValue()
				+ String.format(INCOMING_GAMES_BY_TEAM_ID_QUERY, teamId,
						DateUtils.dateToString(endDate,
								LOOKUP_INPUT_DATE_FORMAT), DateUtils
								.dateToString(startDate,
										LOOKUP_INPUT_DATE_FORMAT), venueId,
						season);
		//logger.info(String.format("Request: %s", getQueryRequest));
		HttpResult result = HttpHelper.executeGet(getQueryRequest,
				HttpHelper.UTF_8_CHARSET);
		//logger.info(String.format("Result: %s", result));
		HttpHelper.checkResult(result, HttpStatus.SC_OK,
				QUERYNG_RESULT_RESPONSE_REGEXP);
		List<Game> games = LookupHelper.unmarshal(Game.class,
				result.getResponseBody());
		if (games.size() == 0) {
			throw new LookupException(
					"No incoming games found for specified parameters");
		}
		return games.get(0);
	}

	/**
	 * Lookup for the teams by @params
	 * 
	 * @param abbrev
	 * @param season
	 * @return first found team
	 * @throws IOException
	 * @throws IllegalStateException
	 */
	public Team lookupTeamByAbbrev(String abbrev, String season) {
		logger.info(String
				.format("Lookup for the teams by abbrev '%s' for the season '%s' and return first found",
						abbrev, season));
		String request = AtbParameter.MLB_ATB_LOOKUP_SERVICE.getValue()
				+ String.format(TEAM_BY_ABBREV_QUERY, abbrev, season);
		//logger.info(String.format("Request: %s", request));
		HttpResult result = HttpHelper.executeGet(request,
				HttpHelper.UTF_8_CHARSET);
		//logger.info(String.format("Result: %s", result));
		HttpHelper.checkResult(result, HttpStatus.SC_OK,
				QUERYNG_RESULT_RESPONSE_REGEXP);
		List<Team> teams = LookupHelper.unmarshal(Team.class,
				result.getResponseBody());
		if (teams.size() == 0) {
			throw new LookupException(String.format(
					"No teams by abbrev '%s' for the season '%s' found",
					abbrev, season));
		}
		return teams.get(0);
	}
}
