package com.mlb.qa.tests.atb.web;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mlb.qa.atb.model.Team;
import com.mlb.qa.atb.model.game_promotion.GamePromotion;
import com.mlb.qa.atb.model.game_promotion.GamePromotionComparator;
import com.mlb.qa.atb.service.http.AtbHttpService;
import com.mlb.qa.atb.service.lookup.AtbLookupService;
import com.mlb.qa.atb.web.page.AtbBallparkPromotionsPage;
import com.mlb.qa.common.comparator.ListComparator;
import com.qaprosoft.carina.core.foundation.UITest;

public class AtbBallparkPromotionsTest extends UITest {
	private AtbHttpService httpService = new AtbHttpService();
	private AtbLookupService lookupService = new AtbLookupService();

	@Test
	public void checkListOfPromotions() {
		String teamAbbrev = "NYM";
		Team team = lookupService.lookupTeamByAbbrev(teamAbbrev, "2014");
		List<GamePromotion> promotionsBackEnd = httpService.loadListOfPromotionsFromGamePromotionsService(
				team.getTeamId(), 2014, 5);
		String url = "http://m.mets.mlb.com/attheballpark/tickets/promotions/2014/05";
		List<GamePromotion> promotionsOnUi = AtbBallparkPromotionsPage.open(driver,
				url).loadListOfGamePromotions();
		System.out.println("UI: " + promotionsOnUi);
		System.out.println("Backend: " + promotionsBackEnd);
		Assert.assertTrue(0 == new ListComparator<GamePromotion>(new
				GamePromotionComparator()).compareContent(promotionsOnUi, promotionsBackEnd),
				"List of promotions on UI isn't equal to list of promotions from  GamePromotion service " +
						teamAbbrev + "; web:" + url);
	}
}
