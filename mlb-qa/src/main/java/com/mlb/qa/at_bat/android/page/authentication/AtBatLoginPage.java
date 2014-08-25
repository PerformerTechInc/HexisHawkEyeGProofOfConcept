package com.mlb.qa.at_bat.android.page.authentication;

import com.mlb.qa.at_bat.android.page.common.AtBatAndroidPage;
import com.mlb.qa.at_bat.android.page.AtBatFavoriteTeamSelectionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

/**
 * MLB At Bat - Login page
 * @author boyle
 *
 */
public class AtBatLoginPage extends AtBatAndroidPage {
	
	@FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/emailtext")
	private ExtendedWebElement emailInput;
	@FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/passwordtext")
	private ExtendedWebElement passwordInput;
	@FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/loginbutton")
	private ExtendedWebElement loginButton;
	@FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/privacypolicy")
	private ExtendedWebElement privacyPolicyLink;
	@FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/forgotpasswordtext")
	private ExtendedWebElement forgottenPasswordLink;
	@FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/helpbutton")
	private ExtendedWebElement helpButton;

	public AtBatLoginPage(WebDriver driver) {
		super(driver);
	}

	public AtBatFavoriteTeamSelectionPage login(String email, String password) {
		type(emailInput, email);
		type(passwordInput, password);
		click(loginButton);
		return new AtBatFavoriteTeamSelectionPage(driver);
	}

	//TODO:  Need to check on this
	/*@Override
	public String getExpectedPageAction() {
		return "Login";
	}*/
}