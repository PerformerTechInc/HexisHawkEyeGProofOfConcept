package com.mlb.qa.android.atb.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

/**
 * Event (game) page. Opens after check in confirmation<br>
 */
public class AtbCheckedInPage extends AtbAndroidPage {
	@FindBy(id = "com.bamnetworks.mobile.android.ballpark:id/venue")
	private ExtendedWebElement stadiumName;

	public AtbCheckedInPage(WebDriver driver) {
		super(driver);
	}

	public String loadCheckedInStadiumName() {
		return stadiumName.getText();
	}

	@Override
	public String getExpectedPageAction() {
		return "Checked In";
	}

}
