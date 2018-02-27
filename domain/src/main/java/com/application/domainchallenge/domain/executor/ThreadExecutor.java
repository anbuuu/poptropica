
package com.application.domainchallenge.domain.executor;

import java.util.concurrent.Executor;

/**
 * Executor implementation will execute the
 * {@link com.application.domainchallenge.domain.interactor.UseCase } out of the UI thread.
 */
public interface ThreadExecutor extends Executor {}
