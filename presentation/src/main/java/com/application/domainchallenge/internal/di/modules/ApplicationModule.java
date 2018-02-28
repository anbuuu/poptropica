package com.application.domainchallenge.internal.di.modules;

import android.content.Context;

import com.application.domainchallenge.AndroidApplication;
import com.application.domainchallenge.AppUIThread;
import com.application.domainchallenge.data.executor.ConcurrentJobExecutor;
import com.application.domainchallenge.data.repository.PropertyListingDataRepository;
import com.application.domainchallenge.domain.executor.PostExecutionThread;
import com.application.domainchallenge.domain.executor.ThreadExecutor;
import com.application.domainchallenge.domain.repository.PropertyListingRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger Module that provides objects which will live during the app lifecycle
 */

@Module
public class ApplicationModule {

    private final AndroidApplication application;

    public ApplicationModule(AndroidApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(ConcurrentJobExecutor concurrentJobExecutor) {
        return concurrentJobExecutor;
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(AppUIThread appUiThread) {
        return appUiThread;
    }

    @Provides
    @Singleton
    PropertyListingRepository provideListingRepository(PropertyListingDataRepository propertyListingDataRepository) {
        return propertyListingDataRepository;
    }

}
