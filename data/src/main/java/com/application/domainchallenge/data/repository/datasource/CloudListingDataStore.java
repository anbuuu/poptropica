package com.application.domainchallenge.data.repository.datasource;

import com.application.domainchallenge.data.entity.Example;
import com.application.domainchallenge.data.net.RestApi;

import io.reactivex.Observable;

/**
 * Created by anbu.ezhilan on 15/2/18.
 */

class CloudListingDataStore implements ListingDataStore {

    private final RestApi restApi;


    public CloudListingDataStore(RestApi restApi) {
        this.restApi = restApi;
    }


    @Override
    public Observable<Example> listingEntityList() {
        return this.restApi.listingEntityList();
    }


}
