package com.mlb.qa.tests.atbat.web;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mlb.qa.at_bat.service.http.AtBatHttpService;
import com.mlb.qa.at_bat.web.page.AtBatStandingsPage;

import com.qaprosoft.carina.core.foundation.UITest;

public class AtBatStandingsTest extends UITest {
	
	private AtBatHttpService httpService = new AtBatHttpService();

	@Test(dataProvider = "excel_ds", description = "Check correct Favorite Team Selected", enabled = true)
	public void checkStandingsFavoriteTeamHighlighted(String teamName, String teamShortCode) {	
		
		AtBatStandingsPage standingsPage = AtBatStandingsPage.open(driver, 
				httpService.getFavoriteTeamStandingsURL(teamShortCode));
		
		Assert.assertTrue(
				standingsPage.isFavoriteTeamHighlighted(teamShortCode), 
				"The selected Favorite Team is not correctly highlighted in Standings");
	}
}
