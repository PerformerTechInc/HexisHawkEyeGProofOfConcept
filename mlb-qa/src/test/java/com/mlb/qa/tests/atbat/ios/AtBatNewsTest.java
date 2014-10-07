package com.mlb.qa.tests.atbat.ios;

import com.mlb.qa.at_bat.ios.page.authentication.AtBatLoginPage;
import com.mlb.qa.at_bat.ios.page.common.AtBatStartPage;
import com.mlb.qa.at_bat.ios.page.footer.AtBatBottomMenuPage;
import com.mlb.qa.atb.service.lookup.AtbLookupService;
import com.qaprosoft.carina.core.foundation.UITest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class AtBatNewsTest extends UITest {


    @Test
    public void checkNewsGlobal() {
        AtbLookupService lookupService = new AtbLookupService();
        List<String> news = lookupService.getNewsTitles();
        int i = 1;
        for (String aNew : news) {
            if (aNew != null) {
                System.out.println(i + " " + aNew);
                i++;
            }
        }
        AtBatStartPage atBatStartPage = new AtBatStartPage(getDriver());
        AtBatLoginPage atBatLoginPage = atBatStartPage.getAtBatLoginPage();
        atBatLoginPage.login();
        AtBatBottomMenuPage atBatBottomMenuPage = new AtBatBottomMenuPage(getDriver());
        atBatBottomMenuPage.getAtBatNewsPage();
        i = 1;
        SoftAssert softAssert = new SoftAssert();
        for (String aNew : news) {
            if (aNew != null && !aNew.contains("'")) {
                softAssert.assertTrue(getDriver().findElements(By.name(aNew)).size() > 0, "Post with title '" + aNew + "' not present");
            }
            i++;
            if (i == 30) {
                break;
            }
        }
        softAssert.assertAll();


    }


}
