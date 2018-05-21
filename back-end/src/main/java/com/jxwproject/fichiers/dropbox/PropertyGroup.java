
package com.jxwproject.fichiers.dropbox;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PropertyGroup {

    @SerializedName("template_id")
    @Expose
    private String templateId;
    @SerializedName("fields")
    @Expose
    private List<Field> fields = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public PropertyGroup() {
    }

    /**
     * 
     * @param templateId
     * @param fields
     */
    public PropertyGroup(String templateId, List<Field> fields) {
        super();
        this.templateId = templateId;
        this.fields = fields;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

}
