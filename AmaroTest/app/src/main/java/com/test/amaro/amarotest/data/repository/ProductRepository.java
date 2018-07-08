package com.test.amaro.amarotest.data.repository;

import com.test.amaro.amarotest.models.Example;
import io.reactivex.Observable;

public interface ProductRepository {

    Observable<Example> loadProducts();
}
