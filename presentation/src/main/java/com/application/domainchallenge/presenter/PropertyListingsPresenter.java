package com.application.domainchallenge.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.application.domainchallenge.domain.Listing;
import com.application.domainchallenge.domain.exception.ErrorBundle;
import com.application.domainchallenge.domain.interactor.DefaultObserver;
import com.application.domainchallenge.domain.interactor.GetPropertyListingsList;
import com.application.domainchallenge.exception.ErrorMessageFactory;
import com.application.domainchallenge.internal.di.PerActivity;
import com.application.domainchallenge.mapper.PropertyListingModelDataMapper;
import com.application.domainchallenge.model.PropertyListingModel;
import com.application.domainchallenge.model.PropertyTypeListingModel;
import com.application.domainchallenge.view.ListingsListView;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

/**
 * {@link PropertyListingsPresenter} that controls the communication between views and models in
 * presentation layer
 */

@PerActivity
public class PropertyListingsPresenter implements Presenter {

    private ListingsListView viewListView;

    private final GetPropertyListingsList getPropertyListingsListUseCase;
    private final PropertyListingModelDataMapper propertyListingModelDataMapper;
    private static final String TAG = PropertyListingsPresenter.class.getSimpleName();

    @Inject
    public PropertyListingsPresenter(GetPropertyListingsList getPropertyListingsListUseCase, PropertyListingModelDataMapper propertyListingModelDataMapper) {
        this.getPropertyListingsListUseCase = getPropertyListingsListUseCase;
        this.propertyListingModelDataMapper = propertyListingModelDataMapper;
    }

    public void setView(@NonNull ListingsListView view) { this.viewListView = view; }

    @Override
    public void resume() { }

    @Override
    public void pause() { }

    @Override
    public void destroy() {
        this.getPropertyListingsListUseCase.dispose();
        this.viewListView = null;
    }
    /**
     * Initialize the Presenter by start retrieving the list
     */
    public void initialize() { this.loadListingList(); }
    /**
     * Loads all Listings
     */
    private void loadListingList() {
        this.hideViewRetry();
        this.showViewLoading();
        this.getListingList();
    }

    //TODO
    private void onListingClicked(PropertyListingModel propertyListingModel) {
        Log.d(TAG, "onListingClicked" + propertyListingModel.getTruncatedDescription());
       // this.viewListView.viewListing(propertyListingModel);
    }
    private void hideViewRetry() {
        this.viewListView.hideRetry();

    }

    private void showViewLoading() {
        this.viewListView.showLoading();
    }

    private void showViewRetry() {
        this.viewListView.showRetry();
    }

    private void hideViewLoading() {
        this.viewListView.hideLoading();
    }

    // TODO Verify this
    private void showErrorMessage(ErrorBundle errorBundle) {
        String errorMessage = ErrorMessageFactory.create(this.viewListView.context(),
                errorBundle.getException());
        this.viewListView.showError(errorMessage);
    }

    private void showListingsCollectionView(Collection<Listing> listingsCollection) {
        final Collection<PropertyTypeListingModel> listingsModelCollection =
                this.propertyListingModelDataMapper.transform(listingsCollection);
        this.viewListView.renderListingsList(listingsModelCollection);

    }

    private void getListingList() {
        this.getPropertyListingsListUseCase.execute(new ListingListObserver(), null);
    }

    private final class ListingListObserver extends DefaultObserver<List<Listing>> {

        @Override
        public void onNext(List<Listing> listings) {
            Log.d(TAG, "Retrieving listings with count = " + listings.size());
            PropertyListingsPresenter.this.showListingsCollectionView(listings);
        }

        @Override
        public void onComplete() {
            PropertyListingsPresenter.this.hideViewLoading();
        }

        @Override
        public void onError(Throwable exception) {
            PropertyListingsPresenter.this.hideViewLoading();
           // TODO fix this PropertyListingsPresenter.this.showErrorMessage(new DefaultErrorBundle( (Exception) ex));
            Log.d(TAG, "The Exception message thrown is " + exception.getMessage());
            PropertyListingsPresenter.this.showErrorMessage("Issue in Loading");
            PropertyListingsPresenter.this.showViewRetry();

        }
    }

    private void showErrorMessage(String s) {
        this.viewListView.showError(s);
    }


}
