package com.application.domainchallenge.domain;


import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class AdIdTest {

    private static final Integer FAKE_AD_ID = 2014191398;
    private Listing listing;

    @Before
    public void setUp() {
        listing = new Listing();
        listing.setAdId(FAKE_AD_ID);
    }

    @Test
    public void testAdIdHappyCase() {
        final Integer adID = listing.getAdId();
        assertThat(adID.intValue(), is(FAKE_AD_ID));
    }
}
