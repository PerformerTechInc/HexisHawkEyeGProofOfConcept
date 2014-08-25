package com.mlb.qa.at_bat.android.page;

import com.mlb.qa.at_bat.android.page.common.AtBatAndroidPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

/**
 * MLB At Bat - Menu
 * @author 
 *
 */
public class AtBatMenu extends AtBatAndroidPage {
	public static String MENU_ITEM_LOCATOR_PATTERN = "//android.widget.TextView[@text='%s']";
	
	@FindBy(id = "android:id/up")
	private ExtendedWebElement openMenuButton;
	@FindBy(name = "Navigate up")
	private ExtendedWebElement openMenuButtonText;
	@FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/drawer_list_view")
	private ExtendedWebElement menuListContainer;
	
	@FindBy(xpath = "//android.widget.TextView[@text='News']")
	private ExtendedWebElement newsMenuItem;
	@FindBy(xpath = "//android.widget.TextView[@text='Scoreboard']")
	private ExtendedWebElement scoreboardMenuItem;
    @FindBy(xpath = "//android.widget.TextView[@text='Video']")
    private ExtendedWebElement videoMenuItem;
    @FindBy(xpath = "//android.widget.TextView[@text='Standings']")
    private ExtendedWebElement standingsMenuItem;
	@FindBy(xpath = "//android.widget.TextView[@text='Teams']")
	private ExtendedWebElement teamsMenuItem;
    @FindBy(xpath = "//android.widget.TextView[@text='Settings']")
    private ExtendedWebElement settingsMenuItem;
	
	@FindBy(id = "android:id/action_bar_title")
	private ExtendedWebElement selectedMenuItem;

	// Menu
	public enum MenuItem {
		FAVORITE_TEAM("Favorite Team"), SCOREBOARD("Scoreboard"), 
		NEWS("News"), SETTINGS("Settings"), STANDINGS("Standings"),
        TEAMS("Teams"), VIDEO("Video");

		private String menuTitle;

		private MenuItem(String title) {
			this.menuTitle = title;
		}

		public String getMenuTitle() {
			return this.menuTitle;
		}
		
		public String getMenuItemLocator() {
			return String.format(MENU_ITEM_LOCATOR_PATTERN, menuTitle);
		}

		public String getMenuItemLocator(String favoriteTeam) {
			return String.format(MENU_ITEM_LOCATOR_PATTERN, favoriteTeam);
		}
	}

	public AtBatMenu(WebDriver driver) {
		super(driver);
	}

	/**
	 * Used it accessing the standard At Bat Menu
	 * @param item is the menu item being searched for.
	 */
	public void clickOnMenuItem(MenuItem item) {
		if (!isElementPresent(menuListContainer, delay)) {
			openMenu();
		}
		
		int i = 0;
		boolean found = false;
		
		while (!found && ++i < 10) {
            logger.info("Attempt #" + i);
			try {
				isElementPresent(String.format("Checking Element '%s'", item.getMenuTitle()),
	                    driver.findElement(By.xpath(item.getMenuItemLocator())));
				found = true;
			} catch (Exception ex) {
				scrollTo(item.getMenuTitle(), menuListContainer);
			}
		}

		click(String.format("Menu item with text '%s'", item.getMenuTitle()),
				driver.findElement(By.xpath(item.getMenuItemLocator())));
	}

	/**
	 * Used if accessing the standard At Bat Menu
	 * @param item is the menu item being searched for.
	 * @param favoriteTeam the name of the Team that we wish to select.
	 */
	public void clickOnMenuItem(MenuItem item, String favoriteTeam) {
		if (!isElementPresent(menuListContainer, delay)) {
			openMenu();
		}

        int i = 0;
        boolean found = false;

        while (!found && ++i < 10) {
            logger.info("Favorite Team Attempt #" + i);
            try {
                isElementPresent(String.format("Checking Element '%s'", favoriteTeam),
                        driver.findElement(By.xpath(item.getMenuItemLocator(favoriteTeam))));
            } catch (Exception ex) {
                scrollTo(favoriteTeam, menuListContainer);
            }
        }

		click(String.format("Menu item with text '%s'", favoriteTeam),
				driver.findElement(By.xpath(item.getMenuItemLocator(favoriteTeam))));
	}

	public Boolean isMenuItemOpened(MenuItem item) {
		return item.getMenuTitle().equalsIgnoreCase(selectedMenuItem.getText());
	}

	public Boolean isMenuItemOpened(MenuItem item, String teamAbbrev) {
		return selectedMenuItem.getText().equalsIgnoreCase(teamAbbrev);
	}
}
