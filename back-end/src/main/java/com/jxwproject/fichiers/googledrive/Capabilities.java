
package com.jxwproject.fichiers.googledrive;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Capabilities {

    @SerializedName("canAddChildren")
    @Expose
    private String canAddChildren;
    @SerializedName("canChangeRestrictedDownload")
    @Expose
    private String canChangeRestrictedDownload;
    @SerializedName("canComment")
    @Expose
    private String canComment;
    @SerializedName("canCopy")
    @Expose
    private String canCopy;
    @SerializedName("canDelete")
    @Expose
    private String canDelete;
    @SerializedName("canDownload")
    @Expose
    private String canDownload;
    @SerializedName("canEdit")
    @Expose
    private String canEdit;
    @SerializedName("canListChildren")
    @Expose
    private String canListChildren;
    @SerializedName("canMoveItemIntoTeamDrive")
    @Expose
    private String canMoveItemIntoTeamDrive;
    @SerializedName("canMoveTeamDriveItem")
    @Expose
    private String canMoveTeamDriveItem;
    @SerializedName("canReadRevisions")
    @Expose
    private String canReadRevisions;
    @SerializedName("canReadTeamDrive")
    @Expose
    private String canReadTeamDrive;
    @SerializedName("canRemoveChildren")
    @Expose
    private String canRemoveChildren;
    @SerializedName("canRename")
    @Expose
    private String canRename;
    @SerializedName("canShare")
    @Expose
    private String canShare;
    @SerializedName("canTrash")
    @Expose
    private String canTrash;
    @SerializedName("canUntrash")
    @Expose
    private String canUntrash;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Capabilities() {
    }

    /**
     * 
     * @param canRemoveChildren
     * @param canChangeRestrictedDownload
     * @param canComment
     * @param canRename
     * @param canDelete
     * @param canMoveItemIntoTeamDrive
     * @param canMoveTeamDriveItem
     * @param canUntrash
     * @param canEdit
     * @param canTrash
     * @param canReadRevisions
     * @param canAddChildren
     * @param canDownload
     * @param canReadTeamDrive
     * @param canShare
     * @param canCopy
     * @param canListChildren
     */
    public Capabilities(String canAddChildren, String canChangeRestrictedDownload, String canComment, String canCopy, String canDelete, String canDownload, String canEdit, String canListChildren, String canMoveItemIntoTeamDrive, String canMoveTeamDriveItem, String canReadRevisions, String canReadTeamDrive, String canRemoveChildren, String canRename, String canShare, String canTrash, String canUntrash) {
        super();
        this.canAddChildren = canAddChildren;
        this.canChangeRestrictedDownload = canChangeRestrictedDownload;
        this.canComment = canComment;
        this.canCopy = canCopy;
        this.canDelete = canDelete;
        this.canDownload = canDownload;
        this.canEdit = canEdit;
        this.canListChildren = canListChildren;
        this.canMoveItemIntoTeamDrive = canMoveItemIntoTeamDrive;
        this.canMoveTeamDriveItem = canMoveTeamDriveItem;
        this.canReadRevisions = canReadRevisions;
        this.canReadTeamDrive = canReadTeamDrive;
        this.canRemoveChildren = canRemoveChildren;
        this.canRename = canRename;
        this.canShare = canShare;
        this.canTrash = canTrash;
        this.canUntrash = canUntrash;
    }

    public String getCanAddChildren() {
        return canAddChildren;
    }

    public void setCanAddChildren(String canAddChildren) {
        this.canAddChildren = canAddChildren;
    }

    public String getCanChangeRestrictedDownload() {
        return canChangeRestrictedDownload;
    }

    public void setCanChangeRestrictedDownload(String canChangeRestrictedDownload) {
        this.canChangeRestrictedDownload = canChangeRestrictedDownload;
    }

    public String getCanComment() {
        return canComment;
    }

    public void setCanComment(String canComment) {
        this.canComment = canComment;
    }

    public String getCanCopy() {
        return canCopy;
    }

    public void setCanCopy(String canCopy) {
        this.canCopy = canCopy;
    }

    public String getCanDelete() {
        return canDelete;
    }

    public void setCanDelete(String canDelete) {
        this.canDelete = canDelete;
    }

    public String getCanDownload() {
        return canDownload;
    }

    public void setCanDownload(String canDownload) {
        this.canDownload = canDownload;
    }

    public String getCanEdit() {
        return canEdit;
    }

    public void setCanEdit(String canEdit) {
        this.canEdit = canEdit;
    }

    public String getCanListChildren() {
        return canListChildren;
    }

    public void setCanListChildren(String canListChildren) {
        this.canListChildren = canListChildren;
    }

    public String getCanMoveItemIntoTeamDrive() {
        return canMoveItemIntoTeamDrive;
    }

    public void setCanMoveItemIntoTeamDrive(String canMoveItemIntoTeamDrive) {
        this.canMoveItemIntoTeamDrive = canMoveItemIntoTeamDrive;
    }

    public String getCanMoveTeamDriveItem() {
        return canMoveTeamDriveItem;
    }

    public void setCanMoveTeamDriveItem(String canMoveTeamDriveItem) {
        this.canMoveTeamDriveItem = canMoveTeamDriveItem;
    }

    public String getCanReadRevisions() {
        return canReadRevisions;
    }

    public void setCanReadRevisions(String canReadRevisions) {
        this.canReadRevisions = canReadRevisions;
    }

    public String getCanReadTeamDrive() {
        return canReadTeamDrive;
    }

    public void setCanReadTeamDrive(String canReadTeamDrive) {
        this.canReadTeamDrive = canReadTeamDrive;
    }

    public String getCanRemoveChildren() {
        return canRemoveChildren;
    }

    public void setCanRemoveChildren(String canRemoveChildren) {
        this.canRemoveChildren = canRemoveChildren;
    }

    public String getCanRename() {
        return canRename;
    }

    public void setCanRename(String canRename) {
        this.canRename = canRename;
    }

    public String getCanShare() {
        return canShare;
    }

    public void setCanShare(String canShare) {
        this.canShare = canShare;
    }

    public String getCanTrash() {
        return canTrash;
    }

    public void setCanTrash(String canTrash) {
        this.canTrash = canTrash;
    }

    public String getCanUntrash() {
        return canUntrash;
    }

    public void setCanUntrash(String canUntrash) {
        this.canUntrash = canUntrash;
    }

}