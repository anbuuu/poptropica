
package com.application.domainchallenge.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Listing implements Serializable
{

    @SerializedName("AdId")
    @Expose
    private Integer adId;
    @SerializedName("AgencyColour")
    @Expose
    private String agencyColour;
    @SerializedName("AgencyContactPhoto")
    @Expose
    private Object agencyContactPhoto;
    @SerializedName("AgencyID")
    @Expose
    private Integer agencyID;
    @SerializedName("AgencyLogoUrl")
    @Expose
    private String agencyLogoUrl;
    @SerializedName("Area")
    @Expose
    private String area;
    @SerializedName("AuctionDate")
    @Expose
    private Object auctionDate;
    @SerializedName("AvailableFrom")
    @Expose
    private Object availableFrom;
    @SerializedName("Bathrooms")
    @Expose
    private Integer bathrooms;
    @SerializedName("Bedrooms")
    @Expose
    private Integer bedrooms;
    @SerializedName("Carspaces")
    @Expose
    private Integer carspaces;
    @SerializedName("DateFirstListed")
    @Expose
    private String dateFirstListed;
    @SerializedName("DateUpdated")
    @Expose
    private String dateUpdated;
    @SerializedName("Description")
    @Expose
    private String description;
    @SerializedName("DisplayPrice")
    @Expose
    private String displayPrice;
    @SerializedName("DisplayableAddress")
    @Expose
    private String displayableAddress;
    @SerializedName("EnquiryTimeStamp")
    @Expose
    private Object enquiryTimeStamp;
    @SerializedName("Features")
    @Expose
    private List<Feature> features = null;
    @SerializedName("FreshnessLevel")
    @Expose
    private Integer freshnessLevel;
    @SerializedName("GroupCount")
    @Expose
    private Integer groupCount;
    @SerializedName("GroupNo")
    @Expose
    private Integer groupNo;
    @SerializedName("HasEnhancedVideoUrl")
    @Expose
    private Integer hasEnhancedVideoUrl;
    @SerializedName("Headline")
    @Expose
    private String headline;
    @SerializedName("HomepassEnabled")
    @Expose
    private Boolean homepassEnabled;
    @SerializedName("ImageUrls")
    @Expose
    private List<String> imageUrls = null;
    @SerializedName("Images")
    @Expose
    private Object images;
    @SerializedName("InspectionDate")
    @Expose
    private Object inspectionDate;
    @SerializedName("Inspections")
    @Expose
    private Object inspections;
    @SerializedName("IsBranded")
    @Expose
    private Integer isBranded;
    @SerializedName("IsElite")
    @Expose
    private Integer isElite;
    @SerializedName("IsPriority")
    @Expose
    private Integer isPriority;
    @SerializedName("Latitude")
    @Expose
    private Double latitude;
    @SerializedName("ListingPrice")
    @Expose
    private Integer listingPrice;
    @SerializedName("ListingStatistics")
    @Expose
    private Object listingStatistics;
    @SerializedName("ListingType")
    @Expose
    private String listingType;
    @SerializedName("ListingTypeString")
    @Expose
    private String listingTypeString;
    @SerializedName("Longitude")
    @Expose
    private Double longitude;
    @SerializedName("MapCertainty")
    @Expose
    private Integer mapCertainty;
    @SerializedName("Mode")
    @Expose
    private Object mode;
    @SerializedName("ProjectDetails")
    @Expose
    private Object projectDetails;
    @SerializedName("PropertyType")
    @Expose
    private String propertyType;
    @SerializedName("PropertyTypeList")
    @Expose
    private Object propertyTypeList;
    @SerializedName("Region")
    @Expose
    private String region;
    @SerializedName("RetinaDisplayThumbUrl")
    @Expose
    private String retinaDisplayThumbUrl;
    @SerializedName("SecondRetinaDisplayThumbUrl")
    @Expose
    private String secondRetinaDisplayThumbUrl;
    @SerializedName("SecondThumbUrl")
    @Expose
    private String secondThumbUrl;
    @SerializedName("State")
    @Expose
    private String state;
    @SerializedName("StatusLabel")
    @Expose
    private Object statusLabel;
    @SerializedName("Suburb")
    @Expose
    private String suburb;
    @SerializedName("ThumbUrl")
    @Expose
    private String thumbUrl;
    @SerializedName("TopSpotEligible")
    @Expose
    private Integer topSpotEligible;
    @SerializedName("TruncatedDescription")
    @Expose
    private String truncatedDescription;
    @SerializedName("UnderOfferOrContract")
    @Expose
    private Integer underOfferOrContract;
    @SerializedName("VideoUrl")
    @Expose
    private Object videoUrl;
    private final static long serialVersionUID = 6580018877541643400L;

    public Integer getAdId() {
        return adId;
    }

    public void setAdId(Integer adId) {
        this.adId = adId;
    }

    public String getAgencyColour() {
        return agencyColour;
    }

    public void setAgencyColour(String agencyColour) {
        this.agencyColour = agencyColour;
    }

    public Object getAgencyContactPhoto() {
        return agencyContactPhoto;
    }

    public void setAgencyContactPhoto(Object agencyContactPhoto) {
        this.agencyContactPhoto = agencyContactPhoto;
    }

    public Integer getAgencyID() {
        return agencyID;
    }

    public void setAgencyID(Integer agencyID) {
        this.agencyID = agencyID;
    }

    public String getAgencyLogoUrl() {
        return agencyLogoUrl;
    }

    public void setAgencyLogoUrl(String agencyLogoUrl) {
        this.agencyLogoUrl = agencyLogoUrl;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Object getAuctionDate() {
        return auctionDate;
    }

    public void setAuctionDate(Object auctionDate) {
        this.auctionDate = auctionDate;
    }

    public Object getAvailableFrom() {
        return availableFrom;
    }

    public void setAvailableFrom(Object availableFrom) {
        this.availableFrom = availableFrom;
    }

    public Integer getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(Integer bathrooms) {
        this.bathrooms = bathrooms;
    }

    public Integer getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(Integer bedrooms) {
        this.bedrooms = bedrooms;
    }

    public Integer getCarspaces() {
        return carspaces;
    }

    public void setCarspaces(Integer carspaces) {
        this.carspaces = carspaces;
    }

    public String getDateFirstListed() {
        return dateFirstListed;
    }

    public void setDateFirstListed(String dateFirstListed) {
        this.dateFirstListed = dateFirstListed;
    }

    public String getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(String dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDisplayPrice() {
        return displayPrice;
    }

    public void setDisplayPrice(String displayPrice) {
        this.displayPrice = displayPrice;
    }

    public String getDisplayableAddress() {
        return displayableAddress;
    }

    public void setDisplayableAddress(String displayableAddress) {
        this.displayableAddress = displayableAddress;
    }

    public Object getEnquiryTimeStamp() {
        return enquiryTimeStamp;
    }

    public void setEnquiryTimeStamp(Object enquiryTimeStamp) {
        this.enquiryTimeStamp = enquiryTimeStamp;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public Integer getFreshnessLevel() {
        return freshnessLevel;
    }

    public void setFreshnessLevel(Integer freshnessLevel) {
        this.freshnessLevel = freshnessLevel;
    }

    public Integer getGroupCount() {
        return groupCount;
    }

    public void setGroupCount(Integer groupCount) {
        this.groupCount = groupCount;
    }

    public Integer getGroupNo() {
        return groupNo;
    }

    public void setGroupNo(Integer groupNo) {
        this.groupNo = groupNo;
    }

    public Integer getHasEnhancedVideoUrl() {
        return hasEnhancedVideoUrl;
    }

    public void setHasEnhancedVideoUrl(Integer hasEnhancedVideoUrl) {
        this.hasEnhancedVideoUrl = hasEnhancedVideoUrl;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public Boolean getHomepassEnabled() {
        return homepassEnabled;
    }

    public void setHomepassEnabled(Boolean homepassEnabled) {
        this.homepassEnabled = homepassEnabled;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public Object getImages() {
        return images;
    }

    public void setImages(Object images) {
        this.images = images;
    }

    public Object getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(Object inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public Object getInspections() {
        return inspections;
    }

    public void setInspections(Object inspections) {
        this.inspections = inspections;
    }

    public Integer getIsBranded() {
        return isBranded;
    }

    public void setIsBranded(Integer isBranded) {
        this.isBranded = isBranded;
    }

    public Integer getIsElite() {
        return isElite;
    }

    public void setIsElite(Integer isElite) {
        this.isElite = isElite;
    }

    public Integer getIsPriority() {
        return isPriority;
    }

    public void setIsPriority(Integer isPriority) {
        this.isPriority = isPriority;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Integer getListingPrice() {
        return listingPrice;
    }

    public void setListingPrice(Integer listingPrice) {
        this.listingPrice = listingPrice;
    }

    public Object getListingStatistics() {
        return listingStatistics;
    }

    public void setListingStatistics(Object listingStatistics) {
        this.listingStatistics = listingStatistics;
    }

    public String getListingType() {
        return listingType;
    }

    public void setListingType(String listingType) {
        this.listingType = listingType;
    }

    public String getListingTypeString() {
        return listingTypeString;
    }

    public void setListingTypeString(String listingTypeString) {
        this.listingTypeString = listingTypeString;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getMapCertainty() {
        return mapCertainty;
    }

    public void setMapCertainty(Integer mapCertainty) {
        this.mapCertainty = mapCertainty;
    }

    public Object getMode() {
        return mode;
    }

    public void setMode(Object mode) {
        this.mode = mode;
    }

    public Object getProjectDetails() {
        return projectDetails;
    }

    public void setProjectDetails(Object projectDetails) {
        this.projectDetails = projectDetails;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public Object getPropertyTypeList() {
        return propertyTypeList;
    }

    public void setPropertyTypeList(Object propertyTypeList) {
        this.propertyTypeList = propertyTypeList;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRetinaDisplayThumbUrl() {
        return retinaDisplayThumbUrl;
    }

    public void setRetinaDisplayThumbUrl(String retinaDisplayThumbUrl) {
        this.retinaDisplayThumbUrl = retinaDisplayThumbUrl;
    }

    public String getSecondRetinaDisplayThumbUrl() {
        return secondRetinaDisplayThumbUrl;
    }

    public void setSecondRetinaDisplayThumbUrl(String secondRetinaDisplayThumbUrl) {
        this.secondRetinaDisplayThumbUrl = secondRetinaDisplayThumbUrl;
    }

    public String getSecondThumbUrl() {
        return secondThumbUrl;
    }

    public void setSecondThumbUrl(String secondThumbUrl) {
        this.secondThumbUrl = secondThumbUrl;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Object getStatusLabel() {
        return statusLabel;
    }

    public void setStatusLabel(Object statusLabel) {
        this.statusLabel = statusLabel;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public Integer getTopSpotEligible() {
        return topSpotEligible;
    }

    public void setTopSpotEligible(Integer topSpotEligible) {
        this.topSpotEligible = topSpotEligible;
    }

    public String getTruncatedDescription() {
        return truncatedDescription;
    }

    public void setTruncatedDescription(String truncatedDescription) {
        this.truncatedDescription = truncatedDescription;
    }

    public Integer getUnderOfferOrContract() {
        return underOfferOrContract;
    }

    public void setUnderOfferOrContract(Integer underOfferOrContract) {
        this.underOfferOrContract = underOfferOrContract;
    }

    public Object getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(Object videoUrl) {
        this.videoUrl = videoUrl;
    }


}
