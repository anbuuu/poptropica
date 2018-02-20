
package com.application.domainchallenge.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Navigator implements Serializable
{

    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("NavigatorField")
    @Expose
    private Integer navigatorField;
    @SerializedName("Options")
    @Expose
    private List<Option> options = null;
    private final static long serialVersionUID = -6147391717406765401L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNavigatorField() {
        return navigatorField;
    }

    public void setNavigatorField(Integer navigatorField) {
        this.navigatorField = navigatorField;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }



}
