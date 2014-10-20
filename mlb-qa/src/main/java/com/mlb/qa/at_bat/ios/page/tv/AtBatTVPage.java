package com.mlb.qa.at_bat.ios.page.tv;

import com.mlb.qa.at_bat.ios.page.common.AtBatIOSPage;
import com.mlb.qa.at_bat.ios.page.games.AtBatClassicGamePage;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Igor Vayner on 10/13/14.
 */
public class AtBatTVPage extends AtBatIOSPage {


    @FindBy(name ="Classics")
    ExtendedWebElement tvButton;

    public AtBatTVPage(WebDriver driver) {
        super(driver);
    }

    public AtBatClassicGamePage getAtBatClassicGamePage(){
       // ExtendedWebElement tvButton = ((AppiumNativeDriver) driver).findElementByIosUIAutomation(".navigationBars()[0].buttons()['Classics']");
        click(tvButton);
        return new AtBatClassicGamePage(driver);

    }
}
