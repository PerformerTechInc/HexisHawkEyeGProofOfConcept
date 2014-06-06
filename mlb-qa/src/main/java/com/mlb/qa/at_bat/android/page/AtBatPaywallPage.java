package com.mlb.qa.at_bat.android.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.mlb.qa.common.exception.TestRuntimeException;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

/**
 * MLB At Bat - Paywall page
 * @author boyle
 *
 */
public class AtBatPaywallPage extends AtBatAndroidPage {

	@FindBy(xpath = "//TextView[@text='Subscribe to At Bat 14']")
	private ExtendedWebElement paywallTitleText;
	@FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/PaywallFragment_loginLabel")
	private ExtendedWebElement existingUserLoginLink;
	@FindBy(xpath = "//TextView[@text='Sign in with MLB.com account']")
	private ExtendedWebElement existingUserLoginText;
	@FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/PaywallFragment_restoreLabel")
	private ExtendedWebElement restorePurchaseLink;
	@FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/PaywallFragment_inAppErrorLabel")
	private ExtendedWebElement storeNotAvailableText;
	@FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/PaywallFragment_continueWithAtBatLite")
	private ExtendedWebElement maybeLaterLink;
	@FindBy(xpath = "//TextView[@text='No Thanks, Maybe Later']")
	private ExtendedWebElement maybeLaterText;

	public AtBatPaywallPage(WebDriver driver) {
		super(driver);
	}

	public AtBatFavoriteTeamSelectionPage continueWithLiteVersion() {
		logger.debug("Skip 'buy premium version' step if displayed");
		// present just for 1st run
		if (isElementPresent(maybeLaterLink, 10)) {
			click(maybeLaterLink);
		} else if (isElementPresent(maybeLaterText, 10)) {
			click(maybeLaterText);
		} else {
			throw new TestRuntimeException(
					"'No Thanks, Maybe Later! not found on this page.");
		}
		return new AtBatFavoriteTeamSelectionPage(driver);
	}

	public AtBatLoginPage loginAsExistingUser() {
		logger.debug("Attempting to 'authorization' as an existing user");
		if (isElementPresent(existingUserLoginLink, 10)) {
			click(existingUserLoginLink);
		} else if (isElementPresent(existingUserLoginText, 10)) {
			click(existingUserLoginText);
		} else {
			throw new TestRuntimeException(
					"'Sign in with MLB.com Account' not found on this page.");
		}

		return new AtBatLoginPage(driver);
	}

	public boolean storeAvailable() {
		if (isElementPresent(storeNotAvailableText, delay)) {
			return false;
		}
		return true;
	}

	public boolean paywallPageAvailable() {
		if (isElementPresent(paywallTitleText, delay)) {
			return true;
		}
		return false;
	}
}
