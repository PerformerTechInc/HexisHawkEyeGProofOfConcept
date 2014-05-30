package com.mlb.qa.atb.model.journal;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;

public class JournalResponse {

    @Expose
    private List<Photo> photos = new ArrayList<Photo>();
    @Expose
    private BallparksStats ballparksStats;
    @Expose
    private List<CheckinHistory> checkinHistory = new ArrayList<CheckinHistory>();

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public BallparksStats getBallparksStats() {
        return ballparksStats;
    }

    public void setBallparksStats(BallparksStats ballparksStats) {
        this.ballparksStats = ballparksStats;
    }

    public List<CheckinHistory> getCheckinHistory() {
        return checkinHistory;
    }

    public void setCheckinHistory(List<CheckinHistory> checkinHistory) {
        this.checkinHistory = checkinHistory;
    }

}
