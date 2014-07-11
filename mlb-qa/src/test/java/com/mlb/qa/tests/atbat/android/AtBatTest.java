package com.mlb.qa.tests.atbat.android;

import org.apache.log4j.Logger;

import com.mlb.qa.at_bat.android.page.AtBatLoginAlert;
import com.mlb.qa.at_bat.android.page.AtBatMenu.MenuItem;
import com.mlb.qa.at_bat.android.page.AtBatFavoriteTeamSelectionPage;
import com.mlb.qa.at_bat.android.page.AtBatSettingsPage;
import com.mlb.qa.at_bat.android.page.AtBatWelcomePage;
import com.qaprosoft.carina.core.foundation.UITest;

/**
 * Generic Class for Methods that can be utilized by the different At Bat Tests
 * @author boyle
 *
 */
public class AtBatTest extends UITest {
	private static final Logger logger = Logger.getLogger(AtBatTest.class);
	
	public void liteUserInitialPath() {
		AtBatWelcomePage welcomePage = new AtBatWelcomePage(driver);
		if (welcomePage.isOpened()) {
			logger.info("Welcome Page is Open");
			welcomePage.passToPaywallPage()
				.continueWithLiteVersion()
				.skipFavoriteTeamSelectionStep()
				.skipPlayServiceAlertInitial()
				.skipSettingNotifications();
		} else {
			logger.info("Welcome Page is NOT Open");
			AtBatSettingsPage settingsPage = new AtBatSettingsPage(driver);
			settingsPage.openMenu()
				.clickOnMenuItem(MenuItem.SETTINGS);

			AtBatLoginAlert loginAlert = settingsPage.tapMenuOption("MLB.com Account")
				.accessMLBAccount();

			if (loginAlert.isLoggedIn()) {
				loginAlert.clearCredentials().clickHome();
			} else {
				loginAlert.cancel().clickHome();
			}
		}
	}

	public void liteUserInitialPathFavoriteTeam(String teamName) {
		AtBatWelcomePage welcomePage = new AtBatWelcomePage(driver);
		if (welcomePage.isOpened()) {
			welcomePage.passToPaywallPage()
				.continueWithLiteVersion()
				.selectFavoriteTeam(teamName)
				.selectNext()  
				.skipPlayServiceAlertInitial()
				.skipSettingNotifications();
		} else {
			AtBatSettingsPage settingsPage = new AtBatSettingsPage(driver);
			settingsPage.openMenu()
				.clickOnMenuItem(MenuItem.SETTINGS);
			settingsPage.tapMenuOption("Favorite Teams");
			
			AtBatFavoriteTeamSelectionPage favoriteTeam = new AtBatFavoriteTeamSelectionPage(driver);
			favoriteTeam.selectFavoriteTeam(teamName)
				.clickHome()
				.clickHome();
		}
	}

	public void fullUserInitialPath() {
		AtBatWelcomePage welcomePage = new AtBatWelcomePage(driver);
		if (welcomePage.isOpened()) {
			welcomePage.passToPaywallPage()
				.loginAsExistingUser()
				.login("media6@mlbtest.com", "p@ssw0rd");
		} else {
			AtBatSettingsPage settingsPage = new AtBatSettingsPage(driver);
			settingsPage.openMenu()
				.clickOnMenuItem(MenuItem.SETTINGS);
			settingsPage.tapMenuOption("MLB.com Account")
				.accessMLBAccount()
				.login("media6@mlbtest.com", "p@ssw0rd")
				.clickHome();
		}
	}

	public void checkInitialFavoriteTeamFlow() {
		AtBatFavoriteTeamSelectionPage favoritePage = new AtBatFavoriteTeamSelectionPage(driver);
		if (favoritePage.isOpened()) {
			favoritePage.skipFavoriteTeamSelectionStep()
			.skipPlayServiceAlertInitial()
			.skipSettingNotifications();
		}
	}
}
