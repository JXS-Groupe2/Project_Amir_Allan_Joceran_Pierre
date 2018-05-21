
package com.jxwproject.fichiers.googledrive;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IndexableText {

    @SerializedName("text")
    @Expose
    private String text;

    /**
     * No args constructor for use in serialization
     * 
     */
    public IndexableText() {
    }

    /**
     * 
     * @param text
     */
    public IndexableText(String text) {
        super();
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
