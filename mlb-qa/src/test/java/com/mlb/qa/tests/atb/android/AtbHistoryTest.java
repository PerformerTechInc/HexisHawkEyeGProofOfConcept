package com.mlb.qa.tests.atb.android;

import com.mlb.qa.atb.AtbHistoryItem;
import com.mlb.qa.atb.android.page.AtbAndroidPage;
import com.mlb.qa.atb.android.page.history.AtbAddGamePage;
import com.mlb.qa.atb.android.page.history.AtbEventDetailsPage;
import com.mlb.qa.atb.android.page.history.AtbHistoryMainPage;
import com.mlb.qa.atb.android.page.journal.AtbJournalPage;
import com.qaprosoft.carina.core.foundation.UITest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;


public class AtbHistoryTest extends UITest {


    @Test(description = "Check basic history")
    public void checkJournalTop() {
        AtbJournalPage atbJournalPage = new AtbJournalPage(getDriver());
        atbJournalPage.clickOnMenuItem(AtbAndroidPage.Menu.JOURNAL);
        List<AtbHistoryItem> fromJournal = atbJournalPage.getListOfHistoryItems();
        AtbHistoryMainPage atbHistoryMainPage = new AtbHistoryMainPage(getDriver());
        atbHistoryMainPage.clickOnMenuItem(AtbAndroidPage.Menu.HISTORY);
        Assert.assertTrue(atbHistoryMainPage.isOpened(), "History isn't open");
        List<AtbHistoryItem> fromHistory = atbHistoryMainPage.getListOfHistoryItems();
        Assert.assertTrue(fromHistory.containsAll(fromJournal));

    }
    @Test(description = "Check back button functionality")
    public void checkBackButtonFunctionality(){
        AtbHistoryMainPage atbHistoryMainPage = new AtbHistoryMainPage(getDriver());
        atbHistoryMainPage.clickOnMenuItem(AtbAndroidPage.Menu.HISTORY);
        Assert.assertTrue(atbHistoryMainPage.isOpened(), "History isn't opened");
        AtbAddGamePage atbAddGamePage = atbHistoryMainPage.getAtbAddGamePage();
        Assert.assertTrue(atbAddGamePage.isOpened(),"Add Game isn't opened");
        navigateBack();
        Assert.assertTrue(atbHistoryMainPage.isOpened(), "History isn't opened, after click on back button");

    }

    @Test(description = "Check back button functionality")
    public void checkEventPage(){
        AtbHistoryMainPage atbHistoryMainPage = new AtbHistoryMainPage(getDriver());
        atbHistoryMainPage.clickOnMenuItem(AtbAndroidPage.Menu.HISTORY);
        Assert.assertTrue(atbHistoryMainPage.isOpened(), "History isn't opened");
        AtbEventDetailsPage atbEventDetailsPage = atbHistoryMainPage.getRandomEvent();
        Assert.assertTrue(atbEventDetailsPage.isOpened(),"Even Details isn't opened");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(atbEventDetailsPage.isAwaylogoVisible(), "Away Logo isn't present");
        softAssert.assertTrue(atbEventDetailsPage.isHomelogoVisible(), "Home Logo isn't present");
        softAssert.assertTrue(atbEventDetailsPage.isTicketsVisible(), "Tickets isn't present");
        softAssert.assertTrue(atbEventDetailsPage.isCheckinButtonVisible(), "Checkin  Logo isn't present");
        softAssert.assertAll();

    }

//    private static final String SERVICE_PATTERN = "https://qamsocial.bamnetworks.com/mobile-service-social/checkins?identityPoint=%s&fingerprint=%s&checkinType=mlb&eventType=&official=1&startDate=&endDate=&contentType=application/json&apikey=tXVNdasBjK1Rr2S83DO5S0X3tZc=";
//
//    private AtbHttpService httpService = new AtbHttpService();
//    private AtbLookupService lookupService = new AtbLookupService();
//    IdentityPoint identityPoint = httpService.loadIdentityPointByEmail(AtbParameter.MLB_ATB_DEFAULT_USER.getValue(),
//            AtbParameter.MLB_ATB_DEFAULT_PASSWORD.getValue());
//    String historyRqUri = String.format(SERVICE_PATTERN, identityPoint.getId(), identityPoint.getFingerPrint());
//    HttpResult httpResult = HttpHelper.executeGet(historyRqUri, new HashMap<String, String>());
//    HistoryResponse historyResponse = JsonUtils.fromJson(httpResult.getResponseBody(), HistoryResponse.class);
//
//
//
//
//
//    SchedulePk customer = lookupService.loadSchedulePk(historyResponse.getResponse().get(0).getEventId());
//    System.out.println(customer.getQueryResults().getRow().getGameId());
}
