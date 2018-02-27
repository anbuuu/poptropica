package com.application.domainchallenge.internal.di;

/**
 * Interface representing a Contract for clients that contains a component
 * for DI
 */

public interface HasComponent<C> {
    C getComponent();
}
