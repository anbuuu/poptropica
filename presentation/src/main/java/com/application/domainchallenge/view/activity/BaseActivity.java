package com.application.domainchallenge.view.activity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.application.domainchallenge.AndroidApplication;
import com.application.domainchallenge.R;
import com.application.domainchallenge.internal.di.components.ApplicationComponent;
import com.application.domainchallenge.internal.di.modules.ActivityModule;
import com.application.domainchallenge.navigation.Navigator;

import javax.inject.Inject;

/**
 * Base {@link android.app.Activity} lass for every Activity
 * in this application
 */
// TODO Moved from Activity to AppCompatActivity
public abstract class BaseActivity extends AppCompatActivity {

    @Inject
    Navigator navigator;

    private static final String TAG = BaseActivity.class.getSimpleName();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getApplicationComponent().inject(this);
        if (!isTablet()) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }

    }

    /**
     * Adds a {@link android.app.Fragment} to this activity's layout
     * @param containerViewId The container view to where add the fragment
     * @param fragment the Fragment to be added
     */
    protected void addFragment(int containerViewId, Fragment fragment) {
        final FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(containerViewId, fragment);
        fragmentTransaction.commit();
    }

    /**
     * Get the Main Application component for Dependency injection
     * @return {@link ApplicationComponent}
     */
    protected ApplicationComponent getApplicationComponent() {
        Log.d(TAG, "Entering getApplicationComponent()");
        return ((AndroidApplication) getApplication()).getApplicationComponent();
    }
    /**
     * Get an activity module for Dependency Injection
     */
    protected ActivityModule getActivityModule(){
        return new ActivityModule(this);
    }

    private boolean isTablet() {
        return getResources().getBoolean(R.bool.is_tablet);
    }

}
