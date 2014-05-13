package com.mlb.qa.tests.android.atbat;

import org.testng.annotations.Test;
import org.testng.Assert;

import com.mlb.qa.android.at_bat.page.AtBatAndroidPage;
import com.mlb.qa.android.at_bat.page.AtBatFavoriteTeamSelectionPage;
import com.mlb.qa.android.at_bat.page.AtBatMenu;
import com.mlb.qa.android.at_bat.page.AtBatNewsPage;
import com.mlb.qa.android.at_bat.page.AtBatNotificationsPage;
import com.mlb.qa.android.at_bat.page.AtBatNotificationsPage.NotificationsToggleItem;
import com.mlb.qa.android.at_bat.page.AtBatPaywallPage;
import com.mlb.qa.android.at_bat.page.AtBatSchedulePage;
import com.mlb.qa.android.at_bat.page.AtBatTeamRosterPage;
import com.mlb.qa.android.at_bat.page.AtBatTeamRosterPage.RosterTabItem;
import com.mlb.qa.android.at_bat.page.AtBatWebViewPage;
import com.mlb.qa.android.at_bat.page.AtBatWelcomePage;
import com.mlb.qa.android.at_bat.page.AtBatTeamPage;
import com.qaprosoft.carina.core.foundation.UITest;

/**
 * MLB At Bat - Tests involving the Team Page
 * @author boyle
 *
 */
public class AtBatTeamPageTest extends UITest {

	@Test(dataProvider = "excel_ds", priority = 0, description = "Testing Team Carousel")
	public void testTeamCarousel(String teamName) {
		liteUserInitialPath();

		AtBatTeamPage teamPage = new AtBatAndroidPage(driver)
				.openTeamsMenu()
				.openTeamByName(teamName)
					.waitForCarouselLoad()
					.selectCarouselItem(1)
					.selectCarouselItem(2)
					.selectCarouselItem(3)
					.selectCarouselItem(4)
					.selectCarouselItem(3)
					.selectCarouselItem(2)
					.selectCarouselItem(1)
					.selectCarouselItem(0);	
		
		Assert.assertTrue(teamPage.isCarouselItemVisible(0), "Incorrect Carousel Item is being displayed");
	}

	@Test(dataProvider = "excel_ds", priority = 2, description = "Testing Team Carousel Ad Appears for Lite User")
	public void testTeamCarouselLiteAd(String teamName) {

		liteUserInitialPath();

		AtBatTeamPage teamPage = new AtBatAndroidPage(driver)
				.openTeamsMenu()
				.openTeamByName(teamName)
					.waitForCarouselLoad()
					.selectCarouselItem(3)
					.selectCarouselItem(4);

		Assert.assertTrue(teamPage.isSponsorSlideDisplayed(), "The 'Sponsor slide' did not display correctly.");
	}

	@Test(dataProvider = "excel_ds", priority = 3, description = "Testing Team Carousel Ad doesn't appear for Full User")
	public void testTeamCarouselFullNoAd(String teamName) {
		boolean result = false;
		fullUserInitialPath();

		AtBatTeamPage teamPage = new AtBatFavoriteTeamSelectionPage(driver)
				.skipFavoriteTeamSelectionStep()
				.skipPlayServiceAlertInitial()
				.skipSettingNotifications()
				.openTeamsMenu()
					.openTeamByName(teamName)
						.waitForCarouselLoad();

		teamPage.selectCarouselItem(3);
		result &= teamPage.isSponsorSlideDisplayed();
		teamPage.selectCarouselItem(2);
		result &= teamPage.isSponsorSlideDisplayed();
		teamPage.selectCarouselItem(1);
		result &= teamPage.isSponsorSlideDisplayed();
		teamPage.selectCarouselItem(0);

		Assert.assertFalse(result, "The 'Sponsor slide' wasn't expected to be available.");
	}

	@Test(dataProvider = "excel_ds", priority = 4, description = "Testing Team Carousel - 5 Items Exists for Lite User")
	public void testTeamCarouselLite5ItemsExist(String teamName) {
		liteUserInitialPath();

		AtBatTeamPage teamPage = new AtBatAndroidPage(driver)
				.openTeamsMenu()
					.openTeamByName(teamName)
						.waitForCarouselLoad();
		Assert.assertEquals(teamPage.getNumberOfCarouselItems(), 5, "The number of carousel items supposed to be available is incorrect");
	}

