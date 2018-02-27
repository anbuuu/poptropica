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
import com.application.domainchallenge.internal.di.components.DaggerPropertyListingComponent;
import com.application.domainchallenge.internal.di.components.PropertyListingComponent;
import com.application.domainchallenge.view.fragment.PropertyListingsFragment;

import butterknife.ButterKnife;

/**
 * Activity that shows the list of Properties
 */


public class PropertyListingsActivity extends BaseActivity
        implements HasComponent<PropertyListingComponent> {

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, PropertyListingsActivity.class);
    }

    private PropertyListingComponent propertyListingComponent;
    private static final String TAG = PropertyListingsActivity.class.getSimpleName();

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
        this.propertyListingComponent = DaggerPropertyListingComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }


    @Override
    public PropertyListingComponent getComponent() {
        return propertyListingComponent;
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainer, fragment);
        //TODO find a abetter way to replace fragment
        transaction.addToBackStack(null);
        transaction.commit();
    }


}

