
package com.application.domainchallenge.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ListingResults implements Serializable
{

    @SerializedName("Listings")
    @Expose
    private List<Listing> listings = null;
    @SerializedName("ResultsReturned")
    @Expose
    private Integer resultsReturned;
    @SerializedName("ResultsTotal")
    @Expose
    private Integer resultsTotal;
    @SerializedName("TopSpotAgencyBanner")
    @Expose
    private Object topSpotAgencyBanner;
    @SerializedName("TopSpotAgencyID")
    @Expose
    private Integer topSpotAgencyID;
    @SerializedName("TopSpotBackgroundColor")
    @Expose
    private Object topSpotBackgroundColor;
    @SerializedName("TopSpotListingsCount")
    @Expose
    private Integer topSpotListingsCount;
    private final static long serialVersionUID = 6730870404237250099L;

    public List<Listing> getListings() {
        return listings;
    }

    public void setListings(List<Listing> listings) {
        this.listings = listings;
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

    public Object getTopSpotAgencyBanner() {
        return topSpotAgencyBanner;
    }

    public void setTopSpotAgencyBanner(Object topSpotAgencyBanner) {
        this.topSpotAgencyBanner = topSpotAgencyBanner;
    }

    public Integer getTopSpotAgencyID() {
        return topSpotAgencyID;
    }

    public void setTopSpotAgencyID(Integer topSpotAgencyID) {
        this.topSpotAgencyID = topSpotAgencyID;
    }

    public Object getTopSpotBackgroundColor() {
        return topSpotBackgroundColor;
    }

    public void setTopSpotBackgroundColor(Object topSpotBackgroundColor) {
        this.topSpotBackgroundColor = topSpotBackgroundColor;
    }

    public Integer getTopSpotListingsCount() {
        return topSpotListingsCount;
    }

    public void setTopSpotListingsCount(Integer topSpotListingsCount) {
        this.topSpotListingsCount = topSpotListingsCount;
    }



}
