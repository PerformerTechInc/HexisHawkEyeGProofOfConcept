package com.mlb.qa.atb.model.photo_gallery;

import com.google.gson.annotations.Expose;

public class Response {

    @Expose
    private String mediaId;
    @Expose
    private String associatedCheckinId;
    @Expose
    private Integer width;
    @Expose
    private String mtype;
    @Expose
    private String associatedEventGUID;
    @Expose
    private String mediumRetinaURL;
    @Expose
    private Integer height;
    @Expose
    private String thumbnailRetinaURL;
    @Expose
    private String userId;
    @Expose
    private String mediaURL;
    @Expose
    private Integer longitude;
    @Expose
    private Integer latitude;
    @Expose
    private String createdDate;
    @Expose
    private String thumbnailURL;
    @Expose
    private String mediumURL;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getAssociatedCheckinId() {
        return associatedCheckinId;
    }

    public void setAssociatedCheckinId(String associatedCheckinId) {
        this.associatedCheckinId = associatedCheckinId;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public String getMtype() {
        return mtype;
    }

    public void setMtype(String mtype) {
        this.mtype = mtype;
    }

    public String getAssociatedEventGUID() {
        return associatedEventGUID;
    }

    public void setAssociatedEventGUID(String associatedEventGUID) {
        this.associatedEventGUID = associatedEventGUID;
    }

    public String getMediumRetinaURL() {
        return mediumRetinaURL;
    }

    public void setMediumRetinaURL(String mediumRetinaURL) {
        this.mediumRetinaURL = mediumRetinaURL;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMediaURL() {
        return mediaURL;
    }

    public void setMediaURL(String mediaURL) {
        this.mediaURL = mediaURL;
    }

    public Integer getLongitude() {
        return longitude;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }

    public Integer getLatitude() {
        return latitude;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }

    public String getMediumURL() {
        return mediumURL;
    }

    public void setMediumURL(String mediumURL) {
        this.mediumURL = mediumURL;
    }

}
