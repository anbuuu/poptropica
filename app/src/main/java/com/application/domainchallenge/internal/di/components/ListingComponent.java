package com.application.domainchallenge.internal.di.components;

import com.application.domainchallenge.internal.di.PerActivity;
import com.application.domainchallenge.internal.di.modules.ActivityModule;
import com.application.domainchallenge.internal.di.modules.ListingModule;
import com.application.domainchallenge.view.fragment.ListingsListFragment;
import com.application.domainchallenge.view.fragment.PropertyListingsFragment;

import dagger.Component;

/**
 * Created by anbu.ezhilan on 17/2/18.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class,
modules = {ActivityModule.class, ListingModule.class})
public interface ListingComponent extends ActivityComponent{
    void inject(ListingsListFragment listingsListFragment);
    void inject(PropertyListingsFragment listingsListFragment);

}
