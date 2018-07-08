package com.test.amaro.amarotest.data.usecases;

import com.test.amaro.amarotest.models.Product;
import io.reactivex.Observable;
import java.util.List;

public interface ProductUseCase {


    Observable<List<Product>> loadProducts();

    Observable<List<Product>> applyFilters(Observable<List<Product>> listObservable);

    Observable<List<Product>> filterPriceOrdering(Observable<List<Product>> listObservable);

    Observable<List<Product>> filterProductsHighOrdered(Observable<List<Product>> listObservable);

    Observable<List<Product>> filterProductsLowOrdered(Observable<List<Product>> listObservable);

    Observable<List<Product>> filterProductsPromotionOnly(Observable<List<Product>> listObservable);

}
