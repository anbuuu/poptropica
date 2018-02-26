package com.application.domainchallenge.exception;

import android.test.AndroidTestCase;

import com.application.domainchallenge.R;
import com.application.domainchallenge.data.exception.ListingNotFoundException;
import com.application.domainchallenge.data.exception.NetworkConnectionException;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by anbu.ezhilan on 26/2/18.
 */

public class ErrorMessageFactoryTest extends AndroidTestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void testNetworkConnectionErrorMessage() {
        String expectedMessage = getContext().getString(R.string.exception_message_no_connection);
        String actualMessage = ErrorMessageFactory.create(getContext(),
                new NetworkConnectionException());
        assertThat(actualMessage, is(equalTo(expectedMessage)));
    }

    @Test
   public void testListingsNotFoundException() {
        String expectedMessage = getContext().getString(R.string.exception_message_listing_not_found);
        String actualMessage = ErrorMessageFactory.create(getContext(), new ListingNotFoundException());

        assertThat(actualMessage, is(equalTo(expectedMessage)));
   }

}
