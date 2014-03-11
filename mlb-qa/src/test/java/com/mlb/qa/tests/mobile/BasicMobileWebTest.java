package com.mlb.qa.tests.mobile;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mlb.qa.gui.pages.mobile.HomePageMobile;
import com.mlb.qa.gui.pages.mobile.PersonPageMobile;
import com.mlb.qa.gui.pages.mobile.StatsPageMobile;
import com.mlb.qa.gui.pages.mobile.TeamPageMobile;
import com.qaprosoft.carina.core.foundation.UITest;

public class BasicMobileWebTest extends UITest {

	@Test
	@Parameters({"team", "role", "sorter", "person"})
	public void testPlayerInfo(String team, String role, String sorter, String person)
	{
		playerInfo(team, role, sorter, person);
	}	
	
	@Test(dataProvider="excel_ds")
	@Parameters({"team", "role", "sorter", "person"})
	public void testPlayersInfo(String TUID, String team, String role, String sorter, String person)
	{
		playerInfo(team, role, sorter, person);
	}
	
	private void playerInfo(String team, String role, String sorter, String person){

		HomePageMobile homePage = new HomePageMobile(driver);
		TeamPageMobile teamPage = homePage.openTeam(team);
		
		StatsPageMobile statsPage = teamPage.showStats();
		statsPage.sortStats(role, sorter);
		//teamPage.showRole(role, sorter);
		
		PersonPageMobile personPage = statsPage.openPerson(person);
		personPage.showBIO();	
	}
}
