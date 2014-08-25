package com.mlb.qa.tests.atbat.android;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mlb.qa.at_bat.android.page.common.AtBatAndroidPage;
import com.mlb.qa.at_bat.android.page.teams.AtBatTeamPage;

public class AtBatTeamPageCarouselTest extends AtBatTest {
	
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
		checkInitialFavoriteTeamFlow();

		AtBatTeamPage teamPage = new AtBatTeamPage(driver)
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
		checkInitialFavoriteTeamFlow();

		AtBatTeamPage teamPage = new AtBatTeamPage(driver)
				.openTeamsMenu()
					.openTeamByName(teamName)
						.waitForCarouselLoad();
		Assert.assertEquals(teamPage.getNumberOfCarouselItems(), 4, "The number of carousel items supposed to be available is incorrect");
	}
}
