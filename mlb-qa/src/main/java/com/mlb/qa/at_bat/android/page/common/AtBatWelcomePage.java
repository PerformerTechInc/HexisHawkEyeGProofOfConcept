package com.mlb.qa.at_bat.android.page.common;

import com.mlb.qa.at_bat.android.page.common.AtBatAndroidPage;
import com.mlb.qa.at_bat.android.page.paywalls.AtBatPaywallPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

/**
 * MLB At Bat entry point<br>
 * @author boyle
 *
 */
public class AtBatWelcomePage extends AtBatAndroidPage {
	
	@FindBy(xpath = "//android.widget.TextView[@text='No Thanks, Maybe Later']")
	private ExtendedWebElement maybeLaterText;
	@FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/PaywallSponsorAppFragment_continueWithAtBatLite")
	private ExtendedWebElement maybeLaterId;

	public AtBatWelcomePage(WebDriver driver) {
		super(driver);
	}
	
	@Override
	public boolean isOpened() {
		if (isElementPresent(maybeLaterId, 10)) {
			return true;
		} else if (isElementPresent(maybeLaterText, 10)) {
			return true;
		}
		return false;
	}
	
	public AtBatPaywallPage passToPaywallPage() {
		isElementPresent(maybeLaterText, 10);
		return new AtBatPaywallPage(driver);
	}
}