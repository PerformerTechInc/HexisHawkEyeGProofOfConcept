package com.mlb.qa.atb.android.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

/**
 * Login page<br>
 */
public class AtbLoginPage extends AtbAndroidPage {
	@FindBy(id = "com.bamnetworks.mobile.android.ballpark:id/emailtext")
	private ExtendedWebElement emailInput;
	@FindBy(id = "com.bamnetworks.mobile.android.ballpark:id/passwordtext")
	private ExtendedWebElement passwordInput;
	@FindBy(id = "com.bamnetworks.mobile.android.ballpark:id/loginbutton")
	private ExtendedWebElement loginButton;

	public AtbLoginPage(WebDriver driver) {
		super(driver);
	}

	public AtbSelectFavoriteTeamPage login(String email, String password) {
        type(emailInput, email);
		type(passwordInput, password);
		click(loginButton);
		return new AtbSelectFavoriteTeamPage(driver);
	}

	@Override
	public String getExpectedPageAction() {
		return "Login";
	}
}
