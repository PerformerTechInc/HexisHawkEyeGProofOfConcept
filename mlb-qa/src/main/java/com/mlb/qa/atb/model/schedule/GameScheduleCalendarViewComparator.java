package com.mlb.qa.atb.model.schedule;

import com.mlb.qa.atb.model.game.Game;

public class GameScheduleCalendarViewComparator extends BaseGameScheduleComparator {

	@Override
	public int compare(Game g1, Game g2) {
		int res = super.compare(g1, g2);
		if (0 != (res = compareFields("Home team abbrev", g1.getHomeTeamAbbrev(), g2.getHomeTeamAbbrev()))) {
			return res;
		}
		if (0 != (res = compareFields("Away team abbrev", g1.getAwayTeamAbbrev(), g2.getAwayTeamAbbrev()))) {
			return res;
		}
		return res;
	}
}
