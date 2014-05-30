package com.mlb.qa.atb.android.page.history;

import com.mlb.qa.atb.android.page.AtbAndroidPage;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 5/30/2014.
 */
public class AtbAddGamePage extends AtbAndroidPage {

    @FindBy(xpath = "//TextView[@text='Add Games']")
    private ExtendedWebElement pageHeader;

    public AtbAddGamePage(WebDriver driver) {
        super(driver);
    }


    @Override
    public boolean isOpened() {
        return isElementPresent(pageHeader, 10);
    }
}
