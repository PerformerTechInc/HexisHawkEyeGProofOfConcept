package com.mlb.qa.atb.android.page.settings;

import com.mlb.qa.atb.android.page.AtbAndroidPage;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 6/3/2014.
 */
public class AtbSettingsPage extends AtbAndroidPage {


    @FindBy(xpath = "//TextView[@text='MLB.com Account']")
    public ExtendedWebElement accountSettingButton;

    @FindBy(id = "com.bamnetworks.mobile.android.ballpark:id/emailtext")
    public ExtendedWebElement loginFild;

    @FindBy(id = "com.bamnetworks.mobile.android.ballpark:id/clearcredentialsbutton")
    public ExtendedWebElement clearButton;

    @FindBy(id = "android:id/button1")
    public ExtendedWebElement okButton;

    public AtbSettingsPage(WebDriver driver) {
        super(driver);
    }

    public void openAccountSetting() {
        click(accountSettingButton);
    }

    public String getCurrentUser() {
        return loginFild.getText();
    }

    public void clickLogout() {
        click(clearButton);
        click(okButton);
    }
}