	@Test(dataProvider = "excel_ds", priority = 5, description = "Testing Team Carousel - 4 Items Exists for Full User")
	public void testTeamCarouselFull4ItemsExist(String teamName) {
		fullUserInitialPath();

		AtBatTeamPage teamPage = new AtBatFavoriteTeamSelectionPage(driver)
				.skipFavoriteTeamSelectionStep()
				.skipPlayServiceAlertInitial()
				.skipSettingNotifications()
				.openTeamsMenu()
					.openTeamByName(teamName)
						.waitForCarouselLoad();
		Assert.assertEquals(teamPage.getNumberOfCarouselItems(), 4, "The number of carousel items supposed to be available is incorrect");
	}

	@Test(dataProvider = "excel_ds", priority = 6, description = "Testing Team Date Bar - 3 Games Exist")
	public void testTeamDateBar3GamesExist(String teamName) {
		liteUserInitialPath();

		AtBatTeamPage teamPage = new AtBatAndroidPage(driver)
				.openTeamsMenu()
					.openTeamByName(teamName)
						.waitForDateProgressBarLoad();
		Assert.assertEquals(teamPage.getNumberOfDateItems(), 3, "The number of games supposed to be displayed is incorrect.");
	}

	@Test(dataProvider = "excel_ds", priority = 7, description = "Testing Team Date Bar - Switching Between Days")
	public void testTeamDatebarSwitchDays(String teamName) {
		liteUserInitialPath();

		AtBatTeamPage teamPage = new AtBatAndroidPage(driver)
				.openTeamsMenu()
					.openTeamByName(teamName)
						.waitForDateProgressBarLoad()
						.selectDateItem(0)
						.selectDateItem(1)
						.selectDateItem(2)
						.selectDateItem(0)
						.selectDateItem(0);
		//TODO:  Need to add an assert here that can check that the correct Date Item is opened.
	}
	
