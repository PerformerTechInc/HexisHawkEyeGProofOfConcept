package com.mlb.qa.atb.model.game;

import com.mlb.qa.common.comparator.ListItemComparator;

/**
 * Comparator for {@link GameStatus}
 */
public class GameStatusComparator extends ListItemComparator<GameStatus> {
	@Override
	public int compare(GameStatus gs1, GameStatus gs2) {
		int res = 0;
		if (gs1 == null && gs2 != null) {
			res = -1;
		}
		else if (gs1 != null && gs2 == null) {
			res = 1;
		}
		else if (gs1 == null && gs2 == null) {
			res = 0;
		}
		else {
			res = compareFields("Game status text", gs1.getStatusText(), gs2.getStatusText());
		}
		doLogging("Game status", gs1, gs2, res==0);
		return res;
	}

}
