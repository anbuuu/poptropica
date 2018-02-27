package com.application.domainchallenge.mapper;

import android.util.Log;

import com.application.domainchallenge.domain.Listing;
import com.application.domainchallenge.internal.di.PerActivity;
import com.application.domainchallenge.model.ListingModel;
import com.application.domainchallenge.model.PropertyTypeListingModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.inject.Inject;

/**
 * Mapper class used to transform {@link Listing} in the domain layer to {@link ListingModel}
 * in the presentation layer
 */
@PerActivity
public class ListingModelDataMapper {

    @Inject
    public ListingModelDataMapper() {}
    /**
     * Transform a {@link com.application.domainchallenge.domain.Listing} into an
     * {@link ListingModel}
     *
     * @param listing Object to be transformed
     * @return {@link ListingModel}
     *
     */

    public static final String TAG = ListingModelDataMapper.class.getSimpleName();
    //public ListingModel transform(ListingEntity listing) {
    public ListingModel transform(Listing listing) {

        if ( listing == null) {
            throw new IllegalArgumentException("cannot transform a null value");
        }

        final ListingModel listingModel = new ListingModel();
        listingModel.setAdId(listing.getAdId());
        listingModel.setAgencyColour(listing.getAgencyColour());
        listingModel.setAgencyContactPhoto(listing.getAgencyContactPhoto());
        listingModel.setAgencyLogoUrl(listing.getAgencyLogoUrl());
        listingModel.setDisplayPrice(listing.getDisplayPrice());
        listingModel.setDisplayableAddress(listing.getDisplayableAddress());
        listingModel.setBedrooms(listing.getBedrooms());
        listingModel.setBathrooms(listing.getBathrooms());
        listingModel.setCarspaces(listing.getCarspaces());
        listingModel.setTruncatedDescription(listing.getTruncatedDescription());
        listingModel.setRetinaDisplayThumbUrl(listing.getRetinaDisplayThumbUrl());
        listingModel.setSecondRetinaDisplayThumbUrl(listing.getSecondRetinaDisplayThumbUrl());
        listingModel.setAgencyLogoUrl(listing.getAgencyLogoUrl());
        listingModel.setIsElite(listing.getIsElite());

        return listingModel;
    }

    /**
     * Transform a collection of {@link Listing} into a
     * collection of {@link ListingModel}
     */
    public Collection<PropertyTypeListingModel> transform(Collection<Listing> listingCollection){

        Collection<PropertyTypeListingModel> propertyTypeListingModelCollection;
        Collection<ListingModel> premiumListingModelCollection;
        Collection<ListingModel> standardListingModelCollection;

        propertyTypeListingModelCollection = new ArrayList<>();
        premiumListingModelCollection = new ArrayList<>();
        standardListingModelCollection = new ArrayList<>();

        if ( listingCollection != null && !listingCollection.isEmpty()) {
            propertyTypeListingModelCollection = new ArrayList<>();
            premiumListingModelCollection = new ArrayList<>();
            standardListingModelCollection = new ArrayList<>();


            for ( Listing listing : listingCollection ) {
                if ( listing.getIsElite() != null && listing.getIsElite() == 1 ) {
                    premiumListingModelCollection.add(transform(listing));
                } else if ( listing.getIsElite() != null && listing.getIsElite() == 0 ) {
                    standardListingModelCollection.add(transform(listing));
                }
            }

            Log.d(TAG, "The standard listing is " + standardListingModelCollection.size() + " and premium is " +
                    premiumListingModelCollection.size());

            // TODO moved to string constants
            propertyTypeListingModelCollection.add(new PropertyTypeListingModel("STANDARD", standardListingModelCollection));
            propertyTypeListingModelCollection.add(new PropertyTypeListingModel("PREMIUM", premiumListingModelCollection));
        } else {
            propertyTypeListingModelCollection = Collections.emptyList();
        }

        //TODO
        return propertyTypeListingModelCollection;
    }
}
