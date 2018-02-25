package com.application.domainchallenge.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.application.domainchallenge.R;
import com.application.domainchallenge.model.ListingModel;
import com.bumptech.glide.Glide;

import java.util.List;

import javax.inject.Inject;

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


    public interface OnPropertyItemClickListener {
        void onPropertyItemClicked(Integer adId);
    }

    private OnPropertyItemClickListener onPropertyItemClickListener;

    @Inject
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

        Toast.makeText(mContext, "Toast. Test Message ", Toast.LENGTH_SHORT).show();


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

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Entering onClick with Data " + listingModel.getAdId() );
                if ( PropertyListItemDataAdapter.this.onPropertyItemClickListener != null ) {
                    Toast.makeText(mContext, "Item Clicked is " + listingModel.getAdId(), Toast.LENGTH_SHORT).show();
                    PropertyListItemDataAdapter.this.onPropertyItemClickListener.
                            onPropertyItemClicked(listingModel.getAdId());
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return (null != categoryItemList ? categoryItemList.size() : 0);

    }

    public void setOnPropertyItemClickListener(OnPropertyItemClickListener
                                                       onPropertyItemClickListener) {
        this.onPropertyItemClickListener = onPropertyItemClickListener;
    }

    public class StandardListingViewHolder extends BaseViewHolder {
       public StandardListingViewHolder(View itemView) {
            super(itemView);
        }
    }

    public class PremiumListingViewHolder extends BaseViewHolder {

        @BindView(R.id.listing_second_retina_thumbnail)
        ImageView iv_listing_image_elite;

        public PremiumListingViewHolder(View itemView) {
            super(itemView);
        }
    }

    public abstract class BaseViewHolder extends RecyclerView.ViewHolder {

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

        public BaseViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
