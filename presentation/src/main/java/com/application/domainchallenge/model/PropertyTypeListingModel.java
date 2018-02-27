package com.application.domainchallenge.model;

import java.util.Collection;



public class PropertyTypeListingModel<T> {

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Collection<PropertyListingModel> getItems() {
        return items;
    }

    public void setItems(Collection<PropertyListingModel> items) {
        this.items = items;
    }

    private String category;
    private Collection<PropertyListingModel> items;

    public PropertyTypeListingModel(String category, Collection<PropertyListingModel> items) {
        this.category = category;
        this.items = items;

    }
}
