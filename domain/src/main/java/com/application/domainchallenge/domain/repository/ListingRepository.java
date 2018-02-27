package com.application.domainchallenge.domain.repository;

import com.application.domainchallenge.domain.Listing;

import java.util.List;

import io.reactivex.Observable;

/**
 * Interface that represents a Repository for getting {@link Listing} related data
 */

public interface ListingRepository {
    /**
     * Get an {@link io.reactivex.Observable} which will emit a list of {@link Listing}
     */
    Observable<List<Listing>> listings();
}
