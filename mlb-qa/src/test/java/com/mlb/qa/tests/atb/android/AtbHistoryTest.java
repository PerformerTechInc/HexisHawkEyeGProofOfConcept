package com.mlb.qa.tests.atb.android;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mlb.qa.atb.AtbHistoryItem;
import com.mlb.qa.atb.AtbParameter;
import com.mlb.qa.atb.android.page.AtbAndroidPage;
import com.mlb.qa.atb.android.page.history.AtbAddGamePage;
import com.mlb.qa.atb.android.page.history.AtbEventDetailsPage;
import com.mlb.qa.atb.android.page.history.AtbHistoryMainPage;
import com.mlb.qa.atb.android.page.journal.AtbJournalPage;
import com.mlb.qa.atb.service.authorization.AuthorizationService;
import com.qaprosoft.carina.core.foundation.UITest;


public class AtbHistoryTest extends UITest {

    @Test()
    public void login(){
        AuthorizationService authorizationService = new AuthorizationService(getDriver());
        authorizationService.reloginUser(AtbParameter.MLB_ATB_DEFAULT_USER.getValue(),AtbParameter.MLB_ATB_DEFAULT_PASSWORD.getValue());

    }


    @Test(description = "Check basic history",dependsOnMethods = "login")
    public void checkJournalTop() {
        AuthorizationService authorizationService = new AuthorizationService(getDriver());
        authorizationService.reloginUser(AtbParameter.MLB_ATB_DEFAULT_USER.getValue(),AtbParameter.MLB_ATB_DEFAULT_PASSWORD.getValue());
        AtbJournalPage atbJournalPage = new AtbJournalPage(getDriver());
        atbJournalPage.clickOnMenuItem(AtbAndroidPage.Menu.JOURNAL);
        List<AtbHistoryItem> fromJournal = atbJournalPage.getListOfHistoryItems();
        AtbHistoryMainPage atbHistoryMainPage = new AtbHistoryMainPage(getDriver());
        atbHistoryMainPage.clickOnMenuItem(AtbAndroidPage.Menu.HISTORY);
        Assert.assertTrue(atbHistoryMainPage.isOpened(), "History isn't open");
        List<AtbHistoryItem> fromHistory = atbHistoryMainPage.getListOfHistoryItems();
        Assert.assertTrue(fromHistory.containsAll(fromJournal));

    }

    @Test(description = "Check back button functionality",dependsOnMethods = "login")
    public void checkBackButtonFunctionality() {
        AuthorizationService authorizationService = new AuthorizationService(getDriver());
        authorizationService.reloginUser(AtbParameter.MLB_ATB_DEFAULT_USER.getValue(),AtbParameter.MLB_ATB_DEFAULT_PASSWORD.getValue());
        AtbHistoryMainPage atbHistoryMainPage = new AtbHistoryMainPage(getDriver());
        atbHistoryMainPage.clickOnMenuItem(AtbAndroidPage.Menu.HISTORY);
        Assert.assertTrue(atbHistoryMainPage.isOpened(), "History isn't opened");
        AtbAddGamePage atbAddGamePage = atbHistoryMainPage.getAtbAddGamePage();
        Assert.assertTrue(atbAddGamePage.isOpened(), "Add Game isn't opened");
        //atbAddGamePage.executeKeyEvent(4);
        getDriver().navigate().back();
        
        Assert.assertTrue(atbHistoryMainPage.isOpened(), "History isn't opened, after click on back button");

    }

    @Test(description = "Check Event Page",dependsOnMethods = "login")
    public void checkEventPage() {
        AuthorizationService authorizationService = new AuthorizationService(getDriver());
        authorizationService.reloginUser(AtbParameter.MLB_ATB_DEFAULT_USER.getValue(),AtbParameter.MLB_ATB_DEFAULT_PASSWORD.getValue());
        AtbHistoryMainPage atbHistoryMainPage = new AtbHistoryMainPage(getDriver());
        atbHistoryMainPage.clickOnMenuItem(AtbAndroidPage.Menu.HISTORY);
        Assert.assertTrue(atbHistoryMainPage.isOpened(), "History isn't opened");
        AtbEventDetailsPage atbEventDetailsPage = atbHistoryMainPage.getRandomEvent();
        Assert.assertTrue(atbEventDetailsPage.isOpened(), "Even Details isn't opened");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(atbEventDetailsPage.isAwaylogoVisible(), "Away Logo isn't present");
        softAssert.assertTrue(atbEventDetailsPage.isHomelogoVisible(), "Home Logo isn't present");
//  TODO:        softAssert.assertTrue(atbEventDetailsPage.isTicketsVisible(), "Tickets aren't present");
//  TODO:      softAssert.assertTrue(atbEventDetailsPage.isCheckinButtonVisible(), "Checkin  Logo isn't present");
//  TODO:        softAssert.assertFalse(atbEventDetailsPage.isDeleteButtonVisible(), "Delete button is present");
        atbHistoryMainPage.clickOnMenuItem(AtbAndroidPage.Menu.HISTORY);
        softAssert.assertAll();

    }
}


/*
 TODO: Backend usage example
 private static final String SERVICE_PATTERN = "https://qamsocial.bamnetworks.com/mobile-service-social/checkins?identityPoint=%s&fingerprint=%s&checkinType=mlb&eventType=&official=1&startDate=&endDate=&contentType=application/json&apikey=tXVNdasBjK1Rr2S83DO5S0X3tZc=";

    private AtbHttpService httpService = new AtbHttpService();
    private AtbLookupService lookupService = new AtbLookupService();
    IdentityPoint identityPoint = httpService.loadIdentityPointByEmail(AtbParameter.MLB_ATB_DEFAULT_USER.getValue(),
            AtbParameter.MLB_ATB_DEFAULT_PASSWORD.getValue());
    String historyRqUri = String.format(SERVICE_PATTERN, identityPoint.getId(), identityPoint.getFingerPrint());
    HttpResult httpResult = HttpHelper.executeGet(historyRqUri, new HashMap<String, String>());
    HistoryResponse historyResponse = JsonUtils.fromJson(httpResult.getResponseBody(), HistoryResponse.class);





    SchedulePk customer = lookupService.loadSchedulePk(historyResponse.getResponse().get(0).getEventId());
    System.out.println(customer.getQueryResults().getRow().getGameId());
*/
