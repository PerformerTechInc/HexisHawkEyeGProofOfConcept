package com.mlb.qa.atb.model.music.json;

import javax.xml.bind.annotation.XmlElement;

import com.mlb.qa.atb.model.Item;

public class BallparkMusicJsonKeyValuePair implements Item{
	@XmlElement(name = "@key")
	private String key;
	@XmlElement(name = "$")
	private String value;

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "BallparkMusicJsonKeyValuePair [key=" + key + ", value=" + value + "]";
	}

}
