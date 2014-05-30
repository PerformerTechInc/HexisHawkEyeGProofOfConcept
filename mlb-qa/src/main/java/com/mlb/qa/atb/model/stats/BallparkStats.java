package com.mlb.qa.atb.model.stats;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class BallparkStats {

    @Expose
    private Integer ballparkOfficialVisits;
    @Expose
    private Integer totalVisits;
    @Expose
    private Integer ballparkTotalVisits;
    @Expose
    private Integer officialVisits;
    @Expose
    private List<Ballpark> ballparks = new ArrayList<Ballpark>();

    public Integer getBallparkOfficialVisits() {
        return ballparkOfficialVisits;
    }

    public void setBallparkOfficialVisits(Integer ballparkOfficialVisits) {
        this.ballparkOfficialVisits = ballparkOfficialVisits;
    }

    public Integer getTotalVisits() {
        return totalVisits;
    }

    public void setTotalVisits(Integer totalVisits) {
        this.totalVisits = totalVisits;
    }

    public Integer getBallparkTotalVisits() {
        return ballparkTotalVisits;
    }

    public void setBallparkTotalVisits(Integer ballparkTotalVisits) {
        this.ballparkTotalVisits = ballparkTotalVisits;
    }

    public Integer getOfficialVisits() {
        return officialVisits;
    }

    public void setOfficialVisits(Integer officialVisits) {
        this.officialVisits = officialVisits;
    }

    public List<Ballpark> getBallparks() {
        return ballparks;
    }

    public void setBallparks(List<Ballpark> ballparks) {
        this.ballparks = ballparks;
    }

}
