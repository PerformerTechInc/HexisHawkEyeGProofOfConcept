package com.mlb.qa.android.at_bat.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

/**
 * MLB At Bat - Notifications page
 * @author boyle
 *
 */
public class AtBatNotificationsPage extends AtBatAndroidPage {

	@FindBy(id = "android:id/alertTitle")
	private ExtendedWebElement alertPlayServices;
	@FindBy(id = "android:id/button1")
	private ExtendedWebElement alertOkLink;

	@FindBy(xpath = "//TextView[@text='Notifications']")
	private ExtendedWebElement notificationsExists;

	@FindBy(xpath = "//Button[@text='Done']")
	private ExtendedWebElement doneLink;

	public AtBatNotificationsPage(WebDriver driver) {
		super(driver);
	}

	public AtBatAndroidPage skipSettingNotifications() {
		logger.debug("Skip 'notification selection step' if displayed");
		skipPlayServiceAlert();
		if (isElementPresent(notificationsExists, delay)) {
			click(doneLink);
		}
		return new AtBatAndroidPage(driver);
	}

	public void skipPlayServiceAlert() {
		logger.debug("Skip 'google play service not supported' step if displayed");
		if (isElementPresent(alertPlayServices, delay)) {
			if (isElementPresent(alertOkLink, delay)) {
				click(alertOkLink);
			}
		}
	}

	public AtBatNotificationsPage skipPlayServiceAlertInitial() {
		logger.debug("Skip 'google play service not supported' step if displayed");
		if (isElementPresent(alertPlayServices, delay)) {
			if (isElementPresent(alertPlayServices, delay)) {
				click(alertOkLink);
			}
		}
		return new AtBatNotificationsPage(driver);
	}
	//TODO:  Need to add in Notification Toggling still.
}
