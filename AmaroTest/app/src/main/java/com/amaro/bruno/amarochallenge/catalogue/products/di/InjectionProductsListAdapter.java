package com.amaro.bruno.amarochallenge.catalogue.products.di;

import android.content.Context;

import com.amaro.bruno.amarochallenge.catalogue.products.adapter.ProductItemClickListener;
import com.amaro.bruno.amarochallenge.catalogue.products.adapter.ProductsListAdapter;
import com.amaro.bruno.amarochallenge.catalogue.products.model.Product;

import java.util.List;

public class InjectionProductsListAdapter {

    public static ProductsListAdapter getProductsListAdapter(Context context, List<Product> products, ProductItemClickListener productItemClickListener){
        return new ProductsListAdapter(context, products, productItemClickListener);
    }

}
