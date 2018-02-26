package com.application.domainchallenge.data.repository.datasource;

import com.application.domainchallenge.data.entity.PropertyResults;

import io.reactivex.Observable;

/**
 * Interface that represents a data store from where Data is retrieved
 */

public interface ListingDataStore {
    /**
     * Get an {@link io.reactivex.Observable} which will emit {@link PropertyResults}
     */
    Observable<PropertyResults> listingEntityList();
}
