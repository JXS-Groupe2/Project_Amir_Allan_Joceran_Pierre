
package com.jxwproject.fichiers.googledrive;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Labels {

    @SerializedName("starred")
    @Expose
    private String starred;
    @SerializedName("hidden")
    @Expose
    private String hidden;
    @SerializedName("trashed")
    @Expose
    private String trashed;
    @SerializedName("restricted")
    @Expose
    private String restricted;
    @SerializedName("viewed")
    @Expose
    private String viewed;
    @SerializedName("modified")
    @Expose
    private String modified;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Labels() {
    }

    /**
     * 
     * @param trashed
     * @param starred
     * @param hidden
     * @param restricted
     * @param viewed
     * @param modified
     */
    public Labels(String starred, String hidden, String trashed, String restricted, String viewed, String modified) {
        super();
        this.starred = starred;
        this.hidden = hidden;
        this.trashed = trashed;
        this.restricted = restricted;
        this.viewed = viewed;
        this.modified = modified;
    }

    public String getStarred() {
        return starred;
    }

    public void setStarred(String starred) {
        this.starred = starred;
    }

    public String getHidden() {
        return hidden;
    }

    public void setHidden(String hidden) {
        this.hidden = hidden;
    }

    public String getTrashed() {
        return trashed;
    }

    public void setTrashed(String trashed) {
        this.trashed = trashed;
    }

    public String getRestricted() {
        return restricted;
    }

    public void setRestricted(String restricted) {
        this.restricted = restricted;
    }

    public String getViewed() {
        return viewed;
    }

    public void setViewed(String viewed) {
        this.viewed = viewed;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

}
