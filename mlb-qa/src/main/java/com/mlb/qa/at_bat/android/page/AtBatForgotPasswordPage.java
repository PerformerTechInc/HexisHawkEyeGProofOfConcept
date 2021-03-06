package com.mlb.qa.at_bat.android.page;

import com.mlb.qa.at_bat.android.page.common.AtBatAndroidPage;
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
	@FindBy(xpath = "//android.widget.TextView[@text='New Password Sent!']")
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
		if (isElementPresent(newPasswordLabel, delay)) {
			return true;
		}
		return false;
	}
}
