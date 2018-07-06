package com.test.amaro.amarotest.dagger.modules

import com.test.amaro.amarotest.dagger.scopes.PerActivity
import com.test.amaro.amarotest.data.repository.ProductRepository
import com.test.amaro.amarotest.main.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class PresenterModule {

    @Provides
    @PerActivity
    fun providesMainPresenter(productRepository: ProductRepository): MainPresenter {
        return MainPresenter(productRepository)
    }
}