package com.mlb.qa.at_bat.model.news;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class RelatedMedium {

    @Expose
    private String type;
    @Expose
    private Integer contentId;
    @Expose
    private String userDate;
    @Expose
    private Integer sequence;
    @SerializedName("delivery-type")
    @Expose
    private String deliveryType;
    @Expose
    private String kicker;
    @Expose
    private String blurb;
    @Expose
    private String duration;
    @Expose
    private String guid;
    @Expose
    private String secure;
    @Expose
    private String headline;
    @Expose
    private Integer namespace;
    @Expose
    private String bigblurb;
    @SerializedName("media-urls")
    @Expose
    private MediaUrls mediaUrls;
    @Expose
    private ItemTagsRoot itemTags;

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
     * @return The contentId
     */
    public Integer getContentId() {
        return contentId;
    }

    /**
     * @param contentId The contentId
     */
    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    /**
     * @return The userDate
     */
    public String getUserDate() {
        return userDate;
    }

    /**
     * @param userDate The userDate
     */
    public void setUserDate(String userDate) {
        this.userDate = userDate;
    }

    /**
     * @return The sequence
     */
    public Integer getSequence() {
        return sequence;
    }

    /**
     * @param sequence The sequence
     */
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    /**
     * @return The deliveryType
     */
    public String getDeliveryType() {
        return deliveryType;
    }

    /**
     * @param deliveryType The delivery-type
     */
    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    /**
     * @return The kicker
     */
    public String getKicker() {
        return kicker;
    }

    /**
     * @param kicker The kicker
     */
    public void setKicker(String kicker) {
        this.kicker = kicker;
    }

    /**
     * @return The blurb
     */
    public String getBlurb() {
        return blurb;
    }

    /**
     * @param blurb The blurb
     */
    public void setBlurb(String blurb) {
        this.blurb = blurb;
    }

    /**
     * @return The duration
     */
    public String getDuration() {
        return duration;
    }

    /**
     * @param duration The duration
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * @return The guid
     */
    public String getGuid() {
        return guid;
    }

    /**
     * @param guid The guid
     */
    public void setGuid(String guid) {
        this.guid = guid;
    }

    /**
     * @return The secure
     */
    public String getSecure() {
        return secure;
    }

    /**
     * @param secure The secure
     */
    public void setSecure(String secure) {
        this.secure = secure;
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

    /**
     * @return The namespace
     */
    public Integer getNamespace() {
        return namespace;
    }

    /**
     * @param namespace The namespace
     */
    public void setNamespace(Integer namespace) {
        this.namespace = namespace;
    }

    /**
     * @return The bigblurb
     */
    public String getBigblurb() {
        return bigblurb;
    }

    /**
     * @param bigblurb The bigblurb
     */
    public void setBigblurb(String bigblurb) {
        this.bigblurb = bigblurb;
    }

    /**
     * @return The mediaUrls
     */
    public MediaUrls getMediaUrls() {
        return mediaUrls;
    }

    /**
     * @param mediaUrls The media-urls
     */
    public void setMediaUrls(MediaUrls mediaUrls) {
        this.mediaUrls = mediaUrls;
    }

    /**
     * @return The itemTags
     */
    public ItemTagsRoot getItemTags() {
        return itemTags;
    }

    /**
     * @param itemTags The itemTags
     */
    public void setItemTags(ItemTagsRoot itemTags) {
        this.itemTags = itemTags;
    }


}
