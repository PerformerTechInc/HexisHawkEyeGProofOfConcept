package com.mlb.qa.at_bat.android.page;

import com.mlb.qa.at_bat.android.page.common.AtBatAndroidPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import com.mlb.qa.common.exception.TestRuntimeException;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

/**
 * MLB At Bat - Notifications page
 * @author boyle
 *
 */
public class AtBatNotificationsPage extends AtBatAndroidPage {

	@FindBy(id = "android:id/alertTitle")
	private ExtendedWebElement alertPlayServices;
	@FindBy(id = "android:id/button1")
	private ExtendedWebElement alertOkLink;

	//Action Bar Items
	@FindBy(xpath = "//android.widget.TextView[@text='Notifications']")
	private ExtendedWebElement notificationsExists;
	@FindBy(xpath = "//android.widget.Button[@text='Done']")
	private ExtendedWebElement doneLink;

	//Notification Container Items
	@FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/TeamListItem_teamName")
	private List<ExtendedWebElement> teamNameContainerList;
	@FindBy(xpath = "//android.widget.TextView[@text='Game Start']")
	private ExtendedWebElement gameStartLabel;
	@FindBy(xpath = "//android.widget.TextView[@text='Game End']")
	private ExtendedWebElement gameEndLabel;
	@FindBy(xpath = "//android.widget.TextView[@text='Scoring Plays']")
	private ExtendedWebElement scoringPlaysLabel;
	@FindBy(xpath = "//android.widget.TextView[@text='Lead Change']")
	private ExtendedWebElement leadChangeLabel;
	@FindBy(xpath = "//android.widget.TextView[@text='News']")
	private ExtendedWebElement newsLabel;
	
	public enum NotificationsToggleItem {
		GAME_START("Game Start"), GAME_END("Game End"), SCORING_PLAYS("Scoring Plays"),
		LEAD_CHANGE("Lead Change"), NEWS("News"), NOTIFICATIONS("Notifications"), SOUNDS("Sounds");

		private String title;

		private NotificationsToggleItem(String title) {
			this.title = title;
		}

		public String getText() {
			return this.title;
		}
	}

	public AtBatNotificationsPage(WebDriver driver) {
		super(driver);
	}

	public AtBatAndroidPage skipSettingNotifications() {
		logger.debug("Skip 'notification selection step' if displayed");
		skipPlayServiceAlert();
		if (isElementPresent(notificationsExists, delay)) {
			click(doneLink);
		} else {
			throw new TestRuntimeException(
					"'Done' button doesn't exist.");
		}
		return new AtBatAndroidPage(driver);
	}

	public void skipPlayServiceAlert() {
		logger.debug("Skip 'google play service not supported' step if displayed");
		if (isElementPresent(alertPlayServices, delay)) {
			if (isElementPresent(alertOkLink, delay)) {
				click(alertOkLink);
			}
		}
	}

	public AtBatNotificationsPage skipPlayServiceAlertInitial() {
		logger.debug("Skip 'google play service not supported' step if displayed");
		if (isElementPresent(alertPlayServices, delay)) {
			if (isElementPresent(alertPlayServices, delay)) {
				click(alertOkLink);
			}
		}
		return new AtBatNotificationsPage(driver);
	}
	
	public Boolean checkIfTeamVisible(String teamName) {
		for (ExtendedWebElement element : teamNameContainerList) {
			if (element.getText().equalsIgnoreCase(teamName)) {
				return true;
			}
		}
		return false;
	}
	//TODO:  Need to add in Notification Toggling still.
	
	public Boolean checkIfNotificationVisible(NotificationsToggleItem notifyItem) {
		switch (notifyItem) {
			case GAME_START: {
				return isElementPresent(gameStartLabel, delay);
			}
			case GAME_END: {
				return isElementPresent(gameEndLabel, delay);
			}
			case SCORING_PLAYS: {
				return isElementPresent(scoringPlaysLabel, delay);
			}
			case LEAD_CHANGE: {
				return isElementPresent(leadChangeLabel, delay);
			}
			case NEWS: {
				return isElementPresent(newsLabel, delay);
			}
			default: {
				throw new TestRuntimeException(
						"Unknown or unsupported menu item: " + notifyItem);
			}
		}
	}
	
	@Override
	public boolean isOpened() {
		return isElementPresent(notificationsExists, delay);
	}
}
