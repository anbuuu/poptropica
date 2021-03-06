package com.application.domainchallenge.presenter;

import android.content.Context;

import com.application.domainchallenge.domain.interactor.GetPropertyListingsList;
import com.application.domainchallenge.mapper.PropertyListingModelDataMapper;
import com.application.domainchallenge.view.ListingsListView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import io.reactivex.observers.DisposableObserver;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class PropertyListingsPresenterTest {

    private PropertyListingsPresenter userListPresenter;

    @Mock private Context mockContext;
    @Mock private ListingsListView mockUserListView;
    @Mock private GetPropertyListingsList mockGetUserList;
    @Mock private PropertyListingModelDataMapper mockUserModelDataMapper;

    @Before
    public void setUp() {
        userListPresenter = new PropertyListingsPresenter(mockGetUserList, mockUserModelDataMapper);
        userListPresenter.setView(mockUserListView);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testUserListPresenterInitialize() {
        given(mockUserListView.context()).willReturn(mockContext);

        userListPresenter.initialize();

        verify(mockUserListView).hideRetry();
        verify(mockUserListView).showLoading();
        verify(mockGetUserList).execute(any(DisposableObserver.class), any(Void.class));
    }
}
