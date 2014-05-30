package com.mlb.qa.atb.android.page.history;

import com.mlb.qa.atb.android.page.AtbAndroidPage;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AtbHistoryMainPage extends AtbAndroidPage
{

    @FindBy(id = "com.bamnetworks.mobile.android.ballpark:id/ballpark_name")
    private ExtendedWebElement ballparkName;


    public AtbHistoryMainPage(WebDriver driver) {
        super(driver);
    }
}
