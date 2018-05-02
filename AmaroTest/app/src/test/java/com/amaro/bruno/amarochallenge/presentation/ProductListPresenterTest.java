package com.amaro.bruno.amarochallenge.presentation;

import android.app.Activity;

import com.amaro.bruno.amarochallenge.MockProducts;
import com.amaro.bruno.amarochallenge.catalogue.products.di.InjectionProductsListPresenter;
import com.amaro.bruno.amarochallenge.catalogue.products.model.Product;
import com.amaro.bruno.amarochallenge.catalogue.products.presentation.ProductListContract;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import io.reactivex.schedulers.Schedulers;

public class ProductListPresenterTest {

    @Mock
    private Activity activity;

    @Mock
    private ProductListContract.View view;

    private ProductListContract.Presenter presenter;
    private List<Product> products;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        products = MockProducts.getMockProducts();
        presenter = InjectionProductsListPresenter.getProductListPresenter(view);
    }

    @Test
    public void getProductListTest(){
        presenter.getProductsList(Schedulers.trampoline(), Schedulers.trampoline());
    }

    @Test
    public void getProductsBySize(){
        Assert.assertEquals(4, presenter.getProductsBySize(products, "P").size());
    }

    @Test
    public void getProductsByPriceRange(){
        Assert.assertEquals(6, presenter.getProductsByPriceRange(products, 100, 200).size());
    }

}
