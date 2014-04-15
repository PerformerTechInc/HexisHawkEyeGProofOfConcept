package com.mlb.qa.atb.model.game_ticket;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.joda.time.DateTime;

import com.mlb.qa.atb.model.Item;
import com.mlb.qa.atb.model.adapter.JodaTimeDateAdapter;

/**
 * Game Ticket item
 */
@XmlRootElement(name = "game")
public class GameTicket implements Item {
	@XmlAttribute(name = "schedule_id")
	private String scheduleId;
	@XmlAttribute(name = "game_time_local")
	@XmlJavaTypeAdapter(value = JodaTimeDateAdapter.class)
	private DateTime dateTimeLocal;
	@XmlAttribute(name = "away_name_team")
	private String awayNameTeam;
	@XmlElement(name = "ticket_link")
	private TicketLink ticketLink;

	public String getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}

	public DateTime getDateTimeLocal() {
		return dateTimeLocal;
	}

	public void setDateTimeLocal(DateTime dateTimeLocal) {
		this.dateTimeLocal = dateTimeLocal;
	}

	public String getAwayNameTeam() {
		return awayNameTeam;
	}

	public void setAwayNameTeam(String awayNameTeam) {
		this.awayNameTeam = awayNameTeam;
	}

	public TicketLink getTicketLink() {
		return ticketLink;
	}

	public void setTicketLink(TicketLink ticketLink) {
		this.ticketLink = ticketLink;
	}

	@Override
	public String toString() {
		return "GameTicket [scheduleId=" + scheduleId + ", dateTimeLocal=" + dateTimeLocal + ", awayNameTeam="
				+ awayNameTeam + ", ticketLink=" + ticketLink + "]";
	}
}
