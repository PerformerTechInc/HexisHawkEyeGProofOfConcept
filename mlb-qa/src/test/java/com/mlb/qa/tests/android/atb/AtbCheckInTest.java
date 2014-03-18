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
import com.qaprosoft.carina.core.foundation.UITest;

public class AtbCheckInTest extends UITest {
	private DateTime gameDate = new DateTime(2014, 3, 22, 0, 0);;

	private AtbHttpService httpService = new AtbHttpService();
	private AtbLookupService lookupService = new AtbLookupService();
	private String homeTeam = "Arizona Diamondbacks";

	@Parameters("team")
	@BeforeClass(enabled = true, description = "Find nearest incoming game for the specified team")
	public void findNearestGameDateForBallpark(String team) {
		homeTeam = team;
		// TODO: find nearest home game for the team
		gameDate = new DateTime(2014, 3, 31, 18, 0); // Temp w/a: 03.31.2014 18:00

	}

	@BeforeClass(enabled = true, dependsOnMethods = "findNearestGameDateForBallpark", description = "")
	public void allowCheckinForGameDate() {
		httpService.setTimeBoundaryCheckinServiceProperty(14400 * 6l); // 24 hrs
		httpService.setGameFeedCheckinServiceProperty(gameDate);
	}

	
	@Test(enabled = true, dependsOnMethods = "allowCheckinForGameDate", description = "")
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

	@Parameters("stadium")
	@Test(enabled = true, dependsOnMethods = "openCheckinWindow", description = "Check in")
	public void checkin(String stadium) {
		AtbCheckedInPage checkedInPage = new AtbAndroidPage(driver)
				.openBallparksFromMenu().openBallparkByName(homeTeam)
				.openCheckInPage().processLocationDetermining()
				.confirmCheckIn();
		Assert.assertTrue(
				checkedInPage.isOpened()
						&& stadium.equalsIgnoreCase(checkedInPage
								.loadCheckedInStadiumName()),
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

	@Test(enabled = false, dependsOnMethods ="logInIfNotLogged")
	public void openCheckinPage() {
		AtbAndroidPage atbap = new AtbAndroidPage(driver);
		//atbap.openCheckinWindow();
		AtbCheckedInPage eventPage = atbap.openBallparksFromMenu()
				.openBallparkByName(homeTeam).openCheckInPage().processLocationDetermining()
				.confirmCheckIn();
		Assert.assertTrue(eventPage.isAlertPresent());
	}
	
	@Test(enabled = false, description = "Check game date")
	public void checkSearchByTeamAbbrev(){
		Team team = lookupService.lookupTeamByAbbrev("ARI", AtbParameter.MLB_ATB_SEASON.getValue());
		Game game = lookupService.lookupNearestIncomingHomeGame(team.getTeamId(), team.getVenueId(), new DateTime(), new DateTime().plusYears(1), "2014");
		System.out.print(game.getGameDate());
	}
}
