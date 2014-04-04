package com.mlb.qa.android.atb.model.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.joda.time.DateTime;

import com.mlb.qa.android.atb.utils.DateUtils;

/**
 * {@link XmlAdapter} for {@link DateTime} with default date format for WSs
 */
public class JodaTimeDateAdapter extends XmlAdapter<String, DateTime> {
	private static final String DATE_PATTERN = "YYYY-MM-dd kk:mm:ss";

	@Override
	public String marshal(DateTime dateTime) throws Exception {
		return DateUtils.dateToString(dateTime, DATE_PATTERN).replaceAll(" ", "T");
	}

	@Override
	public DateTime unmarshal(String source) throws Exception {
		return DateUtils.parseString(source.replaceAll("T", " "), DATE_PATTERN);
	}

}
