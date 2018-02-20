package com.application.domainchallenge.data.repository.datasource;

import android.content.Context;

import com.application.domainchallenge.data.entity.mapper.ListingEntityJsonMapper;
import com.application.domainchallenge.data.net.RestApi;
import com.application.domainchallenge.data.net.RestApiImpl;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by anbu.ezhilan on 15/2/18.
 */

@Singleton
public class ListingDataStoreFactory {

    private final Context context;

    @Inject
    ListingDataStoreFactory(@NotNull Context context
                            ) {
        this.context = context;
    }

    public ListingDataStore createCloudDataStore() {
        final ListingEntityJsonMapper listingEntityJsonMapper = new ListingEntityJsonMapper();
        final RestApi restApi = new RestApiImpl(this.context, listingEntityJsonMapper);

        return new CloudListingDataStore(restApi);
    }

}
