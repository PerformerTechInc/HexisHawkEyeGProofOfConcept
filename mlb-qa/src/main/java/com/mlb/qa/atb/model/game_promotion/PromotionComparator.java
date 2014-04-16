package com.mlb.qa.atb.model.game_promotion;

import com.mlb.qa.common.comparator.ListItemComparator;

/**
 * Comparator for {@link Promotion}
 */
public class PromotionComparator extends ListItemComparator<Promotion> {

	@Override
	public int compare(Promotion p1, Promotion p2) {
		int res = 0;
		if (0 != (res = compareFieldsIgnoreCase("Description", p1.getDescription(), p2.getDescription()))) {
			return res;
		}
		if (0 != (res = compareFieldsIgnoreCase("Offer name", p1.getOfferName(), p2.getOfferName()))) {
			return res;
		}
		if (0 != (res = compareFieldsIgnoreCase("Presented By", p1.getPresentedBy(), p2.getPresentedBy()))) {
			return res;
		}
		/*if (0 != (res = compareFieldsIgnoreCase("Link", p1.getTlink(), p2.getTlink()))) {
			return res;
		}*/
		return res;
	}

}
