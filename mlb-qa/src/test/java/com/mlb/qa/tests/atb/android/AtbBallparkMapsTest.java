package com.mlb.qa.tests.atb.android;

import org.testng.Assert;
import org.testng.AssertJUnit;

import com.mlb.qa.atb.AtbParameter;
import com.mlb.qa.atb.android.page.AtbAndroidPage;
import com.mlb.qa.atb.android.page.AtbBallparksPage;
import com.mlb.qa.atb.android.page.AtbMapPage;
import com.mlb.qa.atb.model.map.Level;
import com.mlb.qa.atb.model.map.Response;
import com.mlb.qa.atb.service.authorization.AuthorizationService;
import com.mlb.qa.common.http.HttpHelper;
import com.mlb.qa.common.http.HttpResult;
import com.qaprosoft.carina.core.foundation.UITest;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.Configuration.Parameter;

import org.testng.annotations.Optional;
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
    @Parameters({"team_abbrev", "TUID"})
    public void checkMapDescription(String teamAbbrev, String teamName) {
    	String env = Configuration.get(Parameter.ENV);
    	String SERVICE_PATTERN = QA_SERVICE_PATTERN;
    	if (env.equalsIgnoreCase("prod")) {
    		SERVICE_PATTERN = PROD_SERVICE_PATTERN;
    	}
    		
    	
        AtbBallparksPage atbBallparksPage = new AtbBallparksPage(driver);
        atbBallparksPage.clickOnMenuItem(AtbAndroidPage.Menu.BALLPARKS);
        atbBallparksPage.openBallparkByTeamName(teamName);
        AtbMapPage atbMapPage = new AtbMapPage(driver);
        atbMapPage.openMap();
        HttpResult httpResult = HttpHelper.executeGet(SERVICE_PATTERN + teamAbbrev.toLowerCase(), new HashMap<String, String>());
        Response response = new Response(httpResult.getResponseBody());
        SoftAssert softAssert = new SoftAssert();
        String stadiumActualName = atbMapPage.getStadiumName();
        String stadiumExpectedName = response.getStadiumName();
        //hardcode real value
        if (stadiumExpectedName.equals("AT"))
        	stadiumExpectedName = "AT&T Park";
        		
        
        Assert.assertEquals(stadiumActualName, stadiumExpectedName, "Incorrect Stadium Name. Expected: "+ stadiumExpectedName + "; Actual: " +stadiumActualName + " \n");
        List<String> levelNames = atbMapPage.getLevelList();
        for (Level level : response.getStadium().getLevels()) {
            Assert.assertTrue(levelNames.contains(level.getName()), "Expect: " + level.getName() + ", but wasn't present \n");
        }
        Assert.assertEquals(levelNames.size(), response.getStadium().getLevels().size(), "Incorrect number of levels");
        softAssert.assertAll();
    }
}
