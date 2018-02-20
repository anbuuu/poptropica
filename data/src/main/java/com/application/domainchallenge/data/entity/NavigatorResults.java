
package com.application.domainchallenge.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class NavigatorResults implements Serializable
{

    @SerializedName("Navigators")
    @Expose
    private List<Navigator> navigators = null;
    private final static long serialVersionUID = 1877441077386653405L;

    public List<Navigator> getNavigators() {
        return navigators;
    }

    public void setNavigators(List<Navigator> navigators) {
        this.navigators = navigators;
    }



}
