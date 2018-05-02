package com.amaro.bruno.amarochallenge.catalogue.products.di;

import com.amaro.bruno.amarochallenge.catalogue.products.presentation.ProductListContract;
import com.amaro.bruno.amarochallenge.catalogue.products.presentation.ProductListPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class ProductsListPresenterModule {

    @Provides
    ProductListPresenter providesProductListPresenter(ProductListContract.View view){
        return new ProductListPresenter(view);
    }

}
