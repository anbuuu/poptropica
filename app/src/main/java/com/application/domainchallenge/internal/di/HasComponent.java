package com.application.domainchallenge.internal.di;

/**
 * Interface representing a Contract for clients that contains a component
 * for dependency injection
 */

public interface HasComponent<C> {
    C getComponent();
}
