
package com.application.domainchallenge.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
public class Option implements Serializable
{

    @SerializedName("Count")
    @Expose
    private Integer count;
    @SerializedName("StringValue")
    @Expose
    private String stringValue;
    @SerializedName("Text")
    @Expose
    private String text;
    private final static long serialVersionUID = -3742351117989361340L;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}
