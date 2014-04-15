package com.mlb.qa.common.date;

import org.joda.time.DateTime;

import com.mlb.qa.common.comparator.ListItemComparator;

/**
 * Default comparator for {@link DateTime}
 */
public class DateTimeDefaultComparator extends ListItemComparator<DateTime> {

	@Override
	public int compare(DateTime o1, DateTime o2) {
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
			res = o1.compareTo(o2);
		}
		doLogging("Date time", o1, o2, res == 0);
		return res;
	}

}
