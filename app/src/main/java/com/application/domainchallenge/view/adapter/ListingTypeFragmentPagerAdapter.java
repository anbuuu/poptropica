package com.application.domainchallenge.view.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.application.domainchallenge.view.fragment.ListingsListFragment;


public class ListingTypeFragmentPagerAdapter extends FragmentPagerAdapter {


    private final static String TAG = ListingTypeFragmentPagerAdapter.class.getSimpleName();
    private final int PAGE_COUNT = 2;
    private String tabTitles[] = new String[] {"Standard", "Premium"}; // TODO move to constants
    private Context mContext;

    public ListingTypeFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.mContext = context;
    }

    @Override
    public long getItemId(int position) {
        Log.d(TAG, "Entering getITemId with Position " + position);

        return super.getItemId(position);
    }

    @Override
    public Fragment getItem(int position) {
        Log.d(TAG, "Entering getITem with Position " + position);


            return ListingsListFragment.newInstance(position);


    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}

