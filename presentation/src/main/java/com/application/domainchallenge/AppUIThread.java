package com.application.domainchallenge;

import com.application.domainchallenge.domain.executor.PostExecutionThread;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * MainThread ( UI Thread ) implementation based on {@link io.reactivex.Scheduler}
 * which will execute Actions on the UI Thread
 */

@Singleton
public class AppUIThread implements PostExecutionThread {

    @Inject
    AppUIThread() {}

    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
