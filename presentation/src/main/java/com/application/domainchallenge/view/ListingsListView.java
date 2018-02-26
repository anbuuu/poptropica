package com.application.domainchallenge.view;

import com.application.domainchallenge.model.PropertyTypeListingModel;

import java.util.Collection;

/**
 * Created by anbu.ezhilan on 17/2/18.
 */

public interface ListingsListView extends LoadDataView{
    /**
     * Render a Listings List in the UI
     */
    //void renderListingsList(Collection<ListingModel> listingModelCollection);
    void renderListingsList(Collection<PropertyTypeListingModel> listingModelCollection);


}
