package com.mlb.qa.at_bat.ios.page.authentication;

import com.mlb.qa.at_bat.ios.page.common.AtBatIOSPage;
import com.mlb.qa.atb.AtbParameter;
import com.qaprosoft.carina.core.foundation.webdriver.appium.AppiumNativeDriver;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Igor Vayner on 6/25/14.
 */
public class AtBatLoginPage extends AtBatIOSPage {

    @FindBy(xpath = "//UIAScrollView[1]/UIATextField[1]")
    private ExtendedWebElement emailInput;

    @FindBy(xpath = "//UIAScrollView[1]/UIASecureTextField[1]")
    private ExtendedWebElement passwordInput;

    @FindBy(xpath = "//UIAScrollView[1]/UIAButton[2]")
    private ExtendedWebElement loginButton;

    @FindBy(name = "Done")
    private ExtendedWebElement doneButton;


    @FindBy(name = "OK")
    private ExtendedWebElement okButton;


    public AtBatLoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(){
        String username = AtbParameter.MLB_ATBAT_DEFAULT_USER.getValue();
        type(emailInput, username);
        int i = 1;
        while (!emailInput.getText().equals(username) && ++i < 10) {
            LOGGER.info("Typing user email. Attempt #" + i + "; email input value: " + emailInput.getText());
            type(emailInput, username);
        }

        type(passwordInput, AtbParameter.MLB_ATBAT_DEFAULT_PASSWORD.getValue());
        click(loginButton);

        //  if (!isElementPresent(doneButton, EXPLICIT_TIMEOUT * 3))
        //	Assert.fail("'Done' button is not recognized!");
        pause(5);
        ExtendedWebElement donePredicate = ((AppiumNativeDriver) driver).findElementByIosUIAutomation(".navigationBars()[0].buttons()['Done']");
        click(donePredicate);

        if (!isElementPresent(okButton, EXPLICIT_TIMEOUT * 3))
            Assert.fail("'ok' button is not recognized!");
        click(okButton);
        pause(4);
        clickOnScreen(15,15);

    }
}
