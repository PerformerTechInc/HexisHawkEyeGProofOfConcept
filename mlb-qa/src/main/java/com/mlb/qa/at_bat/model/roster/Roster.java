package com.mlb.qa.at_bat.model.roster;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.mlb.qa.atb.model.Item;

@XmlRootElement(name = "row")
@XmlAccessorType(XmlAccessType.FIELD)
public class Roster implements Item {

	@XmlAttribute(name = "player_id")
	private String playerId;
	@XmlAttribute(name = "name_full")
	private String nameFull;
	@XmlAttribute(name = "primary_position")
	private String primaryPosition;
	@XmlAttribute(name = "position_txt")
	private String positionTxt;
	@XmlAttribute(name = "jersey_number")
	private String jerseyNumber;

	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return nameFull;
	}

	public void setPlayerName(String playerName) {
		this.nameFull = playerName;
	}

	public String getPlayerPositionNum() {
		return primaryPosition;
	}
	
	public void setPlayerPositionNum(String primaryPosition) {
		this.primaryPosition = primaryPosition;
	}
	
	public String getPlayerPositionText() {
		return positionTxt;
	}
	
	public void setPlayerPositionText(String positionTxt) {
		this.positionTxt = positionTxt;
	}

	public String getPlayerNumber() {
		return jerseyNumber;
	}
	
	public void setPlayerNumber(String jerseyNumber) {
		this.jerseyNumber = jerseyNumber;
	}
	
	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", player_name=" + nameFull + ", player_position_num="
				+ primaryPosition + ", player_position_txt=" + positionTxt + ", player_jersey_number=" + jerseyNumber + "]";
	}
}
