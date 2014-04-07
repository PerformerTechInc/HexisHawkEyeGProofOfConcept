package com.mlb.qa.android.at_bat.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

/**
 * MLB At Bat - Forgot Password page
 * @author boyle
 *
 */
public class AtBatForgotPasswordPage extends AtBatAndroidPage {

	@FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/emailtext")
	private ExtendedWebElement emailInput;
	@FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/sendbutton")
	private ExtendedWebElement sendButton;
	@FindBy(xpath = "//TextView[@text='New Password Sent!']")
	private ExtendedWebElement newPasswordLabel;

	public AtBatForgotPasswordPage(WebDriver driver) {
		super(driver);
	}

	public AtBatForgotPasswordPage resetPassword(String email) {
		type(emailInput, email);
		click(sendButton);
		return new AtBatForgotPasswordPage(driver);
	}

	public boolean passwordSent() {
		if (isElementPresent(newPasswordLabel)) {
			return true;
		}
		return false;
	}
}
