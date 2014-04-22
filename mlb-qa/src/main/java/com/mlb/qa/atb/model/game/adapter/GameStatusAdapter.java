package com.mlb.qa.atb.model.game.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.mlb.qa.atb.model.game.GameStatus;

/**
 * 
 * Adapter for {@link GameStatus}
 */
public class GameStatusAdapter extends XmlAdapter<String, GameStatus> {

	@Override
	public String marshal(GameStatus status) throws Exception {
		return status.getStatusText();
	}

	@Override
	public GameStatus unmarshal(String status) throws Exception {
		return GameStatus.getByStatusText(status);
	}

}
