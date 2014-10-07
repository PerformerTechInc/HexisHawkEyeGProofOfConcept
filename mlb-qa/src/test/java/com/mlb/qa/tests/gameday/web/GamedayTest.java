package com.mlb.qa.tests.gameday.web;

import com.mlb.qa.gameday.page.GameDayUIFinalizedPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.UITest;

public class GamedayTest extends UITest {

	@Test
	public void gamedayQuickTest() {
		GameDayUIFinalizedPage gameday = new GameDayUIFinalizedPage(getDriver());
		gameday.open(getDriver(), "http://mqa.mlb.com/game/2014/07/09/381904/dodgers-vs-tigers");
		
		Assert.assertTrue(gameday.isBoxTabVisible(), "The Box Tab is currently not visible");
	}
	
	@Test
	public void gamedayTabSwitching() {
		GameDayUIFinalizedPage gameday = new GameDayUIFinalizedPage(getDriver()).open(getDriver(), "http://mqa.mlb.com/game/2014/07/09/381904/dodgers-vs-tigers");
		gameday.selectPlaysTab();
		gameday.selectBoxTab();
		gameday.selectPlaysTab();
		gameday.selectBoxTab();
	}
	
}
