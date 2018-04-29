package com.amaro.bruno.amarochallenge.catalogue.ui;

import android.os.Bundle;

import com.amaro.bruno.amarochallenge.BaseActivity;
import com.amaro.bruno.amarochallenge.R;
import com.amaro.bruno.amarochallenge.catalogue.model.Product;
import com.amaro.bruno.amarochallenge.catalogue.presentation.ProductListContract;
import com.amaro.bruno.amarochallenge.catalogue.presentation.ProductListPresenter;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class ProductsListActivity extends BaseActivity implements ProductListContract.View {

    @Inject
    ProductListPresenter productListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_list);

        AndroidInjection.inject(this);

        setup();
    }

    @Override
    protected void onStop() {
        super.onStop();
        productListPresenter.stop();
    }

    @Override
    protected void setup() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void onSuccessListProducts(ArrayList<Product> products) {

    }

    @Override
    public void onError(String msg) {

    }
}
