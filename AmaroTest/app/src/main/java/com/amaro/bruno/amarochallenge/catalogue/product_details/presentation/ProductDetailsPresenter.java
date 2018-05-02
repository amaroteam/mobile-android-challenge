package com.amaro.bruno.amarochallenge.catalogue.product_details.presentation;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.StrikethroughSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.amaro.bruno.amarochallenge.R;
import com.amaro.bruno.amarochallenge.catalogue.product_details.listener.ISizeChangedListener;
import com.amaro.bruno.amarochallenge.catalogue.products.model.Product;
import com.amaro.bruno.amarochallenge.catalogue.products.model.Size;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductDetailsPresenter implements ProductDetailsContract.Presenter {

    private Context context;

    public ProductDetailsPresenter(Context context){
        this.context = context;
    }

    @Override
    public boolean hasDiscountPercent(@NonNull Product product) {
        return product.getDiscountPercent() != null && !"".equals(product.getDiscountPercent());
    }

    @Override
    public void loadSizes(List<Size> sizes, ISizeChangedListener sizeChangedListener) {

        if(sizes.size() > 0){
            for(Size size : sizes){
                if(size.isAvailable()){
                    if(Size.SIZE_GG.equals(size.getSize()) || Size.SIZE_NUMBER_GG.equals(size.getSize())){
                        sizeChangedListener.onSizeVeryBig(size.getSize());
                    }
                    else if(Size.SIZE_G.equals(size.getSize()) || Size.SIZE_NUMBER_G.equals(size.getSize())){
                        sizeChangedListener.onSizeBig(size.getSize());
                    }
                    else if(Size.SIZE_M.equals(size.getSize()) || Size.SIZE_NUMBER_M.equals(size.getSize())){
                        sizeChangedListener.onSizeMedium(size.getSize());
                    }
                    else if(Size.SIZE_P.equals(size.getSize()) || Size.SIZE_NUMBER_P.equals(size.getSize())){
                        sizeChangedListener.onSizeSmall(size.getSize());
                    }
                    else if(Size.SIZE_PP.equals(size.getSize()) || Size.SIZE_NUMBER_PP.equals(size.getSize())){
                        sizeChangedListener.onSizeVerySmall(size.getSize());
                    }
                    else if(Size.SIZE_U.equals(size.getSize())){
                        sizeChangedListener.onSizeUnique(size.getSize());
                    }
                }
            }
        }

    }
}
