package com.application.domainchallenge.data.entity.mapper;

import com.application.domainchallenge.data.entity.Example;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

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
    public Example transformListingEntityCollection(String listingJsonResponse)
            throws JsonSyntaxException {
        final Type listofExampleEntityType = new TypeToken<Example>() {}.getType();
        return this.gson.fromJson(listingJsonResponse, listofExampleEntityType);
    }

}
