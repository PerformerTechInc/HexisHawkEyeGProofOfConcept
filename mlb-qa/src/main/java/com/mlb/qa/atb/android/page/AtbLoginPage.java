package com.mlb.qa.atb.android.page;

import com.qaprosoft.carina.core.foundation.webdriver.Screenshot;
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
        Screenshot.capture(driver, true);
        type(emailInput, email);
        Screenshot.capture(driver, true);
		type(passwordInput, password);
        Screenshot.capture(driver, true);
		click(loginButton);
        Screenshot.capture(driver, true);
		return new AtbSelectFavoriteTeamPage(driver);
	}

	@Override
	public String getExpectedPageAction() {
		return "Login";
	}
}
