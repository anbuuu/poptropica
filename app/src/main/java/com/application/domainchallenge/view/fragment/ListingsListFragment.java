package com.application.domainchallenge.view.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.application.domainchallenge.R;
import com.application.domainchallenge.internal.di.components.ListingComponent;
import com.application.domainchallenge.model.ListingModel;
import com.application.domainchallenge.presenter.ListingsListPresenter;
import com.application.domainchallenge.view.ListingsListView;
import com.application.domainchallenge.view.adapter.ListingsAdapter;
import com.application.domainchallenge.view.adapter.ListingsLayoutManager;

import java.util.Collection;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Fragment that shows a List of Articles.
 */

public class ListingsListFragment
        extends BaseFragment implements ListingsListView{

    private static final String TAG = ListingsListFragment.class.getSimpleName();
    @Inject
    ListingsListPresenter listingsListPresenter;

    @Inject
    ListingsAdapter listingsAdapter;

    @BindView(R.id.rv_property_listings)
    RecyclerView rv_property_listings;

    @BindView(R.id.rl_progress)
    RelativeLayout rl_progress;

    @BindView(R.id.btn_retry)
    Button btn_retry;

    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;

    private ListingListListener listingListListener;
    public ListingsListFragment() {
        // TODO Remove set retain and find the best practices for screen orientation
        setRetainInstance(true);
    }


    public static ListingsListFragment newInstance(int page) {
        Log.d(TAG, "### Entering newInstance()");
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        ListingsListFragment listingsListFragment = new ListingsListFragment();
        listingsListFragment.setArguments(args);
        return listingsListFragment;

    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if ( activity instanceof ListingListListener ) {
            this.listingListListener = ( ListingListListener ) activity;
        }

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "### Entering onCreate()");
        super.onCreate(savedInstanceState);
        this.getComponent(ListingComponent.class).inject(this);
        //mPage = getArguments().getInt(ARG_PAGE);

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment_property_listings,
                container, false);
       //Log.d(TAG, "The Position retrieved is " + mPage);
        ButterKnife.bind(this, fragmentView);
        setupRecyclerView();
        return fragmentView;


    }

    private void setupRecyclerView() {
        // TODO Setup Listener forItem Click this.listingsAdapter.setOnItemClick
        this.rv_property_listings.setAdapter(listingsAdapter);
        this.rv_property_listings.setLayoutManager(new ListingsLayoutManager(context()));

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.listingsListPresenter.setView(this);
        if ( savedInstanceState == null ) {
            this.loadPropertyList();
        }
    }

    private void loadPropertyList() {
        this.listingsListPresenter.initialize();
    }

    @Override
    public void onResume() {
        super.onResume();
        this.listingsListPresenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        this.listingsListPresenter.pause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        rv_property_listings.setAdapter(null);
        /*
        Unbinder unbinder;
in onCreateView you call

unbinder = Butterknife.bind(this, root);

and in onDestroyView you need to call

unbinder.unbind();
         */
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.listingsListPresenter.destroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.listingListListener = null;
    }

    @Override
    public void showLoading() {
        this.rl_progress.setVisibility(View.VISIBLE);
        this.getActivity().setProgressBarIndeterminateVisibility(true);
    }

    @Override
    public void hideLoading() {
        this.rl_progress.setVisibility(View.GONE);
        // TODO this is a deprecated method find alternative
        this.getActivity().setProgressBarIndeterminate(false);
    }

    @Override
    public void showRetry() {
        this.btn_retry.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideRetry() {
        this.btn_retry.setVisibility(View.GONE);
    }

    @Override
    public void showError(String message) {
        this.showToastMessage(message);
    }


    @Override
    public Context context() {
        return this.getActivity().getApplicationContext();
    }

    @Override
    public void renderListingsList(Collection<ListingModel> listingModelCollection) {
        if ( listingModelCollection != null ) {
            this.listingsAdapter.setListingsCollection(listingModelCollection);
        }
    }

    /**
     * Interface for listening User List Events
     */
    public interface ListingListListener {
        void onListingClicked(final ListingModel listingModel);
    }
}
