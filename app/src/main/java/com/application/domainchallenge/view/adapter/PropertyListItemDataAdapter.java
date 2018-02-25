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

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by anbu.ezhilan on 25/2/18.
 */

public class PropertyListItemDataAdapter extends RecyclerView.Adapter  {



    private List<ListingModel> categoryItemList;
    private Context mContext;
    private String categoryName;
    private static final String TAG = PropertyListItemDataAdapter.class.getSimpleName();

    public PropertyListItemDataAdapter(Context context, List<ListingModel> singleSectionItems, String sectionName) {
        this.categoryItemList = singleSectionItems;
        this.mContext = context;
        this.categoryName = sectionName;

    }


    @Override
    public int getItemViewType(int position) {
        return position;
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        Log.d(TAG, "Entering onCreateView Holder with View Type " + viewType);



        final View view;
        if ( categoryName.equalsIgnoreCase("STANDARD")) {
            view = inflater.inflate(R.layout.row_listing_normal, null );
            viewHolder = new StandardListingViewHolder(view);




        } else if ( categoryName.equalsIgnoreCase("PREMIUM")) {
            view = inflater.inflate(R.layout.row_listing_elite, null );
            viewHolder = new PremiumListingViewHolder(view);

        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {

        final ListingModel listingModel = categoryItemList.get(position);
        Log.d(TAG, "Enteirng onBindViewHolder with desc " +
                listingModel.getTruncatedDescription());



        if ( holder instanceof StandardListingViewHolder) {
            Log.d(TAG, "AAA Standard Listing View Holder instance ");

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
        } else if ( holder instanceof PremiumListingViewHolder ) {
            Log.d(TAG, "AAA premium Listing View Holder instance ");
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


    }

    @Override
    public int getItemCount() {
        return (null != categoryItemList ? categoryItemList.size() : 0);

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
