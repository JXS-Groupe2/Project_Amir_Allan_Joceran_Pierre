
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
