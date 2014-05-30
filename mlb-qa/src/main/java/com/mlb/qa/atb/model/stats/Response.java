package com.mlb.qa.atb.model.stats;

import com.google.gson.annotations.Expose;

public class Response {

    @Expose
    private TeamStats teamStats;
    @Expose
    private BallparkStats ballparkStats;

    public TeamStats getTeamStats() {
        return teamStats;
    }

    public void setTeamStats(TeamStats teamStats) {
        this.teamStats = teamStats;
    }

    public BallparkStats getBallparkStats() {
        return ballparkStats;
    }

    public void setBallparkStats(BallparkStats ballparkStats) {
        this.ballparkStats = ballparkStats;
    }

}
