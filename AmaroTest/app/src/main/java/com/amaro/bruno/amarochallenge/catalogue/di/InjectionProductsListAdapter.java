package com.amaro.bruno.amarochallenge.catalogue.di;

import android.content.Context;

import com.amaro.bruno.amarochallenge.catalogue.adapter.ProductsListAdapter;
import com.amaro.bruno.amarochallenge.catalogue.model.Product;

import java.util.List;

public class InjectionProductsListAdapter {

    public static ProductsListAdapter getProductsListAdapter(Context context, List<Product> products){
        return new ProductsListAdapter(context, products);
    }

}
