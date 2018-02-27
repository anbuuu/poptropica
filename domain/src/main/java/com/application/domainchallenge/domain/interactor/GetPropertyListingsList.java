package com.application.domainchallenge.domain.interactor;

import com.application.domainchallenge.domain.Listing;
import com.application.domainchallenge.domain.executor.PostExecutionThread;
import com.application.domainchallenge.domain.executor.ThreadExecutor;
import com.application.domainchallenge.domain.repository.PropertyListingRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * This class is an implementation of {@link UseCase} that represents a use case for
 * retrieving a collection of all {@link Listing}
 */

public class GetPropertyListingsList extends UseCase<List<Listing>, Void> {

    private final PropertyListingRepository propertyListingRepository;

    @Inject
    GetPropertyListingsList(PropertyListingRepository propertyListingRepository,
                            ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.propertyListingRepository = propertyListingRepository;
    }

    @Override
    Observable<List<Listing>> buildUseCasObservable(Void unused) {
        return this.propertyListingRepository.propertyListings();
    }
}
