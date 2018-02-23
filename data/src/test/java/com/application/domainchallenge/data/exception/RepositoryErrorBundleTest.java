package com.application.domainchallenge.data.exception;

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
public class RepositoryErrorBundleTest {

    private RepositoryErrorBundle repositoryErrorBundle;

    @Mock
    private Exception mockException;

    @Before
    public void setUp() {
        repositoryErrorBundle = new RepositoryErrorBundle(mockException);
    }

    @Test
    @SuppressWarnings("ThrowableResultOfMethodCallIgnored")
    public void testGetErrorMessageInteraction() {
        repositoryErrorBundle.getErrorMessage();

        verify(mockException).getMessage();
    }
}
