package com.mlb.qa.at_bat.ios.page.authentication;

import com.mlb.qa.at_bat.ios.page.common.AtBatIOSPage;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
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


    @FindBy(xpath = "//UIAApplication[1]/UIAWindow[4]/UIAAlert[1]/UIATableView[2]")
    private ExtendedWebElement okButton;


    public AtBatLoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(){
        type(emailInput, "media6@mlbtest.com");
        type(passwordInput,"p@ssw0rd");
        click(loginButton);

        click(doneButton);
        click(okButton);

    }
}
