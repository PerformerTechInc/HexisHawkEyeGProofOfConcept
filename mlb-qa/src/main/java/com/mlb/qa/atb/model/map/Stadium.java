package com.mlb.qa.atb.model.map;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Stadium {

    @SerializedName("Levels")
    @Expose
    private List<Level> levels = new ArrayList<Level>();

    public List<Level> getLevels() {
        return levels;
    }

    public void setLevels(List<Level> levels) {
        this.levels = levels;
    }

}