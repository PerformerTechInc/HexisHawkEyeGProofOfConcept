package com.mlb.qa.atb.model.game_ticket;

import javax.xml.bind.annotation.XmlAttribute;

import com.mlb.qa.atb.model.Item;

public class TicketLink implements Item {
	@XmlAttribute(name = "tlink")
	private String link;

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "TicketLink [link=" + link + "]";
	}
}
