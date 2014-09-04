package com.mlb.qa.at_bat.model.news;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class List {

    @Expose
    private String type;
    @Expose
    private Integer contentId;
    @Expose
    private String userDate;
    @Expose
    private String timestamp;
    @Expose
    private String byline;
    @Expose
    private String tagline;
    @SerializedName("alt-headline")
    @Expose
    private String altHeadline;
    @Expose
    private String source;
    @Expose
    private String summary;
    @Expose
    private String blurb;
    @Expose
    private String language;
    @Expose
    private String overridevideo;
    @Expose
    private String headline;
    @Expose
    private String subhead;
    @Expose
    private String approval;
    @Expose
    private String body;
    @Expose
    private String url;
    @SerializedName("shared-url")
    @Expose
    private String sharedUrl;
    @SerializedName("seo-headline")
    @Expose
    private String seoHeadline;
    @Expose
    private java.util.List<Photo> photos = new ArrayList<Photo>();
    @SerializedName("related-media")
    @Expose
    private java.util.List<RelatedMedium> relatedMedia = new ArrayList<RelatedMedium>();
    @Expose
    private ItemTagsMid itemTags;
    @Expose
    private String overridephoto;
    @SerializedName("related-items")
    @Expose
    private java.util.List<Object> relatedItems = new ArrayList<Object>();
    @SerializedName("link-text")
    @Expose
    private String linkText;
    @SerializedName("link-url")
    @Expose
    private String linkUrl;
    @Expose
    private String popup;
    @SerializedName("pop-up")
    @Expose
    private String popUp;
    @SerializedName("mobile-url")
    @Expose
    private String mobileUrl;
    @SerializedName("column-width")
    @Expose
    private Integer columnWidth;
    @SerializedName("media-credit")
    @Expose
    private String mediaCredit;

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
     * @return The timestamp
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp The timestamp
     */
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * @return The byline
     */
    public String getByline() {
        return byline;
    }

    /**
     * @param byline The byline
     */
    public void setByline(String byline) {
        this.byline = byline;
    }

    /**
     * @return The tagline
     */
    public String getTagline() {
        return tagline;
    }

    /**
     * @param tagline The tagline
     */
    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    /**
     * @return The altHeadline
     */
    public String getAltHeadline() {
        return altHeadline;
    }

    /**
     * @param altHeadline The alt-headline
     */
    public void setAltHeadline(String altHeadline) {
        this.altHeadline = altHeadline;
    }

    /**
     * @return The source
     */
    public String getSource() {
        return source;
    }

    /**
     * @param source The source
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * @return The summary
     */
    public String getSummary() {
        return summary;
    }

    /**
     * @param summary The summary
     */
    public void setSummary(String summary) {
        this.summary = summary;
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
     * @return The language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * @param language The language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * @return The overridevideo
     */
    public String getOverridevideo() {
        return overridevideo;
    }

    /**
     * @param overridevideo The overridevideo
     */
    public void setOverridevideo(String overridevideo) {
        this.overridevideo = overridevideo;
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
     * @return The subhead
     */
    public String getSubhead() {
        return subhead;
    }

    /**
     * @param subhead The subhead
     */
    public void setSubhead(String subhead) {
        this.subhead = subhead;
    }

    /**
     * @return The approval
     */
    public String getApproval() {
        return approval;
    }

    /**
     * @param approval The approval
     */
    public void setApproval(String approval) {
        this.approval = approval;
    }

    /**
     * @return The body
     */
    public String getBody() {
        return body;
    }

    /**
     * @param body The body
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * @return The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return The sharedUrl
     */
    public String getSharedUrl() {
        return sharedUrl;
    }

    /**
     * @param sharedUrl The shared-url
     */
    public void setSharedUrl(String sharedUrl) {
        this.sharedUrl = sharedUrl;
    }

    /**
     * @return The seoHeadline
     */
    public String getSeoHeadline() {
        return seoHeadline;
    }

    /**
     * @param seoHeadline The seo-headline
     */
    public void setSeoHeadline(String seoHeadline) {
        this.seoHeadline = seoHeadline;
    }

    /**
     * @return The photos
     */
    public java.util.List<Photo> getPhotos() {
        return photos;
    }

    /**
     * @param photos The photos
     */
    public void setPhotos(java.util.List<Photo> photos) {
        this.photos = photos;
    }

    /**
     * @return The relatedMedia
     */
    public java.util.List<RelatedMedium> getRelatedMedia() {
        return relatedMedia;
    }

    /**
     * @param relatedMedia The related-media
     */
    public void setRelatedMedia(java.util.List<RelatedMedium> relatedMedia) {
        this.relatedMedia = relatedMedia;
    }

    /**
     * @return The itemTags
     */
    public ItemTagsMid getItemTags() {
        return itemTags;
    }

    /**
     * @param itemTags The itemTags
     */
    public void setItemTags(ItemTagsMid itemTags) {
        this.itemTags = itemTags;
    }

    /**
     * @return The overridephoto
     */
    public String getOverridephoto() {
        return overridephoto;
    }

    /**
     * @param overridephoto The overridephoto
     */
    public void setOverridephoto(String overridephoto) {
        this.overridephoto = overridephoto;
    }

    /**
     * @return The relatedItems
     */
    public java.util.List<Object> getRelatedItems() {
        return relatedItems;
    }

    /**
     * @param relatedItems The related-items
     */
    public void setRelatedItems(java.util.List<Object> relatedItems) {
        this.relatedItems = relatedItems;
    }

    /**
     * @return The linkText
     */
    public String getLinkText() {
        return linkText;
    }

    /**
     * @param linkText The link-text
     */
    public void setLinkText(String linkText) {
        this.linkText = linkText;
    }

    /**
     * @return The linkUrl
     */
    public String getLinkUrl() {
        return linkUrl;
    }

    /**
     * @param linkUrl The link-url
     */
    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    /**
     * @return The popup
     */
    public String getPopup() {
        return popup;
    }

    /**
     * @param popup The popup
     */
    public void setPopup(String popup) {
        this.popup = popup;
    }

    /**
     * @return The popUp
     */
    public String getPopUp() {
        return popUp;
    }

    /**
     * @param popUp The pop-up
     */
    public void setPopUp(String popUp) {
        this.popUp = popUp;
    }

    /**
     * @return The mobileUrl
     */
    public String getMobileUrl() {
        return mobileUrl;
    }

    /**
     * @param mobileUrl The mobile-url
     */
    public void setMobileUrl(String mobileUrl) {
        this.mobileUrl = mobileUrl;
    }

    /**
     * @return The columnWidth
     */
    public Integer getColumnWidth() {
        return columnWidth;
    }

    /**
     * @param columnWidth The column-width
     */
    public void setColumnWidth(Integer columnWidth) {
        this.columnWidth = columnWidth;
    }

    /**
     * @return The mediaCredit
     */
    public String getMediaCredit() {
        return mediaCredit;
    }

    /**
     * @param mediaCredit The media-credit
     */
    public void setMediaCredit(String mediaCredit) {
        this.mediaCredit = mediaCredit;
    }

}
