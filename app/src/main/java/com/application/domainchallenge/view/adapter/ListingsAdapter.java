package com.application.domainchallenge.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.application.domainchallenge.R;
import com.application.domainchallenge.model.ListingModel;
import com.bumptech.glide.Glide;

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
    private Context mContext;

    private OnItemClickListener onItemClickListener;

    @Inject
    ListingsAdapter(Context context) {
        this.layoutInflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.listingsCollection = Collections.emptyList();
        this.mContext = context;
    }

    @Override
    public int getItemCount() {
        return (this.listingsCollection != null) ? this.listingsCollection.size() : 0;
    }

    @Override
    public ListingsAdapter.ListingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Create the View
        //final View view = this.layoutInflater.inflate(R.layout.row_listing_normal, parent, false);
        // if isElite is true .. then another layout
        final View view = this.layoutInflater.inflate(R.layout.row_listing_elite, parent, false);
        return new ListingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListingsAdapter.ListingViewHolder holder, int position) {
     /*   Log.d(TAG, "Entering onBindViewHolder with  " +
            this.listingsCollection.get(position).getTruncatedDescription());*/
        final ListingModel listingModel = this.listingsCollection.get(position);
        Glide.with(mContext)
                .load(listingModel.getRetinaDisplayThumbUrl())
                .fitCenter()
                .into(holder.iv_listing_image_normal);
        holder.tv_listing_price.setText(listingModel.getDisplayPrice());
        // combine bedrooms, bathrooms and Car space together
        String concHouseRooms = listingModel.getBedrooms() + " bed " + listingModel.getBathrooms()
                + " bath " + listingModel.getCarspaces() + " car ";
        Log.d(TAG, "The values are " + concHouseRooms + " "  + listingModel.getDisplayPrice()
                +  " " + listingModel.getDisplayableAddress());
        holder.tv_total_rooms.setText(concHouseRooms);
        holder.tv_listing_address.setText(listingModel.getDisplayableAddress());
        Glide.with(mContext)
                .load(listingModel.getAgencyLogoUrl())
                .centerCrop()
                .into(holder.iv_agency_logo);

        Glide.with(mContext)
                .load(listingModel.getSecondRetinaDisplayThumbUrl())
                .fitCenter()
                .into(holder.iv_listing_image_elite);




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

        @BindView(R.id.listing_price)
        TextView tv_listing_price;

        @BindView(R.id.total_rooms)
        TextView tv_total_rooms;

        @BindView(R.id.listing_address)
        TextView tv_listing_address;

        @BindView(R.id.listing_first_retina_thumbnail)
        ImageView iv_listing_image_normal;

        @BindView(R.id.agency_logo)
        ImageView iv_agency_logo;

        @BindView(R.id.listing_second_retina_thumbnail)
        ImageView iv_listing_image_elite;

        public ListingViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
