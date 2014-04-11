package com.mlb.qa.atb.model.music.json;

import javax.xml.bind.annotation.XmlElement;

import com.mlb.qa.atb.model.Item;

public class BallparkMusicJsonItemType implements Item{
	@XmlElement(name = "@key")
	private String key;

	public String getKey() {
		return key;
	}

	@Override
	public String toString() {
		return "BallparkMusicJsonItemType [key=" + key + "]";
	}

}
