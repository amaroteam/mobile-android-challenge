package com.amaro.bruno.amarochallenge.catalogue.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class ProductList {

    @JsonProperty("products")
    private ArrayList<Product> products;

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}
