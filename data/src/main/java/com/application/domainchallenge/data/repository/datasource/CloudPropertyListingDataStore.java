package com.application.domainchallenge.data.repository.datasource;

import com.application.domainchallenge.data.entity.PropertyResults;
import com.application.domainchallenge.data.net.CloudApi;

import io.reactivex.Observable;

/**
 * Listing Data Store Implementation for Cloud
 */

class CloudPropertyListingDataStore implements PropertyListingDataStore {

    private final CloudApi cloudApi;

    public CloudPropertyListingDataStore(CloudApi cloudApi) {
        this.cloudApi = cloudApi;
    }

    @Override
    public Observable<PropertyResults> listingEntityList() {
        return this.cloudApi.listingEntityList();
    }

}
