package com.mlb.qa.android.atb.utils;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.mlb.qa.exception.TestRuntimeException;

public class DateUtils {
		public static final String DEFAULT_DATE_FORMAT = "EEEE | MMM d, yyyy";

		public static enum Month {
			JANUARY(1, "January", "Jan"), 
			FEBRUARY(2, "February", "Feb"), 
			MARCH(3, "March", "Mar"), 
			APRIL(4, "April", "Apr"), 
			MAY(5, "May", "May"), 
			JUNE(6, "June", "Jun"), 
			JULY(7, "July", "Jul"), 
			AUGUST(8, "August",	"Aug"), 
			SEPTEMBER(9, "September", "Sep"), 
			OCTOBER(10,"October", "Oct"), 
			NOVEMBER(11, "November", "Nov"), 
			DECEMBER(12, "December", "Dec");

			private Integer monthOfYear;
			private String fullName;
			private String shortName;

			private Month(Integer monthOfYear, String fullName, String shortName) {
				this.fullName = fullName;
				this.shortName = shortName;
				this.monthOfYear = monthOfYear;
			}

			public static String getShortNameByNumber(Integer number) {
				for (Month month : values()) {
					if (month.getMonthOfYear().equals(number)) {
						return month.getShortName();
					}
				}
				throw new TestRuntimeException("Wrong month number specified: "
						+ number);
			}

			public static Integer getMonthOfYearByShortName(String shortName) {
				for (Month month : values()) {
					if (month.getShortName().equalsIgnoreCase(shortName)) {
						return month.getMonthOfYear();
					}
				}
				throw new TestRuntimeException("Wrong short тame specified: "
						+ shortName);
			}

			public Integer getMonthOfYear() {
				return this.monthOfYear;
			}

			public String getShortName() {
				return this.shortName;
			}

			public String getFullName() {
				return this.fullName;
			}
		}

		/**
		 * Date to string with specified formatting
		 * 
		 * @param dateTime
		 * @param format
		 * @return
		 */
		public static String dateToString(DateTime dateTime, String format) {
			if (null == dateTime) {
				throw new TestRuntimeException("Date object shouldn't be null!");
			}
			DateTimeFormatter frmt = DateTimeFormat.forPattern(format);
			return dateTime.toString(frmt);
		}

		/**
		 * 
		 * @param d1
		 * @param d2
		 * @return true if both represent the same day
		 */
		public static Boolean hasEqualDates(DateTime d1, DateTime d2) {
			if (d1 == null || d2 == null) {
				return false;
			}
			return d1.getDayOfYear() == d2.getDayOfYear()
					&& d1.getYear() == d2.getYear();
		}
}
