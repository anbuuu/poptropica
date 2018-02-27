package com.application.domainchallenge.data.cache.serializer;

import com.google.gson.Gson;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * JSON DataSerializer / De DataSerializer.
 */

@Singleton
public class DataSerializer {

    private final Gson gson = new Gson();

    @Inject
    DataSerializer() {}

    /**
     * Serialize an Object to JSON
    */
    public String serialize(Object object, Class clazz) {
        return gson.toJson(object, clazz);
    }
    /**
     * De Serialize the JSON Object
     */
    public <T> T deserialize(String string, Class<T> clazz) {
        return gson.fromJson(string, clazz);
    }

}
