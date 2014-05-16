package com.mlb.qa.tests.atbat.web;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
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
	
	@Test(dataProvider = "excel_ds", description = "Check list of players is correct", enabled = false)
	public void checkRosterList(String teamName, String teamShortCode) {
		
		String year = AtbParameter.MLB_ATB_SEASON.getValue();
		Team team = lookupService.lookupTeamByAbbrev(teamShortCode, year);
		List<Roster> rosterBackEnd = httpService.loadListOfPlayers(team.getTeamId());
		
		//TODO:  Need to do a comparison just on the roster level here.
	}
	
	@Test(dataProvider = "excel_ds", description = "Check player cards load", threadPoolSize = 5)
	public void checkPlayerCards(String teamName, String teamShortCode) {
		String year = AtbParameter.MLB_ATB_SEASON.getValue();
		Team team = lookupService.lookupTeamByAbbrev(teamShortCode, year);
		List<Roster> rosterBackEnd = httpService.loadListOfPlayers(team.getTeamId());
		
		for (Iterator<Roster> iter = rosterBackEnd.iterator(); iter.hasNext(); ) {
			Roster backendPlayer = iter.next();
			
			Roster webPlayer = AtBatPlayerCardPage.open(driver, 
					httpService.getPlayerCardURL(backendPlayer.getPlayerId(), backendPlayer.getPlayerName())).loadPlayer();
			
			String[] backendPlayerArray = backendPlayer.getPlayerName().split(",");
			String backendPlayerName = backendPlayerArray[1].trim() + " " + backendPlayerArray[0].trim();
			
			Assert.assertEquals(
					webPlayer.getPlayerName(), 
					backendPlayerName, 
					"Player Name doesn't match correctly");
			Assert.assertEquals(
					webPlayer.getPlayerNumber(), 
					backendPlayer.getPlayerNumber(), 
					"Player Number doesn't match correctly");
			Assert.assertEquals(
					Position.PositionShortCode.getPositionEnum(backendPlayer.getPlayerPositionText()), 
					Position.PositionShortCode.getPositionEnum(webPlayer.getPlayerPositionText()),
					"Player Position doesn't match correctly");
		}
	}
	
	@Test(dataProvider = "excel_ds", description = "Checking player mugshots load", enabled = false) 
	public void checkPlayerMugshots(String teamName, String teamShortCode) {
		String year = AtbParameter.MLB_ATB_SEASON.getValue();
		Team team = lookupService.lookupTeamByAbbrev(teamShortCode, year);
		List<Roster> rosterBackEnd = httpService.loadListOfPlayers(team.getTeamId());
		
		for (Iterator<Roster> iter = rosterBackEnd.iterator(); iter.hasNext(); ) {
			Roster ros = iter.next();
			httpService.getPlayerMugshot(ros.getPlayerId(), ros.getPlayerName());
		}
		//TODO:  If a mugshot doesn't appear then an error will be thrown by the getPlayerMugshot stating as such.  Need to look into a proper assert to
		//use here though.
	}

}
