package com.application.domainchallenge.exception;

import android.content.Context;

import com.application.domainchallenge.R;
import com.application.domainchallenge.data.exception.PropertyListingNotFoundException;
import com.application.domainchallenge.data.exception.NetworkConnectionException;

/**
 * Factory used to create Error messages from an Exception as a condition
 */

public class ErrorMessageFactory {

    private ErrorMessageFactory() {}
    /**
     * Creates a String representing a error message
     *
     * @param context Context needed to retrieve String resources
     * @param exception An exception used as a condition to retrieve the correct Error message
     * @return {@link String} an error message
     */
    public static String create(Context context, Exception exception) {

        String errorMessage = context.getString(R.string.exception_message_generic);

        if ( exception instanceof NetworkConnectionException) {
            errorMessage = context.getString(R.string.exception_message_no_connection);
        } else if ( exception instanceof PropertyListingNotFoundException) {
            errorMessage = context.getString(R.string.exception_message_listing_not_found);
        }
        return errorMessage;
    }
}
