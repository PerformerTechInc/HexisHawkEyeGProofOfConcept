package com.mlb.qa.atb.model.game_ticket;

import com.mlb.qa.common.comparator.ListItemComparator;

public class TicketLinkComparator extends ListItemComparator<TicketLink> {

	@Override
	public int compare(TicketLink o1, TicketLink o2) {
		int res = 0;
		if (o1 == null && o2 != null) {
			res = -1;
		}
		else if (o1 != null && o2 == null) {
			res = 1;
		}
		else if (o1 == null && o2 == null) {
			res = 0;
		}
		else {
			res = compareFields("Link", o1.getLink(), o2.getLink());
		}
		doLogging("Ticket Link", o1, o2, res == 0);
		return res;
	}
}
