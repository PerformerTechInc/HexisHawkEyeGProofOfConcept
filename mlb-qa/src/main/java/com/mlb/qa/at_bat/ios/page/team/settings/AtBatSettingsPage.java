package com.mlb.qa.at_bat.ios.page.team.settings;

import com.mlb.qa.at_bat.ios.page.team.AtBatBaseTeamPage;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Igor Vayner on 7/9/14.
 */
public class AtBatSettingsPage extends AtBatBaseTeamPage {

    @FindBy(name = "Lead Change")
    private ExtendedWebElement leadChnageLable;

    public AtBatSettingsPage(WebDriver driver) {
        super(driver);
    }
    @Override
    public boolean isOpened() {
        LOGGER.info("Check is Calendar opened");
        return isElementPresent(leadChnageLable);
    }

}
