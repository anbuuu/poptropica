
package com.application.domainchallenge.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class PoiMarkerResults implements Serializable
{

    @SerializedName("PoiMarkers")
    @Expose
    private List<Object> poiMarkers = null;
    @SerializedName("ResultsReturned")
    @Expose
    private Integer resultsReturned;
    @SerializedName("ResultsTotal")
    @Expose
    private Integer resultsTotal;
    private final static long serialVersionUID = -4980502685970578931L;

    public List<Object> getPoiMarkers() {
        return poiMarkers;
    }

    public void setPoiMarkers(List<Object> poiMarkers) {
        this.poiMarkers = poiMarkers;
    }

    public Integer getResultsReturned() {
        return resultsReturned;
    }

    public void setResultsReturned(Integer resultsReturned) {
        this.resultsReturned = resultsReturned;
    }

    public Integer getResultsTotal() {
        return resultsTotal;
    }

    public void setResultsTotal(Integer resultsTotal) {
        this.resultsTotal = resultsTotal;
    }


}
