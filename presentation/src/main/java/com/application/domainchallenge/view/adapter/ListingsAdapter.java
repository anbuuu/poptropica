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
import com.application.domainchallenge.model.PropertyTypeListingModel;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Adapter that manages a Collection of {@link com.application.domainchallenge.model.ListingModel}
 */

public class ListingsAdapter extends RecyclerView.Adapter {


    private static final String TAG = ListingsAdapter.class.getSimpleName();
    private int mViewType;

    public interface OnItemClickListener {
        void onUserItemClicked(ListingModel listingModel);
    }

    private final int STANDARD = 0, PREMIUM = 1;
    private List<PropertyTypeListingModel> listingsCollection;
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
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Create the View
        //final View view = this.layoutInflater.inflate(R.layout.row_listing_normal, parent, false);
        // if isElite is true .. then another layout

        // TODO Check this null condition
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        Log.d(TAG, "Entering onCreateViewHolder() with View Type " + viewType);
        // Two different layouts based upon the viewtype
        final View view;
        switch(viewType) {
            case STANDARD:
                // Standard Layout
                //TODO change v1
                View v1 = inflater.inflate(R.layout.row_listing_normal, parent, false);
                viewHolder = new StandardListingViewHolder(v1);
                break;

            case PREMIUM:
                View v2 = inflater.inflate(R.layout.row_listing_elite, parent, false);
                viewHolder = new PremiumListingViewHolder(v2);
                break;
                //TODO Check whether you need Default
        }

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {


        //Log.d(TAG, "Entering onBindViewHolder with  " +
          //      this.listingsCollection.get(position).getTruncatedDescription());

        // TODO Check for listing Model notnull


        //final ListingModel listingModel = this.listingsCollection.get(position);

        // Extend from a abstract listingview holder like STandard and extend to premium
       /* if ( holder instanceof StandardListingViewHolder) {
            Log.d(TAG, "AAA Standard ListingEntity View Holder instance ");

            Glide.with(mContext)
                    .load(listingModel.getRetinaDisplayThumbUrl())
                    .fitCenter()
                    .into(((StandardListingViewHolder) holder).iv_listing_image_normal);

            ((StandardListingViewHolder) holder).tv_listing_price.setText(listingModel.getDisplayPrice());
            // combine bedrooms, bathrooms and Car space together
            String concHouseRooms = listingModel.getBedrooms() + " bed " + listingModel.getBathrooms()
                    + " bath " + listingModel.getCarspaces() + " car ";
            Log.d(TAG, "The values are " + concHouseRooms + " "  + listingModel.getDisplayPrice()
                    +  " " + listingModel.getDisplayableAddress());
            ((StandardListingViewHolder) holder).tv_total_rooms.setText(concHouseRooms);
            ((StandardListingViewHolder) holder).tv_listing_address.setText(listingModel.getDisplayableAddress());
            Glide.with(mContext)
                    .load(listingModel.getAgencyLogoUrl())
                    .centerCrop()
                    .into(((StandardListingViewHolder) holder).iv_agency_logo);

        } else if ( holder instanceof  PremiumListingViewHolder) {
            Log.d(TAG, "AAA premium ListingEntity View Holder instance ");
            Glide.with(mContext)
                    .load(listingModel.getRetinaDisplayThumbUrl())
                    .fitCenter()
                    .into(((PremiumListingViewHolder) holder).iv_listing_image_normal);

            ((PremiumListingViewHolder) holder).tv_listing_price.setText(listingModel.getDisplayPrice());
            // combine bedrooms, bathrooms and Car space together
            String concHouseRooms = listingModel.getBedrooms() + " bed " + listingModel.getBathrooms()
                    + " bath " + listingModel.getCarspaces() + " car ";
            Log.d(TAG, "The values are " + concHouseRooms + " "  + listingModel.getDisplayPrice()
                    +  " " + listingModel.getDisplayableAddress());
            ((PremiumListingViewHolder) holder).tv_total_rooms.setText(concHouseRooms);
            ((PremiumListingViewHolder) holder).tv_listing_address.setText(listingModel.getDisplayableAddress());
            Glide.with(mContext)
                    .load(listingModel.getAgencyLogoUrl())
                    .centerCrop()
                    .into(((PremiumListingViewHolder) holder).iv_agency_logo);

            Glide.with(mContext)
                    .load(listingModel.getSecondRetinaDisplayThumbUrl() )
                    .fitCenter()
                    .into(((PremiumListingViewHolder) holder).iv_listing_image_elite);
        }

        
        // TODO set Click Listener
        if ( ListingsAdapter.this.onItemClickListener != null) {
            Log.d(TAG, "On Item Clicked " + listingModel.getTruncatedDescription());
        } */
    }

    @Override
    public int getItemViewType(int position) {
        Log.d(TAG, "Entering getItemViewType with position " + position);

        if ( mViewType == 1) {
            return PREMIUM;
        }
        else {
            return STANDARD;
        }

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /*public void setListingsCollection(Collection<ListingModel> listingsCollection) {
        Log.d(TAG, "Entering setListingsCollection with listingsCollection  " + listingsCollection.size());
        this.validateListingsCollection(listingsCollection);
        this.listingsCollection = (List<ListingModel>) listingsCollection;
        this.notifyDataSetChanged();

    }*/

    public void setListingsCollection(Collection<PropertyTypeListingModel> listingsCollection) {
        Log.d(TAG, "Entering setListingsCollection with listingsCollection  " + listingsCollection.size());
        this.validateListingsCollection(listingsCollection);
        this.listingsCollection = (List<PropertyTypeListingModel>) listingsCollection;
        this.notifyDataSetChanged();

    }


    /*TODO.. Set on Item Click Listener
    public void setOnItemClickListener (OnItemClickListener onItemClickListener) {
    this.onItemClickListener = onItemClickListener;
  }
     */

    private void validateListingsCollection(Collection<PropertyTypeListingModel> listingModelCollection) {
        if ( listingModelCollection == null ) {
            throw new IllegalArgumentException("Property Listings cannot be null");
        }
    }

    public void setViewType(int viewType) {
        mViewType = viewType;
    }

    public static class StandardListingViewHolder extends RecyclerView.ViewHolder{

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

        // TODO Will need two different View Holders because of the following
        // issue that second_retina... has to be commented
        // if normal viewing takes place

     /*   @BindView(R.id.listing_second_retina_thumbnail)
        ImageView iv_listing_image_elite;*/

        public StandardListingViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


    public static class PremiumListingViewHolder extends RecyclerView.ViewHolder{

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

        public PremiumListingViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
