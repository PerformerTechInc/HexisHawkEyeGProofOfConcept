package com.mlb.qa.tests.atb.android;

import com.mlb.qa.atb.AtbHistoryItem;
import com.mlb.qa.atb.android.page.AtbAndroidPage;
import com.mlb.qa.atb.android.page.journal.AtbJournalPage;
import com.qaprosoft.carina.core.foundation.UITest;
import org.testng.annotations.Test;

import java.util.List;


public class AtbHistoryTest extends UITest {



    @Test(description = "Check basic history")
    public void checkHistory(){

        AtbJournalPage atbJournalPage = new AtbJournalPage(getDriver());
        atbJournalPage.clickOnMenuItem(AtbAndroidPage.Menu.JOURNAL);
        List<AtbHistoryItem> fromJornal = atbJournalPage.getListOfHistoryItems();

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
