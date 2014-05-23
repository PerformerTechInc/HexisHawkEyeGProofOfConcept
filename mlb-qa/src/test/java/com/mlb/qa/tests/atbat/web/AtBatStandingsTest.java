package com.mlb.qa.tests.atbat.web;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mlb.qa.at_bat.model.standings.Season;
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

	@Test(description = "Check Standings Legend", enabled = true)
	public void checkStandingsLegend() {

		AtBatStandingsPage standingsPage = AtBatStandingsPage.open(driver,
				httpService.getSeasonStandingsURL(Season.REGULAR_SEASON.getSeasonText()));

		Assert.assertTrue(standingsPage.isPlayoffLegendAvailable(), 
				String.format("Playoff Legend is not available for URL: %s", 
						httpService.getSeasonStandingsURL(Season.REGULAR_SEASON.getSeasonText())));

		standingsPage = AtBatStandingsPage.open(driver,
				httpService.getSeasonStandingsURL(Season.SPRING_TRAINING.getSeasonText()));

		Assert.assertFalse(standingsPage.isPlayoffLegendAvailable(),
				String.format("Playoff Legend is available for URL: %s", 
						httpService.getSeasonStandingsURL(Season.SPRING_TRAINING.getSeasonText())));

		standingsPage = AtBatStandingsPage.open(driver,
				httpService.getSeasonStandingsURL(Season.WILD_CARD.getSeasonText()));

		Assert.assertTrue(standingsPage.isPlayoffLegendAvailable(),
				String.format("Playoff Legend is not available for URL: %s", 
						httpService.getSeasonStandingsURL(Season.WILD_CARD.getSeasonText())));
	}
}
