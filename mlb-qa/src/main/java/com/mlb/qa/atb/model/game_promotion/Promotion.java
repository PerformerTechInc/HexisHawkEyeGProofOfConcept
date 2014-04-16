package com.mlb.qa.atb.model.game_promotion;

import javax.xml.bind.annotation.XmlAttribute;

import com.mlb.qa.atb.model.Item;

public class Promotion implements Item {
	@XmlAttribute(name = "description")
	private String description;
	@XmlAttribute(name = "offer_name")
	private String offerName;
	@XmlAttribute(name = "tlink")
	private String tlink;
	@XmlAttribute(name = "presented_by")
	private String presentedBy;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOfferName() {
		return offerName;
	}

	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}

	public String getTlink() {
		return tlink;
	}

	public void setTlink(String tlink) {
		this.tlink = tlink;
	}

	public String getPresentedBy() {
		return presentedBy;
	}

	public void setPresentedBy(String presentedBy) {
		this.presentedBy = presentedBy;
	}

	@Override
	public String toString() {
		return "Promotion [description=" + description + ", offerName=" + offerName + ", tlink=" + tlink
				+ ", presentedBy=" + presentedBy + "]";
	}

}
