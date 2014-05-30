package com.mlb.qa.atb.model.stats;

import com.google.gson.annotations.Expose;

/**
 * Created by Administrator on 5/26/2014.
 */
public class AwayTeam {

    @Expose
    private String totalPercentage;
    @Expose
    private String totalRecord;
    @Expose
    private String teamId;
    @Expose
    private String venueId;

    public String getTotalPercentage() {
        return totalPercentage;
    }

    public void setTotalPercentage(String totalPercentage) {
        this.totalPercentage = totalPercentage;
    }

    public String getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(String totalRecord) {
        this.totalRecord = totalRecord;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getVenueId() {
        return venueId;
    }

    public void setVenueId(String venueId) {
        this.venueId = venueId;
    }

}
