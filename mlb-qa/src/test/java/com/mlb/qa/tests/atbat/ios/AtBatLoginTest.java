package com.mlb.qa.tests.atbat.ios;

import com.mlb.qa.at_bat.ios.page.authentication.AtBatLoginPage;
import com.mlb.qa.at_bat.ios.page.common.AtBatStartPage;
import com.qaprosoft.carina.core.foundation.UITest;
import org.testng.annotations.Test;

/**
 * Created by Igor Vayner on 6/25/14.
 */
public class AtBatLoginTest extends UITest {

    @Test
    public void login(){

        AtBatStartPage atBatStartPage = new AtBatStartPage(driver);
        AtBatLoginPage atBatLoginPage = atBatStartPage.getAtBatLoginPage();
        atBatLoginPage.login();

    }
}
