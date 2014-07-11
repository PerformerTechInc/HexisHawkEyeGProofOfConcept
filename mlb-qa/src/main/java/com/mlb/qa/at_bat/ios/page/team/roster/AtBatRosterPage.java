package com.mlb.qa.at_bat.ios.page.team.roster;

import com.mlb.qa.at_bat.ios.page.team.AtBatBaseTeamPage;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Igor Vayner on 7/9/14.
 */
public class AtBatRosterPage extends AtBatBaseTeamPage {

    @FindBy(name = "Name")
    private ExtendedWebElement nameButton;

    @FindBy(name = "Position")
    private ExtendedWebElement positionButton;

    public AtBatRosterPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        LOGGER.info("Check is Roster opened");
        return isElementPresent(nameButton)&isElementPresent(positionButton);
    }


}
