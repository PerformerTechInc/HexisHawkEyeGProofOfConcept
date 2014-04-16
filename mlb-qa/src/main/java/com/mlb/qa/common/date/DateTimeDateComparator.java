package com.mlb.qa.common.date;

import org.joda.time.DateTime;

import com.mlb.qa.common.comparator.ListItemComparator;

/**
 * Compare 2 {@link DateTime} instances by Date part
 */
public class DateTimeDateComparator extends ListItemComparator<DateTime> {

	@Override
	public int compare(DateTime d1, DateTime d2) {
		int res = 0;
		if (d1 == null && d2 != null) {
			res = -1;
		}
		else if (d1 != null && d2 == null) {
			res = 1;
		}
		else if (d1 == null && d2 == null) {
			res = 0;
		}
		else {
			DateTime td1 = new DateTime(d1.getYear(), d1.getMonthOfYear(), d1.getDayOfMonth(), 0, 0);
			DateTime td2 = new DateTime(d2.getYear(), d2.getMonthOfYear(), d2.getDayOfMonth(), 0, 0);
			res = td1.compareTo(td2);
		}
		doLogging("Datetime by date part", d1, d2, res == 0);
		return res;
	}

}
