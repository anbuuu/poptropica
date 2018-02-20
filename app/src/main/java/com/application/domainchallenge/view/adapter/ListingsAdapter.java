package com.application.domainchallenge.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.application.domainchallenge.R;
import com.application.domainchallenge.model.ListingModel;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Adapter that manages a Collection of {@link com.application.domainchallenge.model.ListingModel}
 */

public class ListingsAdapter extends RecyclerView.Adapter<ListingsAdapter.ListingViewHolder> {


    private static final String TAG = ListingsAdapter.class.getSimpleName();

    public interface OnItemClickListener {
        void onUserItemClicked(ListingModel listingModel);
    }

    private List<ListingModel> listingsCollection;
    private final LayoutInflater layoutInflater;

    private OnItemClickListener onItemClickListener;

    @Inject
    ListingsAdapter(Context context) {
        this.layoutInflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.listingsCollection = Collections.emptyList();
    }

    @Override
    public int getItemCount() {
        return (this.listingsCollection != null) ? this.listingsCollection.size() : 0;
    }

    @Override
    public ListingsAdapter.ListingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Create the View
        final View view = this.layoutInflater.inflate(R.layout.row_listing, parent, false);
        return new ListingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListingsAdapter.ListingViewHolder holder, int position) {
        Log.d(TAG, "Entering onBindViewHolder with  " +
            this.listingsCollection.get(position).getTruncatedDescription());
        final ListingModel listingModel = this.listingsCollection.get(position);
        holder.textViewItemTitle.setText(listingModel.getTruncatedDescription());
        // TODO set Click Listener
        if ( ListingsAdapter.this.onItemClickListener != null) {
            Log.d(TAG, "On Item Clicked " + listingModel.getTruncatedDescription());
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setListingsCollection(Collection<ListingModel> listingsCollection) {
        Log.d(TAG, "Entering setListingsCollection with listingsCollection  " + listingsCollection.size());
        this.validateListingsCollection(listingsCollection);
        this.listingsCollection = (List<ListingModel>) listingsCollection;
        this.notifyDataSetChanged();

    }

    /*TODO.. Set on Item Click Listener
    public void setOnItemClickListener (OnItemClickListener onItemClickListener) {
    this.onItemClickListener = onItemClickListener;
  }
     */

    private void validateListingsCollection(Collection<ListingModel> listingModelCollection) {
        if ( listingModelCollection == null ) {
            throw new IllegalArgumentException("Property Listings cannot be null");
        }
    }

    static class ListingViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.title)
        TextView textViewItemTitle;

        public ListingViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
