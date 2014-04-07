package com.mlb.qa.android.at_bat.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.mlb.qa.exception.TestRuntimeException;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

public class AtBatMenu extends AtBatAndroidPage {
	@FindBy(xpath = "//TextView[@text='News']")
	private ExtendedWebElement newsMenuItem;

	@FindBy(xpath = "//TextView[@text='Scoreboard']")
	private ExtendedWebElement scoreboardMenuItem;

	@FindBy(xpath = "//TextView[@text='Teams']")
	private ExtendedWebElement teamsMenuItem;

	@FindBy(id = "android:id/action_bar_title")
	private ExtendedWebElement selectedMenuItem;

	// Menu
	public enum MenuItem {
		NEWS("News"), SCOREBOARD("Scoreboard"), TEAMS("Teams");

		private String title;

		private MenuItem(String title) {
			this.title = title;
		}

		public String getTitle() {
			return this.title;
		}
	}

	public AtBatMenu(WebDriver driver) {
		super(driver);
	}

	public AtBatNewsPage openNewsPageIfNotOpened() {
		logger.debug("Open 'News' page if not opened");
		if (!isMenuItemOpened(MenuItem.NEWS)) {
			clickOnMenuItem(MenuItem.NEWS);
		}
		return new AtBatNewsPage(driver);
	}
	
	public AtBatScoreboardPage openPageIfNotOpened(MenuItem menuName) {
		logger.debug("Open 'Scoreboard' page if not opened");
		if (!isMenuItemOpened(menuName)) {
			clickOnMenuItem(menuName);
		}
		return new AtBatScoreboardPage(driver);
	}

	public AtBatScoreboardPage selectMenuItem(MenuItem item) {
		clickOnMenuItem(item);
		
		return new AtBatScoreboardPage(driver);
	}

	private void clickOnMenuItem(MenuItem item) {
		switch (item) {
		case NEWS: {
			click(newsMenuItem);
			break;
		}
		case SCOREBOARD: {
			click(scoreboardMenuItem);
			break;
		}
		case TEAMS: {
			click(teamsMenuItem);
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
