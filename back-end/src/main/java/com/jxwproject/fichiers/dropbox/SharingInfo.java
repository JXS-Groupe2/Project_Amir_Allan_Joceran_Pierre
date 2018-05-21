
package com.jxwproject.fichiers.dropbox;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SharingInfo {

    @SerializedName("read_only")
    @Expose
    private boolean readOnly;
    @SerializedName("parent_shared_folder_id")
    @Expose
    private String parentSharedFolderId;
    @SerializedName("modified_by")
    @Expose
    private String modifiedBy;

    /**
     * No args constructor for use in serialization
     * 
     */
    public SharingInfo() {
    }

    /**
     * 
     * @param parentSharedFolderId
     * @param readOnly
     * @param modifiedBy
     */
    public SharingInfo(boolean readOnly, String parentSharedFolderId, String modifiedBy) {
        super();
        this.readOnly = readOnly;
        this.parentSharedFolderId = parentSharedFolderId;
        this.modifiedBy = modifiedBy;
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    public String getParentSharedFolderId() {
        return parentSharedFolderId;
    }

    public void setParentSharedFolderId(String parentSharedFolderId) {
        this.parentSharedFolderId = parentSharedFolderId;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

}
