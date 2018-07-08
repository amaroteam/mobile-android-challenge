package com.test.amaro.amarotest.dagger.modules;

import android.content.SharedPreferences;
import com.test.amaro.amarotest.dagger.scopes.PerActivity;
import com.test.amaro.amarotest.data.usecases.ProductUseCase;
import com.test.amaro.amarotest.presentation.detail.DetailPresenter;
import com.test.amaro.amarotest.presentation.main.MainPresenter;
import com.test.amaro.amarotest.presentation.main.filter.FilterPresenter;
import dagger.Module;
import dagger.Provides;

@Module
public final class PresenterModule {

    @Provides
    @PerActivity
    public final MainPresenter providesMainPresenter(ProductUseCase productUseCase) {
        return new MainPresenter(productUseCase);
    }

    @Provides
    @PerActivity
    public final DetailPresenter provideDetailPresenter() {
        return new DetailPresenter();
    }

    @Provides
    @PerActivity
    public final FilterPresenter provideFilterPresenter(SharedPreferences sharedPreferences) {
        return new FilterPresenter(sharedPreferences);
    }
}