	@Test(dataProvider = "excel_ds", priority = 8, description = "Testing Team News - Lite User - Ad Displays")
	public void testTeamNewsLiteAd(String teamName) {
		boolean result = true;

		liteUserInitialPath();
		AtBatNewsPage newsPage = new AtBatAndroidPage(driver)
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

	@Test(dataProvider = "excel_ds", priority = 9, description = "Testing Teams News - Full User - No Ad Displays")
	public void testTeamNewsFullNoAd(String teamName) {
		fullUserInitialPath();

		AtBatNewsPage newsPage = new AtBatFavoriteTeamSelectionPage(driver)
				.skipFavoriteTeamSelectionStep()
				.skipPlayServiceAlertInitial()
				.skipSettingNotifications()
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

	@Test(dataProvider = "excel_ds", priority = 10, description = "Testing Teams Video - Lite User - Paywall Appears")
	public void testTeamVideoPaywallAppearsLiteUser(String teamName) {
		liteUserInitialPath();

		new AtBatAndroidPage(driver)
				.openTeamsMenu()
					.openTeamByName(teamName)
					.waitForDateProgressBarLoad()
						.selectTeamVideo();

		AtBatPaywallPage paywallPage = new AtBatPaywallPage(driver);

		Assert.assertTrue(paywallPage.paywallPageAvailable(), "That paywall was supposed to display, but didn't");
	}

	@Test(dataProvider = "excel_ds", priority = 11, description = "Testing Team Schedule - Switching Between Month and List")
	public void testTeamScheduleTabs(String teamName) {
		liteUserInitialPath();

		new AtBatAndroidPage(driver)
				.openTeamsMenu()
					.openTeamByName(teamName)
					.waitForDateProgressBarLoad()
					.swipeUp();

		AtBatSchedulePage schedulePage = new AtBatTeamPage(driver)
					.selectTeamSchedule()
						.selectList()
						.selectMonth()
						.selectList();

		Assert.assertTrue(schedulePage.isListVisible(), "The schedule in list form was supposed to display, but didn't");
	}

	@Test(dataProvider = "excel_ds", priority = 12, description = "Testing Team Roster - Switching Between Name and Position")
	public void testTeamRosterTabs(String teamName) {
		liteUserInitialPath();

		AtBatTeamPage teamPage = new AtBatAndroidPage(driver)
				.openTeamsMenu()
				.openTeamByName(teamName)
				.waitForDateProgressBarLoad();
		teamPage.swipeUp();

		AtBatTeamRosterPage rosterPage = teamPage.selectTeamRoster();
		rosterPage.selectPositionLink();
		Assert.assertTrue(rosterPage.isTabSelected(RosterTabItem.POSITION), "The tab supposed to be selected is not Position.");
		rosterPage.selectNameLink();
		Assert.assertTrue(rosterPage.isTabSelected(RosterTabItem.NAME), "The tab supposed to be selected is not Name.");
		rosterPage.selectPositionLink();
		Assert.assertTrue(rosterPage.isTabSelected(RosterTabItem.POSITION), "The tab supposed to be selected is not Position.");
	}

	@Test(dataProvider = "excel_ds", priority = 13, description = "Testing Team Stadium")
	public void testTeamStadium(String teamName, String stadiumName) {
		liteUserInitialPath();

		AtBatTeamPage teamPage = new AtBatAndroidPage(driver)
				.openTeamsMenu()
				.openTeamByName(teamName)
				.waitForDateProgressBarLoad();
		teamPage.swipeUp();

		Assert.assertTrue(teamPage.isTeamStadium(stadiumName), "The stadium in question is either incorrect or doesn't match it's label correctly.");
	}

	@Test(dataProvider = "excel_ds", priority = 14, description = "Testing Team More")
	public void testTeamMore(String teamName) {
		liteUserInitialPath();

		AtBatTeamPage teamPage = new AtBatAndroidPage(driver)
				.openTeamsMenu()
				.openTeamByName(teamName)
				.waitForDateProgressBarLoad();
		teamPage.swipeUp();
		teamPage.swipeUp();
		teamPage.selectTeamMore();

		Assert.assertTrue(teamPage.getNumberOfMoreItems() >= 3, "The number of items under 'More' has returned less then 3 items.");
	}

	@Test(dataProvider = "excel_ds", priority = 15, description = "Testing Team Facebook")
	public void testTeamMoreFacebook(String teamName, String teamAbbrev) {
		liteUserInitialPath();

		AtBatTeamPage teamPage = new AtBatAndroidPage(driver)
				.openTeamsMenu()
				.openTeamByName(teamName);
		teamPage.swipeUp();
		teamPage.selectTeamMore();
		teamPage.selectTeamMoreFacebook();

		AtBatWebViewPage webViewPage = new AtBatWebViewPage(driver);

		Assert.assertTrue(webViewPage.isTeamsWebView(teamAbbrev), String.format("The Web View displayed is not the correct one for the ", teamName));
	}

	@Test(dataProvider = "excel_ds", priority = 16, description = "Testing Favorite Team Menu - Entry Point")
	public void testTeamEntryFavoriteTeam(String teamName, String teamAbbrev) {
		liteUserInitialPathFavoriteTeam(teamName);

		AtBatTeamPage teamPage = new AtBatMenu(driver)
				.openScoreboard()
				.openFavoriteTeam(teamName);
		
		Assert.assertTrue(teamPage.isTeamsPage(teamAbbrev), String.format("The team page displayed is not the correct team: ", teamName));
	}

	@Test(dataProvider = "excel_ds", priority = 17, description = "Testing Notification - Initial Entry Point ")
	public void testTeamNotificationEntryPoint(String teamName) {
		liteUserInitialPath();
		
		AtBatTeamPage teamPage = new AtBatAndroidPage(driver)
				.openTeamsMenu()
				.openTeamByName(teamName)
				.waitForDateProgressBarLoad();
		teamPage.swipeUp();
		teamPage.swipeUp();
		AtBatNotificationsPage notificationsPage = teamPage.selectTeamNotifications();
		
		Assert.assertTrue(notificationsPage.checkIfTeamVisible(teamName), "The team in question is not present on the screen on initial entry.");
	}

	@Test(dataProvider = "excel_ds", priority = 18, description = "Testing Notification - Toggles Present")
	public void testTeamNotificationTeamExpanded(String teamName) {		
		liteUserInitialPath();
		
		AtBatTeamPage teamPage = new AtBatAndroidPage(driver)
				.openTeamsMenu()
				.openTeamByName(teamName)
				.waitForDateProgressBarLoad();
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
