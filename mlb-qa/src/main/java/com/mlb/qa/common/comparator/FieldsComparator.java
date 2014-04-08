package com.mlb.qa.common.comparator;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class FieldsComparator {
	protected static final Logger logger = LogManager.getLogger(FieldsComparator.class);

	public static int compareFields(String name, String s1, String s2) {
		int res = 0;
		if (isStringEmpty(s2) && isStringEmpty(s1)) {
			res = 0;
		} else if (isStringEmpty(s1) && !isStringEmpty(s2)) {
			res = -1;
		} else if (isStringEmpty(s2) && !isStringEmpty(s1)) {
			res = 1;
		} else {
			res = s1.compareTo(s2);
		}
		doLogging(name, s1, s2, res == 0);
		return res;
	}

	public static int compareFieldsIgnoreCase(String name, String s1, String s2) {
		return compareFields(name, s1 == null ? null : s1.toLowerCase(), s2 == null ? null : s2.toLowerCase());
	}

	public static int compareFields(String name, Integer i1, Integer i2) {
		int res = 0;
		if (i1 == null && i2 != null) {
			res = -1;
		}
		else if (i1 != null && i2 == null) {
			res = 1;
		}
		else if (i1 == null && i2 == null) {
			res = 0;
		}
		else {
			res = i1.compareTo(i2);
		}
		doLogging(name, i1, i2, res == 0);
		return res;
	}

	protected static void doLogging(String name, Object str1, Object str2,
			boolean equal) {
		if (equal) {
			logger.info(new StringBuilder("Equal parameters - ").append(name)
					.append(" \"").append(str1).append("\" = \"").append(str2)
					.append("\"").toString());
		} else {
			logger.info(new StringBuilder("Different parameters - ")
					.append(name).append(" \"").append(str1).append("\" != \"")
					.append(str2).append("\"").toString());
		}
	}

	protected static boolean isStringEmpty(String str) {
		return null == str || str.isEmpty();
	}
}
