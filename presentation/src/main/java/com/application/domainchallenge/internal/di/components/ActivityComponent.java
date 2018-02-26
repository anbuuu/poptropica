package com.application.domainchallenge.internal.di.components;

import android.app.Activity;

import com.application.domainchallenge.internal.di.PerActivity;
import com.application.domainchallenge.internal.di.modules.ActivityModule;

import dagger.Component;

/**
 * Base Component upon which
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
 interface ActivityComponent {

    // Exposed to Sub graphs
    Activity activity();
}
