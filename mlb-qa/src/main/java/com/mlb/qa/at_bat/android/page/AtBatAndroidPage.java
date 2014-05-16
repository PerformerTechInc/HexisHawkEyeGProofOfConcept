package com.mlb.qa.at_bat.android.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.mlb.qa.at_bat.android.page.AtBatMenu.MenuItem;
import com.mlb.qa.common.android.page.AndroidPage;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

/**
 * Base Android Page for 'At Bat' Application
 */
public class AtBatAndroidPage extends AndroidPage {
	
	@FindBy(id = "android:id/up")
	private ExtendedWebElement openMenuButton;
	@FindBy(name = "Navigate up")
	private ExtendedWebElement openMenuButtonText;

	public AtBatAndroidPage(WebDriver driver) {
		super(driver);
	}

	public AtBatMenu openMenu() {
		logger.debug("Open menu");
		if (isElementPresent(openMenuButton, delay)) {
			click(openMenuButton);
		} else if (isElementPresent(openMenuButtonText, delay)){
			click(openMenuButtonText);
		}
		return new AtBatMenu(driver);
	}

	public AtBatMenuTeamsPage openTeamsMenu() {
		openMenu().clickOnMenuItem(MenuItem.TEAMS);
		
		return new AtBatMenuTeamsPage(driver);
	}

	public AtBatNewsPage openNews() {
		openMenu().clickOnMenuItem(MenuItem.NEWS);
		
		return new AtBatNewsPage(driver);
	}

	public AtBatScoreboardPage openScoreboard() {
		openMenu().clickOnMenuItem(MenuItem.SCOREBOARD);
		
		return new AtBatScoreboardPage(driver);
	}

	public AtBatTeamPage openFavoriteTeam(String teamName) {
		openMenu().clickOnMenuItem(MenuItem.FAVORITE_TEAM, teamName);
		
		return new AtBatTeamPage(driver);
	}
}
