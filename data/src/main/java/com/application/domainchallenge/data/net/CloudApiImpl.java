package com.application.domainchallenge.data.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.application.domainchallenge.data.entity.PropertyResults;
import com.application.domainchallenge.data.entity.mapper.PropertyListingEntityJsonMapper;
import com.application.domainchallenge.data.exception.NetworkConnectionException;

import java.net.MalformedURLException;

import io.reactivex.Observable;

/**
 * {@link CloudApi} Implementation or retrieving data from Network
 */

public class CloudApiImpl implements CloudApi {

    private final Context context;
    private final PropertyListingEntityJsonMapper propertyListingEntityJsonMapper;
    private static final String TAG = CloudApiImpl.class.getSimpleName();

    public CloudApiImpl(Context context, PropertyListingEntityJsonMapper propertyListingEntityJsonMapper) {

        if ( context == null || propertyListingEntityJsonMapper == null) {
            throw new IllegalArgumentException("Constructor parameters cannot be null ");
        }
        this.context = context;
        this.propertyListingEntityJsonMapper = propertyListingEntityJsonMapper;
    }


    @Override
    public Observable<PropertyResults> propertyResultsObservable() {

        return Observable.create(emitter -> {
            if ( isThereInternetConnection()) {
                try {
                    String responseListingEntities = getPropertyResultsFromAPI();
                    Log.d(TAG, "the Response retrieved is " + responseListingEntities.toString());
                    if ( responseListingEntities != null) {
                        emitter.onNext(propertyListingEntityJsonMapper.transformListingEntityCollection(responseListingEntities));
                        emitter.onComplete();
                    }
                } catch ( Exception ex ) {
                    Log.d(TAG, "Exception thrown in CloudApiImpl::lisitngEntityList()");
                    emitter.onError(new NetworkConnectionException(ex.getCause()));
                }

            }
        });
    }

    private String getPropertyResultsFromAPI() throws MalformedURLException {
        return ApiConnection.createGET(DOMAIN_JSON_URL, context).requestSyncCall();
    }

    /**
     * Checks if the device has any active internet connection.
     *
     * @return true device with internet connection, otherwise false.
     */
    private boolean isThereInternetConnection() {
        boolean isConnected;

        ConnectivityManager connectivityManager =
                (ConnectivityManager) this.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        isConnected = (networkInfo != null && networkInfo.isConnectedOrConnecting());
        return isConnected;
    }

}
