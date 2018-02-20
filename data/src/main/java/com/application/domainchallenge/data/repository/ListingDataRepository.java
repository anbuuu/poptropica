package com.application.domainchallenge.data.repository;

import com.application.domainchallenge.data.entity.mapper.ListingEntityDataMapper;
import com.application.domainchallenge.data.repository.datasource.ListingDataStore;
import com.application.domainchallenge.data.repository.datasource.ListingDataStoreFactory;
import com.application.domainchallenge.domain.Listing;
import com.application.domainchallenge.domain.repository.ListingRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by anbu.ezhilan on 15/2/18.
 */

@Singleton
public class ListingDataRepository implements ListingRepository {



    private final ListingDataStoreFactory listingDataStoreFactory;
    private final ListingEntityDataMapper listingEntityDataMapper;

    /**
     *
     * Constructs a {@link ListingRepository}
     * @param listingDataStoreFactory
     * @param listingEntityDataMapper
     */
    @Inject
    public ListingDataRepository(ListingDataStoreFactory listingDataStoreFactory, ListingEntityDataMapper listingEntityDataMapper) {
        this.listingDataStoreFactory = listingDataStoreFactory;
        this.listingEntityDataMapper = listingEntityDataMapper;
    }


    @Override
    public Observable<List<Listing>> listings() {
        final ListingDataStore listingDataStore = this.listingDataStoreFactory.createCloudDataStore();
        return listingDataStore.listingEntityList().map(this.listingEntityDataMapper::transform);
    }
}
