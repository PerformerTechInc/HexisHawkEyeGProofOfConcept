package com.mlb.qa.atb.model.map;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Place {

    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Location")
    @Expose
    private String location;
    @SerializedName("Type")
    @Expose
    private String type;
    @SerializedName("SubType")
    @Expose
    private String subType;
    @SerializedName("Section")
    @Expose
    private String section;
    @SerializedName("ID")
    @Expose
    private String iD;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getID() {
        return iD;
    }

    public void setID(String iD) {
        this.iD = iD;
    }

}