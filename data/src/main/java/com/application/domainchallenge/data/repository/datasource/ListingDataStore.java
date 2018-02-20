package com.application.domainchallenge.data.repository.datasource;

import com.application.domainchallenge.data.entity.Example;

import io.reactivex.Observable;

/**
 * Interface that represents a data store from where Data is retrieved
 */

public interface ListingDataStore {
    /**
     * Get an {@link io.reactivex.Observable} which will emit a list of {@link com.application.domainchallenge.data.entity.ListingEntity}
     */
    Observable<Example> listingEntityList();


}
