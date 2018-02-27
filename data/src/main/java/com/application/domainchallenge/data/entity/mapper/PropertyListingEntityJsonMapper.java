package com.application.domainchallenge.data.entity.mapper;

import com.application.domainchallenge.data.entity.PropertyResults;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import javax.inject.Inject;

/**
 * Class used to transform from Strings representing Json to Valid Objects
 */

public class PropertyListingEntityJsonMapper {


    private final Gson gson;
    private final static String TAG = PropertyListingEntityJsonMapper.class.getSimpleName();

    @Inject
    public PropertyListingEntityJsonMapper() {
        this.gson = new Gson();
    }
    /**
     * Transforms from Valid Json String to List of {@link com.application.domainchallenge.data.entity.ListingEntity}
     *
     * @param listingJsonResponse A Json representing
     * @return {@link PropertyResults}
     * @throws com.google.gson.JsonSyntaxException if the
     * json string is not a valid structure
     */
    public PropertyResults transformListingEntityCollection(String listingJsonResponse)
            throws JsonSyntaxException {
        final Type listofExampleEntityType = new TypeToken<PropertyResults>() {}.getType();
        return this.gson.fromJson(listingJsonResponse, listofExampleEntityType);
    }

}
