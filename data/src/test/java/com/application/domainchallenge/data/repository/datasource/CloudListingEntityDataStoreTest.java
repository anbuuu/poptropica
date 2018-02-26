package com.application.domainchallenge.data.repository.datasource;

import com.application.domainchallenge.data.net.RestApi;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CloudListingEntityDataStoreTest {

    private CloudListingDataStore cloudListingDataStore;

    @Mock
    private RestApi mockRestApi;

    @Before
    public void setUp() {
        cloudListingDataStore = new CloudListingDataStore(mockRestApi);
    }

    @Test
    public void testGetListingEntityListFromApi() {
        cloudListingDataStore.listingEntityList();
        verify(mockRestApi).listingEntityList();

    }
}
