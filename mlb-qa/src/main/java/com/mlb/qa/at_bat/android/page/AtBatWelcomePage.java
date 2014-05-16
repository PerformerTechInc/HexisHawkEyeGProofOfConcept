package com.mlb.qa.at_bat.android.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

/**
 * MLB At Bat entry point<br>
 * @author boyle
 *
 */
public class AtBatWelcomePage extends AtBatAndroidPage {
	
	@FindBy(xpath = "//TextView[@text='No Thanks, Maybe Later']")
	public ExtendedWebElement maybeLaterText;

	public AtBatWelcomePage(WebDriver driver) {
		super(driver);
	}
	
	@Override
	public boolean isOpened() {
		return isElementPresent(maybeLaterText, delay);
	}
	
	public AtBatPaywallPage passToPaywallPage() {
		isElementPresent(maybeLaterText, 10);
		return new AtBatPaywallPage(driver);
	}
}