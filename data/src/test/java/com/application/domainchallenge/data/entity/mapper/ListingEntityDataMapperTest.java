package com.application.domainchallenge.data.entity.mapper;

import com.application.domainchallenge.domain.Listing;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by anbu.ezhilan on 22/2/18.
 */


@RunWith(MockitoJUnitRunner.class)
public class ListingEntityDataMapperTest {

    private static final int FAKE_AdId =  2014181602;

    private ListingEntityDataMapper listingEntityDataMapper;

    @Before
    public void setUp() throws Exception {
        listingEntityDataMapper = new ListingEntityDataMapper();
    }

    @Test
    public void testTransformListingEntity() {
        Listing listing = createFakeListingEntity();

        assertThat(listing.getAdId(), is(FAKE_AdId));


    }

    private Listing createFakeListingEntity() {
        Listing listingEntity = new Listing();
        listingEntity.setAdId(FAKE_AdId);
        return listingEntity;
    }
}
