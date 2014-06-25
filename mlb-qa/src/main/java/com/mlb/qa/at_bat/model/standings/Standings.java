package com.mlb.qa.at_bat.model.standings;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.mlb.qa.atb.model.Item;

@XmlRootElement(name = "row")
@XmlAccessorType(XmlAccessType.FIELD)
public class Standings implements Item {

	@XmlAttribute(name = "division")
	private String division;
	@XmlAttribute(name = "division_id")
	private String divisionId;
	@XmlAttribute(name = "team_id")
	private String teamId;
	@XmlAttribute(name = "file_code")
	private String teamShortcode;
	@XmlAttribute(name = "team_full")
	private String teamName;
	@XmlAttribute(name = "team_short")
	private String teamShort;
	@XmlAttribute(name = "team_abbrev")
	private String teamAbbrev;
	@XmlAttribute(name = "clinched_sw")
	private String clinchedSw;

	public String getClinchedSW() {
		return clinchedSw;
	}

	@Override
	public String toString() {
		return "Team Standings [division=" + division + ", division_id=" + divisionId + ", team_id="
				+ teamId + ", file_code=" + teamShortcode + ", team_full=" + teamName + "]";
	}
}
