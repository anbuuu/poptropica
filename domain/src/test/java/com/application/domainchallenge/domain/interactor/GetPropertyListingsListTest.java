package com.application.domainchallenge.domain.interactor;

import com.application.domainchallenge.domain.executor.PostExecutionThread;
import com.application.domainchallenge.domain.executor.ThreadExecutor;
import com.application.domainchallenge.domain.repository.PropertyListingRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

@RunWith(MockitoJUnitRunner.class)
public class GetPropertyListingsListTest {

    private GetPropertyListingsList getPropertyListingsList;

    @Mock private ThreadExecutor mockThreadExecutor;
    @Mock private PostExecutionThread mockPostExecutionThread;
    @Mock private PropertyListingRepository mockPropertyListingRepository;

    @Before
    public void setUp() {
        getPropertyListingsList = new GetPropertyListingsList(mockPropertyListingRepository, mockThreadExecutor,
                mockPostExecutionThread);

    }

    @Test
    public void testGetListingsListUseCaseObservableHappyCase() {
        getPropertyListingsList.buildUseCasObservable(null);

        verify(mockPropertyListingRepository).listings();
        verifyNoMoreInteractions(mockPropertyListingRepository);
        verifyZeroInteractions(mockThreadExecutor);
        verifyZeroInteractions(mockPostExecutionThread);
    }
}
