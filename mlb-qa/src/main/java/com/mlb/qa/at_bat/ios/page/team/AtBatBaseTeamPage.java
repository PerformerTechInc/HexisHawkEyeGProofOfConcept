package com.mlb.qa.at_bat.ios.page.team;

import com.mlb.qa.at_bat.ios.page.common.AtBatIOSPage;
import com.qaprosoft.carina.core.foundation.webdriver.appium.AppiumNativeDriver;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Igor Vayner on 6/26/14.
 */
public class AtBatBaseTeamPage extends AtBatIOSPage {

    @FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[2]")
    protected ExtendedWebElement backButton;

    @FindBy(xpath = "//UIAWindow[1]/UIANavigationBar[1]")
    protected ExtendedWebElement pageHeader;

    public AtBatBaseTeamPage(WebDriver driver) {
        super(driver);
    }

    public void backToPrevious(){
        ExtendedWebElement donePredicate = ((AppiumNativeDriver) driver).findElementByIosUIAutomation(".navigationBars()[0].buttons()[1]");
        click(donePredicate);
    }
}
