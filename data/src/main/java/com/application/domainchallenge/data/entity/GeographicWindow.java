
package com.application.domainchallenge.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class GeographicWindow implements Serializable
{

    @SerializedName("MaximumLatLng")
    @Expose
    private MaximumLatLng maximumLatLng;
    @SerializedName("MinimumLatLng")
    @Expose
    private MinimumLatLng minimumLatLng;
    private final static long serialVersionUID = 5405686076508886780L;

    public MaximumLatLng getMaximumLatLng() {
        return maximumLatLng;
    }

    public void setMaximumLatLng(MaximumLatLng maximumLatLng) {
        this.maximumLatLng = maximumLatLng;
    }

    public MinimumLatLng getMinimumLatLng() {
        return minimumLatLng;
    }

    public void setMinimumLatLng(MinimumLatLng minimumLatLng) {
        this.minimumLatLng = minimumLatLng;
    }

}
