package com.mlb.qa.at_bat.ios.page.common;

import com.mlb.qa.at_bat.ios.page.authentication.AtBatLoginPage;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Igor Vayner on 6/25/14.
 */
public class AtBatStartPage extends AtBatIOSPage {


    @FindBy(name = "Existing Subscribers Log In")
    private ExtendedWebElement subscribersLogIn;

    @FindBy(name = "Go to Lite")
    private ExtendedWebElement goToLite;

    @FindBy(name = "Restore Purchases")
    private ExtendedWebElement restore;


    public AtBatStartPage(WebDriver driver) {
        super(driver);
    }

    public AtBatLoginPage getAtBatLoginPage() {
        if (isElementPresent(subscribersLogIn)) {
            click(subscribersLogIn);
        }
        return new AtBatLoginPage(driver);
    }

}
