package com.mlb.qa.at_bat.android.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

/**
 * MLB At Bat - Team List page
 * @author boyle
 *
 */
public class AtBatMenuTeamsPage extends AtBatMenu {

	@FindBy(id="com.bamnetworks.mobile.android.gameday.atbat:id/MlbTeamListFragment_list")
	private ExtendedWebElement teamsListContainer;	
	public AtBatMenuTeamsPage(WebDriver driver) {
		super(driver);
	}

	public AtBatTeamPage openTeamByName(String teamName) {
		scrollTo(teamName, teamsListContainer);
		click(String.format("Team '%s' name", teamName),
				driver.findElement(By.xpath(String.format(
						MENU_ITEM_LOCATOR_PATTERN, teamName))));
		return new AtBatTeamPage(driver);
	}
}
