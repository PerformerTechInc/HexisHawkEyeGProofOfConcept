package com.mlb.qa.at_bat.ios.page.team;

import com.mlb.qa.at_bat.ios.page.common.AtBatIOSPage;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Igor Vayner on 6/30/14.
 */
public class AtBatTeamSelectionPage extends AtBatIOSPage {

    @FindBy(xpath = "//UIANavigationBar[1]/UIAStaticText[1]")
    private ExtendedWebElement pageHeader;

    private final static String TEAMS = "Teams";

    public AtBatTeamSelectionPage(WebDriver driver) {
        super(driver);
    }

    public AtBatTeamPage selectTeam(String teamName) {
        driver.findElement(By.name(teamName)).click();
        return new AtBatTeamPage(driver);
    }

    @Override
    public boolean isOpened() {

        return pageHeader.getText().equals(TEAMS);
    }

}
