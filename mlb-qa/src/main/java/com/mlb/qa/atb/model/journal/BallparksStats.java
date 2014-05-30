package com.mlb.qa.atb.model.journal;

import com.google.gson.annotations.Expose;

public class BallparksStats {

    @Expose
    private String officialBallparks;
    @Expose
    private Integer totalTeams;
    @Expose
    private String totalVisits;
    @Expose
    private Integer officialTeams;
    @Expose
    private String officialVisits;
    @Expose
    private String totalBallparks;

    public String getOfficialBallparks() {
        return officialBallparks;
    }

    public void setOfficialBallparks(String officialBallparks) {
        this.officialBallparks = officialBallparks;
    }

    public Integer getTotalTeams() {
        return totalTeams;
    }

    public void setTotalTeams(Integer totalTeams) {
        this.totalTeams = totalTeams;
    }

    public String getTotalVisits() {
        return totalVisits;
    }

    public void setTotalVisits(String totalVisits) {
        this.totalVisits = totalVisits;
    }

    public Integer getOfficialTeams() {
        return officialTeams;
    }

    public void setOfficialTeams(Integer officialTeams) {
        this.officialTeams = officialTeams;
    }

    public String getOfficialVisits() {
        return officialVisits;
    }

    public void setOfficialVisits(String officialVisits) {
        this.officialVisits = officialVisits;
    }

    public String getTotalBallparks() {
        return totalBallparks;
    }

    public void setTotalBallparks(String totalBallparks) {
        this.totalBallparks = totalBallparks;
    }

}
