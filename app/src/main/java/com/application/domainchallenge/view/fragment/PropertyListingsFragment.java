package com.application.domainchallenge.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.application.domainchallenge.R;
import com.application.domainchallenge.internal.di.components.ListingComponent;
import com.application.domainchallenge.model.PropertyTypeListingModel;
import com.application.domainchallenge.presenter.ListingsListPresenter;
import com.application.domainchallenge.view.ListingsListView;
import com.application.domainchallenge.view.adapter.PropertyTypeListAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.annotations.Nullable;

/**
 * Created by anbu.ezhilan on 25/2/18.
 */

public class PropertyListingsFragment extends BaseFragment implements
        ListingsListView, SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG = PropertyListingsFragment.class.getSimpleName();
    @Inject
    ListingsListPresenter listingsListPresenter;

    @Inject
    PropertyTypeListAdapter categoryListDataAdapter;

//    @BindView(R.id.rv_property_listings)
//    RecyclerView rv_property_listings;

    @BindView(R.id.rl_progress)
    RelativeLayout rl_progress;

    @BindView(R.id.btn_retry)
    Button btn_retry;

    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;

    private List<List<String>> propertyType = new ArrayList<>();

    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;


    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private ArrayList<PropertyTypeListingModel> categoryList;

    private LinearLayoutManager mLayoutManager;

    //private ListingsListFragment.ListingListListener listingListListener;
    public PropertyListingsFragment() {
        // TODO Remove set retain and find the best practices for screen orientation
        setRetainInstance(true);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Log.d(TAG, "### Entering onCreate()");
        this.getComponent(ListingComponent.class).inject(this);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @android.support.annotation.Nullable ViewGroup container,
                             Bundle savedInstanceState) {

        final View fragmentListingsView = inflater.inflate(R.layout.fragment_category_list,
                container, false);

        return fragmentListingsView;

    }



    @Override
    public void onViewCreated(View view, @android.support.annotation.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);

        refreshLayout.setOnRefreshListener(this);
        recyclerView.setAdapter(categoryListDataAdapter);
        mLayoutManager = new LinearLayoutManager(context(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        this.listingsListPresenter.setView(this);
        recyclerView.setSaveEnabled(true);
        if (savedInstanceState == null) {
            this.loadPropertyList();
        }
    }

    public void loadPropertyList() {
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
        recyclerView.setAdapter(null);
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
        //this.listingListListener = null;
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
    public void onRefresh() {
        this.loadPropertyList();
    }


    @Override
    public Context context() {
        return this.getActivity().getApplicationContext();
    }

    @Override
    public void renderListingsList(Collection<PropertyTypeListingModel> listingModelCollection) {
        if ( listingModelCollection != null ) {
            this.categoryListDataAdapter.setListingsCollection(listingModelCollection);
        }

    }

}
