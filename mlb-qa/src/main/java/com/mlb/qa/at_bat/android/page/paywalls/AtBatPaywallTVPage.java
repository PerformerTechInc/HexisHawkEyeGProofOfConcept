package com.mlb.qa.at_bat.android.page.paywalls;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
/**
 * Created by boyle on 8/6/14.
 */
public class AtBatPaywallTVPage extends AtBatPaywallPage {

    @FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/PaywallFragmentTV_container")
    private ExtendedWebElement paywallTvContainer;
    @FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/PaywallFragmentTV_subscribeButton")
    private ExtendedWebElement subscribeTvButton;
    @FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/PaywallFragmentTV_blackoutText")
    private ExtendedWebElement paywallTvBlackoutText;
    @FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/PaywallFragmentTV_loginLabel")
    private ExtendedWebElement paywallTvLoginLabel;

    public AtBatPaywallTVPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean paywallPageAvailable() {
        //TODO:  Need something that works for both T-Mobile and Non-T-Mobile
        if (isElementPresent(paywallTvContainer, delay)) {
            return true;
        }
        return false;
    }
}
