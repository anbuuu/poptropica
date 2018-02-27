package com.application.domainchallenge.internal.di.components;

import android.content.Context;

import com.application.domainchallenge.domain.executor.PostExecutionThread;
import com.application.domainchallenge.domain.executor.ThreadExecutor;
import com.application.domainchallenge.domain.repository.ListingRepository;
import com.application.domainchallenge.internal.di.modules.ApplicationModule;
import com.application.domainchallenge.view.activity.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * A Component whose life time is the life of the application
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(BaseActivity baseActivity);

    //Exposed to subgraphs
    Context context();
    ThreadExecutor threadExecutor();
    PostExecutionThread postExecutionThread();
    ListingRepository listingRepository();
}
