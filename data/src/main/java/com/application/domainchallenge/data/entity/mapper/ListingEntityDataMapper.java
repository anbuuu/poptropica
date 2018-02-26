package com.application.domainchallenge.data.entity.mapper;

import android.util.Log;

import com.application.domainchallenge.data.entity.Example;
import com.application.domainchallenge.data.entity.ListingEntity;
import com.application.domainchallenge.domain.Listing;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Mapper class used to transform {@link com.application.domainchallenge.data.entity.ListingEntity}
 * to {@link com.application.domainchallenge.domain.Listing} in the Domain Layer
 */

@Singleton
public class ListingEntityDataMapper {

    private static final String TAG = ListingEntityDataMapper.class.getSimpleName();

    @Inject
    ListingEntityDataMapper() {
    }

    /**
     * Transform a List of {@link com.application.domainchallenge.data.entity.ListingEntity} to
     * a Collection of {@link com.application.domainchallenge.domain.Listing}
     */
    public List<Listing> transform(Example listingEntityCollection) {
        final List<Listing> listingsList = new ArrayList<>(20); // TODO why magic Number ?

        if ( listingEntityCollection != null && listingEntityCollection.getListingResults() != null) {
            Log.d(TAG, "Entering transform with collection = " + listingEntityCollection.getListingResults().getListingEntities().size());

            for (ListingEntity listingEntityEntity : listingEntityCollection.getListingResults().getListingEntities()) {
                final Listing listing = transform(listingEntityEntity);
                if (listing != null) {
                    listingsList.add(listing);
                }
            }
        }


        // Need to Map Example into List Listings
        return listingsList;
    }

    /**
     * Transform a {@link ListingEntity} into an {@link Listing}
     *
     * @param listingEntityEntity
     * @return
     */
    public Listing transform(ListingEntity listingEntityEntity) {
        Listing listing = null;
        if (listingEntityEntity != null) {
            listing = new Listing(); //TODO verify this
            listing.setAdId(listingEntityEntity.getAdId());
            listing.setAgencyColour(listingEntityEntity.getAgencyColour());
            listing.setAgencyContactPhoto(listingEntityEntity.getAgencyContactPhoto());
            listing.setAgencyID(listingEntityEntity.getAgencyID());
            listing.setAgencyLogoUrl(listingEntityEntity.getAgencyLogoUrl());
            listing.setArea(listingEntityEntity.getArea());
            listing.setAuctionDate(listingEntityEntity.getAuctionDate());
            listing.setAvailableFrom(listingEntityEntity.getAvailableFrom());
            listing.setBedrooms(listingEntityEntity.getBedrooms());
            listing.setBathrooms(listingEntityEntity.getBathrooms());
            listing.setCarspaces(listingEntityEntity.getCarspaces());
            listing.setDateFirstListed(listingEntityEntity.getDateFirstListed());
            listing.setDateUpdated(listingEntityEntity.getDateUpdated());
            listing.setDescription(listingEntityEntity.getDescription());
            listing.setDisplayPrice(listingEntityEntity.getDisplayPrice());
            listing.setDisplayableAddress(listingEntityEntity.getDisplayableAddress());
            listing.setEnquiryTimeStamp(listingEntityEntity.getEnquiryTimeStamp());
            listing.setFeatures(listing.getFeatures());
            listing.setFreshnessLevel(listingEntityEntity.getFreshnessLevel());
            listing.setGroupCount(listingEntityEntity.getGroupCount());
            listing.setGroupNo(listingEntityEntity.getGroupNo());
            listing.setHasEnhancedVideoUrl(listingEntityEntity.getHasEnhancedVideoUrl());
            listing.setHeadline(listingEntityEntity.getHeadline());
            listing.setHomepassEnabled(listingEntityEntity.getHomepassEnabled());
            listing.setImageUrls(listingEntityEntity.getImageUrls());
            listing.setImages(listingEntityEntity.getImages());
            listing.setInspectionDate(listingEntityEntity.getInspectionDate());
            listing.setInspections(listingEntityEntity.getInspections());
            listing.setIsBranded(listingEntityEntity.getIsBranded());
            listing.setIsElite(listingEntityEntity.getIsElite());
            listing.setIsPriority(listingEntityEntity.getIsPriority());
            listing.setLatitude(listingEntityEntity.getLatitude());
            listing.setListingPrice(listingEntityEntity.getListingPrice());
            listing.setListingStatistics(listingEntityEntity.getListingStatistics());
            listing.setListingType(listingEntityEntity.getListingType());
            listing.setListingTypeString(listingEntityEntity.getListingTypeString());
            listing.setLongitude(listingEntityEntity.getLongitude());
            listing.setMapCertainty(listingEntityEntity.getMapCertainty());
            listing.setMode(listingEntityEntity.getMode());
            listing.setProjectDetails(listingEntityEntity.getProjectDetails());
            listing.setPropertyType(listingEntityEntity.getPropertyType());
            listing.setPropertyTypeList(listingEntityEntity.getPropertyTypeList());
            listing.setRegion(listingEntityEntity.getRegion());
            listing.setRetinaDisplayThumbUrl(listingEntityEntity.getRetinaDisplayThumbUrl());
            listing.setSecondRetinaDisplayThumbUrl(listingEntityEntity.getSecondRetinaDisplayThumbUrl());
            listing.setSecondThumbUrl(listingEntityEntity.getSecondThumbUrl());
            listing.setState(listingEntityEntity.getState());
            listing.setStatusLabel(listingEntityEntity.getStatusLabel());
            listing.setSuburb(listingEntityEntity.getSuburb());
            listing.setThumbUrl(listingEntityEntity.getThumbUrl());
            listing.setTopSpotEligible(listingEntityEntity.getTopSpotEligible());
            listing.setTruncatedDescription(listingEntityEntity.getTruncatedDescription());
            listing.setUnderOfferOrContract(listingEntityEntity.getUnderOfferOrContract());
            listing.setVideoUrl(listingEntityEntity.getVideoUrl());

        }
        return listing;
    }
}
