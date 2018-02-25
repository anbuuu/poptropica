package com.application.domainchallenge.data.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.application.domainchallenge.data.entity.Example;
import com.application.domainchallenge.data.entity.mapper.ListingEntityJsonMapper;
import com.application.domainchallenge.data.exception.NetworkConnectionException;

import java.net.MalformedURLException;

import io.reactivex.Observable;

/**
 * Created by anbu.ezhilan on 15/2/18.
 */

public class RestApiImpl implements RestApi {

    private final Context context;
    private final ListingEntityJsonMapper listingEntityJsonMapper;
    private static final String TAG = RestApiImpl.class.getSimpleName();

    public RestApiImpl(Context context, ListingEntityJsonMapper listingEntityJsonMapper) {

        if ( context == null || listingEntityJsonMapper == null) {
            // TODO Change the Exception Text
            throw new IllegalArgumentException("The Constructor Parameters cannot be null ");
        }
        this.context = context;
        this.listingEntityJsonMapper = listingEntityJsonMapper;
    }


    @Override
    //public Observable<List<ListingEntity>> listingEntityList() {
    public Observable<Example> listingEntityList() {

        return Observable.create(emitter -> {
            if ( isThereInternetConnection()) {
                try {
                    String responseListingEntities = getListingEntitiesFromApi();
                    Log.d(TAG, "the Response retrieved is " + responseListingEntities.toString());
                    if ( responseListingEntities != null) {
                        emitter.onNext(listingEntityJsonMapper.transformListingEntityCollection(responseListingEntities));
                        emitter.onComplete();
                    }
                } catch ( Exception ex ) {
                    Log.d(TAG, "Exception thrown in RestApiImpl::lisitngEntityList()");
                    emitter.onError(new NetworkConnectionException(ex.getCause()));
                }

            }
        });
    }

    private String getListingEntitiesFromApi() throws MalformedURLException {
        return ApiConnection.createGET(API_DOMAIN_URL, context).requestSyncCall();
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
