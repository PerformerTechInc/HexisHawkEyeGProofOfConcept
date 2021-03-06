package com.mlb.qa.at_bat.android.page.teams;

import com.mlb.qa.at_bat.android.page.common.AtBatAndroidPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.mlb.qa.common.exception.TestRuntimeException;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

/**
 * MLB At Bat - Team Roster page
 * @author boyle
 *
 */
public class AtBatTeamRosterPage extends AtBatAndroidPage {
	public static String ROSTER_NAME_LOCATOR_PATTERN = "//android.widget.TextView[@text='%s']";

	@FindBy(xpath = "//android.widget.TextView[@text='Name']")
	private ExtendedWebElement nameLink;
	@FindBy(xpath = "//android.widget.TextView[@text='Position']")
	private ExtendedWebElement positionLink;
	@FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/RosterActivity_rosterList")
	private ExtendedWebElement rosterList;
	
	// Menu
	public enum RosterTabItem {
		NAME("Name"), POSITION("Position");

		private String title;

		private RosterTabItem(String title) {
			this.title = title;
		}

		public String getTitle() {
			return this.title;
		}
	}

	public AtBatTeamRosterPage(WebDriver driver) {
		super(driver);
	}

	public AtBatTeamRosterPage selectPlayerByName(String playerName) {
		scrollTo(playerName, rosterList);
		click(String.format("Player '%s' name", playerName),
				driver.findElement(By.xpath(String.format(
						ROSTER_NAME_LOCATOR_PATTERN, playerName))));
		return new AtBatTeamRosterPage(driver);
	}

	public AtBatTeamRosterPage selectNameLink() {

        retrySelectionMechanism(nameLink);

//		if (isElementPresent(nameLink, delay)) {
//			click(nameLink);
//		}

		return new AtBatTeamRosterPage(driver);
	}

	public AtBatTeamRosterPage selectPositionLink() {

        retrySelectionMechanism(positionLink);

//		if (isElementPresent(positionLink, delay)) {
//            click(positionLink);
//        }

		return new AtBatTeamRosterPage(driver);
	}

	public boolean isTabSelected(RosterTabItem item) {
		switch (item) {
			case NAME:
                pause(3);
				return nameLink.getElement().isSelected();
			case POSITION:
                pause(3);
				return positionLink.getElement().isSelected();
			default:
				throw new TestRuntimeException(
					"Unknown or unsupported tab item: " + item);
		}
	}
}
