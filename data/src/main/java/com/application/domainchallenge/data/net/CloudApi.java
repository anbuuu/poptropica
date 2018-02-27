package com.application.domainchallenge.data.net;

import com.application.domainchallenge.data.entity.PropertyResults;

import io.reactivex.Observable;


/**
 * CloudApi for Retrieving Data from Network
 */

public interface CloudApi {

    String DOMAIN_JSON_URL = "https://rest.domain.com.au/searchservice.svc/mapsearch?mode=buy&sub=Bondi&pcodes=2026&state=NSW";
    /**
     * Retrieves an {@link io.reactivex.Observable} which will emit a link of
     * {@link PropertyResults}
     */
    Observable<PropertyResults> propertyResultsObservable();

}
