package com.mlb.qa.at_bat.model.news;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class ItemTagsLast {

    @Expose
    private List<String> list = new ArrayList<String>();
    @Expose
    private List<String> cmstax = new ArrayList<String>();
    @SerializedName("team_file_code")
    @Expose
    private List<String> teamFileCode = new ArrayList<String>();
    @Expose
    private List<String> index = new ArrayList<String>();
    @SerializedName("default_view")
    @Expose
    private List<String> defaultView = new ArrayList<String>();
    @SerializedName("default_search")
    @Expose
    private List<String> defaultSearch = new ArrayList<String>();
    @SerializedName("archive-list")
    @Expose
    private List<String> archiveList = new ArrayList<String>();
    @SerializedName("override-photo-template")
    @Expose
    private List<String> overridePhotoTemplate = new ArrayList<String>();
    @Expose
    private List<String> language = new ArrayList<String>();

    /**
     * @return The list
     */
    public List<String> getList() {
        return list;
    }

    /**
     * @param list The list
     */
    public void setList(List<String> list) {
        this.list = list;
    }

    /**
     * @return The cmstax
     */
    public List<String> getCmstax() {
        return cmstax;
    }

    /**
     * @param cmstax The cmstax
     */
    public void setCmstax(List<String> cmstax) {
        this.cmstax = cmstax;
    }

    /**
     * @return The teamFileCode
     */
    public List<String> getTeamFileCode() {
        return teamFileCode;
    }

    /**
     * @param teamFileCode The team_file_code
     */
    public void setTeamFileCode(List<String> teamFileCode) {
        this.teamFileCode = teamFileCode;
    }

    /**
     * @return The index
     */
    public List<String> getIndex() {
        return index;
    }

    /**
     * @param index The index
     */
    public void setIndex(List<String> index) {
        this.index = index;
    }

    /**
     * @return The defaultView
     */
    public List<String> getDefaultView() {
        return defaultView;
    }

    /**
     * @param defaultView The default_view
     */
    public void setDefaultView(List<String> defaultView) {
        this.defaultView = defaultView;
    }

    /**
     * @return The defaultSearch
     */
    public List<String> getDefaultSearch() {
        return defaultSearch;
    }

    /**
     * @param defaultSearch The default_search
     */
    public void setDefaultSearch(List<String> defaultSearch) {
        this.defaultSearch = defaultSearch;
    }

    /**
     * @return The archiveList
     */
    public List<String> getArchiveList() {
        return archiveList;
    }

    /**
     * @param archiveList The archive-list
     */
    public void setArchiveList(List<String> archiveList) {
        this.archiveList = archiveList;
    }

    /**
     * @return The overridePhotoTemplate
     */
    public List<String> getOverridePhotoTemplate() {
        return overridePhotoTemplate;
    }

    /**
     * @param overridePhotoTemplate The override-photo-template
     */
    public void setOverridePhotoTemplate(List<String> overridePhotoTemplate) {
        this.overridePhotoTemplate = overridePhotoTemplate;
    }

    /**
     * @return The language
     */
    public List<String> getLanguage() {
        return language;
    }

    /**
     * @param language The language
     */
    public void setLanguage(List<String> language) {
        this.language = language;
    }


}
