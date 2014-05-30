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

/**
 * Check that content of Promotions page for each ballpark is correct<br>
 */
public class AtbBallparkPromotionsTest extends AtbBaseWebTest {
    private AtbHttpService httpService = new AtbHttpService();
    private AtbLookupService lookupService = new AtbLookupService();

    @Test(dataProvider = "excel_ds", description = "Check list of promotions correct")
    @Parameters({"team_abbrev", "team_promotions_web"})
    public void checkListOfPromotions(String teamAbbrev, String promotionsUrl) {
        List<GamePromotion> promotionsOnUi = AtbBallparkPromotionsPage.open(getDriver(),
                promotionsUrl).loadListOfGamePromotions();
        String year = AtbParameter.MLB_ATB_SEASON.getValue();
        int month = new DateTime().getMonthOfYear();
        Team team = lookupService.lookupTeamByAbbrev(teamAbbrev, year);
        List<GamePromotion> promotionsBackEnd = httpService.loadListOfPromotionsFromGamePromotionsService(
                team.getTeamId(), Integer.parseInt(year), month);


        //DateTime date = new DateTime().minusDays(1);
        DateTime date = new DateTime().minusHours(8);
        for (int i = promotionsBackEnd.size() -1; i >= 0; i--) {
            LOGGER.info("GAME DATE: " + promotionsBackEnd.get(i).getGameDate());
            LOGGER.info("CURR DATE: " + date);
            if (promotionsBackEnd.get(i).getGameDate().isBefore(date)) {
                for (int j = promotionsBackEnd.get(i).getPromotions().size() - 1; j >= 0; j--) {

                    //exclude from Back End list those promotions which has displayIfPast=false
                    if (promotionsBackEnd.get(i).getPromotions().get(j).getDisplayIfPast() != null && !promotionsBackEnd.get(i).getPromotions().get(j).getDisplayIfPast()) {
                        promotionsBackEnd.get(i).getPromotions().remove(j);
                    }
                }
                if (promotionsBackEnd.get(i).getPromotions().size()==0){
                    promotionsBackEnd.remove(i);
                }
            }

        }


        int res = new ListComparator<GamePromotion>(new GamePromotionComparator()).compareContent(promotionsOnUi, promotionsBackEnd);

        Assert.assertTrue(0 == res,
                "List of promotions on UI isn't equal to list of promotions from  GamePromotion service " +
                        teamAbbrev + "; web:" + promotionsUrl
        );
    }
}
