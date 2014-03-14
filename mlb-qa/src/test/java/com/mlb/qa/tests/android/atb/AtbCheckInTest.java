package com.mlb.qa.tests.android.atb;


import org.joda.time.DateTime;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mlb.qa.android.atb.page.AtbAndroidPage;
import com.mlb.qa.android.atb.page.AtbEventPage;
import com.mlb.qa.android.atb.page.AtbStartPage;
import com.mlb.qa.android.atb.service.http.AtbHttpService;
import com.mlb.qa.android.atb.utils.AtbParameter;
import com.qaprosoft.carina.core.foundation.UITest;

public class AtbCheckInTest extends UITest {
	private DateTime gameDate = new DateTime(2014, 3, 22, 0, 0);;

	private AtbHttpService httpService = new AtbHttpService();
	private String homeTeam = "Arizona Diamondbacks";

	@Parameters("team")
	@BeforeClass(enabled = false, description = "Find nearest incoming game for the specified team")
	public void findNearestGameDateForBallpark(String team) {
		homeTeam = team;
		// TODO: find nearest home game for the team
		gameDate = new DateTime(2014, 3, 31, 18, 0); // Temp w/a: 03.31.2014 18:00

	}

	@BeforeClass(enabled = false, dependsOnMethods = "findNearestGameDateForBallpark", description = "")
	public void allowCheckinForGameDate() {
		httpService.setTimeBoundaryCheckinServiceProperty(14400 * 6l); // 24 hrs
		httpService.setGameFeedCheckinServiceProperty(gameDate);
	}

	@BeforeClass(enabled = false, dependsOnMethods = "allowCheckinForGameDate", description = "")
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

	@BeforeClass(enabled = false, dependsOnMethods = "loginIfNotLogged")
	public void openCheckinWindow() {
		new AtbAndroidPage(driver).openCheckinWindow();
	}

	@Test(enabled = false, description = "Check in")
	public void checkin() {
		AtbEventPage eventPage = new AtbAndroidPage(driver).openBallparksFromMenu()
				.openBallparkByName(homeTeam).openCheckInPage()
				.processLocationDetermining().confirmCheckIn();
		Assert.assertTrue(eventPage.isAlertPresent());
	}


	/****
	 * 
	 * TEMPORARY debug methods<br>
	 * 
	 */

	@Test(enabled = true, description = "Log in")
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

	@Test(dependsOnMethods ="logInIfNotLogged")
	public void openCheckinPage() {
		AtbAndroidPage atbap = new AtbAndroidPage(driver);
		//atbap.openCheckinWindow();
		AtbEventPage eventPage = atbap.openBallparksFromMenu()
				.openBallparkByName(homeTeam).openCheckInPage().processLocationDetermining()
				.confirmCheckIn();
		Assert.assertTrue(eventPage.isAlertPresent());
	}
}
