package com.mlb.qa.tests.atbat.android;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mlb.qa.at_bat.android.page.common.AtBatAndroidPage;
import com.mlb.qa.at_bat.android.page.teams.AtBatTeamPage;

/**
 * Tests that involve Ads inside of the At Bat Application
 * @author boyle
 *
 */
public class AtBatAdsTest extends AtBatTest {
	
	@Test(dataProvider = "excel_ds", priority = 1, description = "Teams Ads - Lite User Ad Visible")
	public void testTeamAdVisible(String teamName) {
		liteUserInitialPath();

		AtBatTeamPage teamPage = new AtBatAndroidPage(driver)
				.openTeamsMenu()
				.openTeamByName(teamName)
				.waitForDateProgressBarLoad();
		
		Assert.assertTrue(teamPage.isAdVisible(), "The Ad was not visible for a Lite User");
	}

	@Test(dataProvider = "excel_ds", priority = 2, description = "Team Ads - Full User Ad Not Visible")
	public void testTeamAdNotVisible(String teamName) {
		fullUserInitialPath();
		
		AtBatTeamPage teamPage = new AtBatAndroidPage(driver)
				.openTeamsMenu()
				.openTeamByName(teamName)
				.waitForDateProgressBarLoad();

		Assert.assertTrue(!teamPage.isAdVisible(), "The Ad was visible for a Full User");
	}
}
