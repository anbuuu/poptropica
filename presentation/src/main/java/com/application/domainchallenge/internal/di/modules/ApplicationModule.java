package com.application.domainchallenge.internal.di.modules;

import android.content.Context;

import com.application.domainchallenge.AndroidApplication;
import com.application.domainchallenge.UIThread;
import com.application.domainchallenge.data.executor.JobExecutor;
import com.application.domainchallenge.data.repository.ListingDataRepository;
import com.application.domainchallenge.domain.executor.PostExecutionThread;
import com.application.domainchallenge.domain.executor.ThreadExecutor;
import com.application.domainchallenge.domain.repository.ListingRepository;

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
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @Singleton //TODO change the name for UIThread
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

    @Provides
    @Singleton
    ListingRepository provideListingRepository(ListingDataRepository listingDataRepository) {
        return listingDataRepository;
    }

}
