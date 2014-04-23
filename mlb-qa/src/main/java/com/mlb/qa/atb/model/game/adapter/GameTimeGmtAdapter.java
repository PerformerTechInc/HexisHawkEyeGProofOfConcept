package com.mlb.qa.atb.model.game.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import com.mlb.qa.atb.model.game.Game;
import com.mlb.qa.common.date.DateUtils;

public class GameTimeGmtAdapter
		extends XmlAdapter<String, DateTime> {

	@Override
	public String marshal(DateTime dateTime) throws Exception {
		return DateUtils.dateToString(dateTime, Game.GAME_TIME_GMT_FORMAT_PATTERN).replaceAll(" ", "T");
	}

	@Override
	public DateTime unmarshal(String source) throws Exception {
		return DateUtils.parseString(source.replaceAll("T", " "), Game.GAME_TIME_GMT_FORMAT_PATTERN).withZone(DateTimeZone.forOffsetHours(0));
	}
}
