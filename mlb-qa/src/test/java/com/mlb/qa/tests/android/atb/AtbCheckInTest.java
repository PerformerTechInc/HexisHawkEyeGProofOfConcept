package com.mlb.qa.tests.android.atb;

import org.joda.time.DateTime;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
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

	@Parameters("team_abbrev")
	@BeforeClass(enabled = true, description = "Find nearest incoming game for the specified team")
	public void findNearestGameDateForBallpark(String teamAbbrev) {
		String season = AtbParameter.MLB_ATB_SEASON.getValue();
		team = lookupService.lookupTeamByAbbrev(teamAbbrev, season);
		DateTime today = new DateTime();
		game = lookupService.lookupNearestIncomingHomeGame(team.getTeamId(),
				team.getVenueId(), today, today.plusMonths(6), season);

	}

	@BeforeClass(enabled = true, dependsOnMethods = "findNearestGameDateForBallpark", description = "Allow checkin for the game date")
	public void allowCheckinForGameDate() {
		httpService.setTimeBoundaryCheckinServiceProperty(60 * 60 * 4l); // 4
																			// hrs
		DateTime gameDate = DateUtils.parseString(game.getGameTimeLocal(),
				Game.GAME_TIME_LOCAL_FORMAT_PATTERN);
		httpService.setGameFeedCheckinServiceProperty(gameDate);
	}

	@Test(enabled = true, dependsOnMethods = "allowCheckinForGameDate", description = "Log in if not logged yet")
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

	@Test(enabled = true, dependsOnMethods = "loginIfNotLogged")
	public void openCheckinWindow() {
		new AtbAndroidPage(driver).openCheckinWindow();
	}

	@Test(enabled = true, dependsOnMethods = "openCheckinWindow", description = "Check in")
	public void checkin() {
		AtbCheckedInPage checkedInPage = new AtbAndroidPage(driver)
				.openBallparksFromMenu().openBallparkByName(team.getName())
				.openCheckInPage().processLocationDetermining()
				.confirmCheckIn();
		Assert.assertTrue(
				checkedInPage.isOpened()
						&& team.getVenueName().equalsIgnoreCase(
								checkedInPage.loadCheckedInStadiumName()),
				"Checked In page not opened or wrong stadium page displayed");
	}

	/****
	 * 
	 * TEMPORARY debug methods<br>
	 * 
	 */

	@Test(enabled = false, description = "Log in")
	public void logInIfNotLogged() {
		AtbStartPage sp = new AtbStartPage(driver);
		if (sp.isOpened()) {
			sp.passToLoginPage()
					.login(AtbParameter.MLB_ATB_DEFAULT_USER.getValue(),
							AtbParameter.MLB_ATB_DEFAULT_PASSWORD.getValue())
					.skipFavoriteTeamSelection();
			;
		}
	}

	@Test(enabled = false, dependsOnMethods = "logInIfNotLogged")
	public void openCheckinPage() {
		AtbAndroidPage atbap = new AtbAndroidPage(driver);
		// atbap.openCheckinWindow();
		AtbCheckedInPage eventPage = atbap.openBallparksFromMenu()
				.openBallparkByName("").openCheckInPage()
				.processLocationDetermining().confirmCheckIn();
		Assert.assertTrue(eventPage.isAlertPresent());
	}

	@Test(enabled = false, description = "Check game date")
	public void checkSearchByTeamAbbrev() {
		Team team = lookupService.lookupTeamByAbbrev("ARI",
				AtbParameter.MLB_ATB_SEASON.getValue());
		Game game = lookupService.lookupNearestIncomingHomeGame(
				team.getTeamId(), team.getVenueId(), new DateTime(),
				new DateTime().plusYears(1), "2014");
		System.out.print(game.getGameTimeLocal());
	}
}
