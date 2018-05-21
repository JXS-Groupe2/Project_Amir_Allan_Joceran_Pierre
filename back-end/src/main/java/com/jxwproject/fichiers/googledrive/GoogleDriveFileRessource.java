
package com.jxwproject.fichiers.googledrive;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GoogleDriveFileRessource {

    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("mimeType")
    @Expose
    private String mimeType;
    /*@SerializedName("description")
    @Expose
    private String description;
    @SerializedName("starred")
    @Expose
    private String starred;
    @SerializedName("trashed")
    @Expose
    private String trashed;
    @SerializedName("explicitlyTrashed")
    @Expose
    private String explicitlyTrashed;
    @SerializedName("trashingUser")
    @Expose
    private TrashingUser trashingUser;
    @SerializedName("trashedTime")
    @Expose
    private String trashedTime;
    @SerializedName("parents")
    @Expose
    private List<String> parents = null;
    @SerializedName("properties")
    @Expose
    private Properties properties;
    @SerializedName("appProperties")
    @Expose
    private AppProperties appProperties;
    @SerializedName("spaces")
    @Expose
    private List<String> spaces = null;
    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("webContentLink")
    @Expose
    private String webContentLink;
    @SerializedName("webViewLink")
    @Expose
    private String webViewLink;
    @SerializedName("iconLink")
    @Expose
    private String iconLink;
    @SerializedName("hasThumbnail")
    @Expose
    private String hasThumbnail;
    @SerializedName("thumbnailLink")
    @Expose
    private String thumbnailLink;
    @SerializedName("thumbnailVersion")
    @Expose
    private String thumbnailVersion;
    @SerializedName("viewedByMe")
    @Expose
    private String viewedByMe;
    @SerializedName("viewedByMeTime")
    @Expose
    private String viewedByMeTime;
    @SerializedName("createdTime")
    @Expose
    private String createdTime;
    @SerializedName("modifiedTime")
    @Expose
    private String modifiedTime;
    @SerializedName("modifiedByMeTime")
    @Expose
    private String modifiedByMeTime;
    @SerializedName("modifiedByMe")
    @Expose
    private String modifiedByMe;
    @SerializedName("sharedWithMeTime")
    @Expose
    private String sharedWithMeTime;
    @SerializedName("sharingUser")
    @Expose
    private SharingUser sharingUser;
    @SerializedName("owners")
    @Expose
    private List<Owner> owners = null;
    @SerializedName("teamDriveId")
    @Expose
    private String teamDriveId;
    @SerializedName("lastModifyingUser")
    @Expose
    private LastModifyingUser lastModifyingUser;
    @SerializedName("shared")
    @Expose
    private String shared;
    @SerializedName("ownedByMe")
    @Expose
    private String ownedByMe;
    @SerializedName("capabilities")
    @Expose
    private Capabilities capabilities;
    @SerializedName("viewersCanCopyContent")
    @Expose
    private String viewersCanCopyContent;
    @SerializedName("writersCanShare")
    @Expose
    private String writersCanShare;
    @SerializedName("permissions")
    @Expose
    private List<String> permissions = null;
    @SerializedName("permissionIds")
    @Expose
    private List<String> permissionIds = null;
    @SerializedName("hasAugmentedPermissions")
    @Expose
    private String hasAugmentedPermissions;
    @SerializedName("folderColorRgb")
    @Expose
    private String folderColorRgb;
    @SerializedName("originalFilename")
    @Expose
    private String originalFilename;
    @SerializedName("fullFileExtension")
    @Expose
    private String fullFileExtension;
    @SerializedName("fileExtension")
    @Expose
    private String fileExtension;
    @SerializedName("md5Checksum")
    @Expose
    private String md5Checksum;
    @SerializedName("size")
    @Expose
    private String size;
    @SerializedName("quotaBytesUsed")
    @Expose
    private String quotaBytesUsed;
    @SerializedName("headRevisionId")
    @Expose
    private String headRevisionId;
    @SerializedName("contentHints")
    @Expose
    private ContentHints contentHints;
    @SerializedName("imageMediaMetadata")
    @Expose
    private ImageMediaMetadata imageMediaMetadata;
    @SerializedName("videoMediaMetadata")
    @Expose
    private VideoMediaMetadata videoMediaMetadata;
    @SerializedName("isAppAuthorized")
    @Expose
    private String isAppAuthorized;
*/
    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

 /*   public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStarred() {
        return starred;
    }

    public void setStarred(String starred) {
        this.starred = starred;
    }

    public String getTrashed() {
        return trashed;
    }

    public void setTrashed(String trashed) {
        this.trashed = trashed;
    }

    public String getExplicitlyTrashed() {
        return explicitlyTrashed;
    }

    public void setExplicitlyTrashed(String explicitlyTrashed) {
        this.explicitlyTrashed = explicitlyTrashed;
    }

    public TrashingUser getTrashingUser() {
        return trashingUser;
    }

    public void setTrashingUser(TrashingUser trashingUser) {
        this.trashingUser = trashingUser;
    }

    public String getTrashedTime() {
        return trashedTime;
    }

    public void setTrashedTime(String trashedTime) {
        this.trashedTime = trashedTime;
    }

    public List<String> getParents() {
        return parents;
    }

    public void setParents(List<String> parents) {
        this.parents = parents;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public AppProperties getAppProperties() {
        return appProperties;
    }

    public void setAppProperties(AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    public List<String> getSpaces() {
        return spaces;
    }

    public void setSpaces(List<String> spaces) {
        this.spaces = spaces;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getWebContentLink() {
        return webContentLink;
    }

    public void setWebContentLink(String webContentLink) {
        this.webContentLink = webContentLink;
    }

    public String getWebViewLink() {
        return webViewLink;
    }

    public void setWebViewLink(String webViewLink) {
        this.webViewLink = webViewLink;
    }

    public String getIconLink() {
        return iconLink;
    }

    public void setIconLink(String iconLink) {
        this.iconLink = iconLink;
    }

    public String getHasThumbnail() {
        return hasThumbnail;
    }

    public void setHasThumbnail(String hasThumbnail) {
        this.hasThumbnail = hasThumbnail;
    }

    public String getThumbnailLink() {
        return thumbnailLink;
    }

    public void setThumbnailLink(String thumbnailLink) {
        this.thumbnailLink = thumbnailLink;
    }

    public String getThumbnailVersion() {
        return thumbnailVersion;
    }

    public void setThumbnailVersion(String thumbnailVersion) {
        this.thumbnailVersion = thumbnailVersion;
    }

    public String getViewedByMe() {
        return viewedByMe;
    }

    public void setViewedByMe(String viewedByMe) {
        this.viewedByMe = viewedByMe;
    }

    public String getViewedByMeTime() {
        return viewedByMeTime;
    }

    public void setViewedByMeTime(String viewedByMeTime) {
        this.viewedByMeTime = viewedByMeTime;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getModifiedByMeTime() {
        return modifiedByMeTime;
    }

    public void setModifiedByMeTime(String modifiedByMeTime) {
        this.modifiedByMeTime = modifiedByMeTime;
    }

    public String getModifiedByMe() {
        return modifiedByMe;
    }

    public void setModifiedByMe(String modifiedByMe) {
        this.modifiedByMe = modifiedByMe;
    }

    public String getSharedWithMeTime() {
        return sharedWithMeTime;
    }

    public void setSharedWithMeTime(String sharedWithMeTime) {
        this.sharedWithMeTime = sharedWithMeTime;
    }

    public SharingUser getSharingUser() {
        return sharingUser;
    }

    public void setSharingUser(SharingUser sharingUser) {
        this.sharingUser = sharingUser;
    }

    public List<Owner> getOwners() {
        return owners;
    }

    public void setOwners(List<Owner> owners) {
        this.owners = owners;
    }

    public String getTeamDriveId() {
        return teamDriveId;
    }

    public void setTeamDriveId(String teamDriveId) {
        this.teamDriveId = teamDriveId;
    }

    public LastModifyingUser getLastModifyingUser() {
        return lastModifyingUser;
    }

    public void setLastModifyingUser(LastModifyingUser lastModifyingUser) {
        this.lastModifyingUser = lastModifyingUser;
    }

    public String getShared() {
        return shared;
    }

    public void setShared(String shared) {
        this.shared = shared;
    }

    public String getOwnedByMe() {
        return ownedByMe;
    }

    public void setOwnedByMe(String ownedByMe) {
        this.ownedByMe = ownedByMe;
    }

    public Capabilities getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(Capabilities capabilities) {
        this.capabilities = capabilities;
    }

    public String getViewersCanCopyContent() {
        return viewersCanCopyContent;
    }

    public void setViewersCanCopyContent(String viewersCanCopyContent) {
        this.viewersCanCopyContent = viewersCanCopyContent;
    }

    public String getWritersCanShare() {
        return writersCanShare;
    }

    public void setWritersCanShare(String writersCanShare) {
        this.writersCanShare = writersCanShare;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    public List<String> getPermissionIds() {
        return permissionIds;
    }

    public void setPermissionIds(List<String> permissionIds) {
        this.permissionIds = permissionIds;
    }

    public String getHasAugmentedPermissions() {
        return hasAugmentedPermissions;
    }

    public void setHasAugmentedPermissions(String hasAugmentedPermissions) {
        this.hasAugmentedPermissions = hasAugmentedPermissions;
    }

    public String getFolderColorRgb() {
        return folderColorRgb;
    }

    public void setFolderColorRgb(String folderColorRgb) {
        this.folderColorRgb = folderColorRgb;
    }

    public String getOriginalFilename() {
        return originalFilename;
    }

    public void setOriginalFilename(String originalFilename) {
        this.originalFilename = originalFilename;
    }

    public String getFullFileExtension() {
        return fullFileExtension;
    }

    public void setFullFileExtension(String fullFileExtension) {
        this.fullFileExtension = fullFileExtension;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public String getMd5Checksum() {
        return md5Checksum;
    }

    public void setMd5Checksum(String md5Checksum) {
        this.md5Checksum = md5Checksum;
    }

    public long getSize() {
        return Long.parseLong(size);
    }
    
    public String getStringSize() {
        return size;
    }


    public void setSize(String size) {
        this.size = size;
    }

    public String getQuotaBytesUsed() {
        return quotaBytesUsed;
    }

    public void setQuotaBytesUsed(String quotaBytesUsed) {
        this.quotaBytesUsed = quotaBytesUsed;
    }

    public String getHeadRevisionId() {
        return headRevisionId;
    }

    public void setHeadRevisionId(String headRevisionId) {
        this.headRevisionId = headRevisionId;
    }

    public ContentHints getContentHints() {
        return contentHints;
    }

    public void setContentHints(ContentHints contentHints) {
        this.contentHints = contentHints;
    }

    public ImageMediaMetadata getImageMediaMetadata() {
        return imageMediaMetadata;
    }

    public void setImageMediaMetadata(ImageMediaMetadata imageMediaMetadata) {
        this.imageMediaMetadata = imageMediaMetadata;
    }

    public VideoMediaMetadata getVideoMediaMetadata() {
        return videoMediaMetadata;
    }

    public void setVideoMediaMetadata(VideoMediaMetadata videoMediaMetadata) {
        this.videoMediaMetadata = videoMediaMetadata;
    }

    public String getIsAppAuthorized() {
        return isAppAuthorized;
    }

    public void setIsAppAuthorized(String isAppAuthorized) {
        this.isAppAuthorized = isAppAuthorized;
    }
*/
}
