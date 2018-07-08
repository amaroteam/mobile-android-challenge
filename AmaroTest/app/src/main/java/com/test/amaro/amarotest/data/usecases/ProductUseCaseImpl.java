package com.test.amaro.amarotest.data.usecases;

import static com.test.amaro.amarotest.models.ProductComparator.OrderingOptions.ALEATORY;
import static com.test.amaro.amarotest.models.ProductComparator.OrderingOptions.HIGH_ORDERING;
import static com.test.amaro.amarotest.models.ProductComparator.OrderingOptions.LOW_ORDERING;
import static com.test.amaro.amarotest.presentation.main.filter.FilterPresenter.PREFERENCE_PRICE_ORDERING_FILTER;
import static com.test.amaro.amarotest.presentation.main.filter.FilterPresenter.SHOW_PROMOTION;

import android.content.SharedPreferences;
import com.test.amaro.amarotest.data.repository.ProductRepository;
import com.test.amaro.amarotest.models.Example;
import com.test.amaro.amarotest.models.Product;
import com.test.amaro.amarotest.models.ProductComparator.HigherPriceComparator;
import com.test.amaro.amarotest.models.ProductComparator.LowPriceComparator;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

public class ProductUseCaseImpl implements ProductUseCase {

    private ProductRepository productRepository;
    private SharedPreferences sharedPreferences;

    @Inject
    @SuppressWarnings("WeakerAccess")
    public ProductUseCaseImpl(ProductRepository productRepository,
            SharedPreferences sharedPreferences) {
        this.productRepository = productRepository;
        this.sharedPreferences = sharedPreferences;
    }

    @Override
    public Observable<List<Product>> loadProducts() {

        final Observable<List<Product>> unsortedListObservable = productRepository.loadProducts()
                .map(new Function<Example, List<Product>>() {
                    @Override
                    public List<Product> apply(Example example) {
                        return example.getProducts();
                    }
                });

        return applyFilters(unsortedListObservable);
    }

    @Override
    public Observable<List<Product>> applyFilters(
            Observable<List<Product>> unsortedListObservable) {
        Observable<List<Product>> priceSortedListObservable = filterPriceOrdering(
                unsortedListObservable);
        Observable<List<Product>> fullSortedListObservable = priceSortedListObservable;

        if (getShowOnlyPromotionPreference()) {
            fullSortedListObservable = filterProductsPromotionOnly(priceSortedListObservable);
        }

        return fullSortedListObservable;
    }

    @Override
    public Observable<List<Product>> filterPriceOrdering(Observable<List<Product>> listObservable) {

        final int priceOrderPreference = getProductPriceOrderingFilterPreference();

        switch (priceOrderPreference) {
            case ALEATORY:
                return listObservable;
            case HIGH_ORDERING:
                return filterProductsHighOrdered(listObservable);
            case LOW_ORDERING:
                return filterProductsLowOrdered(listObservable);
            default:
                return listObservable;
        }
    }

    @Override
    public Observable<List<Product>> filterProductsHighOrdered(
            Observable<List<Product>> listObservable) {
        return listObservable.map(new Function<List<Product>, List<Product>>() {
            @Override
            public List<Product> apply(List<Product> productList) {
                List<Product> aux = new ArrayList<>(productList.size());
                aux.addAll(productList);
                Collections.copy(aux, productList);
                Collections.sort(aux, new HigherPriceComparator());
                return aux;
            }
        });
    }

    @Override
    public Observable<List<Product>> filterProductsLowOrdered(
            Observable<List<Product>> listObservable) {
        return listObservable.map(new Function<List<Product>, List<Product>>() {
            @Override
            public List<Product> apply(List<Product> productList) {
                List<Product> aux = new ArrayList<>(productList.size());
                aux.addAll(productList);
                Collections.copy(aux, productList);
                Collections.sort(aux, new LowPriceComparator());
                return aux;
            }
        });
    }

    @Override
    public Observable<List<Product>> filterProductsPromotionOnly(
            final Observable<List<Product>> listObservable) {

        return listObservable.map(new Function<List<Product>, List<Product>>() {
            @Override
            public List<Product> apply(List<Product> products) {
                List<Product> promotionOnlyFilteredList = new ArrayList<>();
                for (Product product : products) {
                    if (product.getDiscountPercentage() != null && !product.getDiscountPercentage()
                            .isEmpty()) {
                        promotionOnlyFilteredList.add(product);
                    }
                }
                return promotionOnlyFilteredList;
            }
        });

    }

    private int getProductPriceOrderingFilterPreference() {
        return sharedPreferences.getInt(PREFERENCE_PRICE_ORDERING_FILTER, ALEATORY);
    }

    private boolean getShowOnlyPromotionPreference() {
        return sharedPreferences.getBoolean(SHOW_PROMOTION, false);
    }


}
