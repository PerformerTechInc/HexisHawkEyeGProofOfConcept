package com.mlb.qa.at_bat.service.http;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import com.mlb.qa.at_bat.AtBatParameter;
import com.mlb.qa.at_bat.model.roster.QueryPlayerRosterRS;
import com.mlb.qa.at_bat.model.roster.Roster;
import com.mlb.qa.common.http.HttpHelper;
import com.mlb.qa.common.http.HttpResult;

public class AtBatHttpService {
	private static final Logger logger = Logger.getLogger(AtBatHttpService.class);
	
	private static final String GET_TEAM_ROSTER_PATTERN = "?team_id=team_id_value&roster_40.col_in=player_id&roster_40.col_in=name_full,primary_position,position_txt,jersey_number"; 
	private static final String GET_PLAYER_CARD_PATTERN = "android.html#pid=player_id_value";
	private static final String GET_PLAYER_MUGSHOT_PATTERN = "player_id_value.jpg";
	
	public List<Roster> loadListOfPlayers(String teamId) {
		logger.info(String.format("Loading List of Players for Team Id: %s", teamId));
		String getQueryRequest = AtBatParameter.MLB_ATBAT_ROSTER_LOOKUP.getValue()
				+ GET_TEAM_ROSTER_PATTERN.replaceAll("team_id_value", teamId);
		logger.info(String.format("Request: %s", getQueryRequest));
		
		HttpResult result = HttpHelper.executeGet(getQueryRequest, new HashMap<String, String>());
		//logger.info(String.format("Result: %s", result));
		HttpHelper.checkResultOk(result);
		
		List<Roster> rosterPlayers = QueryPlayerRosterRS.unmarshal(result.getResponseBody());
		logger.info("Roster Found: " + rosterPlayers);
		
		return rosterPlayers;
	}

	public String getPlayerCardURL(String playerId, String playerName) {
		logger.info(String.format("Verifying Player Card Opens for (" + playerName + ")"));
		String getQueryRequest = AtBatParameter.MLB_ATBAT_PLAYER_CARD.getValue()
				+ GET_PLAYER_CARD_PATTERN.replaceAll("player_id_value", playerId);
		logger.info(String.format("Request: %s", getQueryRequest));

		return getQueryRequest;
	}

	public void getPlayerMugshot(String playerId, String playerName) {
		logger.info(String.format("Verifying Player Mugshot Opens for (" + playerName + ")"));
		String getQueryRequest = AtBatParameter.MLB_ATBAT_PLAYER_MUGSHOT.getValue()
				+ GET_PLAYER_MUGSHOT_PATTERN.replaceAll("player_id_value", playerId);
		logger.info(String.format("Request: %s", getQueryRequest));
		
		HttpResult result = HttpHelper.executeGet(getQueryRequest, new HashMap<String, String>());
		HttpHelper.checkResultOk(result);
	}
}
