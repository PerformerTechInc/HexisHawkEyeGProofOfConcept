package com.mlb.qa.atb.model.game.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.joda.time.DateTime;

import com.mlb.qa.atb.model.game.Game;
import com.mlb.qa.common.date.DateUtils;

public class GameTimeLocalAdapter extends XmlAdapter<String, DateTime> {

	@Override
	public String marshal(DateTime dateTime) throws Exception {
		return DateUtils.dateToString(dateTime, Game.GAME_TIME_LOCAL_FORMAT_PATTERN);
	}

	@Override
	public DateTime unmarshal(String source) throws Exception {
		return DateUtils.parseString(source, Game.GAME_TIME_LOCAL_FORMAT_PATTERN);
	}

}
