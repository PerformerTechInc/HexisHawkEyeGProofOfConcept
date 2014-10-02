package com.mlb.qa.at_bat.model.news;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class NewsReaderJson {

    @Expose
    private String type;
    @Expose
    private Integer contentId;
    @Expose
    private String userDate;
    @Expose
    private Integer numitems;
    @Expose
    private String url;
    @SerializedName("shared-url")
    @Expose
    private String sharedUrl;
    @SerializedName("seo-headline")
    @Expose
    private String seoHeadline;
    @Expose
    private java.util.List<List> list = new ArrayList<List>();
    @Expose
    private ItemTagsLast itemTags;

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
     * @return The numitems
     */
    public Integer getNumitems() {
        return numitems;
    }

    /**
     * @param numitems The numitems
     */
    public void setNumitems(Integer numitems) {
        this.numitems = numitems;
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
     * @return The list
     */
    public java.util.List<List> getList() {
        return list;
    }

    /**
     * @param list The list
     */
    public void setList(java.util.List<List> list) {
        this.list = list;
    }

    /**
     * @return The itemTags
     */
    public ItemTagsLast getItemTags() {
        return itemTags;
    }

    /**
     * @param itemTags The itemTags
     */
    public void setItemTags(ItemTagsLast itemTags) {
        this.itemTags = itemTags;
    }


}
