package com.mlb.qa.tests.atbat.android;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mlb.qa.at_bat.android.page.common.AtBatAndroidPage;
import com.mlb.qa.at_bat.android.page.AtBatMenu;
import com.mlb.qa.at_bat.android.page.AtBatNewsPage;
import com.mlb.qa.at_bat.android.page.AtBatNotificationsPage;
import com.mlb.qa.at_bat.android.page.AtBatNotificationsPage.NotificationsToggleItem;
import com.mlb.qa.at_bat.android.page.paywalls.AtBatPaywallPage;
import com.mlb.qa.at_bat.android.page.AtBatSchedulePage;
import com.mlb.qa.at_bat.android.page.teams.AtBatTeamPage;
import com.mlb.qa.at_bat.android.page.teams.AtBatTeamRosterPage;
import com.mlb.qa.at_bat.android.page.teams.AtBatTeamRosterPage.RosterTabItem;
import com.mlb.qa.at_bat.android.page.AtBatWebViewPage;

/**
 * MLB At Bat - Tests involving the Team Page
 * @author boyle
 *
 */
public class AtBatTeamPageMenuTest extends AtBatTest {

	@Test(dataProvider = "excel_ds", priority = 1, description = "Testing Team News - Lite User - Ad Displays")
	public void testTeamNewsLiteAd(String teamName) {
		boolean result = true;

		liteUserInitialPath();
		AtBatNewsPage newsPage = new AtBatAndroidPage(getDriver())
				.openTeamsMenu()
					.openTeamByName(teamName)
					.waitForDateProgressBarLoad()
						.selectTeamNews()
						.switchToDetailedView();

		newsPage.swipeRight();
		newsPage.swipeRight();
		newsPage.swipeRight();
		result &= newsPage.isSponsorSlideDisplayed();
		// 2nd
		newsPage.swipeRight();
		newsPage.swipeRight();
		newsPage.swipeRight();
		newsPage.swipeRight();
		result &= newsPage.isSponsorSlideDisplayed();
		// negative check
		newsPage.swipeLeft();
		newsPage.swipeDown();
		result &= !newsPage.isSponsorSlideDisplayed();
		Assert.assertTrue(
				result,
				"At least one of expected 'Sponsor slide' doesn't displayed or displayed in unexpected place");
	}

	@Test(dataProvider = "excel_ds", priority = 2, description = "Testing Teams News - Full User - No Ad Displays")
	public void testTeamNewsFullNoAd(String teamName) {
		fullUserInitialPath();
		checkInitialFavoriteTeamFlow();

		AtBatNewsPage newsPage = new AtBatNewsPage(getDriver())
				.openTeamsMenu()
					.openTeamByName(teamName)
					.waitForDateProgressBarLoad()
						.selectTeamNews()
						.switchToDetailedView();

		newsPage.swipeRight();
		newsPage.swipeRight();
		newsPage.swipeRight();

		Assert.assertFalse(
				newsPage.isSponsorSlideDisplayed(),
				"The sponsor slide displayed, when it wasn't meant to.");
	}

	@Test(dataProvider = "excel_ds", priority = 3, description = "Testing Teams Video - Lite User - Paywall Appears")
	public void testTeamVideoPaywallAppearsLiteUser(String teamName) {
		liteUserInitialPath();

		//TODO:  This one is going to probably change...
		new AtBatAndroidPage(getDriver())
				.openTeamsMenu()
					.openTeamByName(teamName)
					.waitForDateProgressBarLoad()
						.selectTeamVideo();

		AtBatPaywallPage paywallPage = new AtBatPaywallPage(getDriver());

		Assert.assertTrue(!paywallPage.paywallPageAvailable(), "That paywall was supposed to display, but didn't");
	}

	@Test(dataProvider = "excel_ds", priority = 4, description = "Testing Team Schedule - Switching Between Month and List")
	public void testTeamScheduleTabs(String teamName) {
		liteUserInitialPath();

		new AtBatAndroidPage(getDriver())
				.openTeamsMenu()
					.openTeamByName(teamName)
					.waitForDateProgressBarLoad()
					.swipeUp();

		AtBatSchedulePage schedulePage = new AtBatTeamPage(getDriver())
					.selectTeamSchedule()
						.selectList()
						.selectMonth()
						.selectList();

		Assert.assertTrue(schedulePage.isListVisible(), "The schedule in list form was supposed to display, but didn't");
	}

	@Test(dataProvider = "excel_ds", priority = 5, description = "Testing Team Roster - Switching Between Name and Position")
	public void testTeamRosterTabs(String teamName) {
		liteUserInitialPath();

		AtBatTeamPage teamPage = new AtBatAndroidPage(getDriver())
				.openTeamsMenu()
				.openTeamByName(teamName)
				.waitForDateProgressBarLoad();
		teamPage.swipeUp();
		teamPage.swipeUp();

		AtBatTeamRosterPage rosterPage = teamPage.selectTeamRoster();
		rosterPage.selectPositionLink();
		Assert.assertTrue(rosterPage.isTabSelected(RosterTabItem.POSITION), "The tab supposed to be selected is not Position.");
		rosterPage.selectNameLink();
		Assert.assertTrue(rosterPage.isTabSelected(RosterTabItem.NAME), "The tab supposed to be selected is not Name.");
		rosterPage.selectPositionLink();
		Assert.assertTrue(rosterPage.isTabSelected(RosterTabItem.POSITION), "The tab supposed to be selected is not Position.");
	}

