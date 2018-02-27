package com.application.domainchallenge.mapper;

import android.util.Log;

import com.application.domainchallenge.domain.Listing;
import com.application.domainchallenge.internal.di.PerActivity;
import com.application.domainchallenge.model.PropertyListingModel;
import com.application.domainchallenge.model.PropertyTypeListingModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.inject.Inject;

/**
 * Mapper class used to transform {@link Listing} in the domain layer to {@link PropertyListingModel}
 * in the presentation layer
 */
@PerActivity
public class PropertyListingModelDataMapper {

    @Inject
    public PropertyListingModelDataMapper() {}
    /**
     * Transform a {@link com.application.domainchallenge.domain.Listing} into an
     * {@link PropertyListingModel}
     *
     * @param listing Object to be transformed
     * @return {@link PropertyListingModel}
     *
     */

    public static final String TAG = PropertyListingModelDataMapper.class.getSimpleName();
    //public PropertyListingModel transform(ListingEntity listing) {
    public PropertyListingModel transform(Listing listing) {

        if ( listing == null) {
            throw new IllegalArgumentException("cannot transform a null value");
        }

        final PropertyListingModel propertyListingModel = new PropertyListingModel();
        propertyListingModel.setAdId(listing.getAdId());
        propertyListingModel.setAgencyColour(listing.getAgencyColour());
        propertyListingModel.setAgencyContactPhoto(listing.getAgencyContactPhoto());
        propertyListingModel.setAgencyLogoUrl(listing.getAgencyLogoUrl());
        propertyListingModel.setDisplayPrice(listing.getDisplayPrice());
        propertyListingModel.setDisplayableAddress(listing.getDisplayableAddress());
        propertyListingModel.setBedrooms(listing.getBedrooms());
        propertyListingModel.setBathrooms(listing.getBathrooms());
        propertyListingModel.setCarspaces(listing.getCarspaces());
        propertyListingModel.setTruncatedDescription(listing.getTruncatedDescription());
        propertyListingModel.setRetinaDisplayThumbUrl(listing.getRetinaDisplayThumbUrl());
        propertyListingModel.setSecondRetinaDisplayThumbUrl(listing.getSecondRetinaDisplayThumbUrl());
        propertyListingModel.setAgencyLogoUrl(listing.getAgencyLogoUrl());
        propertyListingModel.setIsElite(listing.getIsElite());

        return propertyListingModel;
    }

    /**
     * Transform a collection of {@link Listing} into a
     * collection of {@link PropertyListingModel}
     */
    public Collection<PropertyTypeListingModel> transform(Collection<Listing> listingCollection){

        Collection<PropertyTypeListingModel> propertyTypeListingModelCollection;
        Collection<PropertyListingModel> premiumPropertyListingModelCollection;
        Collection<PropertyListingModel> standardPropertyListingModelCollection;

        propertyTypeListingModelCollection = new ArrayList<>();
        premiumPropertyListingModelCollection = new ArrayList<>();
        standardPropertyListingModelCollection = new ArrayList<>();

        if ( listingCollection != null && !listingCollection.isEmpty()) {
            propertyTypeListingModelCollection = new ArrayList<>();
            premiumPropertyListingModelCollection = new ArrayList<>();
            standardPropertyListingModelCollection = new ArrayList<>();


            for ( Listing listing : listingCollection ) {
                if ( listing.getIsElite() != null && listing.getIsElite() == 1 ) {
                    premiumPropertyListingModelCollection.add(transform(listing));
                } else if ( listing.getIsElite() != null && listing.getIsElite() == 0 ) {
                    standardPropertyListingModelCollection.add(transform(listing));
                }
            }

            Log.d(TAG, "The standard listing is " + standardPropertyListingModelCollection.size() + " and premium is " +
                    premiumPropertyListingModelCollection.size());

            // TODO moved to string constants
            propertyTypeListingModelCollection.add(new PropertyTypeListingModel("STANDARD", standardPropertyListingModelCollection));
            propertyTypeListingModelCollection.add(new PropertyTypeListingModel("PREMIUM", premiumPropertyListingModelCollection));
        } else {
            propertyTypeListingModelCollection = Collections.emptyList();
        }

        //TODO
        return propertyTypeListingModelCollection;
    }
}
