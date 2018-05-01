package com.amaro.bruno.amarochallenge;

import android.app.Activity;

import com.amaro.bruno.amarochallenge.catalogue.di.InjectionProductsListPresenter;
import com.amaro.bruno.amarochallenge.catalogue.di.ProductsListPresenterModule;
import com.amaro.bruno.amarochallenge.catalogue.model.Product;
import com.amaro.bruno.amarochallenge.catalogue.model.Size;
import com.amaro.bruno.amarochallenge.catalogue.presentation.ProductListContract;
import com.amaro.bruno.amarochallenge.catalogue.presentation.ProductListPresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import javax.inject.Inject;

public class ProductListPresenterTest {

    @Mock
    private Activity activity;

    @Mock
    private ProductListContract.View view;

    private ProductListContract.Presenter presenter;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        presenter = InjectionProductsListPresenter.getProductListPresenter(view);
    }

    @Test
    public void getProductListTest(){
        presenter.getProductsList();
    }

    @Test
    public void getProductsBySize(){
        List<Product> products = MockProducts.getMockProducts();

        presenter.getProductsBySize(products, "P");
    }

    @Test
    public void getProductsByPriceRange(){
        List<Product> products = MockProducts.getMockProducts();

        presenter.getProductsByPriceRange(products, 100, 200);
    }

}
