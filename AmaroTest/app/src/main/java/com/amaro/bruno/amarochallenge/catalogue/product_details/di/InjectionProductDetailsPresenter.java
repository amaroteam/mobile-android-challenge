package com.amaro.bruno.amarochallenge.catalogue.product_details.di;

import android.content.Context;

import com.amaro.bruno.amarochallenge.catalogue.product_details.presentation.ProductDetailsPresenter;

public class InjectionProductDetailsPresenter {

    public static ProductDetailsPresenter inject(Context context){
        return new ProductDetailsPresenter(context);
    }

}
