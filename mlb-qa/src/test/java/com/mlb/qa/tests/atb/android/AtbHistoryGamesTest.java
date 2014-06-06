package com.mlb.qa.tests.atb.android;

import java.util.List;
import java.util.Random;

import org.jfree.util.Log;
import org.joda.time.DateTime;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mlb.qa.atb.AtbParameter;
import com.mlb.qa.atb.android.page.AtbAndroidPage;
import com.mlb.qa.atb.android.page.history.AtbAddGamePage;
import com.mlb.qa.atb.android.page.history.AtbHistoryMainPage;
import com.mlb.qa.atb.model.Team;
import com.mlb.qa.atb.model.game.Game;
import com.mlb.qa.atb.service.authorization.AuthorizationService;
import com.mlb.qa.atb.service.lookup.AtbLookupService;
import com.qaprosoft.carina.core.foundation.UITest;
import com.qaprosoft.carina.core.foundation.webdriver.DriverFactory;

public class AtbHistoryGamesTest extends UITest {

	private AuthorizationService authorizationService;
	private WebDriver prepDriver;

	@DataProvider(name = "prepareTestData")
	public Object[][] prepareTestData(ITestContext context) {
		Object[][] allArguments = createTestArgSets(context, "Execute", "y");
		Random rn = new Random();
		int i = rn.nextInt(allArguments.length);
		Object[][] a = { allArguments[i] };
		return a;
	}
	
	@BeforeClass
	public void changeUser() {
		prepDriver = DriverFactory.create("temp");
		authorizationService = new AuthorizationService(prepDriver);
		authorizationService.reloginUser(
				AtbParameter.MLB_ATB_ADITIONAL_USER.getValue(),
				AtbParameter.MLB_ATB_ADITIONAL_PASSWORD.getValue());
		prepDriver.quit();
	}

	@Test(dataProvider = "prepareTestData", description = "Add game from the future")
	public void checkAddFutureGame(String teamAbbrev) {

		AtbLookupService lookupService = new AtbLookupService();
		String year = AtbParameter.MLB_ATB_SEASON.getValue();
		int month = new DateTime().getMonthOfYear() + 1;
		Team team = lookupService.lookupTeamByAbbrev(teamAbbrev, year);
		List<Game> gamesBe = lookupService.lookupListOfGamesForTheMonth(
				team.getTeamId(), Integer.parseInt(year), month);

		AtbHistoryMainPage atbHistoryMainPage = new AtbHistoryMainPage(
				getDriver());
		atbHistoryMainPage.clickOnMenuItem(AtbAndroidPage.Menu.HISTORY);
		Assert.assertTrue(atbHistoryMainPage.isOpened(), "History isn't opened");
		AtbAddGamePage atbAddGamePage = atbHistoryMainPage.getAtbAddGamePage();
		Assert.assertTrue(atbAddGamePage.isOpened(), "Add Game isn't opened");
		atbAddGamePage.selectHomeTeam(gamesBe.get(gamesBe.size() - 1)
				.getHomeTeamFull());
		atbAddGamePage.selectAwayTeam(gamesBe.get(gamesBe.size() - 1)
				.getAwayTeamFull());
		atbAddGamePage.selectYear(year);
		atbAddGamePage.selectMonth(gamesBe.get(gamesBe.size() - 1)
				.getGameDate().monthOfYear().getAsText());
		atbAddGamePage.selectDay(((Integer) gamesBe.get(gamesBe.size() - 1)
				.getGameDate().getDayOfMonth()).toString());
		atbAddGamePage.clickSearchAmdSelectGame();
		atbAddGamePage.clickAddDeleteButton();
		Assert.assertTrue(atbAddGamePage.checkErrorText());

	}

	
	@Test(dataProvider = "prepareTestData", description = "Add game from the past")
	public void checkAddPastGame(String teamAbbrev) {

		AtbLookupService lookupService = new AtbLookupService();
		String year = AtbParameter.MLB_ATB_SEASON.getValue();
		int month = new DateTime().getMonthOfYear() - 1;
		Team team = lookupService.lookupTeamByAbbrev(teamAbbrev, year);
		List<Game> gamesBe = lookupService.lookupListOfGamesForTheMonth(
				team.getTeamId(), Integer.parseInt(year), month);

		AtbHistoryMainPage atbHistoryMainPage = new AtbHistoryMainPage(
				getDriver());
		atbHistoryMainPage.clickOnMenuItem(AtbAndroidPage.Menu.HISTORY);
		Assert.assertTrue(atbHistoryMainPage.isOpened(), "History isn't opened");
		AtbAddGamePage atbAddGamePage = atbHistoryMainPage.getAtbAddGamePage();
		Assert.assertTrue(atbAddGamePage.isOpened(), "Add Game isn't opened");
		atbAddGamePage.selectHomeTeam(gamesBe.get(gamesBe.size() - 1)
				.getHomeTeamFull());
		atbAddGamePage.selectAwayTeam(gamesBe.get(gamesBe.size() - 1)
				.getAwayTeamFull());
		atbAddGamePage.selectYear(year);
		atbAddGamePage.selectMonth(gamesBe.get(gamesBe.size() - 1)
				.getGameDate().monthOfYear().getAsText());
		atbAddGamePage.selectDay(((Integer) gamesBe.get(gamesBe.size() - 1)
				.getGameDate().getDayOfMonth()).toString());
		atbAddGamePage.clickSearchAmdSelectGame();
		atbAddGamePage.clickAddDeleteButton();
		Log.warn("TODO: additional verification is still required!");
		//Assert.assertFalse(atbAddGamePage.checkErrorText());

	}
	
	@AfterClass
	public void returnDefaultUser() {
		prepDriver = DriverFactory.create("temp");
		authorizationService = new AuthorizationService(prepDriver);


		authorizationService.reloginUser(
				AtbParameter.MLB_ATB_DEFAULT_USER.getValue(),
				AtbParameter.MLB_ATB_DEFAULT_PASSWORD.getValue());
		prepDriver.quit();
	}
}
