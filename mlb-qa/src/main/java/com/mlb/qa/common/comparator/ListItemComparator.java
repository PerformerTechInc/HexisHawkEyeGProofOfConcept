package com.mlb.qa.common.comparator;

import java.util.Comparator;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * 
 * 
 * @param <T>
 */
public abstract class ListItemComparator<T> implements Comparator<T> {
	protected final static Logger logger = LogManager.getLogger(ListItemComparator.class);

	protected int compareFields(String name, String s1, String s2) {
		return FieldsComparator.compareFields(name, s1, s2);
	}
	
	protected int compareFieldsIgnoreCase(String name, String s1, String s2) {
		return FieldsComparator.compareFieldsIgnoreCase(name, s1, s2);
	}

	protected void doLogging(String name, Object str1, Object str2,
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
}
