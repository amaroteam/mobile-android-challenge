package com.amaro.bruno.amarochallenge.catalogue.di;

import com.amaro.bruno.amarochallenge.catalogue.presentation.ProductListContract;
import com.amaro.bruno.amarochallenge.catalogue.presentation.ProductListPresenter;

public class InjectionProductsListPresenter {

    public static ProductListPresenter getProductListPresenter(ProductListContract.View view){
        return new ProductListPresenter(view);
    }

}
