package com.application.domainchallenge.internal.di.modules;

import android.app.Activity;

import com.application.domainchallenge.internal.di.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * A Module to wrap the Activity State and Expose it to Graph
 */

@Module
public class ActivityModule {
    private final Activity activity;


    public ActivityModule(Activity activity) {
        this.activity = activity;
    }
    /**
     * Expose the Activity to dependents in the Graph
     */
    @Provides
    @PerActivity
    Activity activity() { return  this.activity;}
}
