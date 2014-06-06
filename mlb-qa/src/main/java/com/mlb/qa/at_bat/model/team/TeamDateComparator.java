package com.mlb.qa.at_bat.model.team;

import com.mlb.qa.common.comparator.ListItemComparator;

public class TeamDateComparator extends ListItemComparator<String> {
	
	@Override
	public int compare(String date1, String date2) {
		int res = 0;
		
		if (0 != (res = compareFieldsIgnoreCase("Dates Compared: ", date1, date2))) {
			return res;
		}
		
		return res;
	}
}
