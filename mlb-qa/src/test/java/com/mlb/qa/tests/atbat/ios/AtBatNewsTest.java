package com.mlb.qa.tests.atbat.ios;

import com.mlb.qa.at_bat.ios.page.authentication.AtBatLoginPage;
import com.mlb.qa.at_bat.ios.page.common.AtBatStartPage;
import com.mlb.qa.at_bat.ios.page.footer.AtBatBottomMenuPage;
import com.mlb.qa.at_bat.ios.page.footer.AtBatNewsPage;
import com.mlb.qa.atb.service.lookup.AtbLookupService;
import com.qaprosoft.carina.core.foundation.UITest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AtBatNewsTest extends UITest {


    @Test
    public void checkNewsGlobal() {
        AtbLookupService lookupService = new AtbLookupService();
        List<String> news = lookupService.getNewsTitles();
        AtBatStartPage atBatStartPage = new AtBatStartPage(driver);
        AtBatLoginPage atBatLoginPage = atBatStartPage.getAtBatLoginPage();
        atBatLoginPage.login();
        AtBatBottomMenuPage atBatBottomMenuPage = new AtBatBottomMenuPage(driver);
        AtBatNewsPage atBatNewsPage = atBatBottomMenuPage.getAtBatNewsPage();
        List<String> titles = atBatNewsPage.getAllNewsTitles();
        Assert.assertTrue(news.containsAll(titles));

    }


}
