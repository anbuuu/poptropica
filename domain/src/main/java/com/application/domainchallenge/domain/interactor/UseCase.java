package com.application.domainchallenge.domain.interactor;

import com.application.domainchallenge.domain.executor.PostExecutionThread;
import com.application.domainchallenge.domain.executor.ThreadExecutor;
import com.fernandocejas.arrow.checks.Preconditions;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Abstract class for a Use Case This interface represents a execution unit for different use cases
 * Any use case the application should implement this contract
 *
 * By convention each UseCase implementation will return the result using a {@link DisposableObserver}
 * that will execute its job in a background thread and will post the result in the UI thread.
 */
public abstract class UseCase<T, Params> {

    private final ThreadExecutor threadExecutor;
    private final PostExecutionThread postExecutionThread;
    private final CompositeDisposable disposables;


    UseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
        this.disposables = new CompositeDisposable();
    }
    /**
     * Builds an {@link Observable} which will be used when executing
     * the current {@link UseCase}
     */
    abstract Observable<T> buildUseCasObservable(Params params);


    /**
     * Executes the Current Use Case
     *
     * @param observer {@link DisposableObserver} which will be
     * listening to the observable build by {@link #buildUseCasObservable(Params)} method
     * @param params Parameters ( Optional ) used to build / execute this case
     *
     */
    public void execute(DisposableObserver<T> observer, Params params) {

        Preconditions.checkNotNull(observer);
        final Observable<T> observable = this.buildUseCasObservable(params)
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.getScheduler());

        addDisposable(observable.subscribeWith(observer));

    }
    /**
     * Dispose from current {@link CompositeDisposable}
     *
     */
    public void dispose() {
        if ( !disposables.isDisposed()) {
            disposables.dispose();
        }
    }

    /**
     * Dispose from current {@link CompositeDisposable}
     * @param disposable
     */
    public void addDisposable(Disposable disposable) {
        Preconditions.checkNotNull(disposables);
        disposables.add(disposable);
    }

}
