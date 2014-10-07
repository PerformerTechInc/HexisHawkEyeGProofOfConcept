package com.mlb.qa.atb.service.authorization;

import com.mlb.qa.atb.android.page.AtbAndroidPage;
import com.mlb.qa.atb.android.page.AtbStartPage;
import com.mlb.qa.atb.android.page.settings.AtbSettingsPage;

import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 6/3/2014.
 */
public class AuthorizationService {

    private WebDriver driver;

    public AuthorizationService(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyUser(String username) {
        AtbStartPage sp = new AtbStartPage(driver);
        if (!sp.isOpened()) {
            AtbSettingsPage atbSettingsPage = new AtbSettingsPage(driver);
            atbSettingsPage.clickOnMenuItem(AtbAndroidPage.Menu.GENERAL);
            atbSettingsPage.openAccountSetting();
            boolean isLoginCorrect = atbSettingsPage.getCurrentUser().equals(username);
            driver.navigate().back();
            //atbSettingsPage.sendKeys(Keys.BACK_SPACE);
            return isLoginCorrect;
        } else {
            return false;
        }
    }


    public void login(String username, String password) {
        AtbStartPage sp = new AtbStartPage(driver);
        if (sp.isOpened()) {
            sp.passToLoginPage()
                    .login(username,
                            password)
                            .skipFavoriteTeamSelection();
            ;
        }
    }

    public void reloginUser(String username, String password) {
        AtbStartPage sp = new AtbStartPage(driver);
        if (sp.isOpened()) {
            login(username, password);
        } else if (!verifyUser(username)) {
            logout();
            login(username, password);
        }
    }


    public void logout() {
        AtbSettingsPage atbSettingsPage = new AtbSettingsPage(driver);
        atbSettingsPage.clickOnMenuItem(AtbAndroidPage.Menu.GENERAL);
        atbSettingsPage.openAccountSetting();
        atbSettingsPage.clickLogout();
    }
}
