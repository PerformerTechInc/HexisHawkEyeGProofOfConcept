package com.mlb.qa.atb.model.map;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Level {

    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Places")
    @Expose
    private List<Place> places = new ArrayList<Place>();
    @SerializedName("Sections")
    @Expose
    private List<Section> sections = new ArrayList<Section>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

}