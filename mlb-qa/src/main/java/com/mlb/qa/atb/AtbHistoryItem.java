package com.mlb.qa.atb;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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


    public int hashCode() {
        return new HashCodeBuilder(17, 31).
                append(ballpark_name).
                append(city).
                append(checkinDate).
                toHashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AtbHistoryItem))
            return false;
        if (obj == this)
            return true;

        AtbHistoryItem rhs = (AtbHistoryItem) obj;
        return new EqualsBuilder().
                append(ballpark_name, rhs.ballpark_name).
                append(city, rhs.city).append(checkinDate, rhs.checkinDate).
                isEquals();
    }
}
