package com.mlb.qa.atb.android.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

/**
 * Favorite team selection page<br>
 */
public class AtbSelectFavoriteTeamPage extends AtbAndroidPage {
	@FindBy(id = "com.bamnetworks.mobile.android.ballpark:id/next")
	private ExtendedWebElement nextLink;

	public AtbSelectFavoriteTeamPage(WebDriver driver) {
		super(driver);
	}

	public void skipFavoriteTeamSelection() {
		if (isOpened()) {
			click(nextLink);
		}
	}

	@Override
	public String getExpectedPageAction() {
		return "Select Favorite Team";
	}
}
