package com.amaro.bruno.amarochallenge.catalogue.products.di;

import com.amaro.bruno.amarochallenge.catalogue.products.presentation.ProductListContract;
import com.amaro.bruno.amarochallenge.catalogue.products.ui.ProductsListActivity;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ProductsListViewModule {

    @Binds
    abstract ProductListContract.View providesProductsListView(ProductsListActivity productsListActivity);

}