	@Test(dataProvider = "excel_ds", priority = 6, description = "Testing Team Stadium")
	public void testTeamStadium(String teamName, String stadiumName) {
		liteUserInitialPath();

		AtBatTeamPage teamPage = new AtBatAndroidPage(getDriver())
				.openTeamsMenu()
				.openTeamByName(teamName)
				.waitForDateProgressBarLoad();
		teamPage.swipeUp();

		Assert.assertTrue(teamPage.isTeamStadium(stadiumName), "The stadium in question is either incorrect or doesn't match it's label correctly.");
	}

	@Test(dataProvider = "excel_ds", priority = 7, description = "Testing Team More")
	public void testTeamMore(String teamName) {
		liteUserInitialPath();

		AtBatTeamPage teamPage = new AtBatAndroidPage(getDriver())
				.openTeamsMenu()
				.openTeamByName(teamName)
				.waitForDateProgressBarLoad();
		teamPage.swipeUp();
		teamPage.swipeUp();
		teamPage.swipeUp();
		teamPage.selectTeamMore();

		Assert.assertTrue(teamPage.getNumberOfMoreItems() >= 3, "The number of items under 'More' has returned less then 3 items.");
	}

	@Test(dataProvider = "excel_ds", priority = 8, description = "Testing Team Facebook")
	public void testTeamMoreFacebook(String teamName, String teamAbbrev) {
		liteUserInitialPath();

		AtBatTeamPage teamPage = new AtBatAndroidPage(getDriver())
				.openTeamsMenu()
				.openTeamByName(teamName);
		teamPage.swipeUp();
		teamPage.selectTeamMore();
		teamPage.selectTeamMoreFacebook();

		AtBatWebViewPage webViewPage = new AtBatWebViewPage(getDriver());

		Assert.assertTrue(webViewPage.isTeamsWebView(teamAbbrev), String.format("The Web View displayed is not the correct one for the ", teamName));
	}

	@Test(dataProvider = "excel_ds", priority = 9, description = "Testing Favorite Team Menu - Entry Point")
	public void testTeamEntryFavoriteTeam(String teamName, String teamAbbrev) {
		liteUserInitialPathFavoriteTeam(teamName);

		AtBatTeamPage teamPage = new AtBatMenu(getDriver())
				.openScoreboard()
				.openFavoriteTeam(teamName);
		
		Assert.assertTrue(teamPage.isTeamsPage(teamAbbrev), String.format("The team page displayed is not the correct team: ", teamName));
	}

	@Test(dataProvider = "excel_ds", priority = 10, description = "Testing Notification - Initial Entry Point ")
	public void testTeamNotificationEntryPoint(String teamName) {
		liteUserInitialPath();

		AtBatTeamPage teamPage = new AtBatAndroidPage(getDriver())
				.openTeamsMenu()
				.openTeamByName(teamName)
				.waitForDateProgressBarLoad();
		teamPage.swipeUp();
		teamPage.swipeUp();
		teamPage.swipeUp();
		AtBatNotificationsPage notificationsPage = teamPage.selectTeamNotifications();
		
		Assert.assertTrue(notificationsPage.checkIfTeamVisible(teamName), "The team in question is not present on the screen on initial entry.");
	}

	@Test(dataProvider = "excel_ds", priority = 11, description = "Testing Notification - Toggles Present")
	public void testTeamNotificationTeamExpanded(String teamName) {		
		liteUserInitialPath();
		
		AtBatTeamPage teamPage = new AtBatAndroidPage(getDriver())
				.openTeamsMenu()
				.openTeamByName(teamName)
				.waitForDateProgressBarLoad();
		teamPage.swipeUp();
		teamPage.swipeUp();
		teamPage.swipeUp();
		AtBatNotificationsPage notificationsPage = teamPage.selectTeamNotifications();

		Assert.assertTrue(notificationsPage.checkIfNotificationVisible(NotificationsToggleItem.GAME_START), 
				String.format("The %s toggle item is not visible", NotificationsToggleItem.GAME_START.getText()));
		Assert.assertTrue(notificationsPage.checkIfNotificationVisible(NotificationsToggleItem.GAME_END), 
				String.format("The %s toggle item is not visible", NotificationsToggleItem.GAME_END.getText()));
		Assert.assertTrue(notificationsPage.checkIfNotificationVisible(NotificationsToggleItem.SCORING_PLAYS), 
				String.format("The %s toggle item is not visible", NotificationsToggleItem.SCORING_PLAYS.getText()));
		Assert.assertTrue(notificationsPage.checkIfNotificationVisible(NotificationsToggleItem.LEAD_CHANGE), 
				String.format("The %s toggle item is not visible", NotificationsToggleItem.LEAD_CHANGE.getText()));
		Assert.assertTrue(notificationsPage.checkIfNotificationVisible(NotificationsToggleItem.NEWS), 
				String.format("The %s toggle item is not visible", NotificationsToggleItem.NEWS.getText()));
	}
}
