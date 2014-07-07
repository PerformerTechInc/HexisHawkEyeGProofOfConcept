package com.mlb.qa.at_bat.android.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

/**
 * MLB At Bat - Settings page
 * @author boyle
 *
 */
public class AtBatSettingsPage extends AtBatAndroidPage {

	//TODO:  Might be able to clean this up
	@FindBy(xpath = "//android.widget.TextView[@text='Favorite Teams']")
	private ExtendedWebElement favoriteTeamLink;
	@FindBy(xpath = "//android.widget.TextView[@text='Notifications']")
	private ExtendedWebElement notificationsLink;
	@FindBy(xpath = "//android.widget.TextView[@text='Low Memory Settings']")
	private ExtendedWebElement lowMemorySettingsLink;
	@FindBy(xpath = "//android.widget.TextView[@text='Audio Feed']")
	private ExtendedWebElement audioFeedLink;
	@FindBy(xpath = "//android.widget.TextView[@text='Scoreboard Refresh Rate']")
	private ExtendedWebElement scoreboardRefreshRateLink;
	@FindBy(xpath = "//android.widget.TextView[@text='Widget Refresh Rate']")
	private ExtendedWebElement widgetRefreshRateLink;
	@FindBy(xpath = "//android.widget.TextView[@text='Gameday Scout']")
	private ExtendedWebElement gamedayScoutLink;
	@FindBy(xpath = "//android.widget.TextView[@text='MLB.com Account']")
	private ExtendedWebElement mlbAccountLoginLink;
	@FindBy(xpath = "//android.widget.TextView[@text='Extras URL']")
	private ExtendedWebElement extrasUrlLink;
	@FindBy(xpath = "//android.widget.TextView[@text='Mock Latitude/Longitude']")
	private ExtendedWebElement mockLatLongLink;
	@FindBy(xpath = "//android.widget.TextView[@text='ENV Setting']")
	private ExtendedWebElement envSettingLink;
	@FindBy(xpath = "//android.widget.TextView[@text='Restore Purchases']")
	private ExtendedWebElement restorePurchasesLink;
	@FindBy(xpath = "//android.widget.TextView[@text='OverLoad URL']")
	private ExtendedWebElement overLoadUrlLink;
	@FindBy(id = "android:id/checkbox")
	private ExtendedWebElement gamedayScoutCheckbox;
	@FindBy(id = "android:id/list")
	private ExtendedWebElement settingsListContainer;
	public static String SETTINGS_LOCATOR_PATTERN = "//android.widget.TextView[@text='%s']";
    @FindBy(id= "android:id/home")
    private ExtendedWebElement home;

	public AtBatSettingsPage(WebDriver driver) {
		super(driver);
	}

	public AtBatLoginAlert accessMLBAccount() {
		//TODO:  Might not necessarily need this?
		if (isElementPresent(mlbAccountLoginLink, delay)) {
			click(mlbAccountLoginLink);
		}

		return new AtBatLoginAlert(driver);
	}

	public AtBatSettingsPage tapMenuOption(String menuOption) {
		//TODO:  Test that this works.
		scrollTo(menuOption, settingsListContainer);
		click(String.format("Settings Option: '%s'", menuOption),
				driver.findElement(By.xpath(String.format(
						SETTINGS_LOCATOR_PATTERN, menuOption))));

		return new AtBatSettingsPage(driver);
	}

	public AtBatAndroidPage clickHome() {
		if (isElementPresent(home)) {
			click(home);
		}
		return new AtBatAndroidPage(driver);
	}
}
