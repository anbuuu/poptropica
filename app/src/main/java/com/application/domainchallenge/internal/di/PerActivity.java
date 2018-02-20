package com.application.domainchallenge.internal.di;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 *  A Scoping annotation to permit objects whose lifetime should
 *  conform to the life of the activity to be memorized in the
 *  correct component
 */

@Scope
@Retention(RUNTIME)
public @interface PerActivity { }
