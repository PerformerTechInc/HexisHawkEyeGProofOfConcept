package com.mlb.qa.android.at_bat.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.mlb.qa.exception.TestRuntimeException;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

public class Menu extends AtBatAndroidPage {
	@FindBy(xpath = "//TextView[@text='News']")
	private ExtendedWebElement newsMenuItem;

	@FindBy(id = "android:id/action_bar_title")
	private ExtendedWebElement selectedMenuItem;

	// Menu
	public enum MenuItem {
		NEWS("News"), ;

		private String title;

		private MenuItem(String title) {
			this.title = title;
		}

		public String getTitle() {
			return this.title;
		}
	}

	public Menu(WebDriver driver) {
		super(driver);
	}

	public NewsPage openNewsPageIfNotOpened() {
		logger.debug("Open 'News' page if not opened");
		if (!isMenuItemOpened(MenuItem.NEWS)) {
			clickOnMenuItem(MenuItem.NEWS);
		}
		return new NewsPage(driver);
	}

	private void clickOnMenuItem(MenuItem item) {
		switch (item) {
		case NEWS: {
			click(newsMenuItem);
			break;
		}
		default: {
			throw new TestRuntimeException(
					"Unknown or unsupported menu item: " + item);
		}
		}
	}

	public Boolean isMenuItemOpened(MenuItem item) {
		return item.getTitle().equalsIgnoreCase(selectedMenuItem.getText());
	}
}
