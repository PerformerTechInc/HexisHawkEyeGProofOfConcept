package com.mlb.qa.android.atb.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.mlb.qa.android.common.page.AndroidPage;
import com.mlb.qa.exception.CommonTestRuntimeException;
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
		BALLPARKS("BALLPARKS"), ;

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
	public void openMenu(Menu menu) {
		if (isElementNotPresent(menuLayout)) {
			click(openMenuButton);
		}
		ExtendedWebElement menuItemElement = new ExtendedWebElement(
				driver.findElement(By.xpath(menu.getMenuItemLocator())),
				String.format("Menu item with text '%s'",
						menu.getMenuItemText()));
		scrollTo(menuItemElement);
		click(menuItemElement);
	}

	public AtbBallparksPage openBallparksFromMenu() {
		openMenu(Menu.BALLPARKS);
		return new AtbBallparksPage(driver);
	}

	public String getActionTitle() {
		if (isElementNotPresent(actionBarTitle)) {
			throw new CommonTestRuntimeException(
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
}
