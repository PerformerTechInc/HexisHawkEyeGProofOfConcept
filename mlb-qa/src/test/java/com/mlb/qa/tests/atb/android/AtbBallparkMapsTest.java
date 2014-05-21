package com.mlb.qa.tests.atb.android;

import com.mlb.qa.atb.android.page.AtbAndroidPage;
import com.mlb.qa.atb.android.page.AtbBallparksPage;
import com.mlb.qa.atb.android.page.AtbMapPage;
import com.mlb.qa.atb.model.map.Level;
import com.mlb.qa.atb.model.map.Response;
import com.mlb.qa.common.http.HttpHelper;
import com.mlb.qa.common.http.HttpResult;
import com.qaprosoft.carina.core.foundation.UITest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.List;

/**
 * Check that content of Map page for each ballpark is correct<br>
 */
public class AtbBallparkMapsTest extends UITest {
    private static final String SERVICE_PATTERN = "http://wap.mlb.com/ballpark/iphone/config/";

    @Test(dataProvider = "excel_ds", description = "Check ballpark maps")
    @Parameters({"team_abbrev", "TUID"})
    public void checkMapDescription(String teamAbbrev, String teamName) {
        AtbBallparksPage atbBallparksPage = new AtbBallparksPage(driver);
        atbBallparksPage.clickOnMenuItem(AtbAndroidPage.Menu.BALLPARKS);
        atbBallparksPage.openBallparkByTeamName(teamName);
        AtbMapPage atbMapPage = new AtbMapPage(driver);
        atbMapPage.openMap();
        HttpResult httpResult = HttpHelper.executeGet(SERVICE_PATTERN + teamAbbrev.toLowerCase(), new HashMap<String, String>());
        Response response = new Response(httpResult.getResponseBody());
        SoftAssert softAssert = new SoftAssert();
        String stadiumActualName = atbMapPage.getStadiumName();
        softAssert.assertEquals(stadiumActualName,response.getStadiumName(), "Incorrect Stadium Name. Expected: "+response.getStadiumName() + "; Actual: " +stadiumActualName + " \n");
        List<String> levelNames = atbMapPage.getLevelList();
        for (Level level : response.getStadium().getLevels()) {
            softAssert.assertTrue(levelNames.contains(level.getName()), "Expect: " + level.getName() + ", but wasn't present \n");
        }
        softAssert.assertEquals(levelNames.size(), response.getStadium().getLevels().size(), "Incorrect number of levels");
        softAssert.assertAll();
    }
}
