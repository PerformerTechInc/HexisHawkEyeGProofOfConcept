package com.mlb.qa.android.at_bat.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

/**
 * MLB At Bat - Login Alerty
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
	@FindBy(xpath = "//Button[@text='Cancel]'")
	private ExtendedWebElement cancelButton;
	@FindBy(xpath = "//Button[@text='OK']")
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
}