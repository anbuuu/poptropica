package com.application.domainchallenge.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.application.domainchallenge.domain.Listing;
import com.application.domainchallenge.domain.exception.ErrorBundle;
import com.application.domainchallenge.domain.interactor.DefaultObserver;
import com.application.domainchallenge.domain.interactor.GetListingsList;
import com.application.domainchallenge.exception.ErrorMessageFactory;
import com.application.domainchallenge.internal.di.PerActivity;
import com.application.domainchallenge.mapper.ListingModelDataMapper;
import com.application.domainchallenge.model.ListingModel;
import com.application.domainchallenge.view.ListingsListView;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by anbu.ezhilan on 18/2/18.
 */

@PerActivity
public class ListingsListPresenter implements Presenter {

    private ListingsListView viewListView;

    private final GetListingsList getListingsListUseCase;
    private final ListingModelDataMapper listingModelDataMapper;
    private static final String TAG = ListingsListPresenter.class.getSimpleName();

    @Inject
    public ListingsListPresenter(GetListingsList getListingsListUseCase, ListingModelDataMapper listingModelDataMapper) {
        this.getListingsListUseCase = getListingsListUseCase;
        this.listingModelDataMapper = listingModelDataMapper;
    }

    public void setView(@NonNull ListingsListView view) { this.viewListView = view; }

    @Override
    public void resume() { }

    @Override
    public void pause() { }

    @Override
    public void destroy() {
        this.getListingsListUseCase.dispose();
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

    private void onListingClicked(ListingModel listingModel ) {
        Log.d(TAG, "onListingClicked" + listingModel.getTruncatedDescription());
       // this.viewListView.viewListing(listingModel);
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

    private void showErrorMessage(ErrorBundle errorBundle) {
        String errorMessage = ErrorMessageFactory.create(this.viewListView.context(),
                errorBundle.getException());
        this.viewListView.showError(errorMessage);
    }

    private void showListingsCollectionView(Collection<Listing> listingsCollection) {
        final Collection<ListingModel> listingsModelCollection =
                this.listingModelDataMapper.transform(listingsCollection);
        this.viewListView.renderListingsList(listingsModelCollection);
    }

    private void getListingList() {
        this.getListingsListUseCase.execute(new ListingListObserver(), null);
    }

    private final class ListingListObserver extends DefaultObserver<List<Listing>> {

        @Override
        public void onNext(List<Listing> listings) {
            Log.d(TAG, "Retrieving listings with count = " + listings.size());
            ListingsListPresenter.this.showListingsCollectionView(listings);
        }

        @Override
        public void onComplete() {
            ListingsListPresenter.this.hideViewLoading();
        }

        @Override
        public void onError(Throwable exception) {
            ListingsListPresenter.this.hideViewLoading();
           // TODO fix this ListingsListPresenter.this.showErrorMessage(new DefaultErrorBundle( (Exception) ex));
            Log.d(TAG, "The Exception message thrown is " + exception.getMessage());
            ListingsListPresenter.this.showErrorMessage("Issue in Loading");
            ListingsListPresenter.this.showViewRetry();

        }
    }

    private void showErrorMessage(String s) {
        this.viewListView.showError(s);
    }


}
