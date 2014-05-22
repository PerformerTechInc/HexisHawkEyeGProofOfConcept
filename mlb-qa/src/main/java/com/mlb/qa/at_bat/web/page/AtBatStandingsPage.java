package com.mlb.qa.at_bat.web.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class AtBatStandingsPage extends AbstractPage {
	private static final Logger logger = Logger.getLogger(AtBatStandingsPage.class);

	@FindBy(xpath = "//tr[@class='standings-favorite']/td[@class='standings-col-division text-left']")
	private ExtendedWebElement favoriteTeamStandings;
	@FindBy(xpath = "//tr[@class='standings-favorite']/td[@class='standings-col-division text-left']/span[@class='title-short']")
	private ExtendedWebElement favoriteTeamShortCode;
	@FindBy(xpath = "//ul[@class='standings-legend']/li[1]")
	private ExtendedWebElement legendWildCard;
	@FindBy(xpath = "//ul[@class='standings-legend']/li[2]")
	private ExtendedWebElement legendPlayoffBirth;
	@FindBy(xpath = "//ul[@class='standings-legend']/li[3]")
	private ExtendedWebElement legendDivision;
	@FindBy(xpath = "//ul[@class='standings-legend']/li[4]")
	private ExtendedWebElement legendClinchedBestRecord;
	
	public AtBatStandingsPage(WebDriver driver) {
		super(driver);
	}

	public static AtBatStandingsPage open(WebDriver driver, String url) {
		logger.info("Attempting to verify Standings URL: " + url);
		driver.get(url);
		driver.navigate().refresh();
		return new AtBatStandingsPage(driver);
	}

	public Boolean isFavoriteTeamHighlighted(String teamShortCode) {
		boolean result = true;

		logger.info("Currently Selected Team Info: " + favoriteTeamShortCode.getAttribute("innerHTML"));
		result &= favoriteTeamShortCode.getAttribute("innerHTML").equalsIgnoreCase(teamShortCode);

		logger.info("Checking Font: " + favoriteTeamStandings.getElement().getCssValue("font-weight"));
		result &= isBold(favoriteTeamStandings.getElement().getCssValue("font-weight"));

		logger.info("Favorite Team Background is Grey? " + favoriteTeamStandings.getElement().getCssValue("background-color").contains("rgba(244, 244, 244, 1)"));
		result &= favoriteTeamStandings.getElement().getCssValue("background-color").contains("rgba(244, 244, 244, 1)"); //Background Color of Grey

		return result;
	}

	public Boolean isPlayoffLegendAvailable() {
		if (isElementPresent(legendWildCard, 3) && 
				isElementPresent(legendPlayoffBirth, 3) && 
				isElementPresent(legendDivision, 3) &&
				isElementPresent(legendClinchedBestRecord, 3)) {
			return true;
		}
		return false;
	}

	/**
	 * Checks to see if either representation of bold exists as it can be different
	 * between browsers.
	 * 700 - Firefox
	 * bold - Chrome
	 * @param boldRepresentation is the string bold representation to check.
	 * @return brings back whether the string passed can be considered bold.
	 */
	private Boolean isBold(String boldRepresentation) {
		if (boldRepresentation.equals("700") || boldRepresentation.equals("bold")) {
			return true;
		}
		return false;
	}
}
