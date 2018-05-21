
package com.jxwproject.fichiers.googledrive;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExportLinks {

    @SerializedName("(key)")
    @Expose
    private String key;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ExportLinks() {
    }

    /**
     * 
     * @param key
     */
    public ExportLinks(String key) {
        super();
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

}
