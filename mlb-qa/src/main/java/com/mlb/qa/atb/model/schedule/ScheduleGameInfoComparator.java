package com.mlb.qa.atb.model.schedule;

import java.util.Comparator;

import org.joda.time.DateTime;

import com.mlb.qa.common.comparator.ListItemComparator;
import com.mlb.qa.common.date.DateTimeDateComparator;
import com.mlb.qa.common.date.DateTimeDefaultComparator;

/**
 * Comparator for {@link ScheduleGameInfo}
 */
public class ScheduleGameInfoComparator extends ListItemComparator<ScheduleGameInfo> {

	@Override
	public int compare(ScheduleGameInfo si1, ScheduleGameInfo si2) {
		int res = 0;
		if (0 != (res = compareFields("Is scheduled", si1.getIsScheduled(), si2.getIsScheduled()))) {
			return res;
		}
		if (0 != (res = compareFields("Is home", si1.getIsHome(), si2.getIsHome()))) {
			return res;
		}
		if (0 != (res = compareFieldsIgnoreCase("Opponent", si1.getOpponent(), si2.getOpponent()))) {
			return res;
		}
		Comparator<DateTime> dateComparator;
		if (si1.getIsScheduled()) {
			dateComparator = new DateTimeDefaultComparator();
		}
		else {
			dateComparator = new DateTimeDateComparator();
		}
		if (0 != (res = dateComparator.compare(si1.getDate(), si2.getDate()))) {
			return res;
		}
		return 0;
	}

}
