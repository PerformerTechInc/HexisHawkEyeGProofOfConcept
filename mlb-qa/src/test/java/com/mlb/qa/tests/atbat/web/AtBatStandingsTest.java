package com.mlb.qa.tests.atbat.web;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mlb.qa.at_bat.model.standings.Season;
import com.mlb.qa.at_bat.model.standings.StandingsLookup;
import com.mlb.qa.at_bat.service.http.AtBatHttpService;
import com.mlb.qa.at_bat.web.page.AtBatStandingsPage;
import com.qaprosoft.carina.core.foundation.UITest;

public class AtBatStandingsTest extends UITest {

	private AtBatHttpService httpService = new AtBatHttpService();
	private StandingsLookup lookup = new StandingsLookup();

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

		boolean isClinchVisible = lookup.isClinchedFound();
		String available = "available";
		String notAvailable = "not available";		

		AtBatStandingsPage standingsPage = AtBatStandingsPage.open(driver,
				httpService.getSeasonStandingsURL(Season.REGULAR_SEASON.getSeasonText()));

		checkAssert(isClinchVisible, standingsPage, Season.REGULAR_SEASON.getSeasonText(), notAvailable, available);

		standingsPage = AtBatStandingsPage.open(driver,
				httpService.getSeasonStandingsURL(Season.SPRING_TRAINING.getSeasonText()));

		checkAssert(isClinchVisible, standingsPage, Season.SPRING_TRAINING.getSeasonText(), available, available);

		standingsPage = AtBatStandingsPage.open(driver,
				httpService.getSeasonStandingsURL(Season.WILD_CARD.getSeasonText()));

		checkAssert(isClinchVisible, standingsPage, Season.WILD_CARD.getSeasonText(), notAvailable, available);
	}

	private void checkAssert(Boolean isClinchVisible, AtBatStandingsPage standingsPage, String seasonText
			,String availabilityTrue, String availabilityFalse) {
		if (isClinchVisible) {
			checkStandingsPage(standingsPage.isPlayoffLegendAvailable(), seasonText, availabilityTrue);
		} else {
			checkStandingsPage(!standingsPage.isPlayoffLegendAvailable(), seasonText, availabilityFalse);
		}
	}

	private void checkStandingsPage(Boolean playoffLegendVisible, String seasonName
			, String availability) {
		Assert.assertTrue(playoffLegendVisible, 
				String.format("Playoff Legend is %s for URL: %s", 
					availability,
					httpService.getSeasonStandingsURL(seasonName)));		
	}
}
