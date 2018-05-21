
package com.jxwproject.fichiers.googledrive;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImageMediaMetadata {

    @SerializedName("width")
    @Expose
    private String width;
    @SerializedName("height")
    @Expose
    private String height;
    @SerializedName("rotation")
    @Expose
    private String rotation;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("cameraMake")
    @Expose
    private String cameraMake;
    @SerializedName("cameraModel")
    @Expose
    private String cameraModel;
    @SerializedName("exposureTime")
    @Expose
    private String exposureTime;
    @SerializedName("aperture")
    @Expose
    private String aperture;
    @SerializedName("flashUsed")
    @Expose
    private String flashUsed;
    @SerializedName("focalLength")
    @Expose
    private String focalLength;
    @SerializedName("isoSpeed")
    @Expose
    private String isoSpeed;
    @SerializedName("meteringMode")
    @Expose
    private String meteringMode;
    @SerializedName("sensor")
    @Expose
    private String sensor;
    @SerializedName("exposureMode")
    @Expose
    private String exposureMode;
    @SerializedName("colorSpace")
    @Expose
    private String colorSpace;
    @SerializedName("whiteBalance")
    @Expose
    private String whiteBalance;
    @SerializedName("exposureBias")
    @Expose
    private String exposureBias;
    @SerializedName("maxApertureValue")
    @Expose
    private String maxApertureValue;
    @SerializedName("subjectDistance")
    @Expose
    private String subjectDistance;
    @SerializedName("lens")
    @Expose
    private String lens;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ImageMediaMetadata() {
    }

    /**
     * 
     * @param maxApertureValue
     * @param exposureTime
     * @param location
     * @param width
     * @param isoSpeed
     * @param whiteBalance
     * @param cameraMake
     * @param exposureBias
     * @param flashUsed
     * @param lens
     * @param aperture
     * @param focalLength
     * @param sensor
     * @param time
     * @param exposureMode
     * @param height
     * @param rotation
     * @param colorSpace
     * @param subjectDistance
     * @param meteringMode
     * @param cameraModel
     */
    public ImageMediaMetadata(String width, String height, String rotation, Location location, String time, String cameraMake, String cameraModel, String exposureTime, String aperture, String flashUsed, String focalLength, String isoSpeed, String meteringMode, String sensor, String exposureMode, String colorSpace, String whiteBalance, String exposureBias, String maxApertureValue, String subjectDistance, String lens) {
        super();
        this.width = width;
        this.height = height;
        this.rotation = rotation;
        this.location = location;
        this.time = time;
        this.cameraMake = cameraMake;
        this.cameraModel = cameraModel;
        this.exposureTime = exposureTime;
        this.aperture = aperture;
        this.flashUsed = flashUsed;
        this.focalLength = focalLength;
        this.isoSpeed = isoSpeed;
        this.meteringMode = meteringMode;
        this.sensor = sensor;
        this.exposureMode = exposureMode;
        this.colorSpace = colorSpace;
        this.whiteBalance = whiteBalance;
        this.exposureBias = exposureBias;
        this.maxApertureValue = maxApertureValue;
        this.subjectDistance = subjectDistance;
        this.lens = lens;
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

    public String getRotation() {
        return rotation;
    }

    public void setRotation(String rotation) {
        this.rotation = rotation;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCameraMake() {
        return cameraMake;
    }

    public void setCameraMake(String cameraMake) {
        this.cameraMake = cameraMake;
    }

    public String getCameraModel() {
        return cameraModel;
    }

    public void setCameraModel(String cameraModel) {
        this.cameraModel = cameraModel;
    }

    public String getExposureTime() {
        return exposureTime;
    }

    public void setExposureTime(String exposureTime) {
        this.exposureTime = exposureTime;
    }

    public String getAperture() {
        return aperture;
    }

    public void setAperture(String aperture) {
        this.aperture = aperture;
    }

    public String getFlashUsed() {
        return flashUsed;
    }

    public void setFlashUsed(String flashUsed) {
        this.flashUsed = flashUsed;
    }

    public String getFocalLength() {
        return focalLength;
    }

    public void setFocalLength(String focalLength) {
        this.focalLength = focalLength;
    }

    public String getIsoSpeed() {
        return isoSpeed;
    }

    public void setIsoSpeed(String isoSpeed) {
        this.isoSpeed = isoSpeed;
    }

    public String getMeteringMode() {
        return meteringMode;
    }

    public void setMeteringMode(String meteringMode) {
        this.meteringMode = meteringMode;
    }

    public String getSensor() {
        return sensor;
    }

    public void setSensor(String sensor) {
        this.sensor = sensor;
    }

    public String getExposureMode() {
        return exposureMode;
    }

    public void setExposureMode(String exposureMode) {
        this.exposureMode = exposureMode;
    }

    public String getColorSpace() {
        return colorSpace;
    }

    public void setColorSpace(String colorSpace) {
        this.colorSpace = colorSpace;
    }

    public String getWhiteBalance() {
        return whiteBalance;
    }

    public void setWhiteBalance(String whiteBalance) {
        this.whiteBalance = whiteBalance;
    }

    public String getExposureBias() {
        return exposureBias;
    }

    public void setExposureBias(String exposureBias) {
        this.exposureBias = exposureBias;
    }

    public String getMaxApertureValue() {
        return maxApertureValue;
    }

    public void setMaxApertureValue(String maxApertureValue) {
        this.maxApertureValue = maxApertureValue;
    }

    public String getSubjectDistance() {
        return subjectDistance;
    }

    public void setSubjectDistance(String subjectDistance) {
        this.subjectDistance = subjectDistance;
    }

    public String getLens() {
        return lens;
    }

    public void setLens(String lens) {
        this.lens = lens;
    }

}
