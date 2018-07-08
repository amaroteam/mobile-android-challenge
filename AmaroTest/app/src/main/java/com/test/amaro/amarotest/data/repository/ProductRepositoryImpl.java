package com.test.amaro.amarotest.data.repository;

import com.test.amaro.amarotest.data.ProductService;
import com.test.amaro.amarotest.models.Example;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;

public final class ProductRepositoryImpl implements ProductRepository {

    private ProductService productService;

    @Inject
    public ProductRepositoryImpl(ProductService productService) {
        this.productService = productService;
    }

    public Observable<Example> loadProducts() {
        return this.productService.getProducts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
