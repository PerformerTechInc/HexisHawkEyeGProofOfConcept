package com.mlb.qa.tests.android.atb;

import java.io.UnsupportedEncodingException;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mlb.qa.android.atb.model.Game;
import com.mlb.qa.android.atb.model.Team;
import com.mlb.qa.android.atb.page.AtbAndroidPage;
import com.mlb.qa.android.atb.page.AtbCheckedInPage;
import com.mlb.qa.android.atb.page.AtbStartPage;
import com.mlb.qa.android.atb.service.http.AtbHttpService;
import com.mlb.qa.android.atb.service.lookup.AtbLookupService;
import com.mlb.qa.android.atb.utils.AtbParameter;
import com.mlb.qa.android.atb.utils.DateUtils;
import com.qaprosoft.carina.core.foundation.UITest;

public class AtbCheckInTest extends UITest {

	private Game game;
	private Team team;

	private AtbHttpService httpService = new AtbHttpService();
	private AtbLookupService lookupService = new AtbLookupService();

	// @Parameters("team_abbrev")
	// @BeforeClass(enabled = true, description =
	// "Find nearest incoming game for the specified team")
	public void findNearestGameDateForBallpark(String teamAbbrev) {
		String season = AtbParameter.MLB_ATB_SEASON.getValue();
		team = lookupService.lookupTeamByAbbrev(teamAbbrev, season);
		DateTime today = new DateTime();
		game = lookupService.lookupNearestIncomingHomeGame(team.getTeamId(),
				team.getVenueId(), today, today.plusMonths(6), season);
	}

	// @BeforeClass(enabled = true, dependsOnMethods =
	// "findNearestGameDateForBallpark", description =
	// "Allow checkin for the game date")
	public void allowCheckinForGameDate() throws UnsupportedEncodingException {
		DateTime gameDate = DateUtils.parseString(game.getGameTimeLocal(),
				Game.GAME_TIME_LOCAL_FORMAT_PATTERN);
		httpService.setGameFeedCheckinServiceProperty(gameDate);
		int daysBetween = new Period(new DateTime(), gameDate,
				PeriodType.days()).getDays() + 1;
		httpService
				.setTimeBoundaryCheckinServiceProperty(daysBetween * 24 * 60l);
	}

	// @Test(enabled = true, description = "Log in if not logged yet")
	public void loginIfNotLogged() {
		AtbStartPage sp = new AtbStartPage(driver);
		if (sp.isOpened()) {
			sp.passToLoginPage()
					.login(AtbParameter.MLB_ATB_DEFAULT_USER.getValue(),
							AtbParameter.MLB_ATB_DEFAULT_PASSWORD.getValue())
					.skipFavoriteTeamSelection();
			;
		}
	}

	// @Test(enabled = true, dependsOnMethods = "loginIfNotLogged", description
	// = "Open check in window (in Testing area of application)")
	public void openCheckinWindow() {
		new AtbAndroidPage(driver).openCheckinWindow();
	}

	// @Test(enabled = true, dependsOnMethods = "openCheckinWindow", description
	// = "Check in")
	public void checkin() {
		AtbCheckedInPage checkedInPage = new AtbAndroidPage(driver)
				.openBallparksFromMenu()
				.openBallparkByTeamName(team.getNameFull()).openCheckInPage()
				.processLocationDetermining().confirmCheckIn();
		Assert.assertTrue(
				checkedInPage.isOpened()
						&& detectVenueOnUi(game).equalsIgnoreCase(
								checkedInPage.loadCheckedInStadiumName()),
				"Checked In page not opened or wrong stadium page displayed");
	}

	@Test(dataProvider = "excel_ds")
	public void checkin(String teamAbbrev, @Optional("false")String moveCheckinWindow)
			throws UnsupportedEncodingException {
		findNearestGameDateForBallpark(teamAbbrev);
		if (Boolean.parseBoolean(moveCheckinWindow)) {
			allowCheckinForGameDate();
		}
		loginIfNotLogged();
		openCheckinWindow();
		checkin();
	}

	private String detectVenueOnUi(Game game) {
		String venueShort = game.getVenueShort();
		if (null == venueShort || venueShort.isEmpty()) {
			return game.getVenue();
		}
		return venueShort;
	}

	@DataProvider(name = "excel_ds")
	public Object[][] readDataFromXLS(ITestContext context)
	{
		// staticArgs - that are passed from xml bun not excel, the same for
		// every data set (row in excel)
		String[] staticArgs = { "move_checkin_window" };
		return createTestArgSets(context, "Execute", "y", staticArgs);
	}
}
