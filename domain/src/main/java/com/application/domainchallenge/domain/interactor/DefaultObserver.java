
package com.application.domainchallenge.domain.interactor;

import io.reactivex.observers.DisposableObserver;

/**
 * Default {@link DisposableObserver} base class
 */
public class DefaultObserver<T> extends DisposableObserver<T> {
  @Override public void onNext(T t) {
    // Default No Operation
  }

  @Override public void onComplete() {
    // Default No Operation
  }

  @Override public void onError(Throwable exception) {
    // Default No Operation
  }
}
