package com.application.domainchallenge.data.repository.datasource;

import android.content.Context;

import com.application.domainchallenge.data.entity.mapper.PropertyListingEntityJsonMapper;
import com.application.domainchallenge.data.net.CloudApi;
import com.application.domainchallenge.data.net.CloudApiImpl;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Factory that creates different implementations of {@link PropertyListingDataStore}
 * It's only from Cloud as of this version, this is a placeholder for future
 * factory implementations
 */

@Singleton
public class CloudPropertyListingDataStoreFactory {

    private final Context context;

    @Inject
    CloudPropertyListingDataStoreFactory(@NotNull Context context) {
        this.context = context;
    }

    public PropertyListingDataStore createCloudDataStore() {
        final PropertyListingEntityJsonMapper propertyListingEntityJsonMapper = new PropertyListingEntityJsonMapper();
        final CloudApi cloudApi = new CloudApiImpl(this.context, propertyListingEntityJsonMapper);
        return new CloudPropertyListingDataStore(cloudApi);
    }

}
