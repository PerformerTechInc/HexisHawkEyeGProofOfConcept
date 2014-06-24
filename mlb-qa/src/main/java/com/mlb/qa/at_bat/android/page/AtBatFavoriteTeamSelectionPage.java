package com.mlb.qa.at_bat.android.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.mlb.qa.common.exception.TestRuntimeException;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

/**
 * MLB At Bat - Favorite Team page
 * @author boyle
 *
 */
public class AtBatFavoriteTeamSelectionPage extends AtBatMenu {
	
	@FindBy(xpath = "//Button[@text='Next']")
	private ExtendedWebElement nextLink;
	@FindBy(xpath = "//android.widget.TextView[@text='Select a Favorite Team']")
	private ExtendedWebElement favoriteTeamTitle;
	@FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/MLBTeamListFragment_favoriteList")
	private ExtendedWebElement favoriteTeamListContainer;
	
	public AtBatFavoriteTeamSelectionPage(WebDriver driver) {
		super(driver);
	}

	public AtBatNotificationsPage skipFavoriteTeamSelectionStep() {
		logger.debug("Skip 'favorite team selection' step if displayed");
		tapNext();
		
		return new AtBatNotificationsPage(driver);
	}

	/**
	 * Used if on the Favorite Team Page
	 * @param teamName is the name of the team to be selected.
	 * @return brings back a new instance of the Favorite Team Page.
	 */
	public AtBatFavoriteTeamSelectionPage selectFavoriteTeam(String teamName) {
		logger.debug("Select 'favorite team select' if displayed");
		if (isElementPresent(favoriteTeamTitle, delay)) {
			scrollTo(teamName, favoriteTeamListContainer);
			click(String.format("Team: '%s'", teamName),
					driver.findElement(By.xpath(String.format(
							MENU_ITEM_LOCATOR_PATTERN, teamName))));
		}
		return new AtBatFavoriteTeamSelectionPage(driver);
	}

	public AtBatNotificationsPage selectNext() {
		tapNext();
		
		return new AtBatNotificationsPage(driver);
	}

	private void tapNext() {
		if (isElementPresent(nextLink, 10)) {
			click(nextLink);
		} else {
			throw new TestRuntimeException(
					"'Next' button not found on this page");
		}
	}
}