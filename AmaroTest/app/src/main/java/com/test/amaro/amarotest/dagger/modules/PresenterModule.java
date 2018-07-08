package com.test.amaro.amarotest.dagger.modules;

import com.test.amaro.amarotest.dagger.scopes.PerActivity;
import com.test.amaro.amarotest.data.repository.ProductRepository;
import com.test.amaro.amarotest.presentation.detail.DetailPresenter;
import com.test.amaro.amarotest.presentation.main.MainPresenter;
import dagger.Module;
import dagger.Provides;

@Module
public final class PresenterModule {

    @Provides
    @PerActivity
    public final MainPresenter providesMainPresenter(ProductRepository productRepository) {
        return new MainPresenter(productRepository);
    }

    @Provides
    @PerActivity
    public final DetailPresenter provideDetailPresenter() {
        return new DetailPresenter();
    }
}
