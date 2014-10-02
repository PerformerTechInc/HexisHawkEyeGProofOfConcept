package com.mlb.qa.at_bat.model.news;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ItemTagsRoot {

    @Expose
    private List<String> mlbtax = new ArrayList<String>();
    @SerializedName("inning_index_location_xml")
    @Expose
    private List<String> inningIndexLocationXml = new ArrayList<String>();
    @SerializedName("run_scoring_plays_location_plist")
    @Expose
    private List<String> runScoringPlaysLocationPlist = new ArrayList<String>();
    @Expose
    private List<String> mmtax = new ArrayList<String>();
    @Expose
    private List<String> authflow = new ArrayList<String>();
    @SerializedName("calendar_event_id")
    @Expose
    private List<String> calendarEventId = new ArrayList<String>();
    @SerializedName("inning_index_location_plist")
    @Expose
    private List<String> inningIndexLocationPlist = new ArrayList<String>();
    @SerializedName("team_id")
    @Expose
    private List<String> teamId = new ArrayList<String>();
    @SerializedName("game_id")
    @Expose
    private List<String> gameId = new ArrayList<String>();
    @Expose
    private List<String> subject = new ArrayList<String>();
    @SerializedName("home_team_id")
    @Expose
    private List<String> homeTeamId = new ArrayList<String>();
    @SerializedName("game_pk")
    @Expose
    private List<String> gamePk = new ArrayList<String>();
    @SerializedName("combined_media_state")
    @Expose
    private List<String> combinedMediaState = new ArrayList<String>();
    @SerializedName("away_team_id")
    @Expose
    private List<String> awayTeamId = new ArrayList<String>();
    @SerializedName("event_date")
    @Expose
    private List<String> eventDate = new ArrayList<String>();
    @SerializedName("game_events_location_plist")
    @Expose
    private List<String> gameEventsLocationPlist = new ArrayList<String>();

    /**
     * @return The mlbtax
     */
    public List<String> getMlbtax() {
        return mlbtax;
    }

    /**
     * @param mlbtax The mlbtax
     */
    public void setMlbtax(List<String> mlbtax) {
        this.mlbtax = mlbtax;
    }

    /**
     * @return The inningIndexLocationXml
     */
    public List<String> getInningIndexLocationXml() {
        return inningIndexLocationXml;
    }

    /**
     * @param inningIndexLocationXml The inning_index_location_xml
     */
    public void setInningIndexLocationXml(List<String> inningIndexLocationXml) {
        this.inningIndexLocationXml = inningIndexLocationXml;
    }

    /**
     * @return The runScoringPlaysLocationPlist
     */
    public List<String> getRunScoringPlaysLocationPlist() {
        return runScoringPlaysLocationPlist;
    }

    /**
     * @param runScoringPlaysLocationPlist The run_scoring_plays_location_plist
     */
    public void setRunScoringPlaysLocationPlist(List<String> runScoringPlaysLocationPlist) {
        this.runScoringPlaysLocationPlist = runScoringPlaysLocationPlist;
    }

    /**
     * @return The mmtax
     */
    public List<String> getMmtax() {
        return mmtax;
    }

    /**
     * @param mmtax The mmtax
     */
    public void setMmtax(List<String> mmtax) {
        this.mmtax = mmtax;
    }

    /**
     * @return The authflow
     */
    public List<String> getAuthflow() {
        return authflow;
    }

    /**
     * @param authflow The authflow
     */
    public void setAuthflow(List<String> authflow) {
        this.authflow = authflow;
    }

    /**
     * @return The calendarEventId
     */
    public List<String> getCalendarEventId() {
        return calendarEventId;
    }

    /**
     * @param calendarEventId The calendar_event_id
     */
    public void setCalendarEventId(List<String> calendarEventId) {
        this.calendarEventId = calendarEventId;
    }

    /**
     * @return The inningIndexLocationPlist
     */
    public List<String> getInningIndexLocationPlist() {
        return inningIndexLocationPlist;
    }

    /**
     * @param inningIndexLocationPlist The inning_index_location_plist
     */
    public void setInningIndexLocationPlist(List<String> inningIndexLocationPlist) {
        this.inningIndexLocationPlist = inningIndexLocationPlist;
    }

    /**
     * @return The teamId
     */
    public List<String> getTeamId() {
        return teamId;
    }

    /**
     * @param teamId The team_id
     */
    public void setTeamId(List<String> teamId) {
        this.teamId = teamId;
    }

    /**
     * @return The gameId
     */
    public List<String> getGameId() {
        return gameId;
    }

    /**
     * @param gameId The game_id
     */
    public void setGameId(List<String> gameId) {
        this.gameId = gameId;
    }

    /**
     * @return The subject
     */
    public List<String> getSubject() {
        return subject;
    }

    /**
     * @param subject The subject
     */
    public void setSubject(List<String> subject) {
        this.subject = subject;
    }

    /**
     * @return The homeTeamId
     */
    public List<String> getHomeTeamId() {
        return homeTeamId;
    }

    /**
     * @param homeTeamId The home_team_id
     */
    public void setHomeTeamId(List<String> homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    /**
     * @return The gamePk
     */
    public List<String> getGamePk() {
        return gamePk;
    }

    /**
     * @param gamePk The game_pk
     */
    public void setGamePk(List<String> gamePk) {
        this.gamePk = gamePk;
    }

    /**
     * @return The combinedMediaState
     */
    public List<String> getCombinedMediaState() {
        return combinedMediaState;
    }

    /**
     * @param combinedMediaState The combined_media_state
     */
    public void setCombinedMediaState(List<String> combinedMediaState) {
        this.combinedMediaState = combinedMediaState;
    }

    /**
     * @return The awayTeamId
     */
    public List<String> getAwayTeamId() {
        return awayTeamId;
    }

    /**
     * @param awayTeamId The away_team_id
     */
    public void setAwayTeamId(List<String> awayTeamId) {
        this.awayTeamId = awayTeamId;
    }

    /**
     * @return The eventDate
     */
    public List<String> getEventDate() {
        return eventDate;
    }

    /**
     * @param eventDate The event_date
     */
    public void setEventDate(List<String> eventDate) {
        this.eventDate = eventDate;
    }

    /**
     * @return The gameEventsLocationPlist
     */
    public List<String> getGameEventsLocationPlist() {
        return gameEventsLocationPlist;
    }

    /**
     * @param gameEventsLocationPlist The game_events_location_plist
     */
    public void setGameEventsLocationPlist(List<String> gameEventsLocationPlist) {
        this.gameEventsLocationPlist = gameEventsLocationPlist;
    }


}
