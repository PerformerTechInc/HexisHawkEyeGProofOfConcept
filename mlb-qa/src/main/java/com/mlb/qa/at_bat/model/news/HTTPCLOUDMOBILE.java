package com.mlb.qa.at_bat.model.news;

import com.google.gson.annotations.Expose;


public class HTTPCLOUDMOBILE {

    @Expose
    private String playbackScenario;
    @Expose
    private String mediaState;
    @Expose
    private String src;

    /**
     * @return The playbackScenario
     */
    public String getPlaybackScenario() {
        return playbackScenario;
    }

    /**
     * @param playbackScenario The playbackScenario
     */
    public void setPlaybackScenario(String playbackScenario) {
        this.playbackScenario = playbackScenario;
    }

    /**
     * @return The mediaState
     */
    public String getMediaState() {
        return mediaState;
    }

    /**
     * @param mediaState The mediaState
     */
    public void setMediaState(String mediaState) {
        this.mediaState = mediaState;
    }

    /**
     * @return The src
     */
    public String getSrc() {
        return src;
    }

    /**
     * @param src The src
     */
    public void setSrc(String src) {
        this.src = src;
    }


}
