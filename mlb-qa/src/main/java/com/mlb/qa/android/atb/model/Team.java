package com.mlb.qa.android.atb.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "row")
public class Team implements Item {

	@XmlAttribute(name = "team_id")
	private String teamId;
	@XmlAttribute(name = "name")
	private String name;
	@XmlAttribute(name = "name_short")
	private String nameShort;
	@XmlAttribute(name = "name_abbrev")
	private String nameAbbrev;
	@XmlAttribute(name = "name_display_full")
	private String nameFull;
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

	public String getNameFull() {
		return nameFull;
	}

	public void setNameFull(String nameFull) {
		this.nameFull = nameFull;
	}

	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", name=" + name + ", nameShort="
				+ nameShort + ", nameAbbrev=" + nameAbbrev + ", nameFull="
				+ nameFull + ", city=" + city + ", venueId=" + venueId
				+ ", venueName=" + venueName + "]";
	}

}
