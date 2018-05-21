
package com.jxwproject.fichiers.googledrive;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LastModifyingUser {

    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("displayName")
    @Expose
    private String displayName;
    @SerializedName("picture")
    @Expose
    private Picture__ picture;
    @SerializedName("isAuthenticatedUser")
    @Expose
    private String isAuthenticatedUser;
    @SerializedName("permissionId")
    @Expose
    private String permissionId;
    @SerializedName("emailAddress")
    @Expose
    private String emailAddress;

    /**
     * No args constructor for use in serialization
     * 
     */
    public LastModifyingUser() {
    }

    /**
     * 
     * @param picture
     * @param isAuthenticatedUser
     * @param emailAddress
     * @param permissionId
     * @param displayName
     * @param kind
     */
    public LastModifyingUser(String kind, String displayName, Picture__ picture, String isAuthenticatedUser, String permissionId, String emailAddress) {
        super();
        this.kind = kind;
        this.displayName = displayName;
        this.picture = picture;
        this.isAuthenticatedUser = isAuthenticatedUser;
        this.permissionId = permissionId;
        this.emailAddress = emailAddress;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Picture__ getPicture() {
        return picture;
    }

    public void setPicture(Picture__ picture) {
        this.picture = picture;
    }

    public String getIsAuthenticatedUser() {
        return isAuthenticatedUser;
    }

    public void setIsAuthenticatedUser(String isAuthenticatedUser) {
        this.isAuthenticatedUser = isAuthenticatedUser;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

}
