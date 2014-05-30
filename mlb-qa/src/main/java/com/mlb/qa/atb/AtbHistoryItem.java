package com.mlb.qa.atb;

import java.util.Date;

public class AtbHistoryItem {

    private String ballpark_name;

    private String city;

    private String checkinDate;

    public String getBallpark_name() {
        return ballpark_name;
    }

    public void setBallpark_name(String ballpark_name) {
        this.ballpark_name = ballpark_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(String checkinDate) {
        this.checkinDate = checkinDate;
    }
}
