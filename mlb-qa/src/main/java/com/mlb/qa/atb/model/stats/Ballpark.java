package com.mlb.qa.atb.model.stats;

import com.google.gson.annotations.Expose;

public class Ballpark {

    @Expose
    private String id;
    @Expose
    private String address;
    @Expose
    private String name;
    @Expose
    private Integer totalVisits;
    @Expose
    private Integer officialVisits;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotalVisits() {
        return totalVisits;
    }

    public void setTotalVisits(Integer totalVisits) {
        this.totalVisits = totalVisits;
    }

    public Integer getOfficialVisits() {
        return officialVisits;
    }

    public void setOfficialVisits(Integer officialVisits) {
        this.officialVisits = officialVisits;
    }

}
