package com.mlb.qa.atb.model.journal;

import com.google.gson.annotations.Expose;

public class Photo {

    @Expose
    private String mediaId;
    @Expose
    private Integer height;
    @Expose
    private String thumbnailRetinaURL;
    @Expose
    private Integer width;
    @Expose
    private String mediaURL;
    @Expose
    private String mtype;
    @Expose
    private String createdDate;
    @Expose
    private String mediumRetinaURL;
    @Expose
    private String mediumURL;
    @Expose
    private String thumbnailURL;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getThumbnailRetinaURL() {
        return thumbnailRetinaURL;
    }

    public void setThumbnailRetinaURL(String thumbnailRetinaURL) {
        this.thumbnailRetinaURL = thumbnailRetinaURL;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public String getMediaURL() {
        return mediaURL;
    }

    public void setMediaURL(String mediaURL) {
        this.mediaURL = mediaURL;
    }

    public String getMtype() {
        return mtype;
    }

    public void setMtype(String mtype) {
        this.mtype = mtype;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getMediumRetinaURL() {
        return mediumRetinaURL;
    }

    public void setMediumRetinaURL(String mediumRetinaURL) {
        this.mediumRetinaURL = mediumRetinaURL;
    }

    public String getMediumURL() {
        return mediumURL;
    }

    public void setMediumURL(String mediumURL) {
        this.mediumURL = mediumURL;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }

}