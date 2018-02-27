package com.application.domainchallenge.domain.interactor;

import com.application.domainchallenge.domain.Listing;
import com.application.domainchallenge.domain.executor.PostExecutionThread;
import com.application.domainchallenge.domain.executor.ThreadExecutor;
import com.application.domainchallenge.domain.repository.ListingRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * This class is an implementation of {@link UseCase} that represents a use case for
 * retrieving a collection of all {@link Listing}
 */

public class GetListingsList extends UseCase<List<Listing>, Void> {

    private final ListingRepository listingRepository;

    @Inject
    GetListingsList(ListingRepository listingRepository,
                    ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.listingRepository = listingRepository;
    }

    @Override
    Observable<List<Listing>> buildUseCasObservable(Void unused) {
        return this.listingRepository.listings();
    }
}
