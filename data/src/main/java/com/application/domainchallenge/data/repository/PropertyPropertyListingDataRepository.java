package com.application.domainchallenge.data.repository;

import com.application.domainchallenge.data.entity.mapper.PropertyListingEntityDataMapper;
import com.application.domainchallenge.data.repository.datasource.CloudPropertyListingDataStoreFactory;
import com.application.domainchallenge.data.repository.datasource.PropertyListingDataStore;
import com.application.domainchallenge.domain.Listing;
import com.application.domainchallenge.domain.repository.PropertyListingRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * {@link PropertyListingRepository} for Retrieving Listings Data
 */

@Singleton
public class PropertyPropertyListingDataRepository implements PropertyListingRepository {

    private final CloudPropertyListingDataStoreFactory cloudPropertyListingDataStoreFactory;
    private final PropertyListingEntityDataMapper propertyListingEntityDataMapper;

    /**
     *
     * Constructs a {@link PropertyListingRepository}
     * @param cloudPropertyListingDataStoreFactory
     * @param propertyListingEntityDataMapper
     */
    @Inject
    public PropertyPropertyListingDataRepository(CloudPropertyListingDataStoreFactory cloudPropertyListingDataStoreFactory, PropertyListingEntityDataMapper propertyListingEntityDataMapper) {
        this.cloudPropertyListingDataStoreFactory = cloudPropertyListingDataStoreFactory;
        this.propertyListingEntityDataMapper = propertyListingEntityDataMapper;
    }


    @Override
    public Observable<List<Listing>> listings() {
        final PropertyListingDataStore propertyListingDataStore = this.cloudPropertyListingDataStoreFactory.createCloudDataStore();
        return propertyListingDataStore.listingEntityList().map(this.propertyListingEntityDataMapper::transform);
    }
}
