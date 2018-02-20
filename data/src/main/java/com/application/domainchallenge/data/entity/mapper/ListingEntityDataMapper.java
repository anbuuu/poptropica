package com.application.domainchallenge.data.entity.mapper;

import com.application.domainchallenge.data.entity.ListingEntity;
import com.application.domainchallenge.domain.Listing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Mapper class used to transform {@link com.application.domainchallenge.data.entity.ListingEntity}
 * to {@link com.application.domainchallenge.domain.Listing} in the Domain Layer
 */

@Singleton
public class ListingEntityDataMapper {

    @Inject
    ListingEntityDataMapper() {
    }

    /**
     * Transform a List of {@link com.application.domainchallenge.data.entity.ListingEntity} to
     * a Collection of {@link com.application.domainchallenge.domain.Listing}
     */
    public List<Listing> transform(Collection<ListingEntity> listingEntityCollection) {
        final List<Listing> listingsList = new ArrayList<>(20); // TODO why magic Number ?
        for (ListingEntity listingEntity : listingEntityCollection) {
            final Listing listing = transform(listingEntity);
            if (listing != null) {
                listingsList.add(listing);
            }
        }
        return listingsList;
    }

    /**
     * Transform a {@link ListingEntity} into an {@link Listing}
     *
     * @param listingEntity
     * @return
     */
    public Listing transform(ListingEntity listingEntity) {
        Listing listing = null;
        if (listingEntity != null) {
            listing = new Listing(); //TODO verify this
            listing.setAdId(listingEntity.getAdId());
            listing.setAgencyColour(listingEntity.getAgencyColour());
            listing.setAgencyContactPhoto(listingEntity.getAgencyContactPhoto());
            listing.setAgencyID(listingEntity.getAgencyID());
            listing.setAgencyLogoUrl(listingEntity.getAgencyLogoUrl());
            listing.setArea(listingEntity.getArea());
            listing.setAuctionDate(listingEntity.getAuctionDate());
            listing.setAvailableFrom(listingEntity.getAvailableFrom());
            listing.setBathrooms(listingEntity.getBathrooms());
            listing.setCarspaces(listingEntity.getCarspaces());
            listing.setDateFirstListed(listingEntity.getDateFirstListed());
            listing.setDateUpdated(listingEntity.getDateUpdated());
            listing.setDescription(listingEntity.getDescription());
            listing.setDisplayPrice(listingEntity.getDisplayPrice());
            listing.setDisplayableAddress(listingEntity.getDisplayableAddress());
            listing.setEnquiryTimeStamp(listingEntity.getEnquiryTimeStamp());
            listing.setFeatures(listingEntity.getFeatures());
            listing.setFreshnessLevel(listingEntity.getFreshnessLevel());
            listing.setGroupCount(listingEntity.getGroupCount());
            listing.setGroupNo(listingEntity.getGroupNo());
            listing.setHasEnhancedVideoUrl(listingEntity.getHasEnhancedVideoUrl());
            listing.setHeadline(listingEntity.getHeadline());
            listing.setHomepassEnabled(listingEntity.getHomepassEnabled());
            listing.setImageUrls(listingEntity.getImageUrls());
            listing.setImages(listingEntity.getImages());
            listing.setInspectionDate(listingEntity.getInspectionDate());
            listing.setInspections(listingEntity.getInspections());
            listing.setIsBranded(listingEntity.getIsBranded());
            listing.setIsElite(listingEntity.getIsElite());
            listing.setIsPriority(listingEntity.getIsPriority());
            listing.setLatitude(listingEntity.getLatitude());
            listing.setListingPrice(listingEntity.getListingPrice());
            listing.setListingStatistics(listingEntity.getListingStatistics());
            listing.setListingType(listingEntity.getListingType());
            listing.setListingTypeString(listingEntity.getListingTypeString());
            listing.setLongitude(listingEntity.getLongitude());
            listing.setMapCertainty(listingEntity.getMapCertainty());
            listing.setMode(listingEntity.getMode());
            listing.setProjectDetails(listingEntity.getProjectDetails());
            listing.setPropertyType(listingEntity.getPropertyType());
            listing.setPropertyTypeList(listingEntity.getPropertyTypeList());
            listing.setRegion(listingEntity.getRegion());
            listing.setRetinaDisplayThumbUrl(listingEntity.getRetinaDisplayThumbUrl());
            listing.setSecondRetinaDisplayThumbUrl(listingEntity.getSecondRetinaDisplayThumbUrl());
            listing.setSecondThumbUrl(listingEntity.getSecondThumbUrl());
            listing.setState(listingEntity.getState());
            listing.setStatusLabel(listingEntity.getStatusLabel());
            listing.setSuburb(listingEntity.getSuburb());
            listing.setThumbUrl(listingEntity.getThumbUrl());
            listing.setTopSpotEligible(listingEntity.getTopSpotEligible());
            listing.setTruncatedDescription(listingEntity.getTruncatedDescription());
            listing.setUnderOfferOrContract(listingEntity.getUnderOfferOrContract());
            listing.setVideoUrl(listingEntity.getVideoUrl());

        }
        return listing;
    }
}
