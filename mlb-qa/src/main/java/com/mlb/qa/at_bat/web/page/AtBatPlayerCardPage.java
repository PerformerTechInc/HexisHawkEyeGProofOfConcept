package com.mlb.qa.at_bat.web.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.mlb.qa.at_bat.model.roster.Roster;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class AtBatPlayerCardPage extends AbstractPage {
	private static final Logger logger = Logger.getLogger(AtBatPlayerCardPage.class);
	
	@FindBy(xpath = "//div[@class='name']")
	private ExtendedWebElement playerName;
	@FindBy(xpath = "//li[@class='detail-number']/strong")
	private ExtendedWebElement playerNumber;
	@FindBy(xpath = "//li[@class='detail-position']/strong")
	private ExtendedWebElement playerPosition;

	public AtBatPlayerCardPage(WebDriver driver) {
		super(driver);
	}

	public static AtBatPlayerCardPage open(WebDriver driver, String url) {
		driver.get(url);
		driver.navigate().refresh();
		return new AtBatPlayerCardPage(driver);
	}

	public String getPlayerTextDescription() {		
		logger.info("Player Info: " + playerName.getText());
		return playerName.getText();
	}
	
	public Roster loadPlayer() {
		Roster player = new Roster();
		player.setPlayerName(playerName.getText());
		player.setPlayerNumber(playerNumber.getText().substring(1));
		player.setPlayerPositionText(playerPosition.getText());

		return player;
	}
}
