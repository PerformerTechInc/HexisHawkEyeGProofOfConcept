package com.mlb.qa.android.atb.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.mlb.qa.android.atb.service.lookup.LookupItem;

@XmlRootElement(name = "row")
public class Team implements LookupItem {

	@XmlAttribute(name = "team_id")
	private String teamId;
	@XmlAttribute(name = "name")
	private String name;
	@XmlAttribute(name = "name_short")
	private String nameShort;
	@XmlAttribute(name = "name_abbrev")
	private String nameAbbrev;
	@XmlAttribute(name = "city")
	private String city;
	@XmlAttribute(name = "venue_id")
	private String venueId;
	@XmlAttribute(name = "venue_name")
	private String venueName;

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameShort() {
		return nameShort;
	}

	public void setNameShort(String nameShort) {
		this.nameShort = nameShort;
	}

	public String getNameAbbrev() {
		return nameAbbrev;
	}

	public void setNameAbbrev(String nameAbbrev) {
		this.nameAbbrev = nameAbbrev;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getVenueId() {
		return venueId;
	}

	public void setVenueId(String venueId) {
		this.venueId = venueId;
	}

	public String getVenueName() {
		return venueName;
	}

	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}

	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", name=" + name + ", nameShort="
				+ nameShort + ", nameAbbrev=" + nameAbbrev + ", city=" + city
				+ ", venueId=" + venueId + ", venueName=" + venueName + "]";
	}
}
