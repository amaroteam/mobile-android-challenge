package com.test.amaro.amarotest.dagger.modules

import com.test.amaro.amarotest.data.ProductService
import com.test.amaro.amarotest.data.repository.ProductRepository
import com.test.amaro.amarotest.data.repository.ProductRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideProductRepository(service: ProductService): ProductRepository {
        return ProductRepositoryImpl(service)
    }
}