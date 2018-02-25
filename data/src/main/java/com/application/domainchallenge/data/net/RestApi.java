package com.application.domainchallenge.data.net;

import com.application.domainchallenge.data.entity.Example;

import io.reactivex.Observable;


/**
 * RestApi for Retrieving Data from Network
 */

public interface RestApi {

    String API_DOMAIN_URL = "https://rest.domain.com.au/searchservice.svc/mapsearch?mode=buy&sub=Bondi&pcodes=2026&state=NSW";
    /**
     * Retrieves an {@link io.reactivex.Observable} which will emit a link of
     * {@link Example}
     */
    Observable<Example> listingEntityList();

}
