package com.test.amaro.amarotest.presentation.main;

import com.test.amaro.amarotest.presentation.core.BaseMvpPresenter;
import com.test.amaro.amarotest.presentation.core.MvpView;
import com.test.amaro.amarotest.models.Product;
import java.util.List;

public interface MainContract {

    interface MainView extends MvpView {
        void retry();

        void onLoadStarted();

        void onLoadFinished();

        void onShowError(String error);

        void showProducts(List<Product> var1);
    }

    abstract class Presenter extends BaseMvpPresenter<MainView> {
        public abstract void loadProducts();
    }
}
