package com.mlb.qa.tests.atbat.web;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mlb.qa.at_bat.model.roster.Position;
import com.mlb.qa.at_bat.model.roster.Roster;
import com.mlb.qa.at_bat.service.http.AtBatHttpService;
import com.mlb.qa.at_bat.web.page.AtBatPlayerCardPage;
import com.mlb.qa.atb.AtbParameter;
import com.mlb.qa.atb.model.Team;
import com.mlb.qa.atb.service.lookup.AtbLookupService;
import com.qaprosoft.carina.core.foundation.UITest;

public class AtBatRosterTest extends UITest {	
	private static final Logger logger = Logger.getLogger(AtBatRosterTest.class);
	
	private AtBatHttpService httpService = new AtBatHttpService();
	private AtbLookupService lookupService = new AtbLookupService();
	
	@Test(dataProvider = "excel_ds", description = "Check list of players is correct", enabled = true)
	public void checkRosterList(String teamName, String teamShortCode) {
		
		String year = AtbParameter.MLB_ATB_SEASON.getValue();
		Team team = lookupService.lookupTeamByAbbrev(teamShortCode, year);
		List<Roster> rosterBackEnd = httpService.loadListOfPlayers(team.getTeamId());
		
		//TODO:  Need to do a comparison just on the roster level here.
	}
	
	@Test(dataProvider = "excel_ds", description = "Check player cards load", enabled = true)
	public void checkPlayerCards(String teamName, String teamShortCode) {
		String year = AtbParameter.MLB_ATB_SEASON.getValue();
		Team team = lookupService.lookupTeamByAbbrev(teamShortCode, year);
		List<Roster> rosterBackEnd = httpService.loadListOfPlayers(team.getTeamId());
		
		for (Iterator<Roster> iter = rosterBackEnd.iterator(); iter.hasNext(); ) {
			Roster backendPlayer = iter.next();
			
			Roster webPlayer = AtBatPlayerCardPage.open(getDriver(), 
					httpService.getPlayerCardURL(backendPlayer.getPlayerId(), backendPlayer.getPlayerName())).loadPlayer();
			
			String[] backendPlayerArray = backendPlayer.getPlayerName().split(",");
			String backendPlayerName = backendPlayerArray[1].trim() + " " + backendPlayerArray[0].trim();
			
			Assert.assertEquals(
					webPlayer.getPlayerName(), 
					backendPlayerName, 
					String.format("Player Name doesn't match correctly for (%s)", webPlayer.getPlayerName()));
			Assert.assertEquals(
					webPlayer.getPlayerNumber(), 
					backendPlayer.getPlayerNumber(), 
					String.format("Player Number doesn't match correctly for (%s)", webPlayer.getPlayerName()));
			Assert.assertEquals(
					Position.PositionShortCode.getPositionEnum(backendPlayer.getPlayerPositionText()), 
					Position.PositionShortCode.getPositionEnum(webPlayer.getPlayerPositionText()),
					String.format("Player Position doesn't match correctly for (%s)", webPlayer.getPlayerName()));
		}
	}
	
	@Test(dataProvider = "excel_ds", description = "Checking player mugshots load", enabled = true) 
	public void checkPlayerMugshots(String teamName, String teamShortCode) {
		String year = AtbParameter.MLB_ATB_SEASON.getValue();
		Team team = lookupService.lookupTeamByAbbrev(teamShortCode, year);
		List<Roster> rosterBackEnd = httpService.loadListOfPlayers(team.getTeamId());
		
		for (Iterator<Roster> iter = rosterBackEnd.iterator(); iter.hasNext(); ) {
			Roster ros = iter.next();
			httpService.checkPlayerMugshot(ros.getPlayerId(), ros.getPlayerName());
		}
	}

}
