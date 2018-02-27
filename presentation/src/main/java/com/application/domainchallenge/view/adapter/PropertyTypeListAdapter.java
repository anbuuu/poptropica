package com.application.domainchallenge.view.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.application.domainchallenge.R;
import com.application.domainchallenge.model.ListingModel;
import com.application.domainchallenge.model.PropertyTypeListingModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Adapter that manages a collection of {@link PropertyTypeListingModel}
 */

public class PropertyTypeListAdapter extends RecyclerView.Adapter<PropertyTypeListAdapter.PropertyTypeListItemRowHolder> {

    private Context mContext;
    private final String TAG = PropertyTypeListAdapter.class.getSimpleName();
    private List<PropertyTypeListingModel> listingsCollection;
    SnapHelper snapHelper = new LinearSnapHelper();

    // TODO move the Arraylist to a ListingEntity Type Class
    @Inject
    public PropertyTypeListAdapter(Context context) {

        this.mContext = context;
        this.listingsCollection = Collections.emptyList();
    }

    @Override
    public PropertyTypeListItemRowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, null);
        return new PropertyTypeListItemRowHolder(v);
    }

    @Override
    public void onBindViewHolder(PropertyTypeListItemRowHolder holder, int position) {

        final String sectionName = this.listingsCollection.get(position).getCategory();

        Log.d(TAG, "The Section Name is " + sectionName);
        List<ListingModel> singleSectionItems = (List<ListingModel>) this.listingsCollection.get(position).getItems();
        holder.itemTitle.setText(sectionName);

        PropertyListItemDataAdapter propertyListItemDataAdapter = new
                PropertyListItemDataAdapter(mContext, singleSectionItems, sectionName);

        holder.recycler_view_list.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false ));
        holder.recycler_view_list.setAdapter(propertyListItemDataAdapter);
        holder.recycler_view_list.setNestedScrollingEnabled(false);
        holder.recycler_view_list.setSaveEnabled(true);


        snapHelper.attachToRecyclerView(holder.recycler_view_list);



        holder.recycler_view_list.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        // Disallow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(true);
                        break;
                    case MotionEvent.ACTION_UP:
                        //Allow ScrollView to intercept touch events once again.
                        v.getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                }
                // Handle RecyclerView touch events.
                v.onTouchEvent(event);
                return true;
            }
        });


    }

    @Override
    public int getItemCount() {
        return (null != listingsCollection ? listingsCollection.size() : 0);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public void setListingsCollection(Collection<PropertyTypeListingModel> listingsCollection) {
        Log.d(TAG, "Entering setListingsCollection with Listings Collection " + listingsCollection.size());

        this.validateListingsCollection(listingsCollection);
        this.listingsCollection = (ArrayList<PropertyTypeListingModel>) listingsCollection;
        this.notifyDataSetChanged();

    }

    private void validateListingsCollection(Collection<PropertyTypeListingModel> listingsCollection) {
        if ( listingsCollection == null ) {
            throw new IllegalArgumentException("Property Listings Cannot be Null");
        }
    }



    public class PropertyTypeListItemRowHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.categoryHeader)
        TextView itemTitle;

        @BindView(R.id.recycler_view_list)
        RecyclerView recycler_view_list;

        public PropertyTypeListItemRowHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }


    }
}
