package com.amaro.bruno.amarochallenge.catalogue.presentation;

import com.amaro.bruno.amarochallenge.catalogue.extensions.StringUtils;
import com.amaro.bruno.amarochallenge.catalogue.model.Product;
import com.amaro.bruno.amarochallenge.catalogue.model.Size;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

public class ProductListPresenter extends BasePresenter<ProductListContract.View>
        implements ProductListContract.Presenter {

    public ProductListPresenter(ProductListContract.View view) {
        super(view);
    }

    @Override
    public void getProductsList() {
//        TODO Call the API using RxJava and Retrofit
    }

    @Override
    public List<Product> getProductsBySize(List<Product> products, Size size) {
        if(products != null && products.size() > 0){
            return products.stream()
                    .filter(Product::isOnSale)
                    .filter(product -> product.getSizes().contains(size))
                    .collect(Collectors.toList());
        }

        return null;
    }

    @Override
    public List<Product> getProductsByPriceRange(List<Product> products, double initialPrice, double finalPrice){
        if(products != null && products.size() > 0){
            return products.stream()
                    .filter(product -> StringUtils.convertCurrencyToDouble(product.getRegularPrice()) >= initialPrice //TODO create an extension function to convert any currency to a double
                                        && StringUtils.convertCurrencyToDouble(product.getRegularPrice()) <= finalPrice)
                    .collect(Collectors.toList());
        }

        return null;
    }
}
