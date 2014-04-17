package com.mlb.qa.tests.atb.web;

import java.util.List;

import org.joda.time.DateTime;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mlb.qa.atb.AtbParameter;
import com.mlb.qa.atb.model.Team;
import com.mlb.qa.atb.model.game_promotion.GamePromotion;
import com.mlb.qa.atb.model.game_promotion.GamePromotionComparator;
import com.mlb.qa.atb.service.http.AtbHttpService;
import com.mlb.qa.atb.service.lookup.AtbLookupService;
import com.mlb.qa.atb.web.page.AtbBallparkPromotionsPage;
import com.mlb.qa.common.comparator.ListComparator;
import com.qaprosoft.carina.core.foundation.UITest;

/**
 * Check that content of Promotions page for each ballpark is correct<br>
 */
public class AtbBallparkPromotionsTest extends UITest {
	private AtbHttpService httpService = new AtbHttpService();
	private AtbLookupService lookupService = new AtbLookupService();

	@Test(dataProvider = "excel_ds", description = "Check list of promotions correct")
	@Parameters({ "team_abbrev", "team_promotions_web" })
	public void checkListOfPromotions(String teamAbbrev, String promotionsUrl) {
		List<GamePromotion> promotionsOnUi = AtbBallparkPromotionsPage.open(driver,
				promotionsUrl).loadListOfGamePromotions();
		String year = AtbParameter.MLB_ATB_SEASON.getValue();
		int month = new DateTime().getMonthOfYear();
		Team team = lookupService.lookupTeamByAbbrev(teamAbbrev, year);
		List<GamePromotion> promotionsBackEnd = httpService.loadListOfPromotionsFromGamePromotionsService(
				team.getTeamId(), Integer.parseInt(year), month);
		Assert.assertTrue(0 == new ListComparator<GamePromotion>(new
				GamePromotionComparator()).compareContent(promotionsOnUi, promotionsBackEnd),
				"List of promotions on UI isn't equal to list of promotions from  GamePromotion service " +
						teamAbbrev + "; web:" + promotionsUrl);
	}
}
