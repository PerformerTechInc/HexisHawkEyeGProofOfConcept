package com.mlb.qa.android.atb.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

/**
 * Event (game) page. Opens after check in confirmation<br>
 */
public class AtbEventPage extends AtbAndroidPage {
	// TODO: add locator (blocked due to unavailability of page
	@FindBy(id = "")
	private ExtendedWebElement checkinNumber;

	public AtbEventPage(WebDriver driver) {
		super(driver);
	}

	public boolean isCheckinNumberPresent() {
		return isElementPresent(checkinNumber);
	}

}
