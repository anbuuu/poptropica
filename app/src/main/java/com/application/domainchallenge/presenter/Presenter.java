package com.application.domainchallenge.presenter;

/**
 * Interface representing a Presenter in a MVP Pattern
 */

public interface Presenter {
    /**
     * Method that control the lifecycle of the View. It should be called in the Views
     * onResume() method
     */
    void resume();
    /**
     * Method that control the lifecycle of the view. It should be called in the Views
     * onPause method()
     */
    void pause();
    /**
     * Method that control the lifecycle of the view. It should be called in the Views
     * onDestroy method
     */
    void destroy();

}
