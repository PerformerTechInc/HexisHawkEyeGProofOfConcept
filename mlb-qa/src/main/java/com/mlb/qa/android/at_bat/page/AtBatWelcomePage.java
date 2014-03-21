package com.mlb.qa.android.at_bat.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

public class AtBatWelcomePage extends AtBatAndroidPage {

	@FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/PaywallFragment_continueWithAtBatLite")
	public ExtendedWebElement maybeLaterLink;

	public AtBatWelcomePage(WebDriver driver) {
		super(driver);
	}

	public FavoriteTeamSelectionPage continueWithLiteVersion() {
		logger.debug("Skip 'buy premium version' step if displayed");
		// present just for 1st run
		if (isElementPresent(maybeLaterLink, 3)) {
			click(maybeLaterLink);
		}
		return new FavoriteTeamSelectionPage(driver);
	}
}
