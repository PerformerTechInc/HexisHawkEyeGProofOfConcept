package com.mlb.qa.android.atb.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.mlb.qa.android.atb.exception.CheckInProcessingException;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

/**
 * Ballpark home page
 */
public class AtbBallparkPage extends AtbAndroidPage {
	@FindBy(id = "com.bamnetworks.mobile.android.ballpark:id/ballparkupcominggame_checkin")
	private ExtendedWebElement checkInButton;
	@FindBy(id = "android:id/button1")
	private ExtendedWebElement okButtonOnPopup;
	@FindBy(id = "android:id/text1")
	private ExtendedWebElement errorMessageOnPopup;

	public AtbBallparkPage(WebDriver driver) {
		super(driver);
	}

	public AtbCheckinPage openCheckInPage() {
		if (isElementNotPresent(checkInButton)) {
			throw new CheckInProcessingException(
					"No 'Check in' button present on the screen");
		}
		click(checkInButton);
		if (isElementPresent(okButtonOnPopup)) {
			throw new CheckInProcessingException(errorMessageOnPopup.getText());
		}
		return new AtbCheckinPage(driver);
	}
}
