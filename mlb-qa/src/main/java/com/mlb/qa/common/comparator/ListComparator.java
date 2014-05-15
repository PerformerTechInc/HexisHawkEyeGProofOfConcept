package com.mlb.qa.common.comparator;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * Use it for objects' lists comparison
 * 
 * 
 * @param <T>
 */
public class ListComparator<T> {
	private static final Logger LOGGER =Logger.getLogger(ListComparator.class);
	
	private ListItemComparator<T> comparator;

	public ListComparator(ListItemComparator<T> comparator) {
		super();
		this.comparator = comparator;
	}

	private int compare(List<T> l1, List<T> l2, boolean checkElementsOrder) {
		if (l1 == null && l2 != null) {
			return -1;
		}
		if (l1 != null && l2 == null) {
			return 1;
		}
		if (l1.size() != l2.size()) {
			return l1.size() > l2.size() ? 1 : -1;
		}
		List<T> tempL1 = new LinkedList<T>(l1);
		List<T> tempL2 = new LinkedList<T>(l2);
		if (!checkElementsOrder) {
			Collections.sort(tempL1, comparator);
			Collections.sort(tempL2, comparator);
		}
		LOGGER.info("Sorted list 1: " + tempL1);
		LOGGER.info("Sorted list 2: " + tempL2);
		int res = 0;
		for (int i = 0; i < tempL1.size(); i++) {
			LOGGER.info("Itteration: " +i);
			res = comparator.compare(tempL1.get(i), tempL2.get(i));
			if (res != 0) {
				return res;
			}
		}

		return 0;
	}

	public int compareContent(List<T> l1, List<T> l2) {
		return compare(l1, l2, false);
	}

	public int compareContentAndOrder(List<T> l1, List<T> l2) {
		return compare(l1, l2, true);
	}
}
