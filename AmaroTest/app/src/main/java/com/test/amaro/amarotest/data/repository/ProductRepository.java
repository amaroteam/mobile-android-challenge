package com.test.amaro.amarotest.data.repository;

import com.test.amaro.amarotest.models.Product;
import io.reactivex.Observable;
import java.util.List;

public interface ProductRepository {

    Observable<List<Product>> loadProducts();
}
