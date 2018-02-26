package com.application.domainchallenge.data.repository.datasource;

import com.application.domainchallenge.data.entity.PropertyResults;
import com.application.domainchallenge.data.net.RestApi;

import io.reactivex.Observable;

/**
 * Listing Data Store Implementation for Cloud
 */

class CloudListingDataStore implements ListingDataStore {

    private final RestApi restApi;

    public CloudListingDataStore(RestApi restApi) {
        this.restApi = restApi;
    }

    @Override
    public Observable<PropertyResults> listingEntityList() {
        return this.restApi.listingEntityList();
    }

}
