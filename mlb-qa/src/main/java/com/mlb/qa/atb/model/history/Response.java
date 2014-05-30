package com.mlb.qa.atb.model.history;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class Response {

    @Expose
    private String awayName;
    @Expose
    private String awayScore;
    @Expose
    private String checkinDate;
    @Expose
    private String checkinId;
    @Expose
    private Double checkinStatusId;
    @Expose
    private String checkinType;
    @Expose
    private String createdDate;
    @Expose
    private String eventId;
    @Expose
    private String eventName;
    @Expose
    private String eventType;
    @Expose
    private String homeName;
    @Expose
    private String homeScore;
    @Expose
    private Double latitude;
    @Expose
    private Double longitude;
    @Expose
    private Double nthCheckin;
    @Expose
    private Boolean official;
    @Expose
    private List<Object> photos = new ArrayList<Object>();
    @Expose
    private String row;
    @Expose
    private String seat;
    @Expose
    private String section;
    @Expose
    private String subLocation;
    @Expose
    private String venueId;
    @Expose
    private String venueName;
    @Expose
    private String venueType;

    public String getAwayName() {
        return awayName;
    }

    public void setAwayName(String awayName) {
        this.awayName = awayName;
    }

    public String getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(String awayScore) {
        this.awayScore = awayScore;
    }

    public String getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(String checkinDate) {
        this.checkinDate = checkinDate;
    }

    public String getCheckinId() {
        return checkinId;
    }

    public void setCheckinId(String checkinId) {
        this.checkinId = checkinId;
    }

    public Double getCheckinStatusId() {
        return checkinStatusId;
    }

    public void setCheckinStatusId(Double checkinStatusId) {
        this.checkinStatusId = checkinStatusId;
    }

    public String getCheckinType() {
        return checkinType;
    }

    public void setCheckinType(String checkinType) {
        this.checkinType = checkinType;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getHomeName() {
        return homeName;
    }

    public void setHomeName(String homeName) {
        this.homeName = homeName;
    }

    public String getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(String homeScore) {
        this.homeScore = homeScore;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getNthCheckin() {
        return nthCheckin;
    }

    public void setNthCheckin(Double nthCheckin) {
        this.nthCheckin = nthCheckin;
    }

    public Boolean getOfficial() {
        return official;
    }

    public void setOfficial(Boolean official) {
        this.official = official;
    }

    public List<Object> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Object> photos) {
        this.photos = photos;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSubLocation() {
        return subLocation;
    }

    public void setSubLocation(String subLocation) {
        this.subLocation = subLocation;
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

    public String getVenueType() {
        return venueType;
    }

    public void setVenueType(String venueType) {
        this.venueType = venueType;
    }

}