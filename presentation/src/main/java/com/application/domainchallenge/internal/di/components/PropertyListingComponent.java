package com.application.domainchallenge.internal.di.components;

import com.application.domainchallenge.internal.di.PerActivity;
import com.application.domainchallenge.internal.di.modules.ActivityModule;
import com.application.domainchallenge.internal.di.modules.PropertyListingModule;
import com.application.domainchallenge.view.fragment.PropertyListingsFragment;

import dagger.Component;

/**
 *  A Scope {@link PerActivity} component. Injects specific fragments
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class,
modules = {ActivityModule.class, PropertyListingModule.class})
public interface PropertyListingComponent extends ActivityComponent{
    void inject(PropertyListingsFragment propertyListingsFragment);

}
