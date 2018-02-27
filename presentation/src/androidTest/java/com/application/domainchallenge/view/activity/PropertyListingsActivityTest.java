package com.application.domainchallenge.view.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.test.ActivityInstrumentationTestCase2;

import com.application.domainchallenge.R;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;


public class PropertyListingsActivityTest extends ActivityInstrumentationTestCase2<PropertyListingsActivity> {


    public PropertyListingsActivityTest() {
        super(PropertyListingsActivity.class);
    }

    private PropertyListingsActivity propertyListingsActivity;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        this.setActivityIntent(createTargetIntent());
        propertyListingsActivity = getActivity();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void testContainsPropertyListingsFragment() {
        Fragment propertyListFragment = propertyListingsActivity.getSupportFragmentManager().findFragmentById(R.id.fragmentContainer);
        assertThat(propertyListFragment, is(notNullValue()));
    }

    private Intent createTargetIntent() {
        Intent listingsLaunchActivity = PropertyListingsActivity.getCallingIntent(getInstrumentation().getTargetContext());
        return listingsLaunchActivity;

    }
}
