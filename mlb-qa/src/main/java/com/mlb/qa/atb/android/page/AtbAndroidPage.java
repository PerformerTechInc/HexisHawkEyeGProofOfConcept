package com.mlb.qa.atb.android.page;

import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.mlb.qa.common.android.page.AndroidPage;
import com.mlb.qa.common.exception.TestRuntimeException;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

/**
 * Base Android page for 'At the ballpark' application
 */
public class AtbAndroidPage extends AndroidPage {

	@FindBy(id = "android:id/up")
	private ExtendedWebElement openMenuButton;
	@FindBy(id = "com.bamnetworks.mobile.android.ballpark:id/left_drawer")
	private ExtendedWebElement menuLayout;
	@FindBy(id = "android:id/action_bar_title")
	private ExtendedWebElement actionBarTitle;
	@FindBy(id = "com.bamnetworks.mobile.android.ballpark:id/progress_bar")
	private ExtendedWebElement progressBar;
	@FindBy(id = "com.bamnetworks.mobile.android.ballpark:id/error_message")
	private ExtendedWebElement errorMesssage;

	// Menu
	public enum Menu {
		BALLPARKS("BALLPARKS"), CHANGE_SCOREBOARD_START_DATE(
				"Change Scoreboard Start Date"), CLEAR_SCOREBOARD_START_DATE(
				"Clear Scoreboard Start Date"), OPEN_CHECKIN_WINDOW(
				"Open Checkin Window"), CLOSE_CHECKIN_WINDOW(
				"Close Checkin Window"), JOURNAL("JOURNAL"),HISTORY("History");

		public static final String MENU_ITEM_LOCATOR_PATTERN = "//TextView[@text='%s']";

		private String menuItemText;

		private Menu(String text) {
			this.menuItemText = text;
		}

		public String getMenuItemText() {
			return this.menuItemText;
		}

		public String getMenuItemLocator() {
			return String.format(MENU_ITEM_LOCATOR_PATTERN, menuItemText);
		}
	}

	public AtbAndroidPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Open specified menu item
	 * 
	 * @param menu
	 */
	public void clickOnMenuItem(Menu menu) {
		if (!isElementPresent(menuLayout, delay)) {
			click(openMenuButton);
		}
		scrollTo(menu.getMenuItemText(), menuLayout);
		click(String.format("Menu item with text '%s'", menu.getMenuItemText()),
				driver.findElement(By.xpath(menu.getMenuItemLocator())));
	}

	public AtbBallparksPage openBallparksFromMenu() {
		clickOnMenuItem(Menu.BALLPARKS);
		return new AtbBallparksPage(driver);
	}

	public String getActionTitle() {
		if (!isElementPresent(actionBarTitle, delay)) {
			throw new TestRuntimeException(
					"Action bar title not found on the page");
		}
		return actionBarTitle.getText();
	}

	@Override
	public boolean isOpened() {
		String pageAction = getExpectedPageAction();
		if (null != pageAction) {
			return pageAction.equalsIgnoreCase(getActionTitle());
		}
		// or return true by default
		return true;
	}

	/**
	 * Just return null by default
	 * 
	 * @return
	 */
	public String getExpectedPageAction() {
		return null;
	}

	public boolean isErrorMessagePresent() {
		return isElementPresent(errorMesssage, delay);
	}

	public String loadErrorMessage() {
		return errorMesssage.getText();
	}

	public boolean isProgressBarPresent() {
		return isElementPresent(progressBar, delay);
	}

	/**
	 * Testing menu section
	 */

	/**
	 * Set/clear scoreboard start date
	 * 
	 */
	public void changeScoreboardStartDate(DateTime date) {
		logger.info(String.format("Set Scoreboard Start Date to %s", date));
		clickOnMenuItem(Menu.CHANGE_SCOREBOARD_START_DATE);
		new DatePicker(driver).selectDate(date);
	}

	public void clearScoreboardStartDate() {
		logger.info("Clear scoreboard start date from testing menu");
		clickOnMenuItem(Menu.CLEAR_SCOREBOARD_START_DATE);
	}

	/**
	 * 
	 * Open/Close checkin window
	 */
	public void openCheckinWindow() {
		try {
			clickOnMenuItem(Menu.OPEN_CHECKIN_WINDOW);
		} catch (Exception e) {
			if (!isElementPresent(menuLayout, delay)) {
				click(openMenuButton);
			}
			// if passed -> nothing to do: checkin window already opened
			scrollTo(Menu.CLOSE_CHECKIN_WINDOW.getMenuItemText(), menuLayout);
			logger.info("Checkin window already opened. Nothing to do");
			// close menu
			click(openMenuButton);
		}
	}

	public void closeCheckinWindow() {
		try {
			clickOnMenuItem(Menu.CLOSE_CHECKIN_WINDOW);
		} catch (Exception e) {
			if (!isElementPresent(menuLayout, delay)) {
				click(openMenuButton);
			}
			// if passed -> nothing to do: checkin window already opened
			scrollTo(Menu.OPEN_CHECKIN_WINDOW.getMenuItemText(), menuLayout);
			logger.info("Checkin window already closed. Nothing to do");
			// close menu
			click(openMenuButton);
		}
	}

}
