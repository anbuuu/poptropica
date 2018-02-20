package com.application.domainchallenge;

import android.app.Application;

import com.application.domainchallenge.internal.di.components.ApplicationComponent;
import com.application.domainchallenge.internal.di.components.DaggerApplicationComponent;
import com.application.domainchallenge.internal.di.modules.ApplicationModule;

/**
 * Android Main Application
 */

public class AndroidApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.initializeInjector();
        //TODO Add Leak this.initializeLeakDetection();
    }

    private void initializeInjector() {
       this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() { return this.applicationComponent; }
}
