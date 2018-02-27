package com.application.domainchallenge.data.entity.mapper;


import com.application.domainchallenge.data.entity.ListingEntity;
import com.application.domainchallenge.domain.Listing;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(MockitoJUnitRunner.class)
public class PropertyListingEntityDataMapperTest {

    private static final int FAKE_AdId =  2014181602;

    private PropertyListingEntityDataMapper propertyListingEntityDataMapper;

    @Before
    public void setUp() throws Exception {
        propertyListingEntityDataMapper = new PropertyListingEntityDataMapper();
    }

    @Test
    public void testTransformListingEntity() {
        ListingEntity listingEntity = createFakeListingEntity();
        Listing listing = propertyListingEntityDataMapper.transform(listingEntity);

        assertThat(listing, is(instanceOf(com.application.domainchallenge.domain.Listing.class)));
        assertThat(listing.getAdId(), is(FAKE_AdId));
    }

    private ListingEntity createFakeListingEntity() {
        ListingEntity listingEntityEntity = new ListingEntity();
        listingEntityEntity.setAdId(FAKE_AdId);
        return listingEntityEntity;
    }

}
