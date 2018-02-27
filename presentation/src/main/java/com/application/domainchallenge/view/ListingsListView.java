package com.application.domainchallenge.view;

import com.application.domainchallenge.model.PropertyTypeListingModel;

import java.util.Collection;

/**
 * Interface representing a View in a MVP Pattern, the view is representing a list of
 * {@link PropertyTypeListingModel}
 */

public interface ListingsListView extends LoadDataView{
    /**
     * Render a Listings List in the UI
     */
    void renderListingsList(Collection<PropertyTypeListingModel> listingModelCollection);


}
