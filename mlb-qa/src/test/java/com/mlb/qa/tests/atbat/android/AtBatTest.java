package com.mlb.qa.tests.atbat.android;

import com.mlb.qa.at_bat.android.page.AtBatWelcomePage;
import com.qaprosoft.carina.core.foundation.UITest;

/**
 * Generic Class for Methods that can be utilized by the different At Bat Tests
 * @author boyle
 *
 */
public class AtBatTest extends UITest {
	public void liteUserInitialPath() {
		new AtBatWelcomePage(driver)
			.passToPaywallPage()
			.continueWithLiteVersion()
			.skipFavoriteTeamSelectionStep()
			.skipPlayServiceAlertInitial()
			.skipSettingNotifications();
	}

	public void liteUserInitialPathFavoriteTeam(String teamName) {
		new AtBatWelcomePage(driver)
			.passToPaywallPage()
			.continueWithLiteVersion()
			.selectFavoriteTeam(teamName)
			.selectNext()  
			.skipPlayServiceAlertInitial()
			.skipSettingNotifications();
	}

	public void fullUserInitialPath() {
		new AtBatWelcomePage(driver)
			.passToPaywallPage()
			.loginAsExistingUser()
				.login("media6@mlbtest.com", "p@ssw0rd");
	}
}
