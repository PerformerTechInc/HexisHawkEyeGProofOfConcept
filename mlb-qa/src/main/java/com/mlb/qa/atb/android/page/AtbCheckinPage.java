package com.mlb.qa.atb.android.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;
import com.mlb.qa.atb.android.exception.CheckInProcessingException;
import com.mlb.qa.common.timeout.Timeouts;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

/**
 * Check in page<br>
 */
public class AtbCheckinPage extends AtbAndroidPage {
	@FindBy(id = "com.bamnetworks.mobile.android.ballpark:id/confirmcheckinbutton")
	private ExtendedWebElement confirmCheckinButton;
	@FindBy(xpath = "//TextView[@text='Determining device location']")
	private ExtendedWebElement determiningLocationText;
	@FindBy(id = "com.bamnetworks.mobile.android.ballpark:id/refresh_text")
	private ExtendedWebElement refreshButton;
	@FindBy(id = "com.bamnetworks.mobile.android.ballpark:id/ActionBarMenuItem_teleport")
	private ExtendedWebElement teleportButton;
	@FindBy(id = "android:id/alertTitle")
	private ExtendedWebElement alertTitle;
	@FindBy(id = "android:id/message")
	private ExtendedWebElement alertMessage;

	public AtbCheckinPage(WebDriver driver) {
		super(driver);
	}

	public AtbCheckinPage processLocationDetermining() {
		logger.info("Wait for location determining and'teleport' to correct location if needed");
		waitForDeterminingLocation();
		if (isErrorMessagePresent()) {
			// teleport to the location
			click(teleportButton);
			click(refreshButton);
			waitForDeterminingLocation();
		}
		return this;
	}

	// TODO: re-implement this method. with it test are really slow
	private void waitForDeterminingLocation() {
		new WebDriverWait(driver,
				Timeouts.DEFAULT_CONTENT_LOADING_TIMEOUT.getTimeoutInSeconds())
				.until(new Predicate<WebDriver>() {

					@Override
					public boolean apply(WebDriver arg0) {
						return !(isProgressBarPresent() || isElementPresent(determiningLocationText, delay));
					}
				});
	}

	public AtbCheckedInPage confirmCheckIn() {
		click(confirmCheckinButton);
		if (isElementPresent(alertTitle, delay)
				&& "Error".equalsIgnoreCase(alertTitle.getText())) {
			throw new CheckInProcessingException(alertMessage.getText());
		}
		return new AtbCheckedInPage(driver);
	}

	@Override
	public String getExpectedPageAction() {
		return "Check In";
	}
}
