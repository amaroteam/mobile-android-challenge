package com.amaro.bruno.amarochallenge.presentation;

import android.app.Activity;

import com.amaro.bruno.amarochallenge.MockProducts;
import com.amaro.bruno.amarochallenge.catalogue.product_details.di.InjectionProductDetailsPresenter;
import com.amaro.bruno.amarochallenge.catalogue.product_details.presentation.ProductDetailsContract;
import com.amaro.bruno.amarochallenge.catalogue.products.model.Product;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

public class ProductDetailsPresenterTest {

    @Mock
    private Activity activity;

    private ProductDetailsContract.Presenter presenter;
    private List<Product> products;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        products = MockProducts.getMockProducts();
        presenter = InjectionProductDetailsPresenter.inject(activity);
    }

    @Test
    public void hasDiscountPercent(){
        presenter.hasDiscountPercent(products.get(0));
    }

}
