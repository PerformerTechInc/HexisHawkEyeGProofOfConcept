package com.mlb.qa.atb.model.game_promotion;

import com.mlb.qa.common.comparator.ListComparator;
import com.mlb.qa.common.comparator.ListItemComparator;
import com.mlb.qa.common.date.DateTimeDateComparator;

/**
 * Comparator for {@link GamePromotion}
 */
public class GamePromotionComparator extends ListItemComparator<GamePromotion> {

	@Override
	public int compare(GamePromotion o1, GamePromotion o2) {
		int res = 0;
		if (0 != (res = compareFieldsIgnoreCase("Opponent", o1.getAwayNameTeam(), o2.getAwayNameTeam()))) {
			return res;
		}
		if (0 != (res = new DateTimeDateComparator().compare(o1.getGameDate(), o2.getGameDate()))) {
			return res;
		}
		if (0 != (res = new ListComparator<Promotion>(new PromotionComparator()).compareContent(o1.getPromotions(),
				o2.getPromotions()))) {
			return res;
		}
		return res;
	}

}
