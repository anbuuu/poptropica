package com.application.domainchallenge.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
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
import com.application.domainchallenge.internal.di.components.PropertyListingComponent;
import com.application.domainchallenge.model.PropertyTypeListingModel;
import com.application.domainchallenge.presenter.PropertyListingsPresenter;
import com.application.domainchallenge.view.ListingsListView;
import com.application.domainchallenge.view.adapter.PropertyListItemDataAdapter;
import com.application.domainchallenge.view.adapter.PropertyTypeListAdapter;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.annotations.Nullable;

/**
 * Fragment that shows two horizontal list views of Properties based upon the Property type
 */

public class PropertyListingsFragment extends BaseFragment implements
        ListingsListView, SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG = PropertyListingsFragment.class.getSimpleName();

    @Inject
    PropertyListingsPresenter propertyListingsPresenter;

    @Inject
    PropertyTypeListAdapter categoryListDataAdapter;

    //@Inject
   // PropertyListItemDataAdapter categoryItemListDataAdapter;


    @BindView(R.id.rl_progress)
    RelativeLayout rl_progress;

    @BindView(R.id.btn_retry)
    Button btn_retry;

    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private ArrayList<PropertyTypeListingModel> categoryList;
    Unbinder unbinder;
    private Parcelable list_state;
    public final static String LIST_STATE_KEY = "recycler_list_state";


    private LinearLayoutManager mLayoutManager;

    public PropertyListingsFragment() {
        // TODO Remove set retain and find the best practices for screen orientation
        setRetainInstance(true);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(PropertyListingComponent.class).inject(this);

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

        unbinder = ButterKnife.bind(this, view);
        refreshLayout.setOnRefreshListener(this);
        recyclerView.setAdapter(categoryListDataAdapter);
        mLayoutManager = new LinearLayoutManager(context(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        this.propertyListingsPresenter.setView(this);
        //this.categoryItemListDataAdapter.setOnPropertyItemClickListener(onPropertyItemClickListener);
        recyclerView.setSaveEnabled(true);
        if (savedInstanceState == null) {
            this.loadPropertyList();
        }
    }

    public void loadPropertyList() {
        this.propertyListingsPresenter.initialize();
    }

    @Override
    public void onResume() {
        super.onResume();
        this.propertyListingsPresenter.resume();
        if ( list_state != null ) {
            mLayoutManager.onRestoreInstanceState(list_state);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        this.propertyListingsPresenter.pause();
        list_state = recyclerView.getLayoutManager().onSaveInstanceState();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        recyclerView.setAdapter(null);
        unbinder.unbind();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        this.propertyListingsPresenter.destroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void showLoading() {
        refreshLayout.setRefreshing(true);
    }

    @Override
    public void hideLoading() {
        refreshLayout.setRefreshing(false);
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

   /* @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.d(TAG, "Entering onSavedInstanceState");
        super.onSaveInstanceState(outState);
        list_state = recyclerView.getLayoutManager().onSaveInstanceState();
        outState.putParcelable(LIST_STATE_KEY, list_state);
       // outState.putParcelableArrayList(LIST_STATE_KEY, relatedRows);
    }*/

    private PropertyListItemDataAdapter.OnPropertyItemClickListener onPropertyItemClickListener =
            new PropertyListItemDataAdapter.OnPropertyItemClickListener() {
                @Override
                public void onPropertyItemClicked(final Integer adId) {
                    Log.d(TAG, "Entering onPropertyItemClicked on Fragment " + adId);
                    //Toast.makeText()
                }
            };


}
