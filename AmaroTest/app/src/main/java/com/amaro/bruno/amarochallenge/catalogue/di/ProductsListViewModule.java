package com.amaro.bruno.amarochallenge.catalogue.di;

import com.amaro.bruno.amarochallenge.catalogue.presentation.ProductListContract;
import com.amaro.bruno.amarochallenge.catalogue.ui.ProductsListActivity;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ProductsListViewModule {

    @Binds
    abstract ProductListContract.View providesProductsListView(ProductsListActivity productsListActivity);

}
