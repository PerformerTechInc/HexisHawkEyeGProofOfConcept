package com.mlb.qa.android.atb.page;

import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.mlb.qa.android.common.page.AndroidPage;
import com.mlb.qa.exception.TestRuntimeException;
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

	// Menu
	public enum Menu {
		BALLPARKS("BALLPARKS"), 
		CHANGE_SCOREBOARD_START_DATE("Change Scoreboard Start Date"), 
		CLEAR_SCOREBOARD_START_DATE("Clear Scoreboard Start Date");

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
		if (!isElementPresent(menuLayout)) {
			click(openMenuButton);
		}
		scrollTo(menu.getMenuItemText(), menuLayout.getBy());
		click(String.format("Menu item with text '%s'", menu.getMenuItemText()),
				driver.findElement(By.xpath(menu.getMenuItemLocator())));
	}

	public AtbBallparksPage openBallparksFromMenu() {
		clickOnMenuItem(Menu.BALLPARKS);
		return new AtbBallparksPage(driver);
	}

	public String getActionTitle() {
		if (!isElementPresent(actionBarTitle)) {
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

	/**
	 * Testing menu section
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
}
