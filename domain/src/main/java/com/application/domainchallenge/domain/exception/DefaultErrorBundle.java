package com.application.domainchallenge.domain.exception;

/**
 *
 * Wrapper around exceptions used to manage Default Errors
 *
 */

public class DefaultErrorBundle implements ErrorBundle {
    private static final String DEFAULT_ERROR_MSG = "Unknown_Error";

    private final Exception exception;

    public DefaultErrorBundle(Exception exception) {
        this.exception = exception;
    }

    @Override
    public Exception getException() {
        return exception;
    }

    @Override
    public String getErrorMessage() {
        return ( exception != null ? this.exception.getMessage() : DEFAULT_ERROR_MSG);
    }
}
