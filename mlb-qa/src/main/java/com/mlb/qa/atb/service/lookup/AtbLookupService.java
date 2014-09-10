package com.mlb.qa.atb.service.lookup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.mlb.qa.at_bat.model.news.NewsReaderJson;
import com.mlb.qa.atb.model.schedule_pk.SchedulePk;
import com.mlb.qa.common.utils.JsonUtils;
import com.mlb.qa.common.utils.marshaller.MarshallerHelper;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;

import com.mlb.qa.atb.AtbParameter;
import com.mlb.qa.atb.model.Team;
import com.mlb.qa.atb.model.game.Game;
import com.mlb.qa.common.date.DateUtils;
import com.mlb.qa.common.http.HttpHelper;
import com.mlb.qa.common.http.HttpResult;

/**
 * Lookup service<br>
 */
public class AtbLookupService {
    private static final Logger logger = Logger
            .getLogger(AtbLookupService.class);

    // queries
    public static final String INCOMING_GAME_FOR_SCHEDULE_QUERY = "named.schedule_vw_complete.bam?team_id=%s&season=%s&start_date=%s&end_date=%s&game_type='E'&game_type='S'&game_type='R'&game_type='F'&game_type='D'&game_type='L'&game_type='W'&ovrd_enc=utf-8";

    public static final String INCOMING_GAMES_BY_TEAM_ID_QUERY = "named.schedule_vw_complete.bam?schedule_vw_complete.col_in=game_id&schedule_vw_complete.col_in=game_date&schedule_vw_complete.col_in=game_time_local&schedule_vw_complete.col_in=home_team_id&schedule_vw_complete.col_in=home_team_full&schedule_vw_complete.col_in=venue_id&schedule_vw_complete.col_in=venue&schedule_vw_complete.col_in=venue_short&schedule_vw_complete.col_in=away_team_id&schedule_vw_complete.col_in=away_team_full&team_id=%s&end_date=%s&start_date=%s&venue_id=%s&sort_order=asc&season=%s&game_type='W'&game_type='F'&game_type='D'&game_type='R'&game_type='L'&game_type='A'&schedule_vw_complete.recPP=1&schedule_vw_complete.recSP=1";

    public static final String TEAM_BY_ABBREV_QUERY = "named.team_all_season.bam?team_all_season.col_in=venue_id&team_all_season.col_in=name_display_full&team_all_season.col_in=team_id&team_all_season.col_in=name&team_all_season.col_in=name_short&team_all_season.col_in=name_abbrev&team_all_season.col_in=city&team_all_season.col_in=venue_name&name_abbrev='%s'&season=%s&sport_id=1";

    public static final String SCHEDULE_PK_QUERY = "http://qa.mlb.com/lookup/named.schedule_pk.bam?game_pk=%s";

    private static final String QUERYNG_RESULT_RESPONSE_REGEXP = ".*<queryResults.*</queryResults>.*";

    private static final String TOTAL_NEWS_REQUEST = "http://mlb.mlb.com/gen/hb/list/mlb/newsreader.json";

