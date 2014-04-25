package com.mlb.qa.atb.model.schedule;

import com.mlb.qa.atb.model.game.Game;

public class GameScheduleListViewComparator extends BaseGameScheduleComparator {

	@Override
	public int compare(Game g1, Game g2) {
		int res = super.compare(g1, g2);
		if (0 != (res = compareFields("Home team brief", g1.getHomeTeamBrief(), g2.getHomeTeamBrief()))) {
			return res;
		}
		if (0 != (res = compareFields("Away team brief", g1.getAwayTeamBrief(), g2.getAwayTeamBrief()))) {
			return res;
		}
		return res;
	}
}
