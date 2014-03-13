package com.mlb.qa.tests.android.atb;

import java.util.Random;

import org.joda.time.DateTime;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mlb.qa.android.atb.exception.CheckInUnavailableException;
import com.mlb.qa.android.atb.page.AtbAndroidPage;
import com.mlb.qa.android.atb.page.AtbStartPage;
import com.mlb.qa.android.atb.service.http.AtbHttpService;
import com.mlb.qa.android.atb.utils.AtbParameter;
import com.qaprosoft.carina.core.foundation.UITest;

public class AtbCheckInTest extends UITest {
	private DateTime gameDate=new DateTime(2014,3,22,0, 0);;
	
	private AtbHttpService httpService = new AtbHttpService();
	
	@BeforeClass(enabled = false, description = "")
	public void findNearestGameDateForBallpark(){
		//gameDate = new DateTime(2014,3,12,18, 0);	// 03.12.2014 18:00


	}
	
	@BeforeClass(enabled = false, dependsOnMethods = "findNearestGameDateForBallpark", description = "")
	public void allowCheckinForGameDate(){
		httpService.setTimeBoundaryCheckinServiceProperty(14400*6l);		// 24 hrs
		httpService.setGameFeedCheckinServiceProperty(gameDate);
	}
	
	@BeforeClass(enabled=false, dependsOnMethods = "allowCheckinForGameDate", description = "")
	public void loginIfNotLogged(){
		AtbStartPage sp = new AtbStartPage(driver);
		if (sp.isOpened()) {
			sp.passToLoginPage().login(AtbParameter.MLB_ATB_DEFAULT_USER.getValue(), AtbParameter.MLB_ATB_DEFAULT_PASSWORD.getValue())
					.skipFavoriteTeamSelection();
			;
		}
	}
	
	@BeforeClass(enabled = false, dependsOnMethods = "loginIfNotLogged")
	public void setDateTimeFrame(){
		AtbAndroidPage atbap = new AtbAndroidPage(driver);
		atbap.changeScoreboardStartDate(gameDate);
	}
	
	@Test(enabled = false, description = "")
	public void checkin(){
		
	}
	
	@Test(enabled = false, dependsOnMethods = "checkin")
	public void checkCheckinSuccessInBackend(){
		
	}
	
	
	
	/****
	 * 
	 * TEMPORARY debug methods<br>
	 * 
	 */
	@Test(enabled = false, expectedExceptions = CheckInUnavailableException.class)
	public void openCheckinPage() {
		  new AtbAndroidPage(driver).openBallparksFromMenu()
		  .openBallparkByName("Angel Stadium").openCheckInPage();
		 
	}
	
	@Test(enabled = false, description = "Log in")
	public void logInIfNotLogged() {
		AtbStartPage sp = new AtbStartPage(driver);
		if (sp.isOpened()) {
			sp.passToLoginPage().login(AtbParameter.MLB_ATB_DEFAULT_USER.getValue(), AtbParameter.MLB_ATB_DEFAULT_PASSWORD.getValue())
					.skipFavoriteTeamSelection();
			;
		}
	}
	
	@Test(enabled = false, description = "Check Date picker")
	public void checkDatePicker(){
		AtbAndroidPage atbap = new AtbAndroidPage(driver);
		atbap.changeScoreboardStartDate(new DateTime().plusDays(new Random().nextInt(999)));
		atbap.changeScoreboardStartDate(new DateTime().plusDays(new Random().nextInt(999)));
		atbap.clearScoreboardStartDate();
		
	}
}
