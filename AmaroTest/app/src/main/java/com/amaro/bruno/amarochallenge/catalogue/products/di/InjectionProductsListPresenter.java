package com.amaro.bruno.amarochallenge.catalogue.products.di;

import com.amaro.bruno.amarochallenge.catalogue.products.presentation.ProductListContract;
import com.amaro.bruno.amarochallenge.catalogue.products.presentation.ProductListPresenter;

public class InjectionProductsListPresenter {

    public static ProductListPresenter getProductListPresenter(ProductListContract.View view){
        return new ProductListPresenter(view);
    }

}
