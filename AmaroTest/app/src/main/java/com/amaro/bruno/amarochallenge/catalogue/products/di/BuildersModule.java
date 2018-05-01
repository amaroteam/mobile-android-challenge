package com.amaro.bruno.amarochallenge.catalogue.products.di;

import com.amaro.bruno.amarochallenge.catalogue.products.ui.ProductsListActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class BuildersModule {

    @ContributesAndroidInjector(modules = {ProductsListViewModule.class, ProductsListPresenterModule.class})
    abstract ProductsListActivity bindProductsListActivity();

}
