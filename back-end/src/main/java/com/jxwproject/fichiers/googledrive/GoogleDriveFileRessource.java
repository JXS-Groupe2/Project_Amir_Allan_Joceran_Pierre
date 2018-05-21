
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
    @SerializedName("etag")
    @Expose
    private String etag;
    @SerializedName("selfLink")
    @Expose
    private String selfLink;
    @SerializedName("webContentLink")
    @Expose
    private String webContentLink;
    @SerializedName("webViewLink")
    @Expose
    private String webViewLink;
    @SerializedName("alternateLink")
    @Expose
    private String alternateLink;
    @SerializedName("embedLink")
    @Expose
    private String embedLink;
    @SerializedName("openWithLinks")
    @Expose
    private OpenWithLinks openWithLinks;
    @SerializedName("defaultOpenWithLink")
    @Expose
    private String defaultOpenWithLink;
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
    @SerializedName("thumbnail")
    @Expose
    private Thumbnail thumbnail;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("mimeType")
    @Expose
    private String mimeType;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("labels")
    @Expose
    private Labels labels;
    @SerializedName("createdDate")
    @Expose
    private String createdDate;
    @SerializedName("modifiedDate")
    @Expose
    private String modifiedDate;
    @SerializedName("modifiedByMeDate")
    @Expose
    private String modifiedByMeDate;
    @SerializedName("lastViewedByMeDate")
    @Expose
    private String lastViewedByMeDate;
    @SerializedName("markedViewedByMeDate")
    @Expose
    private String markedViewedByMeDate;
    @SerializedName("sharedWithMeDate")
    @Expose
    private String sharedWithMeDate;
    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("sharingUser")
    @Expose
    private SharingUser sharingUser;
    @SerializedName("parents")
    @Expose
    private List<String> parents = null;
    @SerializedName("downloadUrl")
    @Expose
    private String downloadUrl;
    @SerializedName("exportLinks")
    @Expose
    private ExportLinks exportLinks;
    @SerializedName("indexableText")
    @Expose
    private IndexableText indexableText;
    @SerializedName("userPermission")
    @Expose
    private String userPermission;
    @SerializedName("permissions")
    @Expose
    private List<String> permissions = null;
    @SerializedName("permissionIds")
    @Expose
    private List<String> permissionIds = null;
    @SerializedName("hasAugmentedPermissions")
    @Expose
    private String hasAugmentedPermissions;
    @SerializedName("originalFilename")
    @Expose
    private String originalFilename;
    @SerializedName("fileExtension")
    @Expose
    private String fileExtension;
    @SerializedName("fullFileExtension")
    @Expose
    private String fullFileExtension;
    @SerializedName("md5Checksum")
    @Expose
    private String md5Checksum;
    @SerializedName("fileSize")
    @Expose
    private String fileSize;
    @SerializedName("quotaBytesUsed")
    @Expose
    private String quotaBytesUsed;
    @SerializedName("ownerNames")
    @Expose
    private List<String> ownerNames = null;
    @SerializedName("owners")
    @Expose
    private List<Owner> owners = null;
    @SerializedName("teamDriveId")
    @Expose
    private String teamDriveId;
    @SerializedName("lastModifyingUserName")
    @Expose
    private String lastModifyingUserName;
    @SerializedName("lastModifyingUser")
    @Expose
    private LastModifyingUser lastModifyingUser;
    @SerializedName("ownedByMe")
    @Expose
    private String ownedByMe;
    @SerializedName("capabilities")
    @Expose
    private Capabilities capabilities;
    @SerializedName("editable")
    @Expose
    private String editable;
    @SerializedName("canComment")
    @Expose
    private String canComment;
    @SerializedName("canReadRevisions")
    @Expose
    private String canReadRevisions;
    @SerializedName("shareable")
    @Expose
    private String shareable;
    @SerializedName("copyable")
    @Expose
    private String copyable;
    @SerializedName("writersCanShare")
    @Expose
    private String writersCanShare;
    @SerializedName("shared")
    @Expose
    private String shared;
    @SerializedName("explicitlyTrashed")
    @Expose
    private String explicitlyTrashed;
    @SerializedName("trashingUser")
    @Expose
    private TrashingUser trashingUser;
    @SerializedName("trashedDate")
    @Expose
    private String trashedDate;
    @SerializedName("appDataContents")
    @Expose
    private String appDataContents;
    @SerializedName("headRevisionId")
    @Expose
    private String headRevisionId;
    @SerializedName("properties")
    @Expose
    private List<String> properties = null;
    @SerializedName("folderColorRgb")
    @Expose
    private String folderColorRgb;
    @SerializedName("imageMediaMetadata")
    @Expose
    private ImageMediaMetadata imageMediaMetadata;
    @SerializedName("videoMediaMetadata")
    @Expose
    private VideoMediaMetadata videoMediaMetadata;
    @SerializedName("spaces")
    @Expose
    private List<String> spaces = null;
    @SerializedName("isAppAuthorized")
    @Expose
    private String isAppAuthorized;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GoogleDriveFileRessource() {
    }

    /**
     * 
     * @param md5Checksum
     * @param etag
     * @param canComment
     * @param userPermission
     * @param ownedByMe
     * @param downloadUrl
     * @param webContentLink
     * @param exportLinks
     * @param lastModifyingUser
     * @param lastModifyingUserName
     * @param alternateLink
     * @param fullFileExtension
     * @param imageMediaMetadata
     * @param webViewLink
     * @param sharedWithMeDate
     * @param description
     * @param permissions
     * @param trashedDate
     * @param originalFilename
     * @param createdDate
     * @param mimeType
     * @param shared
     * @param fileExtension
     * @param spaces
     * @param iconLink
     * @param hasThumbnail
     * @param modifiedByMeDate
     * @param labels
     * @param isAppAuthorized
     * @param quotaBytesUsed
     * @param properties
     * @param selfLink
     * @param hasAugmentedPermissions
     * @param ownerNames
     * @param canReadRevisions
     * @param editable
     * @param openWithLinks
     * @param copyable
     * @param thumbnail
     * @param thumbnailLink
     * @param trashingUser
     * @param owners
     * @param videoMediaMetadata
     * @param parents
     * @param embedLink
     * @param lastViewedByMeDate
     * @param folderColorRgb
     * @param kind
     * @param version
     * @param id
     * @param fileSize
     * @param title
     * @param thumbnailVersion
     * @param sharingUser
     * @param teamDriveId
     * @param appDataContents
     * @param shareable
     * @param writersCanShare
     * @param markedViewedByMeDate
     * @param modifiedDate
     * @param indexableText
     * @param defaultOpenWithLink
     * @param permissionIds
     * @param explicitlyTrashed
     * @param capabilities
     * @param headRevisionId
     */
    public GoogleDriveFileRessource(String kind, String id, String etag, String selfLink, String webContentLink, String webViewLink, String alternateLink, String embedLink, OpenWithLinks openWithLinks, String defaultOpenWithLink, String iconLink, String hasThumbnail, String thumbnailLink, String thumbnailVersion, Thumbnail thumbnail, String title, String mimeType, String description, Labels labels, String createdDate, String modifiedDate, String modifiedByMeDate, String lastViewedByMeDate, String markedViewedByMeDate, String sharedWithMeDate, String version, SharingUser sharingUser, List<String> parents, String downloadUrl, ExportLinks exportLinks, IndexableText indexableText, String userPermission, List<String> permissions, List<String> permissionIds, String hasAugmentedPermissions, String originalFilename, String fileExtension, String fullFileExtension, String md5Checksum, String fileSize, String quotaBytesUsed, List<String> ownerNames, List<Owner> owners, String teamDriveId, String lastModifyingUserName, LastModifyingUser lastModifyingUser, String ownedByMe, Capabilities capabilities, String editable, String canComment, String canReadRevisions, String shareable, String copyable, String writersCanShare, String shared, String explicitlyTrashed, TrashingUser trashingUser, String trashedDate, String appDataContents, String headRevisionId, List<String> properties, String folderColorRgb, ImageMediaMetadata imageMediaMetadata, VideoMediaMetadata videoMediaMetadata, List<String> spaces, String isAppAuthorized) {
        super();
        this.kind = kind;
        this.id = id;
        this.etag = etag;
        this.selfLink = selfLink;
        this.webContentLink = webContentLink;
        this.webViewLink = webViewLink;
        this.alternateLink = alternateLink;
        this.embedLink = embedLink;
        this.openWithLinks = openWithLinks;
        this.defaultOpenWithLink = defaultOpenWithLink;
        this.iconLink = iconLink;
        this.hasThumbnail = hasThumbnail;
        this.thumbnailLink = thumbnailLink;
        this.thumbnailVersion = thumbnailVersion;
        this.thumbnail = thumbnail;
        this.title = title;
        this.mimeType = mimeType;
        this.description = description;
        this.labels = labels;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.modifiedByMeDate = modifiedByMeDate;
        this.lastViewedByMeDate = lastViewedByMeDate;
        this.markedViewedByMeDate = markedViewedByMeDate;
        this.sharedWithMeDate = sharedWithMeDate;
        this.version = version;
        this.sharingUser = sharingUser;
        this.parents = parents;
        this.downloadUrl = downloadUrl;
        this.exportLinks = exportLinks;
        this.indexableText = indexableText;
        this.userPermission = userPermission;
        this.permissions = permissions;
        this.permissionIds = permissionIds;
        this.hasAugmentedPermissions = hasAugmentedPermissions;
        this.originalFilename = originalFilename;
        this.fileExtension = fileExtension;
        this.fullFileExtension = fullFileExtension;
        this.md5Checksum = md5Checksum;
        this.fileSize = fileSize;
        this.quotaBytesUsed = quotaBytesUsed;
        this.ownerNames = ownerNames;
        this.owners = owners;
        this.teamDriveId = teamDriveId;
        this.lastModifyingUserName = lastModifyingUserName;
        this.lastModifyingUser = lastModifyingUser;
        this.ownedByMe = ownedByMe;
        this.capabilities = capabilities;
        this.editable = editable;
        this.canComment = canComment;
        this.canReadRevisions = canReadRevisions;
        this.shareable = shareable;
        this.copyable = copyable;
        this.writersCanShare = writersCanShare;
        this.shared = shared;
        this.explicitlyTrashed = explicitlyTrashed;
        this.trashingUser = trashingUser;
        this.trashedDate = trashedDate;
        this.appDataContents = appDataContents;
        this.headRevisionId = headRevisionId;
        this.properties = properties;
        this.folderColorRgb = folderColorRgb;
        this.imageMediaMetadata = imageMediaMetadata;
        this.videoMediaMetadata = videoMediaMetadata;
        this.spaces = spaces;
        this.isAppAuthorized = isAppAuthorized;
    }

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

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getSelfLink() {
        return selfLink;
    }

    public void setSelfLink(String selfLink) {
        this.selfLink = selfLink;
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

    public String getAlternateLink() {
        return alternateLink;
    }

    public void setAlternateLink(String alternateLink) {
        this.alternateLink = alternateLink;
    }

    public String getEmbedLink() {
        return embedLink;
    }

    public void setEmbedLink(String embedLink) {
        this.embedLink = embedLink;
    }

    public OpenWithLinks getOpenWithLinks() {
        return openWithLinks;
    }

    public void setOpenWithLinks(OpenWithLinks openWithLinks) {
        this.openWithLinks = openWithLinks;
    }

    public String getDefaultOpenWithLink() {
        return defaultOpenWithLink;
    }

    public void setDefaultOpenWithLink(String defaultOpenWithLink) {
        this.defaultOpenWithLink = defaultOpenWithLink;
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

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Labels getLabels() {
        return labels;
    }

    public void setLabels(Labels labels) {
        this.labels = labels;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getModifiedByMeDate() {
        return modifiedByMeDate;
    }

    public void setModifiedByMeDate(String modifiedByMeDate) {
        this.modifiedByMeDate = modifiedByMeDate;
    }

    public String getLastViewedByMeDate() {
        return lastViewedByMeDate;
    }

    public void setLastViewedByMeDate(String lastViewedByMeDate) {
        this.lastViewedByMeDate = lastViewedByMeDate;
    }

    public String getMarkedViewedByMeDate() {
        return markedViewedByMeDate;
    }

    public void setMarkedViewedByMeDate(String markedViewedByMeDate) {
        this.markedViewedByMeDate = markedViewedByMeDate;
    }

    public String getSharedWithMeDate() {
        return sharedWithMeDate;
    }

    public void setSharedWithMeDate(String sharedWithMeDate) {
        this.sharedWithMeDate = sharedWithMeDate;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public SharingUser getSharingUser() {
        return sharingUser;
    }

    public void setSharingUser(SharingUser sharingUser) {
        this.sharingUser = sharingUser;
    }

    public List<String> getParents() {
        return parents;
    }

    public void setParents(List<String> parents) {
        this.parents = parents;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public ExportLinks getExportLinks() {
        return exportLinks;
    }

    public void setExportLinks(ExportLinks exportLinks) {
        this.exportLinks = exportLinks;
    }

    public IndexableText getIndexableText() {
        return indexableText;
    }

    public void setIndexableText(IndexableText indexableText) {
        this.indexableText = indexableText;
    }

    public String getUserPermission() {
        return userPermission;
    }

    public void setUserPermission(String userPermission) {
        this.userPermission = userPermission;
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

    public String getOriginalFilename() {
        return originalFilename;
    }

    public void setOriginalFilename(String originalFilename) {
        this.originalFilename = originalFilename;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public String getFullFileExtension() {
        return fullFileExtension;
    }

    public void setFullFileExtension(String fullFileExtension) {
        this.fullFileExtension = fullFileExtension;
    }

    public String getMd5Checksum() {
        return md5Checksum;
    }

    public void setMd5Checksum(String md5Checksum) {
        this.md5Checksum = md5Checksum;
    }

    public long getFileSize() {
        return Long.parseLong(fileSize);
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getQuotaBytesUsed() {
        return quotaBytesUsed;
    }

    public void setQuotaBytesUsed(String quotaBytesUsed) {
        this.quotaBytesUsed = quotaBytesUsed;
    }

    public List<String> getOwnerNames() {
        return ownerNames;
    }

    public void setOwnerNames(List<String> ownerNames) {
        this.ownerNames = ownerNames;
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

    public String getLastModifyingUserName() {
        return lastModifyingUserName;
    }

    public void setLastModifyingUserName(String lastModifyingUserName) {
        this.lastModifyingUserName = lastModifyingUserName;
    }

    public LastModifyingUser getLastModifyingUser() {
        return lastModifyingUser;
    }

    public void setLastModifyingUser(LastModifyingUser lastModifyingUser) {
        this.lastModifyingUser = lastModifyingUser;
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

    public String getEditable() {
        return editable;
    }

    public void setEditable(String editable) {
        this.editable = editable;
    }

    public String getCanComment() {
        return canComment;
    }

    public void setCanComment(String canComment) {
        this.canComment = canComment;
    }

    public String getCanReadRevisions() {
        return canReadRevisions;
    }

    public void setCanReadRevisions(String canReadRevisions) {
        this.canReadRevisions = canReadRevisions;
    }

    public String getShareable() {
        return shareable;
    }

    public void setShareable(String shareable) {
        this.shareable = shareable;
    }

    public String getCopyable() {
        return copyable;
    }

    public void setCopyable(String copyable) {
        this.copyable = copyable;
    }

    public String getWritersCanShare() {
        return writersCanShare;
    }

    public void setWritersCanShare(String writersCanShare) {
        this.writersCanShare = writersCanShare;
    }

    public String getShared() {
        return shared;
    }

    public void setShared(String shared) {
        this.shared = shared;
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

    public String getTrashedDate() {
        return trashedDate;
    }

    public void setTrashedDate(String trashedDate) {
        this.trashedDate = trashedDate;
    }

    public String getAppDataContents() {
        return appDataContents;
    }

    public void setAppDataContents(String appDataContents) {
        this.appDataContents = appDataContents;
    }

    public String getHeadRevisionId() {
        return headRevisionId;
    }

    public void setHeadRevisionId(String headRevisionId) {
        this.headRevisionId = headRevisionId;
    }

    public List<String> getProperties() {
        return properties;
    }

    public void setProperties(List<String> properties) {
        this.properties = properties;
    }

    public String getFolderColorRgb() {
        return folderColorRgb;
    }

    public void setFolderColorRgb(String folderColorRgb) {
        this.folderColorRgb = folderColorRgb;
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

    public List<String> getSpaces() {
        return spaces;
    }

    public void setSpaces(List<String> spaces) {
        this.spaces = spaces;
    }

    public String getIsAppAuthorized() {
        return isAppAuthorized;
    }

    public void setIsAppAuthorized(String isAppAuthorized) {
        this.isAppAuthorized = isAppAuthorized;
    }

}
