
package com.jxwproject.fichiers.googledrive;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VideoMediaMetadata {

    @SerializedName("width")
    @Expose
    private String width;
    @SerializedName("height")
    @Expose
    private String height;
    @SerializedName("durationMillis")
    @Expose
    private String durationMillis;

    /**
     * No args constructor for use in serialization
     * 
     */
    public VideoMediaMetadata() {
    }

    /**
     * 
     * @param height
     * @param width
     * @param durationMillis
     */
    public VideoMediaMetadata(String width, String height, String durationMillis) {
        super();
        this.width = width;
        this.height = height;
        this.durationMillis = durationMillis;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getDurationMillis() {
        return durationMillis;
    }

    public void setDurationMillis(String durationMillis) {
        this.durationMillis = durationMillis;
    }

}
