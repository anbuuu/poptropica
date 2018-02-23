package com.application.domainchallenge.view.fragment;

import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.application.domainchallenge.internal.di.HasComponent;

/**
 * Base {@link Fragment} class for every fragment in this application
 */

public abstract class BaseFragment extends Fragment {
    /**
     * Shows a {@link android.widget.Toast}message.
     *
     * @param message A string representing a message to be shown
     */
    protected void showToastMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
    /**
     * Gets a Component for dependency injection by its type
     */
    protected <C> C getComponent(Class<C> componentType) {
        return componentType.cast(( (HasComponent<C>) getActivity()).getComponent());
    }
}
