package com.mlb.qa.atb.model.schedule;

import java.util.Comparator;

import org.joda.time.DateTime;

import com.mlb.qa.atb.model.game.Game;
import com.mlb.qa.atb.model.game.GameStatusComparator;
import com.mlb.qa.common.comparator.ListItemComparator;
import com.mlb.qa.common.date.DateTimeDateComparator;
import com.mlb.qa.common.date.DateTimeDefaultComparator;

public class GameScheduleCalendarViewComparator extends ListItemComparator<Game> {

	@Override
	public int compare(Game g1, Game g2) {
		int res = 0;
		if (0 != (res = compareFields("Home team abbrev", g1.getHomeTeamAbbrev(), g2.getHomeTeamAbbrev()))) {
			return res;
		}
		if (0 != (res = compareFields("Away team abbrev", g1.getAwayTeamAbbrev(), g2.getAwayTeamAbbrev()))) {
			return res;
		}
		if (0 != (res = new GameStatusComparator().compare(g1.getGameStatus(), g2.getGameStatus()))) {
			return res;
		}
		Comparator<DateTime> dateComparator;
		switch (g1.getGameStatus()) {
		case FINAL: {
			// compare final result specific fields
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
			dateComparator = new DateTimeDateComparator();
			break;
		}
		case POSTPONED:
		case DELAYED_START:
		{
			dateComparator = new DateTimeDateComparator();
			break;
		}
		case SCHEDULED:
		default: {
			dateComparator = new DateTimeDefaultComparator();
			break;
		}
		}
		if (0 != (res = dateComparator.compare(g1.getGameTimeLocal(), g2.getGameTimeLocal()))) {
			return res;
		}
		return res;

	}
}
