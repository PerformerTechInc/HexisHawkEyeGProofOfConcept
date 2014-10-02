package com.mlb.qa.at_bat.model.news;

import com.google.gson.annotations.Expose;

public class Photo {

    @Expose
    private String type;
    @Expose
    private String headline;

    /**
     * @return The type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return The headline
     */
    public String getHeadline() {
        return headline;
    }

    /**
     * @param headline The headline
     */
    public void setHeadline(String headline) {
        this.headline = headline;
    }


}
