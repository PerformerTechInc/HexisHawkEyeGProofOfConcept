package com.mlb.qa.android.at_bat.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

/**
 * MLB At Bat - Favorite Team page
 * @author boyle
 *
 */
public class AtBatFavoriteTeamSelectionPage extends AtBatAndroidPage {
	
	@FindBy(xpath = "//Button[@text='Next']")
	private ExtendedWebElement nextLink;
	@FindBy(xpath = "//TextView[@text='Select a Favorite Team']")
	private ExtendedWebElement favoriteTeamTitle;
	
	public AtBatFavoriteTeamSelectionPage(WebDriver driver) {
		super(driver);
	}

	public AtBatNotificationsPage skipFavoriteTeamSelectionStep() {
		logger.debug("Skip 'favorite team selection' step if displayed");
		if (isElementPresent(nextLink)) {
			click(nextLink);
		}
		return new AtBatNotificationsPage(driver);
	}

	public AtBatAndroidPage selectFavoriteTeam() {
		//TODO: Need to finish the logic here that allows the selection of the Favorite Team.
		logger.debug("Select 'favorite team select' if displayed");
		if (isElementPresent(favoriteTeamTitle)) {

		}
		return new AtBatAndroidPage(driver);
	}
}