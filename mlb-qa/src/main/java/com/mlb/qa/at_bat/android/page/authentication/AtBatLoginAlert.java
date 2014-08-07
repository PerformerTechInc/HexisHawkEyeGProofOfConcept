package com.mlb.qa.at_bat.android.page.authentication;

import com.mlb.qa.at_bat.android.page.common.AtBatAndroidPage;
import com.mlb.qa.at_bat.android.page.AtBatForgotPasswordPage;
import com.mlb.qa.at_bat.android.page.AtBatSettingsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

/**
 * MLB At Bat - Login Alert
 * @author boyle
 *
 */
public class AtBatLoginAlert extends AtBatAndroidPage {

	@FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/email_address")
	private ExtendedWebElement emailInput;
	@FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/password")
	private ExtendedWebElement passwordInput;
	@FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/privacypolicy")
	private ExtendedWebElement privacyPolicyLink;
	@FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/forgotpasswordtext")
	private ExtendedWebElement forgottenPasswordLink;
	@FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/registeruserbutton")
	private ExtendedWebElement registerButton;
	@FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/clearbutton")
	private ExtendedWebElement clearCredentialsButton;
	@FindBy(id = "android:id/button2")
	private ExtendedWebElement cancelButton;
	@FindBy(id = "android:id/button1")
	private ExtendedWebElement okButton;

	public AtBatLoginAlert(WebDriver driver) {
		super(driver);
	}

	public AtBatSettingsPage login(String email, String password) {
		type(emailInput, email);
		type(passwordInput, password);
		click(okButton);
		return new AtBatSettingsPage(driver);
	}

	public AtBatSettingsPage logOut() {
		click(clearCredentialsButton);
		return new AtBatSettingsPage(driver);
	}

	public AtBatSettingsPage cancel() {
		click(cancelButton);
		return new AtBatSettingsPage(driver);
	}

	public AtBatForgotPasswordPage forgotPasword() {
		click(forgottenPasswordLink);
		return new AtBatForgotPasswordPage(driver);
	}

	public Boolean isLoggedIn() {
		return isElementPresent(clearCredentialsButton, delay);
	}

	public AtBatSettingsPage clearCredentials() {
		click(clearCredentialsButton);

		return new AtBatSettingsPage(driver);
	}
}
