
package com.application.domainchallenge.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Example implements Serializable
{

    @SerializedName("Ads")
    @Expose
    private Object ads;
    @SerializedName("ClusterResults")
    @Expose
    private Object clusterResults;
    @SerializedName("GeographicWindow")
    @Expose
    private GeographicWindow geographicWindow;
    @SerializedName("ListingResults")
    @Expose
    private ListingResults listingResults;
    @SerializedName("NavigatorResults")
    @Expose
    private NavigatorResults navigatorResults;
    @SerializedName("PoiMarkerResults")
    @Expose
    private PoiMarkerResults poiMarkerResults;
    private final static long serialVersionUID = -2613180813957745504L;

    public Object getAds() {
        return ads;
    }

    public void setAds(Object ads) {
        this.ads = ads;
    }

    public Object getClusterResults() {
        return clusterResults;
    }

    public void setClusterResults(Object clusterResults) {
        this.clusterResults = clusterResults;
    }

    public GeographicWindow getGeographicWindow() {
        return geographicWindow;
    }

    public void setGeographicWindow(GeographicWindow geographicWindow) {
        this.geographicWindow = geographicWindow;
    }

    public ListingResults getListingResults() {
        return listingResults;
    }

    public void setListingResults(ListingResults listingResults) {
        this.listingResults = listingResults;
    }

    public NavigatorResults getNavigatorResults() {
        return navigatorResults;
    }

    public void setNavigatorResults(NavigatorResults navigatorResults) {
        this.navigatorResults = navigatorResults;
    }

    public PoiMarkerResults getPoiMarkerResults() {
        return poiMarkerResults;
    }

    public void setPoiMarkerResults(PoiMarkerResults poiMarkerResults) {
        this.poiMarkerResults = poiMarkerResults;
    }


}
