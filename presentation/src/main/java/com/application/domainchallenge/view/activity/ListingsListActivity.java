package com.application.domainchallenge.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;

import com.application.domainchallenge.R;
import com.application.domainchallenge.internal.di.HasComponent;
import com.application.domainchallenge.internal.di.components.DaggerListingComponent;
import com.application.domainchallenge.internal.di.components.ListingComponent;
import com.application.domainchallenge.view.fragment.PropertyListingsFragment;

import butterknife.ButterKnife;

/**
 * Activity that shows the list of Properties
 */


public class ListingsListActivity extends BaseActivity
        implements HasComponent<ListingComponent> {

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, ListingsListActivity.class);
    }

    private ListingComponent listingComponent;
    private static final String TAG = ListingsListActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO Remove this progress
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_layout);
        ButterKnife.bind(this);
        this.initializeInjector();

        if ( savedInstanceState == null ) {
            addFragment(R.id.fragmentContainer, new PropertyListingsFragment());
        }
    }

    private void initializeInjector() {
        this.listingComponent = DaggerListingComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }


    @Override
    public ListingComponent getComponent() {
        return listingComponent;
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainer, fragment);
        //TODO find a abetter way to replace fragment
        transaction.addToBackStack(null);
        transaction.commit();
    }


}

