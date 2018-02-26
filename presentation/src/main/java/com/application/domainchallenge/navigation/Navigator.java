package com.application.domainchallenge.navigation;

import android.content.Context;
import android.content.Intent;

import com.application.domainchallenge.view.activity.ListingsListActivity;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Class used to navigate around the application
 */

@Singleton
public class Navigator {

    @Inject
    public Navigator() {}
    /**
     * Goes to Listings List Screen
     *
     * @param context A Context needed to open the Activity
     */
    public void navigateToListingsList(Context context) {
        if ( context != null ) {
            Intent intentToLaunch = ListingsListActivity.getCallingIntent(context);
            context.startActivity(intentToLaunch);
        }
    }
}
