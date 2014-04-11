package com.mlb.qa.atb.model.music;


import com.mlb.qa.common.comparator.ListComparator;
import com.mlb.qa.common.comparator.ListItemComparator;

/**
 * Use it to compare list of Music with {@link ListComparator}
 */
public class MusicComparator extends ListItemComparator<Music> {

	@Override
	public int compare(Music m1, Music m2) {
		int res = 0;
		if (0 != (res = compareFieldsIgnoreCase("Description", m1.getDescription(), m2.getDescription()))) {
			return res;
		}
		if (0 != (res = compareFieldsIgnoreCase("Artist", m1.getArtist(), m2.getArtist()))) {
			return res;
		}
		if (0 != (res = compareFieldsIgnoreCase("Title", m1.getTitle(), m2.getTitle()))) {
			return res;
		}
		// categories
		MusicCategory mc1 = m1.getCategory(), mc2 = m2.getCategory();
		if (mc1 == null && mc2 != null) {
			res = -1;
		}
		else if (mc1 != null && mc2 == null) {
			res = 1;
		}
		else if (mc1 == null && mc2 == null) {
			res = 0;
		}
		else {
			res = mc1.compareTo(mc2);
		}
		doLogging("Category", mc1, mc2, res == 0);

		return res;
	}

}
