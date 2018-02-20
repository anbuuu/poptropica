package com.application.domainchallenge.data.entity.mapper;

import com.application.domainchallenge.data.entity.Example;
import com.application.domainchallenge.data.entity.ListingEntity;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import javax.inject.Inject;

/**
 * Class used to transform from Strings representing Json to Valid Objects
 */

public class ListingEntityJsonMapper {


    private final Gson gson;
    private final static String TAG = ListingEntityJsonMapper.class.getSimpleName();

    @Inject
    public ListingEntityJsonMapper() {
        this.gson = new Gson();
    }
    /**
     * Transforms from Valid Json String to List of {@link com.application.domainchallenge.data.entity.ListingEntity}
     *
     * @param listingJsonResponse A Json representing
     * @return List of {@link com.application.domainchallenge.data.entity.ListingEntity}
     * @throws com.google.gson.JsonSyntaxException if the
     * json string is not a valid structure
     */
    //public List<ListingEntity> transformListingEntityCollection(String listingJsonResponse)
    public Example transformListingEntityCollection(String listingJsonResponse)
            throws JsonSyntaxException {
        // This is not listing type .. this is the top level

        final Type listofExampleEntityType = new TypeToken<Example>() {}.getType();

        final Type listOfListingsEntityType = new TypeToken<List<ListingEntity>>() {}.getType();
        return this.gson.fromJson(listingJsonResponse, listofExampleEntityType);
        /*Collection<ListingEntity> enums = gson.fromJson(listingJsonResponse, listOfListingsEntityType);


        for (Iterator<ListingEntity> listingsIterator = enums.iterator(); listingsIterator.hasNext();) {
            Log.d(TAG, "Iterator Value is " + listingsIterator.next());
        }
        return this.gson.fromJson(listingJsonResponse, listOfListingsEntityType);*/
    }

}
