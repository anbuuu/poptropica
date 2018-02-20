package com.application.domainchallenge.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Window;

import com.application.domainchallenge.R;
import com.application.domainchallenge.internal.di.HasComponent;
import com.application.domainchallenge.internal.di.components.DaggerListingComponent;
import com.application.domainchallenge.internal.di.components.ListingComponent;
import com.application.domainchallenge.model.ListingModel;
import com.application.domainchallenge.view.fragment.ListingsListFragment;

import butterknife.ButterKnife;

/**
 * Created by anbu.ezhilan on 16/2/18.
 */

public class ListingsListActivity extends BaseActivity
        implements HasComponent<ListingComponent>, ListingsListFragment.ListingListListener {

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, ListingsListActivity.class);
    }

    private ListingComponent listingComponent;
    private static final String TAG = ListingsListActivity.class.getSimpleName();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_layout);
        ButterKnife.bind(this);
        this.initializeInjector();

        if ( savedInstanceState == null ) {
            addFragment(R.id.fragmentContainer, new ListingsListFragment());
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

    @Override
    public void onListingClicked(ListingModel listingModel) {
        Log.d(TAG, "Entering onListingClicked with User Model " + listingModel.getHeadline());

    }
}
