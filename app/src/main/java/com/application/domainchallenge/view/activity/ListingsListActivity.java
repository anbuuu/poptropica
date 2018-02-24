package com.application.domainchallenge.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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

    /*@BindView(R.id.viewpager)
    ViewPager viewPager;

    @BindView(R.id.sliding_tabs)
    TabLayout sliding_tabs;*/

    /*@BindView(R.id.navigation)
    BottomNavigationView bottomNavigationView;*/
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO Remove this progress
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_layout);
        ButterKnife.bind(this);
        this.initializeInjector();

        //bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
      /*  // This should be the place where the Fragment needs to be setup
        viewPager.setAdapter(new ListingTypeFragmentPagerAdapter(getSupportFragmentManager(),
                ListingsListActivity.this));

        // Give the tablayout to the view pager
        sliding_tabs.setupWithViewPager(viewPager);*/
        if ( savedInstanceState == null ) {
            addFragment(R.id.fragmentContainer, new ListingsListFragment());
        }
        //loadFragment(new ListingsListFragment());
       // Menu menu = bottomNavigationView.getMenu();

        //bottomNavigationView.setSelectedItemId(R.id.navigation_standard);
       // menu.set


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

    /*private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
             = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;

            switch ( item.getItemId()) {
                case R.id.navigation_standard:
                    Log.d(TAG, "Entering Standard");
                    fragment = ListingsListFragment.newInstance(0);
                    loadFragment(fragment);
                    break;

                case R.id.navigation_premium:
                    Log.d(TAG, "Entering Premium");
                    fragment = ListingsListFragment.newInstance(1);
                    loadFragment(fragment);
                    break;
            }
            return false;
        }
    };*/

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainer, fragment);
        //TODO find a abetter way to replace fragment
        transaction.addToBackStack(null);
        transaction.commit();
    }

}

