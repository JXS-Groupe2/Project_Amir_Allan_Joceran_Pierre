
package com.jxwproject.fichiers.googledrive;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContentHints {

    @SerializedName("thumbnail")
    @Expose
    private Thumbnail thumbnail;
    @SerializedName("indexableText")
    @Expose
    private String indexableText;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ContentHints() {
    }

    /**
     * 
     * @param indexableText
     * @param thumbnail
     */
    public ContentHints(Thumbnail thumbnail, String indexableText) {
        super();
        this.thumbnail = thumbnail;
        this.indexableText = indexableText;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getIndexableText() {
        return indexableText;
    }

    public void setIndexableText(String indexableText) {
        this.indexableText = indexableText;
    }

}
