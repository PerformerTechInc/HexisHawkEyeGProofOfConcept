package com.mlb.qa.atb.model.schedule;

import com.mlb.qa.atb.model.game.Game;
import com.mlb.qa.atb.model.game.GameStatus;
import com.mlb.qa.atb.model.game.GameStatusComparator;
import com.mlb.qa.common.comparator.ListItemComparator;
import com.mlb.qa.common.date.DateTimeDateComparator;
import com.mlb.qa.common.date.DateTimeDefaultComparator;

public class GameScheduleCalendarViewComparator extends ListItemComparator<Game> {

	@Override
	public int compare(Game g1, Game g2) {
		int res = 0;
		if (0 != (res = new DateTimeDateComparator().compare(g1.getGameDate(), g2.getGameDate()))) {
			return res;
		}
		if (0 != (res = compareFields("Home team abbrev", g1.getHomeTeamAbbrev(), g2.getHomeTeamAbbrev()))) {
			return res;
		}
		if (0 != (res = compareFields("Away team abbrev", g1.getAwayTeamAbbrev(), g2.getAwayTeamAbbrev()))) {
			return res;
		}
		if (0 != (res = new GameStatusComparator().compare(g1.getGameStatus(), g2.getGameStatus()))) {
			return res;
		}
		
		// additional check that match time is correct for scheduled games
		if (GameStatus.SCHEDULED.equals(g1.getGameStatus())) {
			if (0 != (res = new DateTimeDefaultComparator().compare(g1.getGameTimeGmt(), g2.getGameTimeGmt()))) {
				return res;
			}
		}
		// additional checks if game status is final
		if (GameStatus.FINAL.equals(g1.getGameStatus()))
		{
			if (0 != (res = compareFields("Home team result", g1.getHomeResult(), g2.getHomeResult()))) {
				return res;
			}
			if (0 != (res = compareFields("Away team result", g1.getAwayResult(), g2.getAwayResult()))) {
				return res;
			}
			if (0 != (res = compareFields("Home team score", g1.getHomeTeamScore(), g2.getHomeTeamScore()))) {
				return res;
			}
			if (0 != (res = compareFields("Away team score", g1.getAwayTeamScore(), g2.getAwayTeamScore()))) {
				return res;
			}
		}
		return res;

	}
}
