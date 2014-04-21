package com.mlb.qa.android.at_bat.page;

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
	@FindBy(xpath = "//TextView[@text='Favorite Teams']")
	private ExtendedWebElement favoriteTeamLink;
	@FindBy(xpath = "//TextView[@text='Notifications']")
	private ExtendedWebElement notificationsLink;
	@FindBy(xpath = "//TextView[@text='Low Memory Settings']")
	private ExtendedWebElement lowMemorySettingsLink;
	@FindBy(xpath = "//TextView[@text='Audio Feed']")
	private ExtendedWebElement audioFeedLink;
	@FindBy(xpath = "//TextView[@text='Scoreboard Refresh Rate']")
	private ExtendedWebElement scoreboardRefreshRateLink;
	@FindBy(xpath = "//TextView[@text='Widget Refresh Rate']")
	private ExtendedWebElement widgetRefreshRateLink;
	@FindBy(xpath = "//TextView[@text='Gameday Scout']")
	private ExtendedWebElement gamedayScoutLink;
	@FindBy(xpath = "//TextView[@text='MLB.com Account']")
	private ExtendedWebElement mlbAccountLoginLink;
	@FindBy(xpath = "//TextView[@text='Extras URL']")
	private ExtendedWebElement extrasUrlLink;
	@FindBy(xpath = "//TextView[@text='Mock Latitude/Longitude']")
	private ExtendedWebElement mockLatLongLink;
	@FindBy(xpath = "//TextView[@text='ENV Setting']")
	private ExtendedWebElement envSettingLink;
	@FindBy(xpath = "//TextView[@text='Restore Purchases']")
	private ExtendedWebElement restorePurchasesLink;
	@FindBy(xpath = "//TextView[@text='OverLoad URL']")
	private ExtendedWebElement overLoadUrlLink;
	@FindBy(id = "android:id/checkbox")
	private ExtendedWebElement gamedayScoutCheckbox;
	@FindBy(id = "android:id/list")
	private ExtendedWebElement settingsListContainer;
	public static String SETTINGS_LOCATOR_PATTERN = "//TextView[@text='%s']";

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

	public AtBatAndroidPage tapMenuOption(String menuOption) {
		//TODO:  Test that this works.
		scrollTo(menuOption, settingsListContainer);
		click(String.format("Settings Option: '%s'", menuOption),
				driver.findElement(By.xpath(String.format(
						SETTINGS_LOCATOR_PATTERN, menuOption))));

		return new AtBatAndroidPage(driver);
	}
}
