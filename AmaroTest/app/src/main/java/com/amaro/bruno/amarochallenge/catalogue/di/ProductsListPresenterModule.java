package com.amaro.bruno.amarochallenge.catalogue.di;

import com.amaro.bruno.amarochallenge.catalogue.presentation.ProductListContract;
import com.amaro.bruno.amarochallenge.catalogue.presentation.ProductListPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class ProductsListPresenterModule {

    @Provides
    ProductListPresenter providesProductListPresenter(ProductListContract.View view){
        return new ProductListPresenter(view);
    }

}
