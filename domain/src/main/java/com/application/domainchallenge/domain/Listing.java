package com.application.domainchallenge.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class that represents a Listing in the Domain Layer
 */

public class Listing {
    private Integer adId;
    private String agencyColour;
    private Object agencyContactPhoto;
    private Integer agencyID;
    private String agencyLogoUrl;
    private String area;
    private Object auctionDate;
    private Object availableFrom;
    private Integer bathrooms;
    private Integer bedrooms;
    private Integer carspaces;
    private String dateFirstListed;
    private String dateUpdated;
    private String description;
    private String displayPrice;
    private String displayableAddress;
    private Object enquiryTimeStamp;
    private List<Feature> features = null;
    private Integer freshnessLevel;
    private Integer groupCount;
    private Integer groupNo;
    private Integer hasEnhancedVideoUrl;
    private String headline;
    private Boolean homepassEnabled;
    private List<String> imageUrls = null;
    private Object images;
    private Object inspectionDate;
    private Object inspections;
    private Integer isBranded;
    private Integer isElite;
    private Integer isPriority;
    private Double latitude;
    private Integer listingPrice;
    private Object listingStatistics;
    private String listingType;
    private String listingTypeString;
    private Double longitude;
    private Integer mapCertainty;
    private Object mode;
    private Object projectDetails;
    private String propertyType;
    private Object propertyTypeList;
    private String region;
    private String retinaDisplayThumbUrl;
    private String secondRetinaDisplayThumbUrl;
    private String secondThumbUrl;
    private String state;
    private Object statusLabel;
    private String suburb;
    private String thumbUrl;
    private Integer topSpotEligible;
    private String truncatedDescription;
    private Integer underOfferOrContract;
    private Object videoUrl;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
