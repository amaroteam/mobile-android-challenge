package com.test.amaro.amarotest.dagger.modules

import com.test.amaro.amarotest.data.repository.ProductRepository
import com.test.amaro.amarotest.data.repository.ProductRepositoryImpl
import com.test.amaro.amarotest.data.ProductService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideAmaroRepository(service: ProductService): ProductRepository {
        return ProductRepositoryImpl(service)
    }
}