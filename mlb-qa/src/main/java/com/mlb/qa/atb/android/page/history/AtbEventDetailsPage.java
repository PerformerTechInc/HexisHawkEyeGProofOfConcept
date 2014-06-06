package com.mlb.qa.atb.android.page.history;

import com.mlb.qa.atb.android.page.AtbAndroidPage;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AtbEventDetailsPage extends AtbAndroidPage {

    @FindBy(xpath = "//TextView[@text='Event Detail']")
    private ExtendedWebElement pageHeader;

    @FindBy(id = "com.bamnetworks.mobile.android.ballpark:id/awaylogo")
    private ExtendedWebElement awaylogo;

    @FindBy(id = "com.bamnetworks.mobile.android.ballpark:id/homelogo")
    private ExtendedWebElement homelogo;

    @FindBy(id = "com.bamnetworks.mobile.android.ballpark:id/checkin_button")
    private ExtendedWebElement checkin_button;

    @FindBy(id = "com.bamnetworks.mobile.android.ballpark:id/tickets")
    private ExtendedWebElement tickets;

    @FindBy(id = "com.bamnetworks.mobile.android.ballpark:id/menuitem_delete_checkin")
    private ExtendedWebElement deleteButton;

    public AtbEventDetailsPage(WebDriver driver) {
        super(driver);
    }


    public boolean isAwaylogoVisible(){
        return isElementPresent(awaylogo);
    }

    public boolean isHomelogoVisible(){
        return isElementPresent(homelogo);
    }

    public boolean isCheckinButtonVisible(){
        return isElementPresent(checkin_button);
    }

    public boolean isTicketsVisible(){
        return isElementPresent(tickets);
    }

    public boolean isDeleteButtonVisible(){
        return isElementPresent(deleteButton, 10);
    }

    @Override
    public boolean isOpened() {
        return isElementPresent(pageHeader, 10);
    }
}