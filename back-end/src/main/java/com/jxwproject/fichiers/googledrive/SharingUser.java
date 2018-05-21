
package com.jxwproject.fichiers.googledrive;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SharingUser {

    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("displayName")
    @Expose
    private String displayName;
    @SerializedName("photoLink")
    @Expose
    private String photoLink;
    @SerializedName("me")
    @Expose
    private String me;
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
    public SharingUser() {
    }

    /**
     * 
     * @param photoLink
     * @param emailAddress
     * @param me
     * @param permissionId
     * @param displayName
     * @param kind
     */
    public SharingUser(String kind, String displayName, String photoLink, String me, String permissionId, String emailAddress) {
        super();
        this.kind = kind;
        this.displayName = displayName;
        this.photoLink = photoLink;
        this.me = me;
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

    public String getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }

    public String getMe() {
        return me;
    }

    public void setMe(String me) {
        this.me = me;
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
