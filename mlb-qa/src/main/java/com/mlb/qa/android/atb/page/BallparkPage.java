package com.mlb.qa.android.atb.page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.mlb.qa.android.atb.exception.CheckInUnavailableException;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

/**
 * Ballpark home page
 */
public class BallparkPage extends AtbAndroidPage {
	@FindBy(id = "com.bamnetworks.mobile.android.ballpark:id/ballparkupcominggame_checkin")
	private ExtendedWebElement checkInButton;

	public BallparkPage(WebDriver driver) {
		super(driver);
	}

	public CheckinPage openCheckInPage() {
		if (isElementNotPresent(checkInButton)) {
			throw new CheckInUnavailableException(
					"No 'Check in' button present on the screen");
		}
		click(checkInButton);
		if (isAlertPresent()) {
			logger.debug("Try to close allert");
			Alert alert = driver.switchTo().alert();
			String msg = alert.getText();
			alert.accept();
			throw new CheckInUnavailableException(
					"Impossible to open check in window. Reason: " + msg);
		}
		return new CheckinPage(driver);
	}
}
