package com.amaro.bruno.amarochallenge.catalogue.presentation;

import com.amaro.bruno.amarochallenge.catalogue.model.Product;
import com.amaro.bruno.amarochallenge.catalogue.model.Size;

import java.util.ArrayList;
import java.util.List;

public interface ProductListContract {

    interface View extends BaseView{
        void onSuccessListProducts(ArrayList<Product> products);
    }

    interface Presenter{
        void getProductsList();
        List<Product> getProductsBySize(List<Product> products, Size size);
        List<Product> getProductsByPriceRange(List<Product> products, double initialPrice, double finalPrice);
    }

}
