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
 * Created by anbu.ezhilan on 16/2/18.
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

        // bedrooms, carspaces, displayprice,
        // displayable address, truncated description
        // retinathumbnailurl, secondretinathumbnailurl
        // isElite

        // Need to add tp

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

        //final PropertyTypeListingModel propertyTypeListingModel = new PropertyTypeListingModel(propertyType, listingModel);
        return listingModel;
    }

    //public Collection<>
    /**
     * Transform a collection of {@link Listing} into a
     * collection of {@link ListingModel}
     */
   // public Collection<ListingModel> transform(Collection<ListingEntity> listingCollection) {
    public Collection<PropertyTypeListingModel> transform(Collection<Listing> listingCollection){

        // ListingEntity is retrieved completely
        // Need to transform into a PropertyTypeListings object
        // for premium it should be

        //Collection<ListingModel> listingModelCollection;
        PropertyTypeListingModel propertyTypeListingModel = null;
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

            // Check for Elite


            for ( Listing listing : listingCollection ) {

                // Gets the whole listings
                // in this case for first instance
                if ( listing.getIsElite() != null && listing.getIsElite() == 1 ) {
                    //listingModelCollection = new PropertyTypeListingModel();
                    //listingModelCollection.add(transform(listing));

                    // You need to have a collection of PropertyTypeListingModel which is literally
                    // {"PREMIUM", "{ListingModel{ } }
                    // so you need list of listingmodels before you create a PropertyTypeListingModel
                    // so, first transform the listings and get the items which is the listing
                    // First Time it comes .. Add's to the List

                    // now how do you add a new
                    premiumListingModelCollection.add(transform(listing));

                   /* if ( propertyTypeListingModel == null ) {
                        // Create new instance
                        propertyTypeListingModel = new PropertyTypeListingModel("PREMIUM", premiumListingModelCollection);
                    }*/
                    //propertyTypeListingModelCollection.add(propertyTypeListingModel);
                } else if ( listing.getIsElite() != null && listing.getIsElite() == 0 ) {
                    standardListingModelCollection.add(transform(listing));
                    /*if ( propertyTypeListingModel == null ) {
                        propertyTypeListingModel = new PropertyTypeListingModel("STANDARD", standardListingModelCollection);

                    }*/
                    //propertyTypeListingModelCollection.add(propertyTypeListingModel);

                }



            }

            Log.d(TAG, "The standard listing is " + standardListingModelCollection.size() + " and premium is " +
                    premiumListingModelCollection.size());

            propertyTypeListingModelCollection.add(new PropertyTypeListingModel("STANDARD", standardListingModelCollection));
            propertyTypeListingModelCollection.add(new PropertyTypeListingModel("PREMIUM", premiumListingModelCollection));
        } else {
            propertyTypeListingModelCollection = Collections.emptyList();
        }

        //TODO
        return propertyTypeListingModelCollection;
    }
}
