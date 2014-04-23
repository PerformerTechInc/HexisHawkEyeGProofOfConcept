package com.mlb.qa.common.date;

public enum TimeZone {
	ET(-5), MST(-7), CT(-5), MT(-6), PT(-8);
	private Integer offset;

	private TimeZone(Integer offset) {
		this.offset = offset;
	}

	public Integer getOffset() {
		return offset;
	}
}
