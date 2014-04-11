package com.mlb.qa.atb.model.checkin_history;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.joda.time.DateTime;

import com.mlb.qa.atb.model.Item;
import com.mlb.qa.atb.model.adapter.JodaTimeDateAdapter;

/**
 * Check-in in history bean. NOTE: only base fields implemented
 */
public class CheckinHistoryJsonItem implements Item {
	@XmlElement(name = "checkinType", required = false)
	private String checkinType;
	@XmlElement(name = "checkinStatusId", required = true)
	private Integer checkinStatusId;
	@XmlElement(name = "eventType", required = false)
	private String eventType;
	@XmlElement(name = "checkinId", required = true)
	private String checkinId;
	@XmlElement(name = "eventId", required = true)
	private Integer eventId;
	@XmlElement(name = "awayName", required = false)
	private String awayName;
	@XmlElement(name = "homeName", required = false)
	private String homeName;
	@XmlElement(name = "eventName", required = false)
	private String eventName;
	private DateTime checkinDate;
	@XmlElement(name = "official", required = false)
	private Boolean isOfficial;
	@XmlElement(name = "venueId", required = true)
	private Integer venueId;
	@XmlElement(name = "venueName", required = false)
	private Integer venueName;

	public String getCheckinType() {
		return checkinType;
	}

	public void setCheckinType(String checkinType) {
		this.checkinType = checkinType;
	}

	public Integer getCheckinStatusId() {
		return checkinStatusId;
	}

	public void setCheckinStatusId(Integer checkinStatusId) {
		this.checkinStatusId = checkinStatusId;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getCheckinId() {
		return checkinId;
	}

	public void setCheckinId(String checkinId) {
		this.checkinId = checkinId;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public String getAwayName() {
		return awayName;
	}

	public void setAwayName(String awayName) {
		this.awayName = awayName;
	}

	public String getHomeName() {
		return homeName;
	}

	public void setHomeName(String homeName) {
		this.homeName = homeName;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	@XmlElement(name = "checkinDate")
	@XmlJavaTypeAdapter(value = JodaTimeDateAdapter.class)
	public DateTime getCheckinDate() {
		return checkinDate;
	}

	public void setCheckinDate(DateTime checkinDate) {
		this.checkinDate = checkinDate;
	}

	public Boolean getIsOfficial() {
		return isOfficial;
	}

	public void setIsOfficial(Boolean isOfficial) {
		this.isOfficial = isOfficial;
	}

	public Integer getVenueId() {
		return venueId;
	}

	public void setVenueId(Integer venueId) {
		this.venueId = venueId;
	}

	public Integer getVenueName() {
		return venueName;
	}

	public void setVenueName(Integer venueName) {
		this.venueName = venueName;
	}

	@Override
	public String toString() {
		return "CheckinHistoryItem [checkinType=" + checkinType + ", checkinStatusId=" + checkinStatusId
				+ ", eventType=" + eventType + ", checkinId=" + checkinId + ", eventId=" + eventId + ", awayName="
				+ awayName + ", homeName=" + homeName + ", eventName=" + eventName + ", checkinDate=" + checkinDate
				+ ", isOfficial=" + isOfficial + ", venueId=" + venueId + ", venueName=" + venueName + "]";
	}

}
