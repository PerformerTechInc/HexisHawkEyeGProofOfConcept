package com.mlb.qa.gameday.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class GameDayUIFinalizedPage extends AbstractPage {
	
	@FindBy(xpath = "//*[@id='gameframe_scroll']/div/div[2]/div/div/nav/ul/li[1]")
	private ExtendedWebElement boxTab;
	@FindBy(xpath = "//*[@id='gameframe_scroll']/div/div[2]/div/div/nav/ul/li[2]")
	private ExtendedWebElement playsTab;

	public GameDayUIFinalizedPage(WebDriver driver) {
		super(driver);
	}
	
	public GameDayUIFinalizedPage open(WebDriver driver, String url) {
		driver.get(url);
		driver.navigate().refresh();
		return new GameDayUIFinalizedPage(driver);
	}
	
	public boolean isBoxTabVisible() {
		return isElementPresent(boxTab);
	}
	
	public void selectPlaysTab() {
		click(playsTab);
	}
	
	public void selectBoxTab() {
		click(boxTab);
	}

}
