package com.mlb.qa.atb.model.game_promotion;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.joda.time.DateTime;

import com.mlb.qa.atb.model.Item;
import com.mlb.qa.atb.model.adapter.JodaTimeDateAdapter;

/**
 * Game Promotion
 */
public class GamePromotion implements Item {

	@XmlAttribute(name = "away_name_team")
	private String awayNameTeam;
	@XmlAttribute(name = "game_time_local")
	@XmlJavaTypeAdapter(value = JodaTimeDateAdapter.class)
	private DateTime gameDate;
	@XmlElement(name = "promotion")
	private List<Promotion> promotions;

	public String getAwayNameTeam() {
		return awayNameTeam;
	}

	public void setAwayNameTeam(String awayNameTeam) {
		this.awayNameTeam = awayNameTeam;
	}

	public DateTime getGameDate() {
		return gameDate;
	}

	public void setGameDate(DateTime gameDate) {
		this.gameDate = gameDate;
	}

	public List<Promotion> getPromotions() {
		return promotions;
	}

	public void setPromotions(List<Promotion> promotions) {
		this.promotions = promotions;
	}

	@Override
	public String toString() {
		return "GamePromotion [awayNameTeam=" + awayNameTeam + ", gameDate=" + gameDate + ", promotions=" + promotions
				+ "]";
	}

}
