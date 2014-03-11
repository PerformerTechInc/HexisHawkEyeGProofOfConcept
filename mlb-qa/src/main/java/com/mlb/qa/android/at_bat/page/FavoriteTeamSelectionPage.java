package com.mlb.qa.android.at_bat.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

public class FavoriteTeamSelectionPage extends AtBatAndroidPage {
	@FindBy(xpath = "//Button[@text='No thanks, maybe later']")
	public ExtendedWebElement maybeLaterLink;

	public FavoriteTeamSelectionPage(WebDriver driver) {
		super(driver);
	}

	public AtBatAndroidPage skipFavoriteTeamSelectionStep() {
		logger.debug("Skip 'favorite team selection' step if displayed");
		if (isElementPresent(maybeLaterLink)) {
			click(maybeLaterLink);
		}
		return new AtBatAndroidPage(driver);
	}

}