    private static final String TEAM_NEWS_REQUEST = "http://mlb.mlb.com/gen/hb/list/%s/newsreader.json";

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
                        DateUtils.LOOKUP_INPUT_DATE_FORMAT), DateUtils
                        .dateToString(startDate,
                                DateUtils.LOOKUP_INPUT_DATE_FORMAT), venueId,
                season);
        logger.info(String.format("Request: %s", getQueryRequest));
        HttpResult result = HttpHelper.executeGet(getQueryRequest, new HashMap<String, String>());
        logger.info(String.format("Result: %s", result));
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
        logger.info(String.format("Request: %s", request));
        HttpResult result = HttpHelper.executeGet(request, new HashMap<String, String>());
        logger.info(String.format("Result: %s", result));
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

    public List<Game> lookupListOfGamesForTheMonth(String teamId, Integer year,
                                                   Integer month) {
        logger.info(String.format("Load list of scheduled games' info by team id: %s, year: %s, month: %s", teamId,
                year, month));
        DateTime beginDate = new DateTime(year, month, 1, 0, 0);
        DateTime endDate = beginDate.plusMonths(1).minusDays(1);
        String getQueryRequest = AtbParameter.MLB_ATB_LOOKUP_SERVICE.getValue()
                + String.format(INCOMING_GAME_FOR_SCHEDULE_QUERY, teamId, year.toString(),
                DateUtils.dateToString(beginDate,
                        DateUtils.LOOKUP_INPUT_DATE_FORMAT), DateUtils.dateToString(endDate,
                        DateUtils.LOOKUP_INPUT_DATE_FORMAT));
        logger.info(String.format("Request: %s", getQueryRequest));
        HttpResult result = HttpHelper.executeGet(getQueryRequest, new HashMap<String, String>());
        // logger.info(String.format("Result: %s", result));
        HttpHelper.checkResultOk(result);
        List<Game> games = LookupHelper.unmarshal(Game.class,
                result.getResponseBody());
        logger.info("Found scheduled games: " + games);
        return games;
    }

    public List<Game> lookupListofGamesBetweenDates(String teamId, String year, DateTime d1, DateTime d2) {
        logger.info(String.format("Load list of schedules games for teamid: %s, between dates %s and %s", teamId, d1, d2));
        DateTime beginDate = d1;
        DateTime endDate = d2;
        String getQueryRequest = AtbParameter.MLB_ATB_LOOKUP_SERVICE.getValue()
                + String.format(INCOMING_GAME_FOR_SCHEDULE_QUERY, teamId, year,
                DateUtils.dateToString(beginDate,
                        DateUtils.LOOKUP_INPUT_DATE_FORMAT), DateUtils.dateToString(endDate,
                        DateUtils.LOOKUP_INPUT_DATE_FORMAT));
        logger.info(String.format("Request: %s", getQueryRequest));
        HttpResult result = HttpHelper.executeGet(getQueryRequest, new HashMap<String, String>());
        HttpHelper.checkResultOk(result);
        List<Game> games = LookupHelper.unmarshal(Game.class,
                result.getResponseBody());
        logger.info("Found scheduled games: " + games);
        return games;

    }

    public SchedulePk loadSchedulePk(String gameID) {
        HttpResult httpResult1 = HttpHelper.executeGet(String.format(SCHEDULE_PK_QUERY, gameID), new HashMap<String, String>());
        return MarshallerHelper.unmarshall(httpResult1.getResponseBody(), SchedulePk.class);
    }

    public List<String> getNewsTitles() {
        HttpResult result = HttpHelper.executeGet(TOTAL_NEWS_REQUEST, new HashMap<String, String>());
        NewsReaderJson newsReaderJson = JsonUtils.fromJson(result.getResponseBody(), NewsReaderJson.class);
        List<String> titles = new ArrayList<String>();
        List<com.mlb.qa.at_bat.model.news.List> newsList = newsReaderJson.getList();
        for (com.mlb.qa.at_bat.model.news.List list : newsList) {
            if (list.getType().equals("article")){
                titles.add(list.getHeadline());}
        }
        return titles;
    }
    public List<String> getNewsTitles(String teamName) {
        HttpResult result = HttpHelper.executeGet(String.format(TEAM_NEWS_REQUEST,teamName), new HashMap<String, String>());
        NewsReaderJson newsReaderJson = JsonUtils.fromJson(result.getResponseBody(), NewsReaderJson.class);
        List<String> titles = new ArrayList<String>();
        List<com.mlb.qa.at_bat.model.news.List> newsList = newsReaderJson.getList();
        for (com.mlb.qa.at_bat.model.news.List list : newsList) {
            if (list.getType().equals("article")){
                titles.add(list.getHeadline());}
        }
        return titles;
    }
}
