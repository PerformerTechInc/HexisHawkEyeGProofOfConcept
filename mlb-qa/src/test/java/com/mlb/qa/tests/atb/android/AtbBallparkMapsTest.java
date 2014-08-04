package com.mlb.qa.tests.atb.android;

import com.mlb.qa.atb.android.page.AtbAndroidPage;
import com.mlb.qa.atb.android.page.AtbBallparksPage;
import com.mlb.qa.atb.android.page.AtbMapPage;
import com.mlb.qa.atb.model.map.Level;
import com.mlb.qa.atb.model.map.Response;
import com.mlb.qa.common.http.HttpHelper;
import com.mlb.qa.common.http.HttpResult;
import com.qaprosoft.carina.core.foundation.UITest;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.Configuration.Parameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.List;

/**
 * Check that content of Map page for each ballpark is correct<br>
 */
public class AtbBallparkMapsTest extends UITest {

	   
    private static final String PROD_SERVICE_PATTERN = "http://wap.mlb.com/ballpark/iphone/config/";
    private static final String QA_SERVICE_PATTERN = "http://wapqa.mlb.com/ballpark/iphone/config/";



    
    @Test(dataProvider = "excel_ds", description = "Check ballpark maps"/*, dependsOnMethods = "login"*/)
    @Parameters({"team_abbrev", "TUID","stadium_name"})
    public void checkMapDescription(String teamAbbrev, String teamName, String stadiumName) {
    	String env = Configuration.get(Parameter.ENV);
    	String SERVICE_PATTERN = QA_SERVICE_PATTERN;
    	if (env.equalsIgnoreCase("prod")) {
    		SERVICE_PATTERN = PROD_SERVICE_PATTERN;
    	}
    		
    	
        AtbBallparksPage atbBallparksPage = new AtbBallparksPage(getDriver());
        atbBallparksPage.clickOnMenuItem(AtbAndroidPage.Menu.BALLPARKS);
        atbBallparksPage.openBallparkByTeamName(teamName);

/*		try {
			atbBallparksPage.openBallparkByTeamName(teamName);
		} catch (Exception e) {
			atbBallparksPage.openBallparkByTeamName(teamName);
		}
*/
        AtbMapPage atbMapPage = new AtbMapPage(getDriver());
        atbMapPage.openMap(teamAbbrev);
        HttpResult httpResult = HttpHelper.executeGet(SERVICE_PATTERN + teamAbbrev.toLowerCase() + "_map.json", new HashMap<String, String>());
        Response response = new Response(httpResult.getResponseBody());
        SoftAssert softAssert = new SoftAssert();
        String stadiumActualName = atbMapPage.getStadiumName();

        String stadiumExpectedName = null;

        if (stadiumName.length()>0){
        	stadiumExpectedName = stadiumName;}
        else {
            stadiumExpectedName = response.getStadiumName();
        }


        softAssert.assertEquals(stadiumActualName, stadiumExpectedName, "Incorrect Stadium Name. Expected: "+ stadiumExpectedName + "; Actual: " +stadiumActualName + " \n");
        List<String> levelNames = atbMapPage.getLevelList();
        for (Level level : response.getStadium().getLevels()) {
            softAssert.assertTrue(levelNames.contains(level.getName()), "Expect: " + level.getName() + ", but wasn't present \n");
        }
        softAssert.assertEquals(levelNames.size(), response.getStadium().getLevels().size(), "Incorrect number of levels");
        softAssert.assertAll();
    }
}
