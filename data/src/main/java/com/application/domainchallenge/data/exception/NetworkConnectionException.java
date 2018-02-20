package com.application.domainchallenge.data.exception;

/**
 * Exception throw by the application when there is a Network Connection Exception
 */

public class NetworkConnectionException extends Exception {

    public NetworkConnectionException() { super(); }

    public NetworkConnectionException(final Throwable cause ) {
        super(cause);
    }
}
