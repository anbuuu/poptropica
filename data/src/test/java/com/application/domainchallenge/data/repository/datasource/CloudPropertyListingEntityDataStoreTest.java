package com.application.domainchallenge.data.repository.datasource;

import com.application.domainchallenge.data.net.CloudApi;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CloudPropertyListingEntityDataStoreTest {

    private CloudPropertyListingDataStore cloudListingDataStore;

    @Mock
    private CloudApi mockCloudApi;

    @Before
    public void setUp() {
        cloudListingDataStore = new CloudPropertyListingDataStore(mockCloudApi);
    }

    @Test
    public void testGetListingEntityListFromApi() {
        cloudListingDataStore.listingEntityList();
        verify(mockCloudApi).listingEntityList();

    }
}
