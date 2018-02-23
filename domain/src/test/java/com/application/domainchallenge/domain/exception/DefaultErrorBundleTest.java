package com.application.domainchallenge.domain.exception;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

/**
 * Created by anbu.ezhilan on 23/2/18.
 */

@RunWith(MockitoJUnitRunner.class)
public class DefaultErrorBundleTest {

    private DefaultErrorBundle defaultErrorBundle;

    @Mock
    private Exception mockException;

    @Before
    public void setUp() {
        defaultErrorBundle = new DefaultErrorBundle(mockException);
    }

    @Test
    public void testGetErrorMessageInteraction() {
        defaultErrorBundle.getErrorMessage();

        verify(mockException).getMessage();
    }
}
