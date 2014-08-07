package com.mlb.qa.at_bat.android.page.paywalls;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

/**
 * Created by boyle on 8/6/14.
 */
public class AtBatPaywallSponsorPage extends AtBatPaywallPage {

    @FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/PaywallSponsorAppFragment_redeemSponsorButton")
    private ExtendedWebElement sponsorRedeemButton;
    @FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/PaywallSponsorAppFragment_continueContainer")
    private ExtendedWebElement paywallContinueContainer;
    @FindBy(id = "com.bamnetworks.mobile.android.gameday.atbat:id/PaywallSponsorAppFragment_loginLabel")
    private ExtendedWebElement loginLabel;

    public AtBatPaywallSponsorPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean paywallPageAvailable() {
        //TODO:  Need something that works for both T-Mobile and Non-T-Mobile
        if (isElementPresent(loginLabel, delay)) {
            return true;
        }
        return false;
    }
}
