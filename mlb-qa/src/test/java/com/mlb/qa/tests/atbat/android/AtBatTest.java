package com.mlb.qa.tests.atbat.android;

import com.mlb.qa.at_bat.android.page.media.AtBatAudioPage;
import com.mlb.qa.at_bat.android.page.media.AtBatTvPage;
import com.mlb.qa.at_bat.android.page.media.AtBatVideoStreamPage;
import com.mlb.qa.at_bat.android.page.paywalls.AtBatPaywallPage;
import com.mlb.qa.at_bat.android.page.paywalls.AtBatPaywallTVPage;
import org.apache.log4j.Logger;

import com.mlb.qa.at_bat.android.page.authentication.AtBatLoginAlert;
import com.mlb.qa.at_bat.android.page.AtBatMenu.MenuItem;
import com.mlb.qa.at_bat.android.page.AtBatFavoriteTeamSelectionPage;
import com.mlb.qa.at_bat.android.page.AtBatSettingsPage;
import com.mlb.qa.at_bat.android.page.common.AtBatWelcomePage;
import com.mlb.qa.atb.AtbParameter;
import com.qaprosoft.carina.core.foundation.UITest;
import org.testng.Assert;

/**
 * Generic Class for Methods that can be utilized by the different At Bat Tests
 * @author boyle
 *
 */
public class AtBatTest extends UITest {
	private static final Logger logger = Logger.getLogger(AtBatTest.class);
	
	public void liteUserInitialPath() {
		AtBatWelcomePage welcomePage = new AtBatWelcomePage(getDriver());
		if (welcomePage.isOpened()) {
			logger.info("Welcome Page is Open");
			welcomePage.passToPaywallPage()
				.continueWithLiteVersion()
				.skipFavoriteTeamSelectionStep()
				.skipPlayServiceAlertInitial()
				.skipSettingNotifications();
		} else {
			logger.info("Welcome Page is NOT Open");
			AtBatSettingsPage settingsPage = new AtBatSettingsPage(getDriver());
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
		AtBatWelcomePage welcomePage = new AtBatWelcomePage(getDriver());
		if (welcomePage.isOpened()) {
			welcomePage.passToPaywallPage()
				.continueWithLiteVersion()
				.selectFavoriteTeam(teamName)
				.selectNext()  
				.skipPlayServiceAlertInitial()
				.skipSettingNotifications();
		} else {
			AtBatSettingsPage settingsPage = new AtBatSettingsPage(getDriver());
			settingsPage.openMenu()
				.clickOnMenuItem(MenuItem.SETTINGS);
			settingsPage.tapMenuOption("Favorite Teams");
			
			AtBatFavoriteTeamSelectionPage favoriteTeam = new AtBatFavoriteTeamSelectionPage(getDriver());
			favoriteTeam.selectFavoriteTeam(teamName)
				.clickHome()
				.clickHome();
		}
	}

	public void fullUserInitialPath() {
		AtBatWelcomePage welcomePage = new AtBatWelcomePage(getDriver());
		if (welcomePage.isOpened()) {
			welcomePage.passToPaywallPage()
				.loginAsExistingUser()
				.login(AtbParameter.MLB_ATBAT_DEFAULT_USER.getValue(), AtbParameter.MLB_ATBAT_DEFAULT_PASSWORD.getValue());
		} else {
			AtBatSettingsPage settingsPage = new AtBatSettingsPage(getDriver());
			settingsPage.openMenu()
				.clickOnMenuItem(MenuItem.SETTINGS);
			settingsPage.tapMenuOption("MLB.com Account")
				.accessMLBAccount()
				.login(AtbParameter.MLB_ATBAT_DEFAULT_USER.getValue(), AtbParameter.MLB_ATBAT_DEFAULT_PASSWORD.getValue())
				.clickHome();
		}
	}

	public void checkInitialFavoriteTeamFlow() {
		AtBatFavoriteTeamSelectionPage favoritePage = new AtBatFavoriteTeamSelectionPage(getDriver());
		if (favoritePage.isOpened()) {
			favoritePage.skipFavoriteTeamSelectionStep()
			.skipPlayServiceAlertInitial()
			.skipSettingNotifications();
		}
	}

    public void assertLiteTVResults(String pageType) {
        AtBatTvPage tvPage = new AtBatTvPage(getDriver());

        //Loop through days from present backwards looking for a day with games.
        while (!tvPage.doGamesExist() && tvPage.isPreviousDayAvailable()) {
            tvPage.tapPreviousDay();
        }

        tvPage.selectStream(1);

        AtBatVideoStreamPage mediaPlayer = new AtBatVideoStreamPage(getDriver());

        Assert.assertFalse(mediaPlayer.isOpen(), String.format("%s (Assert True) - Paywall not visible, TV visible", pageType));

        AtBatPaywallTVPage paywallPage = new AtBatPaywallTVPage(getDriver());

        Assert.assertTrue(paywallPage.paywallPageAvailable(), String.format("%s (Assert True) - Paywall not visible, TV visible", pageType));
    }

    public void assertLiteAudioResults(String pageType) {
        AtBatAudioPage audioPage = new AtBatAudioPage(getDriver());

        Assert.assertFalse(audioPage.isOpen(), String.format("%s (Assert False) - Paywall not visible, Audio page visible", pageType));

        AtBatPaywallPage paywallPage = new AtBatPaywallPage(getDriver());

        Assert.assertTrue(paywallPage.paywallPageAvailable(), String.format("%s (Assert True) - Paywall not visible, Audio page visible", pageType));
    }
}
