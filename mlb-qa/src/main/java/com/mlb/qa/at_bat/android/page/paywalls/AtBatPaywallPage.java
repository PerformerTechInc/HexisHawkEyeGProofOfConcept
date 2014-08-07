package com.mlb.qa.at_bat.android.page.paywalls;

import com.mlb.qa.at_bat.android.page.common.AtBatAndroidPage;
import com.mlb.qa.at_bat.android.page.AtBatFavoriteTeamSelectionPage;
import com.mlb.qa.at_bat.android.page.authentication.AtBatLoginPage;
import org.openqa.selenium.By;
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

	@FindBy(xpath = "//android.widget.TextView[@text='Subscribe to At Bat 14']")
	private ExtendedWebElement paywallTitleText;
	@FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/PaywallFragment_loginLabel")
	private ExtendedWebElement existingUserLoginLink;
	@FindBy(xpath = "//android.widget.TextView[@text='Sign in with MLB.com account']")
	private ExtendedWebElement existingUserLoginText;
	@FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/PaywallFragment_restoreLabel")
	private ExtendedWebElement restorePurchaseLink;
	@FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/PaywallFragment_inAppErrorLabel")
	private ExtendedWebElement storeNotAvailableText;
	@FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/PaywallFragment_continueWithAtBatLite")
	private ExtendedWebElement maybeLaterLink;
	@FindBy(xpath = "//android.widget.TextView[@text='No Thanks, Maybe Later']")
	private ExtendedWebElement maybeLaterText;
	@FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/PaywallSponsorAppFragment_redeemSponsorButton")
	private ExtendedWebElement sponsorRedeemButton;
	@FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/PaywallSponsorAppFragment_continueContainer")
	private ExtendedWebElement paywallContinueContainer;
    @FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/PaywallSponsorAppFragment_loginLabel")
    private ExtendedWebElement loginLabel;

	public AtBatPaywallPage(WebDriver driver) {
		super(driver);
	}

	public AtBatFavoriteTeamSelectionPage continueWithLiteVersion() {
		logger.info("Skip 'buy premium version' step if displayed");
		// present just for 1st run
		if (isElementPresent(maybeLaterLink, 10)) {
			click(maybeLaterLink);
		} else if (isElementPresent(paywallContinueContainer, 10)) {
			click("No Thanks, Maybe Later! - Container",
					paywallContinueContainer.getElement().findElement(By.className("android.widget.TextView")));
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

	public void selectRedeemOption() {
		click(sponsorRedeemButton);
	}

	public boolean storeAvailable() {
		if (isElementPresent(storeNotAvailableText, delay)) {
			return false;
		}
		return true;
	}

	public boolean paywallPageAvailable() {
        //TODO:  Need something that works for both T-Mobile and Non-T-Mobile
		if (isElementPresent(paywallTitleText, delay)) {
			return true;
		} else if (isElementPresent(loginLabel, delay)) {
            return true;
        }
		return false;
	}
}
