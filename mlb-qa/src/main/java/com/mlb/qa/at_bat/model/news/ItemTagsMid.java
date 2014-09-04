package com.mlb.qa.at_bat.model.news;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ItemTagsMid {

    @SerializedName("archive-element")
    @Expose
    private List<String> archiveElement = new ArrayList<String>();
    @SerializedName("clob_autoTagSkip_playerCards")
    @Expose
    private List<String> clobAutoTagSkipPlayerCards = new ArrayList<String>();
    @SerializedName("game_pk")
    @Expose
    private List<String> gamePk = new ArrayList<String>();
    @SerializedName("player_id")
    @Expose
    private List<String> playerId = new ArrayList<String>();
    @Expose
    private List<String> content = new ArrayList<String>();
    @Expose
    private List<String> notebook = new ArrayList<String>();
    @SerializedName("team_id")
    @Expose
    private List<String> teamId = new ArrayList<String>();
    @SerializedName("notebook_date")
    @Expose
    private List<String> notebookDate = new ArrayList<String>();
    @SerializedName("team_file_code")
    @Expose
    private List<String> teamFileCode = new ArrayList<String>();
    @SerializedName("active_beatwriters")
    @Expose
    private List<String> activeBeatwriters = new ArrayList<String>();

    /**
     * @return The archiveElement
     */
    public List<String> getArchiveElement() {
        return archiveElement;
    }

    /**
     * @param archiveElement The archive-element
     */
    public void setArchiveElement(List<String> archiveElement) {
        this.archiveElement = archiveElement;
    }

    /**
     * @return The clobAutoTagSkipPlayerCards
     */
    public List<String> getClobAutoTagSkipPlayerCards() {
        return clobAutoTagSkipPlayerCards;
    }

    /**
     * @param clobAutoTagSkipPlayerCards The clob_autoTagSkip_playerCards
     */
    public void setClobAutoTagSkipPlayerCards(List<String> clobAutoTagSkipPlayerCards) {
        this.clobAutoTagSkipPlayerCards = clobAutoTagSkipPlayerCards;
    }

    /**
     * @return The gamePk
     */
    public List<String> getGamePk() {
        return gamePk;
    }

    /**
     * @param gamePk The game_pk
     */
    public void setGamePk(List<String> gamePk) {
        this.gamePk = gamePk;
    }

    /**
     * @return The playerId
     */
    public List<String> getPlayerId() {
        return playerId;
    }

    /**
     * @param playerId The player_id
     */
    public void setPlayerId(List<String> playerId) {
        this.playerId = playerId;
    }

    /**
     * @return The content
     */
    public List<String> getContent() {
        return content;
    }

    /**
     * @param content The content
     */
    public void setContent(List<String> content) {
        this.content = content;
    }

    /**
     * @return The notebook
     */
    public List<String> getNotebook() {
        return notebook;
    }

    /**
     * @param notebook The notebook
     */
    public void setNotebook(List<String> notebook) {
        this.notebook = notebook;
    }

    /**
     * @return The teamId
     */
    public List<String> getTeamId() {
        return teamId;
    }

    /**
     * @param teamId The team_id
     */
    public void setTeamId(List<String> teamId) {
        this.teamId = teamId;
    }

    /**
     * @return The notebookDate
     */
    public List<String> getNotebookDate() {
        return notebookDate;
    }

    /**
     * @param notebookDate The notebook_date
     */
    public void setNotebookDate(List<String> notebookDate) {
        this.notebookDate = notebookDate;
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
     * @return The activeBeatwriters
     */
    public List<String> getActiveBeatwriters() {
        return activeBeatwriters;
    }

    /**
     * @param activeBeatwriters The active_beatwriters
     */
    public void setActiveBeatwriters(List<String> activeBeatwriters) {
        this.activeBeatwriters = activeBeatwriters;
    }


}
