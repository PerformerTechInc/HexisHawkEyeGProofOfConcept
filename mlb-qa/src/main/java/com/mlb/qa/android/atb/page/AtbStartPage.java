package com.mlb.qa.android.atb.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

/**
 * MLB Ballpark start page<br>
 */
public class AtbStartPage extends AtbAndroidPage {
	@FindBy(xpath = "//TextView[@text='MLB Ballpark']")
	private ExtendedWebElement mlbTitle;
	@FindBy(id = "com.bamnetworks.mobile.android.ballpark:id/signin")
	private ExtendedWebElement getStartedButton;

	public AtbStartPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public boolean isOpened() {
		return isElementPresent(mlbTitle);
	}

	public AtbLoginPage passToLoginPage() {
		click(getStartedButton);
		return new AtbLoginPage(driver);
	}
}
