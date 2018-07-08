package com.test.amaro.amarotest.presentation.main.filter;

import com.test.amaro.amarotest.presentation.core.BaseMvpPresenter;
import com.test.amaro.amarotest.presentation.core.MvpView;

public interface FilterContract {

    interface FilterView extends MvpView {

        void showPriceOrderingFilter(int priceOrderingPreference);

        void showPromotionFilter(boolean showPromotions);
    }

    abstract class Presenter extends BaseMvpPresenter<FilterView> {

        public abstract void loadFilterOptions();

        public abstract void updatePriceOrderingFilter(int priceOrderingPreference);

        public abstract void updatePromotionFilter(boolean showPromotions);
    }
}
