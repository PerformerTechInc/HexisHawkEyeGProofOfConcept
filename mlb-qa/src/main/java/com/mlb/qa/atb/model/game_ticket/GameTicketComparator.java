package com.mlb.qa.atb.model.game_ticket;

import com.mlb.qa.common.comparator.ListItemComparator;
import com.mlb.qa.common.date.DateTimeDefaultComparator;

/**
 * Comparator for {@link GameTicket}
 */
public class GameTicketComparator extends ListItemComparator<GameTicket> {

	@Override
	public int compare(GameTicket gt1, GameTicket gt2) {
		int res = 0;
		if (0 != (res = compareFieldsIgnoreCase("ID", gt1.getScheduleId(), gt2.getScheduleId()))) {
			return res;
		}
		if (0 != (res = compareFieldsIgnoreCase("Away team name", gt1.getAwayNameTeam(), gt1.getAwayNameTeam()))) {
			return res;
		}
		// date
		if (0 != (res = new DateTimeDefaultComparator().compare(gt1.getDateTimeLocal(), gt2.getDateTimeLocal()))) {
			return res;
		}
		// ticket link
		if (0 != (res = new TicketLinkComparator().compare(gt1.getTicketLink(), gt2.getTicketLink()))) {
			return res;
		}
		return res;
	}
}
