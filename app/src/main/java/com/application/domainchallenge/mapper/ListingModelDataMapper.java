package com.application.domainchallenge.mapper;

import com.application.domainchallenge.domain.Listing;
import com.application.domainchallenge.internal.di.PerActivity;
import com.application.domainchallenge.model.ListingModel;

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
    public ListingModel transform(Listing listing) {

        if ( listing == null) {
            throw new IllegalArgumentException("cannot transform a null value");
        }

        // bedrooms, carspaces, displayprice,
        // displayable address, truncated description
        // retinathumbnailurl, secondretinathumbnailurl
        // isElite
        final ListingModel listingModel = new ListingModel();
        listingModel.setAgencyLogoUrl(listing.getAgencyLogoUrl());
        listingModel.setBathrooms(listing.getBathrooms());
        listingModel.setCarspaces(listing.getCarspaces());
        listingModel.setTruncatedDescription(listing.getTruncatedDescription());
        listingModel.setRetinaDisplayThumbUrl(listing.getRetinaDisplayThumbUrl());
        listingModel.setSecondRetinaDisplayThumbUrl(listing.getSecondRetinaDisplayThumbUrl());
        listingModel.setIsElite(listing.getIsElite());

        return listingModel;
    }
    /**
     * Transform a collection of {@link Listing} into a
     * collection of {@link ListingModel}
     */
    public Collection<ListingModel> transform(Collection<Listing> listingCollection) {
        Collection<ListingModel> listingModelCollection;

        if ( listingCollection != null && !listingCollection.isEmpty()) {
            listingModelCollection = new ArrayList<>();

            for ( Listing listing : listingCollection ) {
                listingModelCollection.add(transform(listing));
            }
        } else {
            listingModelCollection = Collections.emptyList();
        }

        return listingModelCollection;
    }
}
