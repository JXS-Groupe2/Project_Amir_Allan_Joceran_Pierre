
package com.jxwproject.fichiers.googledrive;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GoogleDriveFilesList {

    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("nextPageToken")
    @Expose
    private String nextPageToken;
    @SerializedName("incompleteSearch")
    @Expose
    private boolean incompleteSearch;
    @SerializedName("files")
    @Expose
    private GoogleDriveFileRessource[] files;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GoogleDriveFilesList() {
    	
    }

    /**
     * 
     * @param incompleteSearch
     * @param items
     * @param nextPageToken
     * @param kind
     */
    public GoogleDriveFilesList(String kind, String nextPageToken, boolean incompleteSearch, GoogleDriveFileRessource[] items) {
        super();
        this.kind = kind;
        this.nextPageToken = nextPageToken;
        this.incompleteSearch = incompleteSearch;
        this.files = items;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
    
    public String getNextPageToken() {
        return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

    public boolean getIncompleteSearch() {
        return incompleteSearch;
    }

    public void setIncompleteSearch(boolean incompleteSearch) {
        this.incompleteSearch = incompleteSearch;
    }

    public GoogleDriveFileRessource[] getFiles() {
        return files;
    }

    public void setItems(GoogleDriveFileRessource[] files) {
        this.files = files;
    }

}
