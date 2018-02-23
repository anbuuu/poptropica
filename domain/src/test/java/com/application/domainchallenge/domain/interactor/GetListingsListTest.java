package com.application.domainchallenge.domain.interactor;

import com.application.domainchallenge.domain.executor.PostExecutionThread;
import com.application.domainchallenge.domain.executor.ThreadExecutor;
import com.application.domainchallenge.domain.repository.ListingRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

/**
 * Created by anbu.ezhilan on 23/2/18.
 */

@RunWith(MockitoJUnitRunner.class)
public class GetListingsListTest {

    private GetListingsList getListingsList;

    @Mock private ThreadExecutor mockThreadExecutor;
    @Mock private PostExecutionThread mockPostExecutionThread;
    @Mock private ListingRepository mockListingRepository;

    @Before
    public void setUp() {
        getListingsList = new GetListingsList(mockListingRepository, mockThreadExecutor,
                mockPostExecutionThread);

    }

    @Test
    public void testGetListingsListUseCaseObservableHappyCase() {
        getListingsList.buildUseCasObservable(null);

        verify(mockListingRepository).listings();
        verifyNoMoreInteractions(mockListingRepository);
        verifyZeroInteractions(mockThreadExecutor);
        verifyZeroInteractions(mockPostExecutionThread);
    }
}
