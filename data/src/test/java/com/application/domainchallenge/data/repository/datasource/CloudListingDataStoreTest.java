package com.application.domainchallenge.data.repository.datasource;

import com.application.domainchallenge.data.entity.Example;
import com.application.domainchallenge.data.net.RestApi;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import io.reactivex.Observable;

import static org.mockito.Mockito.verify;

/**
 * Created by anbu.ezhilan on 15/2/18.
 */


@RunWith(MockitoJUnitRunner.class)
public class CloudListingDataStoreTest {

    private CloudListingDataStore cloudListingDataStore;

    @Mock
    private RestApi mockRestApi;

    @Before
    public void setUp() {
        cloudListingDataStore = new CloudListingDataStore(mockRestApi);

    }

    @Test
    public void testGetListingEntityListFromApi() {
        Observable<Example> listObservable = cloudListingDataStore.listingEntityList();
        verify(mockRestApi).listingEntityList();
        /*

        List<User> users = ArrayList<>();

users.add(new User("jon snow"));
users.add(new User("tyrion lannister"));

Observable
    .just(users)
    .concatMap(userList -> Observable.from(userList))
    .subscribe(user -> log(user.name));

    // concatMap: when applied to an item emitted by the source Observable, returns an Observable

    // => "jon snow", "tyrion lannister"
         */
    }
}
