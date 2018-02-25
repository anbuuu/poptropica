package com.application.domainchallenge.data.net;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import io.reactivex.annotations.Nullable;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import static com.application.domainchallenge.data.net.ApiConstants.DEFAULT_CONNECT_TIMEOUT;
import static com.application.domainchallenge.data.net.ApiConstants.DEFAULT_READ_TIMEOUT;

/**
 * API connection class used to retrieve data from Cloud
 * Implements {@link Callable} so when executed async can
 * return a value
 */

public class ApiConnection implements Callable<String> {

    private static final String CONTENT_TYPE_LABEL = "Content-Type";
    private static final String CONTENT_TYPE_VALUE_JSON = "application/json; characterset=utf-8";
    private static final String TAG = ApiConnection.class.getSimpleName();

    private URL url;
    private String response;
    private Context mContext;


    private ApiConnection(String url, Context context) throws MalformedURLException {
        this.mContext = context;
        this.url = new URL(url);
    }

    static ApiConnection createGET(String url, Context context) throws MalformedURLException {
        return new ApiConnection(url, context);
    }

    /**
     * Do a Request to an api synchronously
     * @return A String response
     * @throws Exception
     */
    @Nullable
    String requestSyncCall() {
        connectToApi();
        return response;
    }

    private void connectToApi() {
        OkHttpClient okHttpClient = this.createClient();


        final Request request = new Request.Builder()
                .url(this.url)
                .addHeader(CONTENT_TYPE_LABEL, CONTENT_TYPE_VALUE_JSON)
                .get()
                .build();

        try {
            this.response = okHttpClient.newCall(request).execute().body().string();
        } catch ( IOException ex) {
            ex.printStackTrace();
        }
    }

    private OkHttpClient createClient() {

        File cacheDir;
        Cache cache = null;

        try {
            cacheDir = new File(mContext.getCacheDir(), "http");
            cache = new Cache(cacheDir, ApiConstants.CACHE_SIZE);
        } catch ( Exception ex ) {
            Log.e(TAG, "Cannot Create Cache File");
        }

        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                                        .cache(cache)
                                        .addInterceptor(new ResponseCacheInterceptor())
                                        .connectTimeout(DEFAULT_CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
                                        .readTimeout(DEFAULT_READ_TIMEOUT, TimeUnit.MILLISECONDS)
                                        .followSslRedirects(true)
                                        .build();

        return okHttpClient;
    }

    @Override
    public String call() throws Exception {
        return requestSyncCall();
    }

    /**
     * Interceptor to cache data and maintain it for a minute.
     *
     * If the same network request is sent within a minute,
     * the response is retrieved from cache.
     */
    private static class ResponseCacheInterceptor implements Interceptor {
        @Override
        public okhttp3.Response intercept(Chain chain) throws IOException {
            okhttp3.Response originalResponse = chain.proceed(chain.request());
            return originalResponse.newBuilder()
                    .header("Cache-Control", "public, max-age=" + 60)
                    .build();
        }
    }

}
