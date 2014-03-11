package com.mlb.qa.tests.android;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mlb.qa.android.at_bat.page.AtBatAndroidPage;
import com.mlb.qa.android.at_bat.page.AtBatWelcomePage;
import com.mlb.qa.android.at_bat.page.NewsPage;
import com.qaprosoft.carina.core.foundation.UITest;

public class AppiumAndroidAtBatTest extends UITest {
	private String[] shareOptionsArr = { "Messaging", "Bluetooth", "Google",
			"Google+", "Gmail" };

	@Test(priority = 0, description = "Pass welcome and team selection steps if displayed")
	public void testPaywallLiteUser() {
		new AtBatWelcomePage(driver).continueWithLiteVersion()
				.skipFavoriteTeamSelectionStep();

	}

	@Test(priority = 1, description = "Swiping on news page")
	public void testSwipingOnNewsPage() {
		NewsPage newsPage = new AtBatAndroidPage(driver).openMenu()
				.openNewsPageIfNotOpened();
		newsPage.swipeRight();
		newsPage.swipeRight();
		newsPage.swipeRight();
		newsPage.swipeRight();
		newsPage.swipeLeft();
		newsPage.swipeDown();
		newsPage.swipeUp();
		newsPage.swipeRight();
	}

	@Test(priority = 2, description = "Check 'Sponsor slide' displayed in expected news pages")
	public void testNewsAdsAppears() {
		boolean result = true;
		// 1st 'Sponsor slide'
		NewsPage newsPage = new AtBatAndroidPage(driver).openMenu()
				.openNewsPageIfNotOpened().switchToDetailedView();
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

	@Test(priority = 3, description = "Check available Share options")
	public void testNewsShare() {
		NewsPage newsPage = new AtBatAndroidPage(driver).openMenu()
				.openNewsPageIfNotOpened().switchToDetailedView();
		List<String> shareOptions = newsPage.loadShareWithOptions();
		List<String> expectedShareOptions = new LinkedList<String>();
		expectedShareOptions.addAll(Arrays.asList(shareOptionsArr));
		Collections.sort(shareOptions);
		Collections.sort(expectedShareOptions);
		Assert.assertTrue(expectedShareOptions.equals(shareOptions),
				"List of expected share options not equal to expected one");
	}
}
