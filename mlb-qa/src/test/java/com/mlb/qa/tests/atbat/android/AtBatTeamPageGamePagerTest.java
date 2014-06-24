package com.mlb.qa.tests.atbat.android;

import java.util.List;

import org.joda.time.DateTime;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mlb.qa.at_bat.AtBatParameter;
import com.mlb.qa.at_bat.android.page.AtBatAndroidPage;
import com.mlb.qa.at_bat.android.page.AtBatTeamPage;
import com.mlb.qa.at_bat.model.team.TeamDateComparator;
import com.mlb.qa.at_bat.model.team.TeamPageUtils;
import com.mlb.qa.at_bat.service.http.AtBatHttpService;
import com.mlb.qa.atb.model.Team;
import com.mlb.qa.atb.model.game.Game;
import com.mlb.qa.atb.service.lookup.AtbLookupService;
import com.mlb.qa.common.comparator.ListComparator;
import com.mlb.qa.common.date.DateUtils;

public class AtBatTeamPageGamePagerTest extends AtBatTest {
	private AtBatHttpService httpService = new AtBatHttpService();
	private AtbLookupService lookupService = new AtbLookupService();
	private TeamPageUtils teamUtils = new TeamPageUtils();
	
	@Test(dataProvider = "excel_ds", priority = 1, description = "Testing Team Date Bar - 3 Games Exist", enabled = false)
	public void testTeamDateBar3GamesExist(String teamName) {
		liteUserInitialPath();
		
		AtBatTeamPage teamPage = new AtBatAndroidPage(driver)
				.openTeamsMenu()
					.openTeamByName(teamName)
						.waitForDateProgressBarLoad();
		Assert.assertEquals(teamPage.getNumberOfDateItems(), 3, "The number of games supposed to be displayed is incorrect.");
	}
	
	@Test(dataProvider = "excel_ds", priority = 2, description = "Testing Team Date Bar - Switching Between Days", enabled = false)
	public void testTeamDatebarSwitchDays(String teamName, String teamShortCode) {
		liteUserInitialPath();

		AtBatTeamPage teamPage = new AtBatAndroidPage(driver)
				.openTeamsMenu()
					.openTeamByName(teamName)
						.waitForDateProgressBarLoad();
		
		String currentDateItem = DateUtils.dateToString(teamUtils.getCorrectScoreboardDate(), teamUtils.gamePagerDateFormat);
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(teamPage.getDateItem(1), currentDateItem, 
				String.format("Date Test (0) - Expected: %s Actual: %s", currentDateItem, teamPage.getDateItem(1)));
		
		teamPage.selectDateItem(0);
		currentDateItem = DateUtils.dateToString(teamUtils.getCorrectScoreboardDate().minusDays(1), teamUtils.gamePagerDateFormat);
		softAssert.assertEquals(teamPage.getDateItem(0), currentDateItem, 
				String.format("Date Test (1) - Expected: %s Actual: %s", currentDateItem, teamPage.getDateItem(0)));
		
		teamPage.selectDateItem(1);
		currentDateItem = DateUtils.dateToString(teamUtils.getCorrectScoreboardDate(), teamUtils.gamePagerDateFormat);
		softAssert.assertEquals(teamPage.getDateItem(1), currentDateItem, 
				String.format("Date Test (2) - Expected: %s Actual: %s", currentDateItem, teamPage.getDateItem(1)));
		
		teamPage.selectDateItem(2);
		currentDateItem = DateUtils.dateToString(teamUtils.getCorrectScoreboardDate().plusDays(1), teamUtils.gamePagerDateFormat);
		softAssert.assertEquals(teamPage.getDateItem(1), currentDateItem, 
				String.format("Date Test (3) - Expected: %s Actual: %s", currentDateItem, teamPage.getDateItem(1)));
		
		teamPage.selectDateItem(0);
		currentDateItem = DateUtils.dateToString(teamUtils.getCorrectScoreboardDate(), teamUtils.gamePagerDateFormat);
		softAssert.assertEquals(teamPage.getDateItem(1), currentDateItem, 
				String.format("Date Test (4) - Expected: %s Actual: %s", currentDateItem, teamPage.getDateItem(1)));
		
		teamPage.selectDateItem(0);
		currentDateItem = DateUtils.dateToString(teamUtils.getCorrectScoreboardDate().minusDays(1), teamUtils.gamePagerDateFormat);
		softAssert.assertEquals(teamPage.getDateItem(0), currentDateItem, 
				String.format("Date Test (5) - Expected: %s Actual: %s", currentDateItem, teamPage.getDateItem(0)));
		softAssert.assertAll();
	}

	@Test(dataProvider = "excel_ds", priority = 3, description = "Testing Team Date Bar - Valid Dates Are Loaded", enabled = false)
	public void testTeamDatebarValidDatesLoaded(String teamName, String teamShortCode) {
		liteUserInitialPath();

		AtBatTeamPage teamPage = new AtBatAndroidPage(driver)
				.openTeamsMenu()
					.openTeamByName(teamName)
						.waitForDateProgressBarLoad();
		
		String year = AtBatParameter.MLB_ATBAT_SEASON.getValue();
		Team team = lookupService.lookupTeamByAbbrev(teamShortCode, year);
		DateTime currentDate = new DateTime();
		
		List<Game> gameList = lookupService.lookupListofGamesBetweenDates(team.getTeamId(), year, 
				currentDate.minusDays(7), currentDate.plusDays(7));
		List<String> backEndList = teamUtils.getCurrentGamePagerDates(gameList);
		List<String> frontEndList = teamPage.getDateItems();

		Assert.assertTrue(0 == new ListComparator<String>(new TeamDateComparator()).compareContentAndOrder(backEndList, frontEndList), "Dates do not match");
	}

	@Test(dataProvider = "excel_ds", priority = 4, description = "Testing Team Correct Game Icons Appear", enabled = true)
	public void testTeamCorrectGameButtons(String teamName, String teamShortCode) {
		/*liteUserInitialPath();
		
		AtBatTeamPage teamPage = new AtBatAndroidPage(driver)
		.openTeamsMenu()
			.openTeamByName(teamName)
				.waitForDateProgressBarLoad();*/
		
		httpService.getScoreboard("05", "29");
	}
}
