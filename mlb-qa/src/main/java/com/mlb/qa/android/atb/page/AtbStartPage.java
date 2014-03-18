package com.mlb.qa.android.atb.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

/**
 * MLB Ballpark start page<br>
 */
public class AtbStartPage extends AtbAndroidPage {
	@FindBy(xpath = "//TextView[@text='Create an MLB.com account or log in with your existing MLB.com information.']")
	private ExtendedWebElement mlbLoginTitle;
	@FindBy(id = "com.bamnetworks.mobile.android.ballpark:id/signin")
	private ExtendedWebElement signInButton;

	public AtbStartPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public boolean isOpened() {
		return isElementPresent(mlbLoginTitle);
	}

	public AtbLoginPage passToLoginPage() {
		click(signInButton);
		return new AtbLoginPage(driver);
	}
}
