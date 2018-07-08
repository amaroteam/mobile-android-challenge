package com.test.amaro.amarotest.presentation.detail;

import com.test.amaro.amarotest.models.Product;
import com.test.amaro.amarotest.models.Size;
import com.test.amaro.amarotest.presentation.core.BaseMvpPresenter;
import com.test.amaro.amarotest.presentation.core.MvpView;
import java.util.List;

public interface DetailContract {

    interface DetailView extends MvpView {

        void setupToolbar(String name);

        void showProductImage(String url);

        void showProductPrice(String price);

        void showProductInstallment(String installment);

        void hideProductInstallment();

        void showProductPromotionalPrice(String price, String promotionalPrice);

        void showProductUniqueSize(List<Size> sizes);

        void showProductSizesRecyclerView(List<Size> sizes);

        void showProductImageEmptyState();
    }

    abstract class Presenter extends BaseMvpPresenter<DetailView> {

        public abstract void loadProduct(Product product);
    }
}