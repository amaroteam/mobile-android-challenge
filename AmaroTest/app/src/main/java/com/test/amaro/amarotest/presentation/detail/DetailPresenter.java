package com.test.amaro.amarotest.presentation.detail;

import android.support.annotation.NonNull;
import com.test.amaro.amarotest.models.Product;
import com.test.amaro.amarotest.models.Size;
import java.util.ArrayList;
import java.util.List;

public final class DetailPresenter extends DetailContract.Presenter {

    @Override
    public void loadProduct(final Product product) {
        setupToolbar(product);
        setImage(product.getImage());
        setSizes(product.getSizes());
        setInstallment(product.getInstallments());
        setPromotion(product.getDiscountPercentage(), product.getRegularPrice(),
                product.getActualPrice());
    }

    private void setupToolbar(final Product product) {
        getView().setupToolbar(product.getName());
    }

    private void setInstallment(@NonNull String installments) {
        if (!installments.isEmpty() && installments.charAt(0) != '1') {
            getView().showProductInstallment(installments);
        } else {
            getView().hideProductInstallment();
        }
    }

    private void setImage(final String image) {
        if (image.isEmpty()) {
            getView().showProductImageEmptyState();
        } else {
            getView().showProductImage(image);
        }
    }

    private void setSizes(@NonNull List<Size> sizes) {
        final List<Size> availableSizes = getAvailableSizesFilteredList(sizes);
        if (!availableSizes.isEmpty() && availableSizes.size() > 1) {
            getView().showProductSizesRecyclerView(availableSizes);
        } else {
            getView().showProductUniqueSize(availableSizes);
        }
    }

    private void setPromotion(
            final String discountPercentage,
            final String regularPrice,
            final String actualPrice) {
        if (discountPercentage.isEmpty()) {
            getView().showProductPrice(actualPrice);
        } else {
            getView().showProductPromotionalPrice(regularPrice, actualPrice);
        }
    }

    private List<Size> getAvailableSizesFilteredList(final List<Size> sizes) {

        final List<Size> aux = new ArrayList<>();

        for (Size size : sizes) {
            if (size.getAvailable()) {
                aux.add(size);
            }
        }

        return aux;
    }

}
