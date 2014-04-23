package com.mlb.qa.atb.model.game.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.joda.time.DateTime;

import com.mlb.qa.atb.model.game.Game;
import com.mlb.qa.common.date.DateUtils;

public class GameDateAdapter extends XmlAdapter<String, DateTime> {

	@Override
	public String marshal(DateTime dateTime) throws Exception {
		return DateUtils.dateToString(dateTime, Game.GAME_DATE_FORMAT_PATTERN).replaceAll(" ", "T");
	}

	@Override
	public DateTime unmarshal(String source) throws Exception {
		return DateUtils.parseString(source.replaceAll("T", " "), Game.GAME_DATE_FORMAT_PATTERN);
	}

}
