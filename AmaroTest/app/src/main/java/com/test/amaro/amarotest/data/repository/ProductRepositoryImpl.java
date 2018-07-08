package com.test.amaro.amarotest.data.repository;

import com.test.amaro.amarotest.data.ProductService;
import com.test.amaro.amarotest.models.Example;
import com.test.amaro.amarotest.models.Product;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import javax.inject.Inject;

public final class ProductRepositoryImpl implements ProductRepository {

    private final ProductService service;

    public Observable<List<Product>> loadProducts() {
        return this.service.getProducts()
                .map(new Function<Example, List<Product>>() {
                    @Override
                    public List<Product> apply(Example example) {
                        return example.getProducts();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public final ProductService getService() {
        return this.service;
    }

    @Inject
    public ProductRepositoryImpl(ProductService service) {
        this.service = service;
    }
}
