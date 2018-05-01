package com.amaro.bruno.amarochallenge.catalogue.product_details.presentation;

import android.support.annotation.NonNull;
import android.view.View;

import com.amaro.bruno.amarochallenge.BaseView;
import com.amaro.bruno.amarochallenge.catalogue.product_details.listener.ISizeChangedListener;
import com.amaro.bruno.amarochallenge.catalogue.products.model.Product;
import com.amaro.bruno.amarochallenge.catalogue.products.model.Size;

import java.util.List;

public interface ProductDetailsContract {

    interface Presenter{
        boolean hasDiscountPercent(@NonNull Product product);
        void loadSizes(List<Size> sizes, ISizeChangedListener sizeChangedListener);
    }

}
