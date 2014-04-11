package com.mlb.qa.atb.model.music.json;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.mlb.qa.atb.model.Item;

public class BallparkMusicJsonItem implements Item{
	@XmlElement(name = "itemType")
	private BallparkMusicJsonItemType itemType;
	@XmlElement(name = "field")
	private List<BallparkMusicJsonKeyValuePair> parameters;

	public BallparkMusicJsonItemType getItemType() {
		return itemType;
	}

	public List<BallparkMusicJsonKeyValuePair> getParameters() {
		return parameters;
	}

	@Override
	public String toString() {
		return "BallparkMusicJsonItem [itemType=" + itemType + ", parameters=" + parameters + "]";
	}

}
