package com.mlb.qa.atb.model.stats;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;

public class TeamStats {

    @Expose
    private String overallTotalHomeRecord;
    @Expose
    private List<HomeTeam> homeTeams = new ArrayList<HomeTeam>();
    @Expose
    private List<AwayTeam> awayTeams = new ArrayList<AwayTeam>();
    @Expose
    private List<TotalTeam> totalTeams = new ArrayList<TotalTeam>();
    @Expose
    private String overallTotalHomePercentage;

    public String getOverallTotalHomeRecord() {
        return overallTotalHomeRecord;
    }

    public void setOverallTotalHomeRecord(String overallTotalHomeRecord) {
        this.overallTotalHomeRecord = overallTotalHomeRecord;
    }

    public List<HomeTeam> getHomeTeams() {
        return homeTeams;
    }

    public void setHomeTeams(List<HomeTeam> homeTeams) {
        this.homeTeams = homeTeams;
    }

    public List<AwayTeam> getAwayTeams() {
        return awayTeams;
    }

    public void setAwayTeams(List<AwayTeam> awayTeams) {
        this.awayTeams = awayTeams;
    }

    public List<TotalTeam> getTotalTeams() {
        return totalTeams;
    }

    public void setTotalTeams(List<TotalTeam> totalTeams) {
        this.totalTeams = totalTeams;
    }

    public String getOverallTotalHomePercentage() {
        return overallTotalHomePercentage;
    }

    public void setOverallTotalHomePercentage(String overallTotalHomePercentage) {
        this.overallTotalHomePercentage = overallTotalHomePercentage;
    }

}
