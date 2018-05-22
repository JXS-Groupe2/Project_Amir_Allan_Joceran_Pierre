
package com.jxwproject.fichiers.dropbox;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DropboxFileRessource {

    @SerializedName(".tag")
    @Expose
    private String fileType;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("client_modified")
    @Expose
    private String clientModified;
    @SerializedName("server_modified")
    @Expose
    private String serverModified;
    @SerializedName("rev")
    @Expose
    private String rev;
    @SerializedName("size")
    @Expose
    private int size;
    @SerializedName("path_lower")
    @Expose
    private String pathLower;
    @SerializedName("path_display")
    @Expose
    private String pathDisplay;
    @SerializedName("sharing_info")
    @Expose
    private SharingInfo sharingInfo;
    @SerializedName("property_groups")
    @Expose
    private List<PropertyGroup> propertyGroups = null;
    @SerializedName("has_explicit_shared_members")
    @Expose
    private boolean hasExplicitSharedMembers;
    @SerializedName("content_hash")
    @Expose
    private String contentHash;

    /**
     * No args constructor for use in serialization
     * 
     */
    public DropboxFileRessource() {
    }

    /**
     * 
     * @param rev
     * @param propertyGroups
     * @param serverModified
     * @param tag
     * @param pathDisplay
     * @param pathLower
     * @param size
     * @param id
     * @param clientModified
     * @param sharingInfo
     * @param name
     * @param hasExplicitSharedMembers
     * @param contentHash
     */
    public DropboxFileRessource(String tag, String name, String id, String clientModified, String serverModified, String rev, int size, String pathLower, String pathDisplay, SharingInfo sharingInfo, List<PropertyGroup> propertyGroups, boolean hasExplicitSharedMembers, String contentHash) {
        super();
        this.fileType = tag;
        this.name = name;
        this.id = id;
        this.clientModified = clientModified;
        this.serverModified = serverModified;
        this.rev = rev;
        this.size = size;
        this.pathLower = pathLower;
        this.pathDisplay = pathDisplay;
        this.sharingInfo = sharingInfo;
        this.propertyGroups = propertyGroups;
        this.hasExplicitSharedMembers = hasExplicitSharedMembers;
        this.contentHash = contentHash;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClientModified() {
        return clientModified;
    }

    public void setClientModified(String clientModified) {
        this.clientModified = clientModified;
    }

    public String getServerModified() {
        return serverModified;
    }

    public void setServerModified(String serverModified) {
        this.serverModified = serverModified;
    }

    public String getRev() {
        return rev;
    }

    public void setRev(String rev) {
        this.rev = rev;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getPathLower() {
        return pathLower;
    }

    public void setPathLower(String pathLower) {
        this.pathLower = pathLower;
    }

    public String getPathDisplay() {
        return pathDisplay;
    }

    public void setPathDisplay(String pathDisplay) {
        this.pathDisplay = pathDisplay;
    }

    public SharingInfo getSharingInfo() {
        return sharingInfo;
    }

    public void setSharingInfo(SharingInfo sharingInfo) {
        this.sharingInfo = sharingInfo;
    }

    public List<PropertyGroup> getPropertyGroups() {
        return propertyGroups;
    }

    public void setPropertyGroups(List<PropertyGroup> propertyGroups) {
        this.propertyGroups = propertyGroups;
    }

    public boolean isHasExplicitSharedMembers() {
        return hasExplicitSharedMembers;
    }

    public void setHasExplicitSharedMembers(boolean hasExplicitSharedMembers) {
        this.hasExplicitSharedMembers = hasExplicitSharedMembers;
    }

    public String getContentHash() {
        return contentHash;
    }

    public void setContentHash(String contentHash) {
        this.contentHash = contentHash;
    }

}
