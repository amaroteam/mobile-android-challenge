package com.test.amaro.amarotest.presentation.main.filter;

import static com.test.amaro.amarotest.models.ProductComparator.OrderingOptions.ALEATORY;

import android.content.SharedPreferences;
import javax.inject.Inject;

public class FilterPresenter extends FilterContract.Presenter {

    private SharedPreferences sharedPreferences;
    public static final String SHOW_PROMOTION = "SHOW_PROMOTION";
    public static final String PREFERENCE_PRICE_ORDERING_FILTER = "PREFERENCE_PRICE_ORDERING_FILTER";

    @Inject
    public FilterPresenter(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    @Override
    public void loadFilterOptions() {
        getView().showPriceOrderingFilter(getPriceOrderPreference());
        getView().showPromotionFilter(getShowOnlyPromotionPreference());
    }

    private int getPriceOrderPreference() {
        return sharedPreferences
                .getInt(PREFERENCE_PRICE_ORDERING_FILTER, ALEATORY);
    }

    private boolean getShowOnlyPromotionPreference() {
        return sharedPreferences.getBoolean(SHOW_PROMOTION, false);
    }

    @Override
    public void updatePriceOrderingFilter(int priceOrderingPreference) {
        sharedPreferences.edit().putInt(PREFERENCE_PRICE_ORDERING_FILTER, priceOrderingPreference)
                .apply();
    }

    @Override
    public void updatePromotionFilter(boolean showPromotions) {
        sharedPreferences.edit().putBoolean(SHOW_PROMOTION, showPromotions).apply();
    }
}
